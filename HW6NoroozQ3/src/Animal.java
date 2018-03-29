public abstract class Animal {
    protected int energy;
    protected int life;
    protected boolean alive;
    protected int numOfRecovery;

    public Animal() {
        alive = true;
        numOfRecovery = 0;
    }

    public abstract void recovery();

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


