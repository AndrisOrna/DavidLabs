package CurrencyConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller implements ActionListener, WindowListener {

    private View view;
    private ArrayList<Model> models;

    public Controller()
    {
        models = new ArrayList<>();

        view = new View();
        view.init();

        view.setWindowsListener(this);
        view.getAdd().addActionListener(this);
        view.getRemove().addActionListener(this);
        view.getPrint().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getAdd())
        {
            addToModel();
        }else if (e.getSource() == view.getRemove())
        {
            removeFromModel();
        }
        else if (e.getSource() == view.getPrint())
        {
            printModel();
        }
       //System.out.println("button pressed");
    }

    private void addToModel() {
        models.add(new Model(view.getfNameField().getText(), view.getlNameField().getText()));
    }

    private void removeFromModel() {

        int index = -1;

        for (int i = 0; i < models.size(); i++)
        {
            if (models.get(i).getfName().equals(view.getfNameField().getText())){
                index = i;

                break;
            }
        }

        if(index != -1)
            models.remove(index);

    }

    private void printModel() {
        String text = "";

        for (Model m : models)
        {
            text = text + m + "\n";
        }

        view.getPrintArea().setText(text);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window started");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window closing");
        File f = new File("backup.txt");

        try
        {
            PrintWriter pw = new PrintWriter(f);

            for(Model m : models)
            {
                pw.println(m);
            }

            pw.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
