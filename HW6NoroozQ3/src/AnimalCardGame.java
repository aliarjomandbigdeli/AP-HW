import java.util.Scanner;

/**
 * this class models Animal card game
 *
 * @author Ali ArjomandBigdeli
 * @since 4.1.2018
 */
public class AnimalCardGame {
    private Player playerA;
    private Player playerB;

    /**
     * constructor
     */
    public AnimalCardGame() {
        playerA = new HumanPlayer();
    }


    /**
     * this method is for running the game
     */
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
        return ifEndGame();
    }

}
