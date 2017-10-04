import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static Paragraphs Parse(String path) throws IOException {

        File docFile = new File(path);
        FileInputStream finStream = new FileInputStream(docFile.getAbsolutePath());
        // throws IOException and need to import org.apache.poi.hwpf.HWPFDocument;
        HWPFDocument doc=new HWPFDocument(finStream);
        WordExtractor wordExtract=new WordExtractor(doc);

        // dataArray stores the each line from the document
        String [] dataArray =wordExtract.getParagraphText();

        Paragraphs paragraphs = new Paragraphs();
        for(int i=0;i<dataArray.length;i++) {
            // printing lines from the array
            if (dataArray[i].contains("ТУ-") && i<5)
                paragraphs.numberTU = dataArray[i].substring(3);

            if (dataArray[i].contains("№") && i<5)
                paragraphs.numberTU = dataArray[i].substring(1);

            if (dataArray[i].contains("10/0,4") || dataArray[i].contains("6/0,4")) {
                paragraphs.numberTP = dataArray[i].replaceAll("\\s+", " ").
                        substring(dataArray[i].replaceAll("\\s+", " ").indexOf("кВ № ") + 5,
                                dataArray[i].replaceAll("\\s+", " ").indexOf(", подключе"));
            }
            if (dataArray[i].contains("на присоединение")) {
                paragraphs.function = dataArray[i];
                paragraphs.function2 = dataArray[i + 1];
            }
            if (dataArray[i].contains("Выданы")){
                paragraphs.subscriber = dataArray[i].substring(dataArray[i].indexOf(": ")+2);
            }
            if (dataArray[i].contains("Место расположения объекта")){
                paragraphs.address = dataArray[i].substring(dataArray[i].indexOf(": ")+2);
            }
            if (dataArray[i].contains("присоединения:")){
                paragraphs.point = dataArray[i].substring(dataArray[i].indexOf(": ")+2);
            }

        }
        finStream.close();
        System.out.println(paragraphs.toString());
        return paragraphs;
    }

    public static void CopyTU (String path, String path1, String filename) throws InvalidFormatException, IOException {
        File docFile = new File(path);
        FileInputStream finStream = new FileInputStream(docFile.getAbsolutePath());
        HWPFDocument doc=new HWPFDocument(finStream);
        WordExtractor wordExtract=new WordExtractor(doc);
        doc.write(new FileOutputStream(path1 + "\\" + filename
        + "\\" +filename+".doc"));
    }

    public static void ChengePattern(Paragraphs paragraphs, String path,String path1, String filename) throws FileNotFoundException, IOException, InvalidFormatException {

        XWPFDocument doc = new XWPFDocument(OPCPackage.open(path));
        for (XWPFParagraph p : doc.getParagraphs()) {
          //  System.out.println("-----"+p.getText());
           List<XWPFRun> runs = p.getRuns();
           StringBuilder sb = new StringBuilder();
           String text = null;
           if (runs != null) {
                for (XWPFRun r : runs) {
                    sb.append(r.getText(r.getTextPosition()));
                }
               XWPFRun run = p.createRun();

               if (sb.toString().contains("Выданы:")) {
                    text = paragraphs.subscriber;
               }
               else if (sb.toString().contains("ТУ №")){
                   text = paragraphs.numberTU;
               } else if (sb.toString().contains("Т Е Х Н И Ч Е С К И Е   Т Р Е Б О В А Н И Я")){
                   run.addBreak();
                   text = paragraphs.function;
                   run.setBold(true);
                   run.setText(text);
                   run.addBreak();
                   text = paragraphs.function2;
                   run.setBold(true);
               }
               else if (sb.toString().contains("Место расположения объекта: ")){
                    text = paragraphs.address;
               }
               else if (sb.toString().contains("Точка присоединения: ")){
                   text = paragraphs.point;
               }
               else if (sb.toString().contains("Предусмотреть в ТП-")){
                   text = paragraphs.numberTP+":";
                   run.setBold(true);
               }
               else if (sb.toString().contains("Предусмотреть в КТП") &&
                       !sb.toString().contains("Предусмотреть в КТП-потребителя")){
                   text = paragraphs.numberTP+":";
                   run.setBold(true);
               }
               else if (sb.toString().contains("Установить в ТП-")){
                   text = paragraphs.numberTP+" шкаф АСКУЭ заводского исполнения. В шкафу смонтировать:";
               }
               else if (sb.toString().contains("Установить в КТП ")){
                   text = paragraphs.numberTP+" шкаф АСКУЭ заводского исполнения. В шкафу смонтировать:";
               }
               else if ((sb.toString().contains("Необходимое оборудование ") &&
                       !sb.toString().contains("КТП-потребителя")) || sb.toString().contains("Для монтажа в ТП № ")){
                   text = paragraphs.numberTP+":";
                   run.setFontSize(11);
                   run.setBold(true);
               }
                   run.setFontFamily("ARIAL");
                   run.setText(text);
                   p.addRun(run);
               
            }
        }
        File folder = new File(path1 + "\\" + filename);
        folder.mkdir();
        doc.write(new FileOutputStream(folder+"\\"+"тех требования "+filename+".docx"));

    }
}
