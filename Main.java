import javax.swing.SwingUtilities;
import View.*;
import Controller.*;
import Model.*;

public class Main {
    public static void main(String[] args) {
        CowStock cowStock = new CowStock();
        Manage manage = new Manage(cowStock);
        // Create and run JFrame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window(manage);

                new CowStockFrame(manage);
            }
        });
    }
}
