import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CoveringWindow extends JFrame implements ActionListener {
    private JPanel rootPanel;
    private JTextField TextField1;
    private JTextField TextField2;
    private JTextField TextField3;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu submenuNK;
    private JMenu submenuK;
    private JMenu submenuTP;
    private JMenu submenuFacade;
    private JMenu submenuKTP;
    private JMenuItem itemNothingK; //ничего нет кунгей
    private JMenuItem itemNothingF; //CLN без конц фасад
    private JMenuItem item200041; // 200.04, 1 конц
    private JMenuItem item20004Nothing; // 200.04, ничего не прописано
    private JMenuItem item2301; // 230, 1 концентратор
    private JMenuItem item230Nothing; // 230, ничего не прописано
    private JMenuItem itemNothingH; // без ничего по высокой
    private JMenuItem item1KK; //220 1 конц кунгей
    private JMenuItem item1KF; //CLN с 1 конц фасад
    private JMenuItem item1KM20004F; //1 концентратор и М-200.04 фасад
    private JMenuItem item220NothingF; //220 без конц фасад
    private JMenuItem item3KK; //Кунгей, 3 концентратора кунгей
    private JMenuItem item3KF; //CLN с 3 конц фасад
    private JMenuItem itemFull;
    private JMenuItem itemMMT;
    private JMenuItem itemMMT3; //ММТ-5 и 3 конц
    private JMenuItem itemMMTH; //ММТ-5 по высокой
    private JMenuItem itemMMTAntenna;
    private JMenuItem itemMMTAntennaHigh; //ММТ и антена по высокой 10кВ ктп
    private JMenuItem itemMMTAntenna04; //ММТ и антена ктп
    private JMenuItem itemMMTAntenna04SCH; //ММТ и антена субпотребители и квар-ные счетчики ктп

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
                Parser.ChengePattern(paragraphs, actionEvent.getActionCommand(), TextField3.getText(),
                        TextField2.getText());
                Parser.CopyTU(TextField1.getText()+"\\"+TextField2.getText()+".doc",
                        TextField3.getText(), TextField2.getText());
                JOptionPane.showMessageDialog(null,
                        "Сэр / Сэрина, есть, Сэр / Сэрина. Все готово! \n Не забудь занести в Excel");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (InvalidFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
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
                "\\___Тех условия и тех требования\\Шаблоны\\в ТП жарыка\\200.04, ничего не прописано.docx");
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
        itemNothingF = new JMenuItem("CLN без конц");
        itemNothingF.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\фасад (не кунгей)\\CLN без конц.docx");
        itemNothingF.addActionListener(actionListener);
        submenuFacade.add(itemNothingF);

        item1KM20004F = new JMenuItem("1 концентратор и М-200.04");
        item1KM20004F.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\фасад (не кунгей)\\1 концентратор и М-200.04.docx");
        item1KM20004F.addActionListener(actionListener);
        submenuFacade.add(item1KM20004F);

        item1KF = new JMenuItem("CLN с 1 конц");
        item1KF.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\фасад (не кунгей)\\CLN с 1 конц.docx");
        item1KF.addActionListener(actionListener);
        submenuFacade.add(item1KF);

        item220NothingF = new JMenuItem("220 без конц");
        item220NothingF.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\фасад (не кунгей)\\220 без конц.docx");
        item220NothingF.addActionListener(actionListener);
        submenuFacade.add(item220NothingF);

        item3KF = new JMenuItem("CLN с 3 конц");
        item3KF.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\фасад (не кунгей)\\CLN с 3 конц.docx");
        item3KF.addActionListener(actionListener);
        submenuFacade.add(item3KF);
        submenuNK.add(submenuFacade);

        //КТП потребителя
        submenuKTP = new JMenu("КТП потребителя");

        itemMMTAntennaHigh = new JMenuItem("ММТ и антена по высокой 10кВ");
        itemMMTAntennaHigh.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\КТП Потребителя\\ММТ и антена по высокой 10кВ.docx");
        itemMMTAntennaHigh.addActionListener(actionListener);
        submenuKTP.add(itemMMTAntennaHigh);

        itemMMTAntenna04SCH = new JMenuItem("ММТ и антена субпотребители и квар-ные счетчики");
        itemMMTAntenna04SCH.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны" +
                "\\КТП Потребителя\\ММТ и антена субпотребители и квар-ные счетчики.docx");
        itemMMTAntenna04SCH.addActionListener(actionListener);
        submenuKTP.add(itemMMTAntenna04SCH);

        itemMMTAntenna04 = new JMenuItem("ММТ и антена");
        itemMMTAntenna04.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны" +
                "\\КТП Потребителя\\ММТ и антена.docx");
        itemMMTAntenna04.addActionListener(actionListener);
        submenuKTP.add(itemMMTAntenna04);

        submenuNK.add(submenuKTP);
        menu.add(submenuNK);

        //Кунгей
        submenuK = new JMenu("Кунгей");

        itemNothingK = new JMenuItem("ничего нет");
        itemNothingK.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\Кунгей\\ничего нет.docx");
        itemNothingK.addActionListener(actionListener);
        submenuK.add(itemNothingK);

        item1KK = new JMenuItem("220 1 конц");
        item1KK.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\Кунгей\\220 1 конц.docx");
        item1KK.addActionListener(actionListener);
        submenuK.add(item1KK);

        item3KK = new JMenuItem("Кунгей, 3 концентратора");
        item3KK.setActionCommand("\\\\192.168.4.99\\oaskue_bp\\АСКУЭ 0,4кВ" +
                "\\___Тех условия и тех требования\\Шаблоны\\Кунгей\\Кунгей, 3 концентратора.docx");
        item3KK.addActionListener(actionListener);
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
