import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public void chooseCards() {
        System.out.println("Please choose 10 cards");
        Scanner inputStream = new Scanner(System.in);
        ArrayList<Animal> animals2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the " + (i + 1) + "choice: ");
            int choice = inputStream.nextInt();
            animals2.add(animals.get(choice - 1));
        }
        animals = animals2;
    }
}
