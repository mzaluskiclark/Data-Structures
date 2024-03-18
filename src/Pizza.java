public class Pizza {
    private String[] toppingsArray = new String[10];
    private double pizzaPrice;

    private String descriptionString;


    public Pizza (String[] userToppingsArray, int userNumOfToppings) {
        toppingsArray = userToppingsArray;
        pizzaPrice = 14 + (2 * userNumOfToppings);
        descriptionString = "";
        for (int i = 0; i < userNumOfToppings; i++) {
            descriptionString += toppingsArray[i];
            if (i < userNumOfToppings - 1) {
                descriptionString += ", ";
            }
        }

    }
    @Override
    public String toString() {
        return "Your pizza has these toppings: " + descriptionString;
    }
    public double getPizzaPrice() {
        return pizzaPrice;
    }
}