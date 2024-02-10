//imports the libraries for GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
//main class for the Pizza Application
public class PizzaApp extends JFrame implements ItemListener {
    //declares variables such as pizzaSize constant, and totals for size, toppings, and total pizza
    int pizzaSize = 50;
    float sizePriceTotal = 0;
    float toppingPriceTotal = 0;
    double total = 0;
    //Creates the label for the title
    JLabel label = new JLabel("                     Create Your Pizza");
    //Creates the pizza size buttons
    JRadioButton small = new JRadioButton("Small ($5)", false);
    JRadioButton medium = new JRadioButton("Medium ($10)", false);
    JRadioButton large = new JRadioButton("Large (15$)", false);
    JRadioButton supersize = new JRadioButton("Super ($20)", false);
    //Creates the toppings checkboxes
    JCheckBox Mushroom = new JCheckBox("Mushrooms", false);
    JCheckBox Peppers = new JCheckBox("Peppers", false);
    JCheckBox Pineapple = new JCheckBox("Pineapple", false);
    JCheckBox Rocks = new JCheckBox("Rocks", false);
    JCheckBox Cheese = new JCheckBox("Cheese", false);
    //creates the total label
    JLabel Total = new JLabel("Total:");
    //Creates the panel that the pizza graphic will be on
    JPanel pizzaPanel = new PizzaPanel();
    //Creates the buttongroup for the sizes, only one can be selected at a time
    //Constructs PizzaApp class
    public PizzaApp(){
        super("PizzaApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Layout for the JFrame
        setLayout(new BorderLayout());
        //Sets the font, style, and size for the displayed text
        label.setFont(new Font("Arial",Font.BOLD, 40));

        small.setForeground(Color.blue);
        small.setFont(new Font("Arial", Font.PLAIN, 30));
        medium.setForeground(Color.green);
        medium.setFont(new Font("Arial", Font.PLAIN, 30));
        large.setForeground(Color.orange);
        large.setFont(new Font("Arial", Font.PLAIN, 30));
        supersize.setForeground(Color.red);
        supersize.setFont(new Font("Arial", Font.PLAIN, 30));

        Mushroom.setFont(new Font("Arial", Font.PLAIN, 16));
        Peppers.setFont(new Font("Arial", Font.PLAIN, 16));
        Pineapple.setFont(new Font("Arial", Font.PLAIN, 16));
        Rocks.setFont(new Font("Arial", Font.PLAIN, 16));
        Cheese.setFont(new Font("Arial", Font.PLAIN, 16));

        Total.setFont(new Font("Arial",Font.BOLD, 40));
        //Creates the buttongroup for size buttons and adds the components to the group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(small);
        buttonGroup.add(medium);
        buttonGroup.add(large);
        buttonGroup.add(supersize);



        //Creates the panel for the radio buttons and adds them to it
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(label);
        radioPanel.add(small);
        radioPanel.add(medium);
        radioPanel.add(large);
        radioPanel.add(supersize);

        //Creates the panel for check buttons and adds them to it
        JPanel checkPanel = new JPanel(new GridLayout(0, 5));
        checkPanel.add(Mushroom);
        checkPanel.add(Peppers);
        checkPanel.add(Pineapple);
        checkPanel.add(Rocks);
        checkPanel.add(Cheese);
        //Creates the panel for the total label
        JPanel totalPanel = new JPanel(new FlowLayout());
        totalPanel.add(Total);

        //Adds item listeners to all buttons to check for clicks and unclicks
        small.addItemListener(this);
        medium.addItemListener(this);
        large.addItemListener(this);
        supersize.addItemListener(this);
        Mushroom.addItemListener(this);
        Peppers.addItemListener(this);
        Pineapple.addItemListener(this);
        Rocks.addItemListener(this);
        Cheese.addItemListener(this);

        //Adds all the panels to the Frame
        add(radioPanel, BorderLayout.NORTH);
        add(checkPanel, BorderLayout.LINE_START);
        add(pizzaPanel, BorderLayout.LINE_END);
        add(totalPanel, BorderLayout.SOUTH);
    }
    @Override
    //Method that deals with button interaction
    public void itemStateChanged(ItemEvent e) {
        //Gets the item sources and state changes of the buttons
        Object source = e.getItem();
        int select = e.getStateChange();

        byte toppingcounter = 0;
        toppingPriceTotal = 0;
        //Calculates the topping total price based on toppings buttons which are pressed
        if (Mushroom.isSelected()){
            toppingPriceTotal += 0.50;

        }
        if (Peppers.isSelected()){
            toppingPriceTotal += 0.50;

        }
        if (Pineapple.isSelected()){
            toppingPriceTotal += 0.50;

        }
        if (Rocks.isSelected()){
            toppingPriceTotal += 0.50;

        }
        //Detects when buttons are pressed, and updates variables accordingly
        if(select == ItemEvent.SELECTED) {
            if (source == small) {
                sizePriceTotal = 5;
                pizzaSize = 50;
            } else if (source == medium) {
                sizePriceTotal = 10;
                pizzaSize = 100;
            } else if (source == large) {
                sizePriceTotal = 15;
                pizzaSize = 150;
            } else if (source == supersize) {
                sizePriceTotal = 20;
                pizzaSize = 200;
            }
            //counts how many toppings are selected at a time
            if (Mushroom.isSelected()) {
                toppingcounter += 1;
            }
            if (Peppers.isSelected()) {
                toppingcounter += 1;
            }
            if (Pineapple.isSelected()) {
                toppingcounter += 1;
            }
            if (Rocks.isSelected()) {
                toppingcounter += 1;
            }
            if (Cheese.isSelected()) {
                toppingcounter += 1;
            }
            //Displays a warning message if too many toppings are selected
            if (toppingcounter > 3) {
                JOptionPane.showMessageDialog(null, "Cannot Select more than three toppings.");
                toppingcounter = 3;
                //Handles deselecting buttons when you reach the topping limit
                if (source == Mushroom){
                    Mushroom.setSelected(false);
                }
                else if (source == Peppers){
                    Peppers.setSelected(false);
                }
                else if (source == Pineapple){
                    Pineapple.setSelected(false);
                }
                else if (source == Rocks){
                    Rocks.setSelected(false);
                }
            }
            //Handles total calculations
            if (toppingcounter < 3) {
                total = sizePriceTotal + toppingPriceTotal;
            } else if (Cheese.isSelected()) {
                total = (sizePriceTotal + toppingPriceTotal);
            } else {
                total = (sizePriceTotal + toppingPriceTotal) - 0.25;
            }
        }
        //code repeated to show price in real time
        if (toppingcounter < 3) {
            total = sizePriceTotal + toppingPriceTotal;
        } else if (Cheese.isSelected()) {
            total = (sizePriceTotal + toppingPriceTotal);
        } else  {
            total = (sizePriceTotal + toppingPriceTotal) - 0.25;
        }
        //Updates the total text label to show the total in real time
        Total.setText("Total: $" + total);
        //redraws the pizza GUI every time an element is changed
        pizzaPanel.repaint();

    }
    //Class that creates the panel that the pizza will be drawn in
    class PizzaPanel extends JPanel {
        //calls functions needed to draw the pizza
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Creates the pizza circle with a set width, height, and variable pizzaSize
            drawPizza(g, getWidth()/4, getHeight()/2, pizzaSize/4);
        }
        //helper function that draws the pizza using fillOval and setColor
        private void drawPizza(Graphics g, int x, int y, int radius) {
            int diameter = radius * 2;
            g.setColor(new Color(255,170,0));
            g.fillOval(x - radius, y - radius, diameter, diameter);
            g.setColor(new Color(0,0,0));//resets color just in case
        }
        //reserves space for the pizza, so it doesn't interfere with other panels
        public Dimension getPreferredSize() {
            return new Dimension(300, 10);
        }
    }
    //main function that runs PizzaApp
    public static void main(String[] args) {
        PizzaApp frame = new PizzaApp();
        frame.setSize(850,500);
        //does not allow for resizing as resizing messes up the visual pizza gui
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

