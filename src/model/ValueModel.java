package model;


import exceptions.InputException;
import interfaces.IModelListenere;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tanasescu on 11/30/2014.
 */
public class ValueModel {


    private int temperatura;
    private int vant;
    private int presiune;

    private List<IModelListenere> listeners;

    // Metoda pentru setarea temperaturii random
    public void setTemperature() throws InputException {
        try {

            Random rand = new Random();
            temperatura = rand.nextInt(50);

            notifyListeners();
        } catch (NumberFormatException e) {
            throw new InputException("temperatura", e.getMessage());
        }

    }

    // Metoda pentru setarea vitezei vantului random
    public void setWind () throws InputException {

        try {
            Random rand1 = new Random();
             vant = rand1.nextInt(50);

            notifyListeners();
        } catch (NumberFormatException e) {
            throw new InputException("viteza vantului", e.getMessage());
        }
    }

    // Metoda pentru setarea presiunii random
    public void setPressure() throws InputException{

        try {
            Random rand2 = new Random();
            presiune = rand2.nextInt(1500);
            notifyListeners();

        } catch (NumberFormatException e) {
            throw new InputException("presiunea", e.getMessage());
        }
    }

    // Metoda care returneaza temperatura
    public String getTemperature() {

        return ((Integer.toString(temperatura)));

    }

    // Metoda care returneaza viteza vantului
    public String getWind() {
        return ((Integer.toString(vant)));
    }

    // Metoda care returneaza presiunea
    public String getPressure() {
        return ((Integer.toString(presiune)));
    }

    // Adauga la lista
    public void addModelListener(IModelListenere listener) {
        if (listeners == null) {

            listeners = new ArrayList<IModelListenere>();
        }

        listeners.add(listener);
    }

    // Notifica utilizatorii vizualizarilor de schimbarile efectuate
    private void notifyListeners() {

        if (listeners != null && !listeners.isEmpty()) {
            for (IModelListenere listener : listeners)
                listener.onUpdate();
        }
    }
}
