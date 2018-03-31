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
            //playerB = new AIPlayer();
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
        turnProcess(playerA);
        playerA.showAllCards();


        //while (true) {

//            playerA.showCards();
//            if (ifTurnProcessEndGame(playerA))
//                break;
//
//            if (!isComputer)
//                playerB.drawGrids();
//            if (ifTurnProcessEndGame(playerB))
//                break;

        //}
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
    private boolean turnProcess(Player player) {
        player.showAllCards();
        Scanner inputStream = new Scanner(System.in);
        System.out.println(player.getId() + "'s turn");
        System.out.println("Do want to attack or recovery?(a/r)");

        System.out.println("Please choose your animal: ");
        int myAnimal = inputStream.nextInt();
        System.out.println("Please choose your animal: ");
        int opponentAnimal = inputStream.nextInt();
        player.attack(myAnimal - 1, opponentAnimal - 1);

//        if (!player.shoot(isExact)) {
//            return false;
//        }
        if (ifEndGame()) {
            return true;
        } else {
            return false;
        }

    }

}
