public abstract class Animal {
    protected int energy;
    protected int life;
    protected boolean alive;
    protected int numOfRecovery;
    protected String[] attackTags;
    protected int attackValue;
    protected int attackValue2;


    public Animal() {
        alive = true;
        numOfRecovery = 0;
        attackTags = new String[2];
        attackTags[0] = " ";
        attackTags[1] = " ";


    }

    public boolean isAlive() {
        return alive;
    }

    public abstract void recovery();

    public boolean attack(Animal animal) {
        if (energy - attackValue >= 0) {
            animal.life -= attackValue;
            energy -= attackValue;
            if (animal.life < 0) {
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


