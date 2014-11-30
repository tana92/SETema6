package view;


import interfaces.IControler;
import interfaces.IModelListenere;
import interfaces.IModelView;
import model.ValueModel;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Tanasescu on 11/30/2014.
 */
public class ValueView extends JFrame implements IModelListenere, IModelView {

    private JLabel t = new JLabel("Temperature");
    private JTextField temp = new JTextField(10);

    private JLabel w = new JLabel("Wind");
    private JTextField wi = new JTextField(10);

    private JLabel p = new JLabel("Pressure");
    private JTextField pres = new JTextField(10);

    private JButton update = new JButton("Update");

    private ValueModel model;
    private ValueModel model1;
    private ValueModel model2;


    public ValueView() {


        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.setFont(new Font("Sans Serif", Font.PLAIN, 75));


        this.setSize(500,600);
        jpanel.add(t);
        jpanel.add(temp);
        jpanel.add(w);
        jpanel.add(wi);
        jpanel.add(p);
        jpanel.add(pres);
        jpanel.add(update);

        this.setContentPane(jpanel);
        this.pack();
        this.setTitle("Meteo");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public void addModel(ValueModel mod, ValueModel mod1,ValueModel mod2) {
        model = mod;
        temp.setText(mod.getTemperature());

        model1 = mod1;
        wi.setText(mod1.getWind());

        model2 = mod2;
        pres.setText(mod2.getPressure());

    }

    public void addController(IControler controller) {
        update.setActionCommand(IControler.ACTION_CALCULATE);
        update.addActionListener(controller);

    }

    public void onMessage(boolean isError, String message) {
        if (isError) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Calc MVC", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public void onUpdate() {
        temp.setText(model.getTemperature());
        wi.setText(model1.getWind());
        pres.setText(model2.getPressure());



    }
}
