import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Document {
    public static void ChengePattern() throws FileNotFoundException, IOException, InvalidFormatException {

        XWPFDocument doc = new XWPFDocument(OPCPackage.open("тех_требования 10 Кан А. ул.Волгодонская,31.docx"));
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("Кан А.П.")) {
                        text = text.replace("Кан А.П.", "SSSSAAAAAA");
                        r.setText(text, 0);
                    }
                }
            }
        }
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains("needle")) {
                                text = text.replace("needle", "haystack");
                                r.setText(text,0);
                            }
                        }
                    }
                }
            }
        }
        doc.write(new FileOutputStream("C:\\Users\\ApotinV\\Desktop\\GenerateTechnicalSpecifications\\output.docx"));

       /* // file object was created
       // File docFile = new File("C:\\Users\\ApotinV\\Desktop\\GenerateTechnicalSpecifications\\тех_требования 11 Хауиягын Даулет ул.Казахстанская, уч.43.1.docx");
        String fileName = "C:\\Users\\ApotinV\\Desktop\\GenerateTechnicalSpecifications\\тех_требования 11 Хауиягын Даулет ул.Казахстанская, уч.43.1.docx";
        String search = "Хауиягын Д";
        String replace = "число ПИ";
        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get(fileName);
        Files.write(path,
                new String(Files.readAllBytes(path), charset).replace(search, replace)
                        .getBytes(charset));
        // file input stream with docFile
      /*  FileInputStream finStream=new FileInputStream(docFile.getAbsolutePath());

        // throws IOException and need to import org.apache.poi.hwpf.HWPFDocument;
        XWPFDocument doc=new XWPFDocument(finStream);
        //XWPFWordExtractor wordExtract=new XWPFWordExtractor(doc);

        // dataArray stores the each line from the document
       // String [] dataArray =wordExtract.getParagraph();
        List<String> paragraphs = new ArrayList<>();

        try
        {
            List<XWPFParagraph> paragraphList = doc.getParagraphs();
            for (XWPFParagraph paragraph : paragraphList)
            {
                paragraphs.add(paragraph.getText());
                System.out.println(paragraph.getText());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


        /*for(int i=0;i<dataArray.length;i++) {
            // printing lines from the array
            if (dataArray[i].contains("ТУ-"))
                System.out.println(dataArray[i].substring(3));
            if (dataArray[i].contains("на присоединение")) {
                System.out.println(dataArray[i]);
                System.out.println(dataArray[i + 1]);
            }
            if (dataArray[i].contains("Выданы")){
                System.out.println(dataArray[i].substring(dataArray[i].indexOf(": ")+2));
            }
            if (dataArray[i].contains("Место расположения объекта")){
                System.out.println(dataArray[i].substring(dataArray[i].indexOf(": ")+2));
            }
            if (dataArray[i].contains("Точка  присоединения")){
                System.out.println(dataArray[i].substring(dataArray[i].indexOf(": ")+2));
            }*/


            //System.out.println("\n–"+dataArray[i]);

        //}
        //closing fileinputstream
        //finStream.close();
    }
}
