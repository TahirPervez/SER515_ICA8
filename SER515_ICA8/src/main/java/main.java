import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input;
        boolean valid = true;
        do {
            System.out.println("Enter 1 to run the program using the console, or 2 to run it using files.");
            input = scan.nextInt();
            if (input != 1 && input != 2) {
                System.out.println("Invalid Input");
            } else {
                valid = true;
            }
        } while(!valid);
        Urinals urinals = new Urinals();
        if(input == 1) {
            System.out.println(urinals.readInFromConsole());
        } else {
            // read in file?
            urinals.readInFile("src/main/resources/urinal.dat");
        }
    }
}
