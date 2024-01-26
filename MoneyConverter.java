//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// this imports the libraries including random which will be used for the roulette game and scanner which will be used for user input
import java.util.Random;
import java.util.Scanner;
public class MoneyConverter {
//this program calculates the amount of each denomination of coin in an amount of dollars and cents given by the user
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("Enter amount of money (__.__): ");
        //this creates a new int variable that is set to the double value provided by the user, and then multiplied by 100
        int total = (int) (sc.nextDouble() * 100);
        //creates a copy of the initial total to be used for second calculation after gambling
        int newtotal = total * 2;
        //these next lines calculate the amount of each coin in the total and prints them
        int quarters = (int) (total / 25);
        total = total - (quarters * 25);
        int dimes = (int) (total / 10);
        total = total - (dimes * 10);
        int nickels = (int) (total / 5);
        total = total - (nickels * 5);
        int pennies = total;
        System.out.println("Total quarters: " + quarters);
        System.out.println("Total dimes: " + dimes);
        System.out.println("Total nickels: " + nickels);
        System.out.println("Total pennies: " + pennies);

        //this part of the code allows the user to gamble their coins in a roullette style
        System.out.print("Would you like to gamble your coins?: ");
        //this takes in the first character the user inputs to whether they want to gamble (allows for 'yes', 'yea', and 'yup' etc. to all work
        char yesORno = sc.next().charAt(0);
        //tells the user to input either yes or no if they answer something random
        if (yesORno != 'n' & yesORno != 'y') {
            System.out.println("Please answer either yes or no");
        }
        //loop that runs until the user finally answers yes to gambling
        while (yesORno != 'y') {
            System.out.println("Let's try again...");
            System.out.print("Would you like to gamble your coins?: ");
            yesORno = sc.next().charAt(0);
            if (yesORno != 'n' & yesORno != 'y') {
                System.out.println("Please answer with either yes or no.");
            }
        }
        System.out.println("Finally...We will be playing roulette. Do you want to go all in on Red or all in on Black?: ");
        //takes in user input, but does nothing with it because any answer results in the same chance of win/loss
        char pretend = sc.next().charAt(0);
        //these next couple lines define a random integer which will be set to either 1 "win" or "0" lose
        Random rand = new Random();
        int randomint = rand.nextInt(2);
        //detects if the user has "won" and recalculates the coin totals after being doubled
        if (randomint == 1) {
            System.out.println("You win!");
            int newquarters = (int) (newtotal / 25);
            newtotal = newtotal - (newquarters * 25);
            int newdimes = (int) (newtotal / 10);
            newtotal = newtotal - (newdimes * 10);
            int newnickels = (int) (newtotal / 5);
            newtotal = newtotal - (newnickels * 5);
            int newpennies = newtotal;
            System.out.println("Total quarters: " + newquarters);
            System.out.println("Total dimes: " + newdimes);
            System.out.println("Total nickels: " + newnickels);
            System.out.println("Total pennies: " + newpennies);
        }
        //if the random integer does not become one, outputs that the user has lost their money
        else {
            System.out.print("You lose... you now have 0 coins. NEVER GAMBLE!");
        }
    }
}

