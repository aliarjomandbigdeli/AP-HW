import java.util.ArrayList;
import java.util.Random;

/**
 * this class models Animal card game player
 *
 * @author Ali ArjomandBigdeli
 * @since 4.1.2018
 */
public abstract class Player {
    protected ArrayList<Animal> animals;
    protected Player opponent;
    private String id;


    /**
     * constructor
     */
    public Player() {
        animals = new ArrayList<>();
        id = " ";
    }

    /**
     * this use to set opponent for a player
     *
     * @param opponent opponent for a player
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * setter
     *
     * @param id the ID of a player(it's like name)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter
     *
     * @return the ID of a player
     */
    public String getId() {
        return id;
    }

    /**
     * this method distribute 30 cards(animals) to a player in a random ways
     */
    public void distributeCards() {
        int[] numberOfAnimals = new int[12];
        for (int i = 0; i < numberOfAnimals.length; i++) {
            numberOfAnimals[i] = 0;
        }
        while (animals.size() < 30) {
            Random random = new Random();
            int number = random.nextInt(12);
            switch (number) {
                case 0:
                    if (numberOfAnimals[0] < 5) {
                        numberOfAnimals[0]++;
                        Animal animal = new Lion();
                        animals.add(animal);
                    }
                    break;
                case 1:
                    if (numberOfAnimals[1] < 5) {
                        numberOfAnimals[1]++;
                        Animal animal = new Bear();
                        animals.add(animal);
                    }
                    break;
                case 2:
                    if (numberOfAnimals[2] < 5) {
                        numberOfAnimals[2]++;
                        Animal animal = new Tiger();
                        animals.add(animal);
                    }
                    break;
                case 3:
                    if (numberOfAnimals[3] < 5) {
                        numberOfAnimals[3]++;
                        Animal animal = new Vulture();
                        animals.add(animal);
                    }
                    break;
                case 4:
                    if (numberOfAnimals[4] < 5) {
                        numberOfAnimals[4]++;
                        Animal animal = new Fox();
                        animals.add(animal);
                    }
                    break;
                case 5:
                    if (numberOfAnimals[5] < 5) {
                        numberOfAnimals[5]++;
                        Animal animal = new Elephant();
                        animals.add(animal);
                    }
                    break;
                case 6:
                    if (numberOfAnimals[6] < 5) {
                        numberOfAnimals[6]++;
                        Animal animal = new Wolf();
                        animals.add(animal);
                    }
                    break;
                case 7:
                    if (numberOfAnimals[7] < 5) {
                        numberOfAnimals[7]++;
                        Animal animal = new Swine();
                        animals.add(animal);
                    }
                    break;
                case 8:
                    if (numberOfAnimals[8] < 5) {
                        numberOfAnimals[8]++;
                        Animal animal = new Hippopotamus();
                        animals.add(animal);
                    }
                    break;
                case 9:
                    if (numberOfAnimals[9] < 5) {
                        numberOfAnimals[9]++;
                        Animal animal = new Cow();
                        animals.add(animal);
                    }
                    break;
                case 10:
                    if (numberOfAnimals[10] < 5) {
                        numberOfAnimals[10]++;
                        Animal animal = new Rabbit();
                        animals.add(animal);
                    }
                    break;
                case 11:
                    if (numberOfAnimals[11] < 5) {
                        numberOfAnimals[11]++;
                        Animal animal = new Turtle();
                        animals.add(animal);
                    }
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * you can see your cards with this method
     */
    public void showCards() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ": " + animals.get(i));

        }
    }

    /**
     * this method shows your cards and your opponent cards
     */
    public void showAllCards() {

        int max = animals.size() > opponent.animals.size() ? animals.size() : opponent.animals.size();
        System.out.println("#################################################################" +
                "\t\t\t\t\t\t\t" + "#################################################################");
        System.out.println("########################## Your cards ###########################" +
                "\t\t\t\t\t\t\t" + "######################## Opponent cards #########################");
        System.out.println("#################################################################" +
                "\t\t\t\t\t\t\t" + "#################################################################");
        for (int i = 0; i < max; i++) {
            System.out.print((i + 1) + ": ");
            if (i < animals.size()) {
                System.out.print(animals.get(i).getClass().getSimpleName() +
                        "{energy=" + animals.get(i).energy +
                        ", life=" + animals.get(i).life +
                        ", " + animals.get(i).attackTags[0] +
                        " Power1=" + animals.get(i).attackValue[0]);
                if (animals.get(i).attackValue[1] != 0) {
                    System.out.print(", " + animals.get(i).attackTags[1] +
                            " Power2=" + animals.get(i).attackValue[1]);
                }
                System.out.print('}');
            } else {
                System.out.print("                                                                 ");
            }
            if (i < opponent.animals.size()) {
                if (i < animals.size() && animals.get(i).attackValue[1] != 0)
                    System.out.print("\t\t\t\t\t\t\t");
                else
                    System.out.print("\t\t\t\t\t\t\t\t\t\t");

                System.out.print(opponent.animals.get(i).getClass().getSimpleName() +
                        "{energy=" + opponent.animals.get(i).energy +
                        ", life=" + opponent.animals.get(i).life +
                        ", " + opponent.animals.get(i).attackTags[0] +
                        " Power1=" + opponent.animals.get(i).attackValue[0]);
                if (opponent.animals.get(i).attackValue[1] != 0) {
                    System.out.print(", " + opponent.animals.get(i).attackTags[1] +
                            " Power2=" + opponent.animals.get(i).attackValue[1]);
                }
                System.out.print('}');
            }
            System.out.println();
        }
    }

    /**
     * by this method you can choose 10 cards from distributed cards
     */
    public abstract void chooseCards();

    /**
     * this method handle turn process of the game
     */
    public abstract void turn();

    /**
     * this method use for attacking one animal to another
     * @param myAnimal the animal wants attack
     * @param opponentAnimal be attacked animal
     * @param attackType specifies the attack type
     * @return a boolean that check whether the animal can attack or not(has enough energy or not)
     */
    public boolean attack(int myAnimal, int opponentAnimal, int attackType) {
        if (animals.get(myAnimal).attack(opponent.animals.get(opponentAnimal), attackType)) {
            if (!opponent.animals.get(opponentAnimal).isAlive()) {
                opponent.animals.remove(opponentAnimal);
            }
            return true;
        } else
            return false;
    }

    /**
     * this method check whether the animal can attack or not(has enough energy or not)
     * @param myAnimal one of Animal type
     * @param attackType specifies the attack type
     * @return a boolean that check whether the animal can attack or not(has enough energy or not)
     */
    public boolean canAttack(int myAnimal, int attackType) {
        return animals.get(myAnimal).canAttack(attackType);
    }


    /**
     * this method use for attacking group of animals to another
     * @param opponentAnimal be attacked animal
     * @param animalsIndex specifies index of animals that want to attack
     * @param attackTypes specifies the attack type
     * @return a boolean that check whether the animal can attack or not
     */
    public boolean groupAttack(int opponentAnimal, ArrayList<Integer> animalsIndex, int[] attackTypes) {
        int sumOfAttack = 0;
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        for (int i = 0; i < animalsIndex.size(); i++) {
            animalArrayList.add(animals.get(animalsIndex.get(i)));
        }
        for (int i = 0; i < animalArrayList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (!animalArrayList.get(i).attackTags[attackTypes[i]].equals(animalArrayList.get(j).attackTags[attackTypes[j]])) {
                    System.err.println("Can't group attack(tags)");
                    return false;
                }
            }
            sumOfAttack += animalArrayList.get(i).attackValue[attackTypes[i]];
        }

        for (int i = 0; i < animalArrayList.size(); i++) {
            if (animalArrayList.get(i).energy - (sumOfAttack / animalArrayList.size()) < 0) {
                System.err.println("Can't group attack(energy)");
                return false;
            }
        }

        for (int i = 0; i < animalArrayList.size(); i++) {
            animalArrayList.get(i).energy -= (sumOfAttack / animalArrayList.size());
        }
        opponent.animals.get(opponentAnimal).life -= sumOfAttack;
        if (opponent.animals.get(opponentAnimal).life <= 0) {
            opponent.animals.get(opponentAnimal).alive = false;
            opponent.animals.remove(opponentAnimal);
        }
        return true;
    }

    /**
     * the method specifies whether the player is a winner or not
     * @return boolean that specifies whether the player is a winner or not
     */
    public boolean isWinner() {
        return opponent.animals.size() == 0;
    }

}
