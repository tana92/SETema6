package controler;

import exceptions.InputException;
import interfaces.IControler;
import interfaces.IModelView;
import model.ValueModel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanasescu on 11/30/2014.
 */
public class VController implements IControler {
    // Declar modelele
    private ValueModel model,model1,model2;
    // Declar o lista de vizualizari
    private List<IModelView> views;


    // Metoda pentru adaugarea unei vizualizari
    public void addView(IModelView view) {
        if (views == null) {
            views = new ArrayList<IModelView>();
        }
        views.add(view);
    }


    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(ACTION_CALCULATE)) {
            try {
                String userInput="ACTION_CALCULATE";
                makeOperation(userInput);

            } catch (InputException e) {
                notifyViews(true, e.getMessage());
            } catch (ClassCastException ec) {
                notifyViews(true, ec.getMessage());
            }
        }
    }

    // Adaug modelul
    public void addModel(ValueModel mm,ValueModel mm1,ValueModel mm2) {
        model = mm;
        model1 = mm1;
        model2 = mm2;
    }

    // Afisez mesajul
    private void notifyViews(boolean isError, String message) {
        if (views != null && !views.isEmpty()) {
            for (IModelView view : views) {
                view.onMessage(isError, message);
            }
        }
    }

    // Setez valorile
    private void makeOperation(String operand) throws InputException {
        if (model != null && model1 != null & model2 != null) {

            try {
                model.setTemperature();
                model1.setWind();
                model2.setPressure();

            } catch (NumberFormatException e) {
                throw new InputException(operand, e.getMessage());
            }
        }
    }
}
