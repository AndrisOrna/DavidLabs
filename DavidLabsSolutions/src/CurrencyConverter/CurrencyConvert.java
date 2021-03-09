package CurrencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConvert extends JFrame implements BaseCurrency, MultipleCurrency, ActionListener {

    private double euroRate = 1.15;
    private double gbpRate = 1.30;
    private double yuanRate = 0.8;

    private double baseCurrency = 0.0;

    private JTextField euroField = new JTextField(),gbpField = new JTextField(),usdField = new JTextField(),yuanField = new JTextField();
    private JLabel euroLab = new JLabel("Euro"),gbpLab = new JLabel("gbp"),usdLab = new JLabel("usd"),yuanLab = new JLabel("yuan");

    private Container contentPane = this.getContentPane();

    public CurrencyConvert()
    {
        setSize(200,400);
        setTitle("Currency Convert");
        setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
    }

    public void init()
    {
        euroField.addActionListener(this);
        gbpField.addActionListener(this);
        usdField.addActionListener(this);
        yuanField.addActionListener(this);

        add(euroLab);
        add(euroField);

        add(gbpLab);
        add(gbpField);

        add(usdLab);
        add(usdField);

        add(yuanLab);
        add(yuanField);

        this.setVisible(true);
    }

    @Override
    public void setUsd(double d) {
        baseCurrency = d;
    }

    @Override
    public double toUsd() {
        double returnValue = Math.ceil((baseCurrency) * 100)/100;
        return returnValue;
    }

    @Override
    public double toEuro() {
        double returnValue = Math.ceil((baseCurrency/euroRate) * 100)/100;
        return returnValue;
    }

    @Override
    public double toGBP() {
        double returnValue = Math.ceil((baseCurrency/gbpRate) * 100)/100;
        return returnValue;
    }

    @Override
    public double toYuan() {
        double returnValue = Math.ceil((baseCurrency/yuanRate) * 100)/100;
        return returnValue;
    }

    @Override
    public void euroToUsd(double d) {
        baseCurrency = d * euroRate;
    }

    @Override
    public void gbpToUsd(double d) {
        baseCurrency = d * gbpRate;
    }

    @Override
    public void yuanToUsd(double d) {
        baseCurrency = d * yuanRate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == euroField)
        {
            euroToUsd(Double.parseDouble(euroField.getText()));
        }
        else if (e.getSource() == usdField)
        {
            setUsd(Double.parseDouble(usdField.getText()));
        }
        else if(e.getSource() == gbpField)
        {
            gbpToUsd(Double.parseDouble(gbpField.getText()));
        }
        else if(e.getSource() == yuanField)
        {
            yuanToUsd(Double.parseDouble(yuanField.getText()));
        }

        euroField.setText("" + toEuro());
        usdField.setText("" + toUsd());
        gbpField.setText("" + toGBP());
        yuanField.setText("" + toYuan());
    }

    public static void main(String[] args) {
        new CurrencyConvert().init();
    }
}
