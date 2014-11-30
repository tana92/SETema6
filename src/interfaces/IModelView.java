package interfaces;

/**
 * Created by Tanasescu on 11/30/2014.
 */
public interface IModelView {
    // Metoda pentru afisarea mesajului primit de la controller
    public void onMessage(boolean isError, String message);
}
