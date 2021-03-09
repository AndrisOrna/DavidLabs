package CurrencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public class View extends JFrame {

    private JButton add = new JButton("add");
    private JButton remove = new JButton("remove");
    private JButton print = new JButton("print");

    private JLabel fNameLab = new JLabel("First Name:");
    private JLabel lNameLab = new JLabel("Last Name:");

    private JLabel printLab = new JLabel("Print Area:");

    private JTextField fNameField = new JTextField();
    private JTextField lNameField = new JTextField();

    private JTextArea printArea = new JTextArea();

    private JPanel menuPanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JPanel printPanel = new JPanel();


    private Container contentPane = this.getContentPane();

    public View()
    {
        this.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        this.setSize(750,750);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public void init()
    {
        menuPanel.add(add);
        menuPanel.add(remove);
        menuPanel.add(print);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(fNameLab);
        mainPanel.add(fNameField);
        mainPanel.add(lNameLab);
        mainPanel.add(lNameField);


        printPanel.setLayout(new BorderLayout());

        JScrollPane scroll = new JScrollPane(printArea);

        printPanel.add(printLab, BorderLayout.NORTH);
        printPanel.add(scroll, BorderLayout.CENTER);


        contentPane.add(menuPanel);
        contentPane.add(mainPanel);
        contentPane.add(printPanel);


        this.setVisible(true);
    }

    public void setWindowsListener(WindowListener w)
    {
        this.addWindowListener(w);
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getRemove() {
        return remove;
    }

    public JButton getPrint() {
        return print;
    }

    public JTextField getfNameField() {
        return fNameField;
    }

    public JTextField getlNameField() {
        return lNameField;
    }

    public JTextArea getPrintArea() {
        return printArea;
    }

}
