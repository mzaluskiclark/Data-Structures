//imports the libraries for the GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GuiItemOrder extends JFrame implements ActionListener {
    //creates the labels, text fields, and buttons
    JLabel heading = new JLabel("Add to your cart (Maximum weight: 5000g)");
    JLabel discountLabel = new JLabel("If you buy more than 10 shrimp you get them all free!");
    JLabel appleLabel = new JLabel("How many apples do you want to buy? ($6 each)(200g each)");
    JTextField appleField = new JTextField();
    JLabel shrimpLabel = new JLabel("How many shrimp do you want to buy? ($10 each)(100g each)");
    JTextField shrimpField = new JTextField();
    JLabel colaLabel = new JLabel("How many cola do you want to buy? ($5 each)(300g each)");
    JTextField colaField = new JTextField();
    JButton button = new JButton("Update my cart");
    //sets the font size for the headers
    Font bigFont = new Font("Arial", Font.BOLD, 16);
    JLabel summaryText = new JLabel("Your cart: ");
    //empty labels that will be updated with the cart summary
    JLabel summaryApple = new JLabel("");
    JLabel summaryShrimp = new JLabel("");
    JLabel summaryCola = new JLabel("");
    JLabel totalLabel = new JLabel("");
    JLabel weightLabel = new JLabel("");
    //GUI constructor
    public GuiItemOrder() {
        super("My frame");
        setLayout(new BorderLayout());
        //creates the Panel in a grid layout and adds the labels, text fields, and buttons to the group
        JPanel gridPanel = new JPanel(new GridLayout(0,1));
        gridPanel.add(heading);
        gridPanel.add(discountLabel);
        gridPanel.add(appleLabel);
        gridPanel.add(appleField);
        gridPanel.add(shrimpLabel);
        gridPanel.add(shrimpField);
        gridPanel.add(colaLabel);
        gridPanel.add(colaField);
        gridPanel.add(summaryText);
        gridPanel.add(summaryApple);
        gridPanel.add(summaryShrimp);
        gridPanel.add(summaryCola);
        gridPanel.add(button);
        gridPanel.add(totalLabel);
        gridPanel.add(weightLabel);
        heading.setFont(bigFont);
        button.addActionListener(this);
        add(gridPanel, BorderLayout.NORTH);
    }
    //performs the actions when "Update cart" button is pressed
    public void actionPerformed(ActionEvent e) {
        //creates an empty ArrayList to store the ItemOrders
        ArrayList<ItemOrder> list = new ArrayList<>();
        //Takes in user input from the text fields for amount of each item
        String userApplesString = appleField.getText();
        String userShrimpString = shrimpField.getText();
        String userColaString = colaField.getText();
        //converts the user inputs from strings to integers
        int userApplesInt = (Integer.parseInt(userApplesString));
        int userShrimpInt = (Integer.parseInt(userShrimpString));
        int userColaInt = (Integer.parseInt(userColaString));
        //creates the item objects with their name and price
        Item Apple = new Item("Apple", 6);
        Item Shrimp = new Item("Shrimp", 10);
        Item Cola = new Item("Cola", 5);
        //creates the ItemOrder objects for each user order
        ItemOrder appleOrder = new ItemOrder(Apple, userApplesInt);
        ItemOrder shrimpOrder = new ItemOrder(Shrimp, userShrimpInt);
        ItemOrder colaOrder = new ItemOrder(Cola, userColaInt);

        //creates the user's shopping cart instance of the class
        ShoppingCart cart = new ShoppingCart(list);
        cart.addItemOrder(appleOrder);
        cart.addItemOrder(shrimpOrder);
        cart.addItemOrder(colaOrder);
        //creates empty strings to display the summary of each item purchased
        String sumApple = " ";
        String sumShrimp = " ";
        String sumCola = " ";

        int total = 0;
        int weight = 0;
        //loops that get itemOrder details from the array and add them to the string
        for (ItemOrder i : cart.getArrayList()) {
            if (i.getItem().getItemName().equals("Apple")) {
                sumApple += i.getItemAmount() + " " + i.getItem().getItemName() + "(s) at $" + i.getItem().getItemPrice() + " each, for a total of $" + (i.getItemAmount() * i.getItem().getItemPrice());
                total += i.getItemAmount() * i.getItem().getItemPrice();
                //calculates the weight of the type of item in the cart
                weight += i.getItemAmount() * 300;
            }
        }
        //sets the text of the string to the text of the label
        summaryApple.setText(sumApple);

        for (ItemOrder i : cart.getArrayList()) {
            if (i.getItem().getItemName().equals("Shrimp")) {
                //handles the discount if more than 10 shrimp are in the cart
                if (i.getItemAmount() > 10) {
                    sumShrimp = "Since you bought more than 10 shrimp, all your shrimp are free!";
                    weight += i.getItemAmount() * 100;
                }
                else {
                    sumShrimp += i.getItemAmount() + " " + i.getItem().getItemName() + "(s) at $" + i.getItem().getItemPrice() + " each, for a total of $" + (i.getItemAmount() * i.getItem().getItemPrice());
                    total += i.getItemAmount() * i.getItem().getItemPrice();
                    weight += i.getItemAmount() * 100;
                }
            }
        }
        summaryShrimp.setText(sumShrimp);

        for (ItemOrder i : cart.getArrayList()) {
            if (i.getItem().getItemName().equals("Cola")) {
                sumCola += i.getItemAmount() + " " + i.getItem().getItemName() + "(s) at $" + i.getItem().getItemPrice() + " each, for a total of $" + (i.getItemAmount() * i.getItem().getItemPrice());
                total += i.getItemAmount() * i.getItem().getItemPrice();
                weight += i.getItemAmount() * 200;
            }
        }
        summaryCola.setText(sumCola);
        totalLabel.setText("Your cart total is: $" + (total));
        //displays a pop-up if total cart weight exceeds the maximum
        if (weight > 5000) {
            JOptionPane.showMessageDialog(null, "Your cart's weight exceeds the maximum \n Your cart weighs " + weight + " grams out of a maximum 5000 grams");
        }
    }
    //main method that displays the GUI
    public static void main(String[] args) {
        GuiItemOrder frame = new GuiItemOrder();
        frame.setSize(400,600);
        frame.setVisible(true);
    }
}


