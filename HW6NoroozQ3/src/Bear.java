public class Bear extends Animal {
    public Bear() {
        super();
        energy = 900;
        life = 850;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 900;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}
