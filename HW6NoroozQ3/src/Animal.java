
/**
 * this class models Animal card game animals
 *
 * @author Ali ArjomandBigdeli
 * @since 4.1.2018
 */
public abstract class Animal {
    protected int energy;
    protected int maxEnergy;
    protected int life;
    protected boolean alive;
    protected int numOfRecovery;
    protected String[] attackTags;
    protected int[] attackValue;


    /**
     * constructor
     */
    public Animal() {
        alive = true;
        numOfRecovery = 0;
        attackTags = new String[2];
        attackTags[0] = " ";
        attackTags[1] = " ";
        attackValue = new int[2];
        attackValue[0] = 0;
        attackValue[1] = 0;
    }

    /**
     * this method return the live status of an animal
     * @return a boolean that specifies the live status of an animal
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * by this method you can refill the energy of an animal
     * @return a boolean that specifies the process is possible or not
     */
    public boolean recovery() {
        if (numOfRecovery < 3) {
            energy = maxEnergy;
            numOfRecovery++;
            return true;
        } else {
            System.out.println("This animal can't recovery any more!");
            return false;
        }
    }

    /**
     * this method use for attacking one animal to another
     * @param animal the animal you want to attack to
     * @param attackType specifies the attack type
     * @return a boolean that specifies the process is possible or not
     */
    public boolean attack(Animal animal, int attackType) {
        if (energy - attackValue[attackType] >= 0) {
            animal.life -= attackValue[attackType];
            energy -= attackValue[attackType];
            if (animal.life <= 0) {
                animal.alive = false;
            }
            return true;
        } else {
            System.err.println("Can't attack");
            return false;
        }
    }

    /**
     *
     * @param attackType specifies the attack type
     * @return a boolean that specifies the process is possible or not
     */
    public boolean canAttack(int attackType) {
        return energy - attackValue[attackType] >= 0;
    }

    /**
     * toString
     * @return toString
     */
    @Override
    public String toString() {
        if (alive) {
            return getClass().getSimpleName() +
                    "{energy=" + energy +
                    ", life=" + life +
                    '}';
        } else {
            return getClass().getSimpleName() +
                    "{is dead}";
        }
    }
}


