
import model.ValueModel;
import view.ValueView;
import controler.VController;


/**
 * Created by Tanasescu on 11/30/2014.
 */
public class main {

    public static void main(String[] args) {

        ValueModel modell = new ValueModel();
        ValueModel modell1 = new ValueModel();
        ValueModel modell2 = new ValueModel();
        ValueView view = new ValueView();
        VController controller = new VController();

        // Adaug un view
        modell.addModelListener(view);

        // Adaug modelele si controller-ul la view
        view.addModel(modell,modell1,modell2);
        view.addController(controller);

        // Adaug modelele si un view la controller
        controller.addModel(modell,modell1,modell2);
        controller.addView(view);

        // Afisez view-ul
        view.setVisible(true);
    }
}
