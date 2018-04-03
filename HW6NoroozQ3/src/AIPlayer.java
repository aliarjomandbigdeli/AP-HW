import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Player {

    /**
     * constructor
     */
    public AIPlayer() {
        super();
        setId("Computer");
    }

    /**
     * by this method you can choose 10 cards from distributed cards
     */
    @Override
    public void chooseCards() {
        ArrayList<Animal> animals2 = new ArrayList<>();
        double avgEnergy = 0;
        double avgLife = 0;
        for (Animal animal : animals) {
            avgEnergy += animal.energy;
            avgLife += animal.life;
        }
        avgEnergy /= animals.size();
        avgLife /= animals.size();
        for (Animal animal : animals) {
            if (animals2.size() < 10) {
                if (animal.energy > avgEnergy || animal.life > avgLife || animal.attackValue[1] >= 500) {
                    animals2.add(animal);
                }
            } else {
                break;
            }
        }
        animals = animals2;
    }

    /**
     * this method handle turn process of the game
     */
    public void turn() {
        System.out.println(getId() + "'s turn");
        Random random = new Random();

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).energy < animals.get(i).attackValue[0] && animals.get(i).numOfRecovery < 3) {
                animals.get(i).recovery();
                return;
            }
        }

        int myAnimal = random.nextInt(animals.size());
        int opponentAnimal = random.nextInt(opponent.animals.size());
        int attackType = 0;
        for (int i = 0; i < animals.size(); i++) {
            for (int j = 0; j < opponent.animals.size(); j++) {
                if (animals.get(i).attackValue[0] > opponent.animals.get(j).life &&
                        animals.get(i).energy - animals.get(i).attackValue[0] >= 0) {
                    myAnimal = i;
                    opponentAnimal = j;
                    attackType = 0;
                    attack(myAnimal, opponentAnimal, attackType);
                    return;
                } else if (animals.get(i).attackValue[1] > opponent.animals.get(j).life &&
                        animals.get(i).energy - animals.get(i).attackValue[1] >= 0) {
                    myAnimal = i;
                    opponentAnimal = j;
                    attackType = 1;
                    attack(myAnimal, opponentAnimal, attackType);
                    return;
                }
            }
        }

        if (animals.get(myAnimal).attackValue[1] != 0) {
            attackType = random.nextInt(2);
        }
        while (!attack(myAnimal, opponentAnimal, attackType)) {
            myAnimal = random.nextInt(animals.size());
            opponentAnimal = random.nextInt(opponent.animals.size());
            if (animals.get(myAnimal).attackValue[1] != 0) {
                attackType = random.nextInt(2);
            }
        }

    }
}
