
public abstract class Animal {
    protected int energy;
    protected int maxEnergy;
    protected int life;
    protected boolean alive;
    protected int numOfRecovery;
    protected String[] attackTags;
    protected int[] attackValue;


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

    public boolean isAlive() {
        return alive;
    }

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


