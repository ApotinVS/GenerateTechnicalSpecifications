import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CoveringWindow extends JFrame implements ActionListener {
    private JPanel rootPanel;
    private JButton Button1;
    private JTextField TextField1;
    private JTextField TextField2;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu submenuNK;
    private JMenu submenuK;
    private JMenu submenuTP;
    private JMenu submenuFacade;
    private JMenu submenuKTP;
    private JMenuItem itemNothingK;
    private JMenuItem itemNothingF;
    private JMenuItem item200041; // 200.04, 1 конц
    private JMenuItem item20004Nothing; // 200.04, ничего не прописано
    private JMenuItem item2301; // 230, 1 концентратор
    private JMenuItem item230Nothing; // 230, ничего не прописано
    private JMenuItem itemNothingH; // без ничего по высокой
    private JMenuItem item1KK;
    private JMenuItem item1KF;
    private JMenuItem item3KK;
    private JMenuItem item3KF;
    private JMenuItem itemFull;
    private JMenuItem itemAntenna;
    private JMenuItem itemMMT;
    private JMenuItem itemMMT3;//ММТ-5 и 3 конц
    private JMenuItem itemMMTH; //ММТ-5 по высокой
    private JMenuItem itemMMTAntenna;
    private JMenuItem itemMMTAntennaHigh;
    private JMenuItem itemMMTAntenna04;

    public CoveringWindow(){
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CreateMenu();
        setPreferredSize(new Dimension(640, 480));
        pack();
        setVisible(true);

    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                Paragraphs paragraphs = Parser.Parse(TextField1.getText()+"\\"+TextField2.getText()+".doc");
                Parser.ChengePattern(paragraphs, actionEvent.getActionCommand(),
                        TextField2.getText());
                Parser.CopyTU(TextField1.getText()+"\\"+TextField2.getText()+".doc",TextField2.getText());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
        }
    };

    public void CreateMenu (){

        menuBar = new JMenuBar();
        menu = new JMenu("Шаблон");

        //Не кунгей
        submenuNK = new JMenu("не Кунгей");
        //ТП
        submenuTP = new JMenu("ТП");

        item20004Nothing = new JMenuItem("200.04, 1 конц");
        item20004Nothing.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\200.04, ничего не прописано.docx");
        item20004Nothing.addActionListener(actionListener);
        submenuTP.add(item20004Nothing);

        item2301 = new JMenuItem("230, 1 концентратор");
        item2301.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\230, 1 концентратор.docx");
        item2301.addActionListener(actionListener);
        submenuTP.add(item2301);

        item230Nothing = new JMenuItem("230, ничего не прописано");
        item230Nothing.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\230, ничего не прописано.docx");
        item230Nothing.addActionListener(actionListener);
        submenuTP.add(item230Nothing);

        itemNothingH = new JMenuItem("без ничего по высокой");
        itemNothingH.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\без ничего по высокой.docx");
        itemNothingH.addActionListener(actionListener);
        submenuTP.add(itemNothingH);

        item200041 = new JMenuItem("200.04, ничего не прописано");
        item200041.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\200.04, 1 конц.docx");
        item200041.addActionListener(actionListener);
        submenuTP.add(item200041);

        itemMMTH = new JMenuItem("ММТ-5 по высокой");
        itemMMTH.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\ММТ-5 по высокой.docx");
        itemMMTH.addActionListener(actionListener);
        submenuTP.add(itemMMTH);

        itemMMT = new JMenuItem("1 ММТ-5");
        itemMMT.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\1 ММТ-5.docx");
        itemMMT.addActionListener(actionListener);
        submenuTP.add(itemMMT);

        itemMMT3 = new JMenuItem("ММТ-5 и 3 конц");
        itemMMT3.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\ММТ-5 и 3 конц.docx");
        itemMMT3.addActionListener(actionListener);
        submenuTP.add(itemMMT3);

        itemAntenna = new JMenuItem("антена");
        itemAntenna.addActionListener(this);
        submenuTP.add(itemAntenna);

        itemMMTAntenna = new JMenuItem("1 ММТ + 1 антена");
        itemMMTAntenna.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                    "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\1 ММТ, 1 антена.docx");
        itemMMTAntenna.addActionListener(actionListener);
        submenuTP.add(itemMMTAntenna);

        itemFull = new JMenuItem("1 ММТ + 1 антена + 6 концентраторов");
        itemFull.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\1 ММТ, 1 антена, 6 концентраторов.docx");
        itemFull.addActionListener(actionListener);
        submenuTP.add(itemFull);
        submenuNK.add(submenuTP);

        // Фасад
        submenuFacade = new JMenu("Фасад");
        itemNothingF = new JMenuItem("без ничего");
        itemNothingF.addActionListener(this);
        submenuFacade.add(itemNothingF);
        item1KF = new JMenuItem("1 концентратор");
        item1KF.addActionListener(this);
        submenuFacade.add(item1KF);
        item3KF = new JMenuItem("3 концентратора");
        item3KF.addActionListener(this);
        submenuFacade.add(item3KF);
        submenuNK.add(submenuFacade);
        
        //КТП потребителя
        submenuKTP = new JMenu("КТП потребителя");
        itemMMTAntennaHigh = new JMenuItem("ММТ+антена по высокой");
        itemMMTAntennaHigh.addActionListener(this);
        submenuKTP.add(itemMMTAntennaHigh);
        itemMMTAntenna04 = new JMenuItem("ММТ+антена 0.4");
        itemMMTAntenna04.addActionListener(this);
        submenuKTP.add(itemMMTAntenna04);
        submenuNK.add(submenuKTP);
        menu.add(submenuNK);

        //Кунгей
        submenuK = new JMenu("Кунгей");
        itemNothingK = new JMenuItem("без ничего");
        itemNothingK.addActionListener(this);
        submenuK.add(itemNothingK);
        item1KK = new JMenuItem("1 концентратор");
        item1KK.addActionListener(this);
        submenuK.add(item1KK);
        item3KK = new JMenuItem("3 концентратора");
        item3KK.addActionListener(this);
        submenuK.add(item3KK);
        menu.add(submenuK);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        menuBar.setVisible(true);
    }






    public static void main(String[] args) {
        new CoveringWindow();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
