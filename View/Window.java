package View;

import javax.swing.*;

import Controller.Manage;
import Model.Cow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {

    private JTextField inputField; // Input area
    private JTextArea outputArea; // Output area
    private JButton btnGetCow; // Button to display input
    private JButton btnGetMilk; // Button to Get Milk field
    private JButton btnEatLemon; // Button to EatLemon Button
    private Manage manage;
     private ArrayList<Cow> cows = new ArrayList<>(); //keep order of cow before update in output area

    public Window(Manage manage) {
        // Set the title of the JFrame
        this.manage = manage;
        setTitle("Simple JFrame Example");


        inputField = new JTextField(20); // Input area
        outputArea = new JTextArea(10, 30); // Output area
        outputArea.setEditable(false); // Make the output area read-only
        JScrollPane scrollPane = new JScrollPane(outputArea); // Scroll pane for the output area

        // Initialize buttons
        btnGetCow = new JButton("Get Cow");
        btnGetMilk = new JButton("Get Milk");
        btnEatLemon = new JButton("Eat Lemon");

        // Set layout for the JFrame
        setLayout(new FlowLayout());

        // Add components to the JFrame
        add(new JLabel("Input:")); // Label for input field
        add(inputField); // Add input area
        add(btnGetCow); // Add display button
        add(btnGetMilk); // Add Get Milk button
        add(btnEatLemon); // Add EatLemon button
        btnEatLemon.setVisible(false);
        add(new JLabel("Output:")); // Label for output area
        add(scrollPane); // Add output area inside scroll pane

        // Set up the button actions
        btnGetCow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // outputArea.setText("");
                String inputText = inputField.getText();
                inputText = inputText.trim();
                // Regular expression to m atch 8 digit only and no 0 at the first digit
                String regex = "^[1-9][0-9]{7}$";

                // input check
                if (inputText.matches(regex)) {
                    // Parse input to int
                    int input = Integer.parseInt(inputText);
                    manage.setIdInput(input); // Send id to Manage

                } else {
                    // if not match to regex
                    JOptionPane.showMessageDialog(btnGetCow,
                            "Invalid input! Please enter exactly 8 digits with the first digit not being 0.");
                }
                //check that cow is nerver shown
                Cow cow = manage.showCowbyID();
                if (!cow.isShown) {
                    cow.isShown = true;
                    cows.add(cow);
                    outputArea.append("ID: " + cow.getId() + ", Color: " + cow.getColor() + ", Age: " + cow.getAge()
                            + "  milk product: " + cow.numberOfMilk + "\n");
                }
                if(cow.getColor() == "white" && !cow.isDrinkLemon){
                    btnEatLemon.setVisible(true);
                }
                if(cow.getColor() == "brown"){
                    btnEatLemon.setVisible(false);
                }
            }
        });

        // BUTTON ZONE ------------------------------------------------------------------
        //BTN GETMILK
        btnGetMilk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display milk information
                JOptionPane.showMessageDialog(btnGetMilk,
                        manage.getMilkfromCow());
                Cow currentCow = manage.getCurrentCow();
                updateCowList(currentCow);
            }
        });
       
        //BTN GETMILK
        btnEatLemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cow cow = manage.getCurrentCow();
                cow.isDrinkLemon = true;
               
            }
        });

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window size and make it visible
        setSize(400, 300);
        setVisible(true);
    }

    // Update cow that have more milk product
    public void updateCowList(Cow cow) {

        outputArea.setText("");
            for (Cow c : cows) {
                if(c.getColor() == "Blue"){
                    outputArea.append("ID: " + c.getId() + ", Color: " + c.getColor() + ", Age: " + c.getAge()
                    + "  milk product: " + c.numberOfMilk + "BSOD NOW" + "\n");
                }else{

                    outputArea.append("ID: " + c.getId() + ", Color: " + c.getColor() + ", Age: " + c.getAge()
                    + "  milk product: " + c.numberOfMilk + "\n");
                }
            }
    }

    // Show the updated list of cows in the output area
    public void showStock() {
        outputArea.setText(""); // Clear the existing content
        for (Cow cow : cows) {
            outputArea.append("ID: " + cow.getId() + ", Color: " + cow.getColor() + ", Age: " + cow.getAge() + "\n");
        }
    }
}

