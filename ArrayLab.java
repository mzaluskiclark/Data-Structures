//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gut
import java.util.Scanner;
public class ArrayLab {
    public static void main(String[] args) {
        //Creates an empty array with 20 empty memory spaces for values
        double[] myArray = new double[20];
        //creates count variable
        int count = 0;
        var sc = new Scanner(System.in);
        System.out.println("Enter up to 20 double values!");
        //takes in user input for values, and adds them to the array
        for (int i = 0; i < 20; i++) {
            System.out.println("Enter value: ");
            double input = (sc.nextDouble());
            //counts how many values are in the array
            count += 1;
            myArray[i] = input;
            //prompts the user if they want to continue adding values, and breaks if they don't
            System.out.println("Type 'y' to continue or 'n' if you are finished");
            char yesORno = sc.next().charAt(0);
            if (yesORno == 'n'){
                break;
            }
            else if (yesORno != 'y'){
                System.out.println("You have not entered 'y' or 'n', so I will print your numbers anyway");
                break;
            }
        }
        //prints the elements of the array
        System.out.println("Here are your numbers!");
        for (int i = 0; i < count; i++){
            System.out.println(myArray[i]);
        }
    }
}