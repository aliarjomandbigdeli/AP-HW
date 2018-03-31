import java.util.ArrayList;
import java.util.Random;

public abstract class Player {
    protected ArrayList<Animal> animals;
    protected Player opponent;
    protected String id;


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
                        Animal animal = new Hipppopotamus();
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

    public void showCards() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ": " + animals.get(i));

        }
    }

    public void showAllCards() {

        System.out.println("#########################################" +
                "\t\t\t\t\t\t\t" + "#########################################");
        System.out.println("############## Your cards ###############" +
                "\t\t\t\t\t\t\t" + "############ Opponent cards #############");
        System.out.println("#########################################" +
                "\t\t\t\t\t\t\t" + "#########################################");
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).isAlive()) {
                System.out.println((i + 1) + ": " +
                        animals.get(i).getClass().getSimpleName() +
                        "{energy=" + animals.get(i).energy +
                        ", life=" + animals.get(i).life +
                        '}' + "\t\t\t\t\t\t\t\t\t\t" + opponent.animals.get(i).getClass().getSimpleName() +
                        "{energy=" + opponent.animals.get(i).energy +
                        ", life=" + opponent.animals.get(i).life + '}');
            } else {
                System.out.println(getClass().getSimpleName() +
                        "{is dead}");
            }
        }
    }

    public abstract void chooseCards();

    public boolean attack(int myAnimal, int opponentAnimal) {
        if (animals.get(myAnimal).attack(opponent.animals.get(opponentAnimal))) {
            if (!opponent.animals.get(opponentAnimal).isAlive()) {
                opponent.animals.remove(opponentAnimal);
            }
            return true;
        }else
            return false;
    }

    public boolean isWinner() {
        if (opponent.animals.size() == 0)
            return true;
        else
            return false;
    }

}
