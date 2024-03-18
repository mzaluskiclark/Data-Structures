import java.util.Scanner;

public class PizzaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for toppings
        String[] toppingsArray = new String[10];
        int numOfToppings = 0;
        final String QUIT = "QUIT";

        System.out.println("Enter the pizza toppings (enter QUIT to finish or reach maximum toppings):");
        while (numOfToppings < 10) {
            System.out.print("Topping " + (numOfToppings + 1) + ": ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(QUIT)) {
                break;
            }
            toppingsArray[numOfToppings] = input;
            numOfToppings++;
        }

        // Prompt the user for delivery
        System.out.print("Do you want the pizza to be delivered? (yes/no): ");
        String deliveryChoice = scanner.nextLine();

        Pizza pizza;
        if (deliveryChoice.equalsIgnoreCase("yes")) {
            // Prompt for delivery address
            System.out.print("Enter delivery address: ");
            String deliveryAddress = scanner.nextLine();
            pizza = new DeliveryPizza(toppingsArray, deliveryAddress, numOfToppings);
        } else {
            pizza = new Pizza(toppingsArray, numOfToppings);
        }

        // Display pizza information
        System.out.println("\nYour Pizza Details:");
        System.out.println(pizza);

        // If DeliveryPizza, also display delivery fee and address
        if (pizza instanceof DeliveryPizza) {
            DeliveryPizza deliveryPizza = (DeliveryPizza) pizza;
            System.out.println("Delivery Address: " + deliveryPizza.getDeliveryAddress());
            System.out.println("Delivery Fee: $" + deliveryPizza.getDeliveryFee());
        }

        scanner.close();
    }
}
