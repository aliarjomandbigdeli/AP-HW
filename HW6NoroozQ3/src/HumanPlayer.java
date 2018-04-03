import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

    /**
     * constructor
     */
    public HumanPlayer() {
        super();
    }

    /**
     * by this method you can choose 10 cards from distributed cards
     */
    @Override
    public void chooseCards() {
        int N = 10;
        System.out.println("Please choose 10 cards");
        Scanner inputStream = new Scanner(System.in);
        ArrayList<Animal> animals2 = new ArrayList<>();
        int[] choice = new int[N];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            flag = false;
            System.out.println("Enter the  choice" + (i + 1) + ": ");
            choice[i] = inputStream.nextInt();
            for (int j = 0; j < i; j++) {
                if (choice[i] == choice[j]) {
                    i--;
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            if (choice[i] <= 0 || choice[i] > 30) {
                i--;
                continue;
            }

            animals2.add(animals.get(choice[i] - 1));
        }
        animals = animals2;
    }

    /**
     * this method handle turn process of the game
     */
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
            while (myAnimal > animals.size()) {
                System.out.println("Please choose your animal, again: ");
                myAnimal = inputStream.nextInt();
            }
            int attackType = 0;
            int opponentAnimal;
            if (animals.get(myAnimal - 1).attackValue[1] != 0) {
                System.out.println("Please choose type of your attack(1/2): ");
                attackType = inputStream.nextInt();
                attackType--;
            }
            if (canAttack(myAnimal - 1, attackType)) {
                System.out.println("Please choose the animal you want to attack to: ");
                opponentAnimal = inputStream.nextInt();
                while (opponentAnimal > opponent.animals.size()) {
                    System.out.println("Please choose the animal you want to attack to, again: ");
                    opponentAnimal = inputStream.nextInt();
                }
                attack(myAnimal - 1, opponentAnimal - 1, attackType);
            } else {
                System.out.println("Do you want to choose another attack or group attack?(a/g)");
                ans = inputStream.next();
                if (ans.equals("a")) {
                    System.out.println("Please choose your animal: ");
                    myAnimal = inputStream.nextInt();
                    while (myAnimal > animals.size()) {
                        System.out.println("Please choose your animal, again: ");
                        myAnimal = inputStream.nextInt();
                    }
                    System.out.println("Please choose the animal you want to attack to: ");
                    opponentAnimal = inputStream.nextInt();
                    while (opponentAnimal > opponent.animals.size()) {
                        System.out.println("Please choose the animal you want to attack to, again: ");
                        opponentAnimal = inputStream.nextInt();
                    }
                    attackType = 0;
                    if (animals.get(myAnimal - 1).attackValue[1] != 0) {
                        System.out.println("Please choose type of your attack(1/2): ");
                        attackType = inputStream.nextInt();
                        attackType--;
                    }
                    while (!attack(myAnimal - 1, opponentAnimal - 1, attackType)) {
                        System.out.println("Please choose your animal, again: ");
                        myAnimal = inputStream.nextInt();
                        while (myAnimal > animals.size()) {
                            System.out.println("Please choose your animal, again: ");
                            myAnimal = inputStream.nextInt();
                        }
                        System.out.println("Please choose the animal you want to attack to, again: ");
                        opponentAnimal = inputStream.nextInt();
                        while (opponentAnimal > opponent.animals.size()) {
                            System.out.println("Please choose the animal you want to attack to, again: ");
                            opponentAnimal = inputStream.nextInt();
                        }
                        attackType = 0;
                        if (animals.get(myAnimal - 1).attackValue[1] != 0) {
                            System.out.println("Please choose type of your attack(1/2): ");
                            attackType = inputStream.nextInt();
                            attackType--;
                        }
                    }
                } else if (ans.equals("g")) {
                    ArrayList<Integer> animalsIndex;
                    int[] attackTypes;
                    do {
                        System.out.println("Please choose the animal you want to attack to: ");
                        opponentAnimal = inputStream.nextInt();
                        System.out.print("How many animals do you want to choose:");
                        int numOfAnimals = inputStream.nextInt();
                        animalsIndex = new ArrayList<>();
                        attackTypes = new int[numOfAnimals];
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
                    } while (!groupAttack(opponentAnimal - 1, animalsIndex, attackTypes));

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
