import java.util.Scanner;

public class AnimalCardGame {
    private Player playerA;
    private Player playerB;

    /**
     * constructor
     */
    public AnimalCardGame() {
        playerA = new HumanPlayer();
    }


    public void startGame() {
        Scanner inputStream = new Scanner(System.in);
        System.out.println("Single player?(y/n)");
        String ans = inputStream.next();
        boolean isComputer = false;
        if (ans.equals("y")) {
            isComputer = true;
            playerB = new AIPlayer();
        } else {
            playerB = new HumanPlayer();
        }
        playerA.setOpponent(playerB);
        playerB.setOpponent(playerA);

        System.out.print("First player: Please enter your name: ");
        String playerAId = inputStream.next();
        playerA.setId(playerAId);
        playerA.distributeCards();
        playerA.showCards();
        playerA.chooseCards();
        playerA.showCards();

        if (!isComputer) {
            System.out.print("Second player: Please enter your name: ");
            String playerBId = inputStream.next();
            playerB.setId(playerBId);
        }
        playerB.distributeCards();
        playerB.showCards();
        playerB.chooseCards();
        playerB.showCards();

//        System.out.println("show All cards: ");
//        playerA.showAllCards();


        while (true) {
            if (ifTurnProcessEndGame(playerA))
                break;

            if (ifTurnProcessEndGame(playerB))
                break;
        }
    }


    /**
     * check whether  the game ends or doesn't(someone wins or not)
     *
     * @return whether  the game ends or doesn't
     */
    private boolean ifEndGame() {
        if (playerA.isWinner()) {
            System.out.println(playerA.getId() + " wins *_*");
            return true;
        }
        if (playerB.isWinner()) {
            System.out.println(playerB.getId() + " wins *_*");
            return true;
        }
        return false;
    }

    /**
     * this method runs the turn process of the game
     *
     * @param player the turn is for this player
     * @return whether the turn process can end the game or not
     */
    private boolean ifTurnProcessEndGame(Player player) {
        player.showAllCards();
        player.turn();
//        Scanner inputStream = new Scanner(System.in);
//        System.out.println(player.getId() + "'s turn");
//        System.out.println("Do want to attack or recovery?(a/r)");
//        String ans = inputStream.next();
//        while (!ans.equals("a") && !ans.equals("r")) {
//            System.out.println("Please enter again, do want to attack or recovery?(a/r)");
//            ans = inputStream.next();
//        }
//        if (ans.equals("a")) {
//            System.out.println("Please choose your animal: ");
//            int myAnimal = inputStream.nextInt();
//            System.out.println("Please choose the animal you want to attack to: ");
//            int opponentAnimal = inputStream.nextInt();
//            int attackType = 0;
//            if (player.animals.get(myAnimal - 1).attackValue[1] != 0) {
//                System.out.println("Please choose type of your attack(1/2): ");
//                attackType = inputStream.nextInt();
//                attackType--;
//            }
//
////            System.out.println("Group Attack: ");
////            int myAnimal;
////            int opponentAnimal;
////            System.out.println("Please choose the animal you want to attack to: ");
////            opponentAnimal = inputStream.nextInt();
////            System.out.print("How many animals do you want to choose:");
////            int numOfAnimals = inputStream.nextInt();
////            ArrayList<Integer> animalsIndex = new ArrayList<>();
////            int[] attackTypes = new int[numOfAnimals];
////            for (int i = 0; i < attackTypes.length; i++) {
////                attackTypes[i] = 0;
////            }
////            for (int i = 0; i < numOfAnimals; i++) {
////                System.out.println("Please choose your animal " + (i + 1) + ": ");
////                animalsIndex.add(inputStream.nextInt() - 1);
////                if (player.animals.get(animalsIndex.get(i)).attackValue[1] != 0) {
////                    System.out.println("Please choose type of your attack(1/2): ");
////                    attackTypes[i] = inputStream.nextInt();
////                    attackTypes[i]--;
////
////                }
////            }
////            player.groupAttack(opponentAnimal - 1, animalsIndex, attackTypes);
//
//
//            if (!player.attack(myAnimal - 1, opponentAnimal - 1, attackType)) {
//                System.out.println("Do you want to choose another attack or group attack?(a/g)");
//                ans = inputStream.next();
//                if (ans.equals("a")) {
//                    do {
//                        System.out.println("Please choose your animal, again: ");
//                        myAnimal = inputStream.nextInt();
//                        System.out.println("Please choose the animal you want to attack to, again: ");
//                        opponentAnimal = inputStream.nextInt();
//                        if (player.animals.get(myAnimal - 1).attackValue[1] != 0) {
//                            System.out.println("Please choose type of your attack(1/2): ");
//                            attackType = inputStream.nextInt();
//                            attackType--;
//                        }
//                    } while (!player.attack(myAnimal - 1, opponentAnimal - 1, attackType));
//                } else if (ans.equals("g")) {
//                    System.out.println("Please choose the animal you want to attack to: ");
//                    opponentAnimal = inputStream.nextInt();
//                    System.out.print("How many animals do you want to choose:");
//                    int numOfAnimals = inputStream.nextInt();
//                    ArrayList<Integer> animalsIndex = new ArrayList<>();
//                    int[] attackTypes = new int[numOfAnimals];
//                    for (int i = 0; i < attackTypes.length; i++) {
//                        attackTypes[i] = 0;
//                    }
//                    for (int i = 0; i < numOfAnimals; i++) {
//                        System.out.println("Please choose your animal " + (i + 1) + ": ");
//                        animalsIndex.add(inputStream.nextInt() - 1);
//                        if (player.animals.get(animalsIndex.get(i)).attackValue[1] != 0) {
//                            System.out.println("Please choose type of your attack(1/2): ");
//                            attackTypes[i] = inputStream.nextInt();
//                            attackTypes[i]--;
//
//                        }
//                    }
//                    player.groupAttack(opponentAnimal - 1, animalsIndex, attackTypes);
//                }
//
//            }
//        } else if (ans.equals("r")) {
//            System.out.println("Please choose your animal: ");
//            int myAnimal = inputStream.nextInt();
//            while (!playerA.animals.get(myAnimal - 1).recovery()) {
//                System.out.println("Please choose your animal, again: ");
//                myAnimal = inputStream.nextInt();
//            }
//        }

        return ifEndGame();
    }

}
