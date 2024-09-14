package View;

import javax.swing.*;
import Controller.Manage;
import Model.Cow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CowStockFrame extends JFrame {
    
    private JTextArea stockDisplay;  // Text area to display stock
    private Manage manage;
    private JButton refreshButton;

    public CowStockFrame(Manage m) {
        manage = m;
        setTitle("Cow Stock Manager");

        // Set layout to BorderLayout
        setLayout(new BorderLayout());

        // Initialize the text area to display stock (initially empty)
        stockDisplay = new JTextArea(15, 30);
        stockDisplay.setEditable(false);  // Read-only text area
        JScrollPane scrollPane = new JScrollPane(stockDisplay);  // Add scroll to the text area

        // Initialize and configure the refresh button
        refreshButton = new JButton("Refresh Stock");

        // Add text area and button to the frame
        add(scrollPane, BorderLayout.CENTER);     // Add the text area to the center
        add(refreshButton, BorderLayout.SOUTH);   // Add the refresh button to the bottom

        // Display initial stock
        showStock(manage.getStock());

        // Add action listener to the refresh button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStock(manage.getStock());
            }
        });

        // Basic frame settings
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    // Show stock in the output area
    private void showStock(ArrayList<Cow> stock) {
        stockDisplay.setText("");  // Clear existing content
        
        // Iterate over the stock and append details to the text area
        for (Cow cow : stock) {
            stockDisplay.append("ID: " + cow.getId() + ", Color: " + cow.getColor() + ", Age: " + cow.getAge() + "\n");
        }
    }
}
