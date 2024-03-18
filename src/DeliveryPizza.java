public class DeliveryPizza extends Pizza{
    private double deliveryFee;
    private String deliveryAddress;
    public DeliveryPizza (String[] userToppingsArray, String userDeliveryAddress, int userNumOfToppings) {
        super(userToppingsArray, userNumOfToppings);
        deliveryAddress = userDeliveryAddress;
        double i = getPizzaPrice();
        //calculates delivery fee based on the price of the pizza
        if (i > 18) {
            deliveryFee = 3;
        }
        else {
            deliveryFee = 5;
        }
    }
    public double getDeliveryFee() {
        return deliveryFee;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
