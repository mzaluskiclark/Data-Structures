import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoPizza extends JFrame implements ActionListener {
    // Creates the labels, text fields, and buttons to be added to the panels
    JLabel heading = new JLabel("Add ANY topping to your pizza!");
    JLabel typeToppings = new JLabel("Enter topping name 1 at a time: ($2 each)");
    //creates 2 font styles for the fonts on screen
    Font bigFont = new Font("Arial", Font.BOLD, 20);
    Font mediumFont = new Font("Arial", Font.ITALIC, 12);
    JTextField headingField = new JTextField(20); //makes the text field 20 columns wide
    JButton confirmToppingButton = new JButton("Add Topping");
    JButton confirmOrderButton = new JButton("Confirm Order");
    JLabel listOfToppings = new JLabel(); //starts with an empty label
    String[] toppingsList = new String[10]; //creates the array of strings for the 10 toppings
    String deliveryAddress = ""; //empty string to store the delivery address
    String deliveryDistance = "";
    int toppingsCounter = 0; //variable to be updated with each new toppings

    public DemoPizza() {
        super("My frame");
        setLayout(new BorderLayout());
        //Creates a panel for the heading text and adds the labels to it
        JPanel gridPanel = new JPanel(new GridLayout(0, 1));
        gridPanel.add(heading);
        gridPanel.add(typeToppings);

        //Creates a panel for the text field and adds the text field to it
        JPanel textFieldPanel = new JPanel(new FlowLayout());
        textFieldPanel.add(headingField);

        //Creates a panel for the buttons and adds the buttons to it
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(confirmToppingButton);
        buttonPanel.add(confirmOrderButton);

        //adds action listeners to the buttons
        confirmToppingButton.addActionListener(this);
        confirmOrderButton.addActionListener(this);

        //adds the panels to the frame
        add(gridPanel, BorderLayout.NORTH);
        add(textFieldPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.EAST);
        listOfToppings.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 0)); //code that creates an empty element, so my text isn't right on the border
        add(listOfToppings, BorderLayout.SOUTH);

        //sets the font of the labels
        heading.setFont(bigFont);
        listOfToppings.setFont(mediumFont);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirmToppingButton) {
            String topping = headingField.getText(); // Get the topping entered by the user
            //checks if toppings doesn't exceed max
            if (toppingsCounter < 10) {
                toppingsList[toppingsCounter] = topping; //adds topping to array
                toppingsCounter += 1; //adds 1 for each topping
                headingField.setText(""); //clears the displayed text field for it to be updated
                updateListOfToppings(); //updates text field with new topping list
            }
            //error warning for too many toppings
            else {
                JOptionPane.showMessageDialog(this, "You can only have 10 toppings");
            }
        }

        //handles when confirm order button is pressed

        if (e.getSource() == confirmOrderButton) {
            //prompts user if they want delivery
            String deliveryChoice = null;
            try {
                deliveryChoice = JOptionPane.showInputDialog("Do you want your pizza delivered? (yes/no) ($3 for totals above $18, $5 for below)");
                if (deliveryChoice.equalsIgnoreCase("yes")) {
                    //if user says yes to delivery
                    deliveryAddress = JOptionPane.showInputDialog("Enter address for Delivery");
                }
                //prompts the user for delivery distance from their address
                if (deliveryChoice.equalsIgnoreCase("yes")) {
                    deliveryDistance = JOptionPane.showInputDialog("How many miles from Worcester is your address?");
                }
                //creates the pizzaDelivery object if user says yes to delivery
                if (deliveryChoice.equalsIgnoreCase("yes")) {
                    DeliveryPizza userPizza = new DeliveryPizza(toppingsList, deliveryAddress, toppingsCounter);
                    DeliveryPizza deliveryPizza = userPizza;
                    //calculates total with get functions from classes
                    double grandTotal = userPizza.getPizzaPrice() + deliveryPizza.getDeliveryFee();
                    //builds the string that diplays pizza totals for price, delivery, using get methods
                    if (deliveryAddress.isEmpty()) {
                        deliveryAddress = "No delivery Address given";
                    }
                    JOptionPane.showMessageDialog(this, userPizza + "\nYour delivery price is: $" + deliveryPizza.getDeliveryFee() + "\nYour grand total is: $" + grandTotal + "\nYour pizza will be delivered to: " + deliveryPizza.getDeliveryAddress() + "\nYour estimated delivery time will be " + (Integer.parseInt(deliveryDistance) * 2 + " minutes"));
                } else {
                    //creates the pizza object if user says no to delivery
                    Pizza userPizza = new Pizza(toppingsList, toppingsCounter);
                    //displays pizza totals for price
                    JOptionPane.showMessageDialog(this, userPizza + "\nYou did not opt for delivery.\n" + "Your grand total is: $"+ userPizza.getPizzaPrice());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for distance.");
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Null input error. Please enter all required information.");
            }
        }
    }
    //method that updates the text of listOfToppings on the label
    private void updateListOfToppings() {
        String toppingsText = ""; // Initializes an empty string
        //for loop iterates for as many elements are in the list
        for (int i = 0; i < toppingsCounter; i++) {
            toppingsText += toppingsList[i]; //updates toppingsText string to element at i in list
            if (i < toppingsCounter - 1) {
                toppingsText += ", "; // Add a comma if it's not the last topping
            }
        }
        listOfToppings.setText("Toppings: " + toppingsText); // sets the text of listOfToppings
    }
    //main function that creates the frame
    public static void main(String[] args) {
        DemoPizza frame = new DemoPizza();
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}