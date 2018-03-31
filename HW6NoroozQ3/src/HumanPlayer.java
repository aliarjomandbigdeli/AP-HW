import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer() {
        super();
    }

    @Override
    public void chooseCards() {
        System.out.println("Please choose 10 cards");
        Scanner inputStream = new Scanner(System.in);
        ArrayList<Animal> animals2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the  choice" + (i + 1) + ": ");
            int choice = inputStream.nextInt();
            animals2.add(animals.get(choice - 1));
        }
        animals = animals2;
    }

    public void turn() {
        Scanner inputStream = new Scanner(System.in);
        System.out.println(getId() + "'s turn");
        System.out.println("Do want to attack or recovery?(a/r)");
        String ans = inputStream.next();
        while (!ans.equals("a") && !ans.equals("r")) {
            System.out.println("Please enter again, do want to attack or recovery?(a/r)");
            ans = inputStream.next();
        }
        if (ans.equals("a")) {
            System.out.println("Please choose your animal: ");
            int myAnimal = inputStream.nextInt();
            System.out.println("Please choose the animal you want to attack to: ");
            int opponentAnimal = inputStream.nextInt();
            int attackType = 0;
            if (animals.get(myAnimal - 1).attackValue[1] != 0) {
                System.out.println("Please choose type of your attack(1/2): ");
                attackType = inputStream.nextInt();
                attackType--;
            }


            if (!attack(myAnimal - 1, opponentAnimal - 1, attackType)) {
                System.out.println("Do you want to choose another attack or group attack?(a/g)");
                ans = inputStream.next();
                if (ans.equals("a")) {
                    System.out.println("Please choose your animal: ");
                    myAnimal = inputStream.nextInt();
                    System.out.println("Please choose the animal you want to attack to: ");
                    opponentAnimal = inputStream.nextInt();
                    attackType = 0;
                    if (animals.get(myAnimal - 1).attackValue[1] != 0) {
                        System.out.println("Please choose type of your attack(1/2): ");
                        attackType = inputStream.nextInt();
                        attackType--;
                    }
                    while (!attack(myAnimal - 1, opponentAnimal - 1, attackType)) {
                        System.out.println("Please choose your animal, again: ");
                        myAnimal = inputStream.nextInt();
                        System.out.println("Please choose the animal you want to attack to, again: ");
                        opponentAnimal = inputStream.nextInt();
                        attackType = 0;
                        if (animals.get(myAnimal - 1).attackValue[1] != 0) {
                            System.out.println("Please choose type of your attack(1/2): ");
                            attackType = inputStream.nextInt();
                            attackType--;
                        }
                    }
                } else if (ans.equals("g")) {
                    System.out.println("Please choose the animal you want to attack to: ");
                    opponentAnimal = inputStream.nextInt();
                    System.out.print("How many animals do you want to choose:");
                    int numOfAnimals = inputStream.nextInt();
                    ArrayList<Integer> animalsIndex = new ArrayList<>();
                    int[] attackTypes = new int[numOfAnimals];
                    for (int i = 0; i < attackTypes.length; i++) {
                        attackTypes[i] = 0;
                    }
                    for (int i = 0; i < numOfAnimals; i++) {
                        System.out.println("Please choose your animal " + (i + 1) + ": ");
                        animalsIndex.add(inputStream.nextInt() - 1);
                        if (animals.get(animalsIndex.get(i)).attackValue[1] != 0) {
                            System.out.println("Please choose type of your attack(1/2): ");
                            attackTypes[i] = inputStream.nextInt();
                            attackTypes[i]--;

                        }
                    }
                    groupAttack(opponentAnimal - 1, animalsIndex, attackTypes);
                }

            }
        } else if (ans.equals("r")) {
            System.out.println("Please choose your animal: ");
            int myAnimal = inputStream.nextInt();
            while (!animals.get(myAnimal - 1).recovery()) {
                System.out.println("Please choose your animal, again: ");
                myAnimal = inputStream.nextInt();
            }
        }
    }
}
