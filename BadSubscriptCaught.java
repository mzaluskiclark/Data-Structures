import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] listNames =  {"Bob", "Joe", "Jim", "Tim", "Dan", "Sheldon", "Peter", "Stewie", "Brian", "Chris"};
        System.out.println("This is the list of names: ");
        for (int i = 0; i < 10; i++){
            System.out.print(listNames[i] + ", ");
        }
        System.out.println("0, 1, 2, 3, 4, 5, 6, 7, 8, 9)");
        boolean validAnswer = false;
        while (!validAnswer) {
        System.out.println("Give an integer value for the position of the name you want printed: ");
        int input = scanner.nextInt();
        try {
            System.out.println(listNames[input]);
            validAnswer = true;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("ArrayIndexOutOfBoundsException" + exception.getMessage());
        }
        }
    }
}