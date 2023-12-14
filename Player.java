import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
   // private Scanner scanner;

   Scanner scanner = new Scanner(System.in);

    public Player() {
        //scanner = new Scanner(System.in);
        setName();
        setSymbol();
    }

    void setName() {
        System.out.print("Enter Player's name: ");
        this.name = scanner.nextLine();
    }

    void setSymbol() {
        System.out.println(name + ", choose your symbol ('X' or 'O'): ");
        symbol = scanner.next().charAt(0);
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
