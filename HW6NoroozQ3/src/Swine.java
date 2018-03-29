public class Swine extends Animal {
    public Swine() {
        super();
        energy = 500;
        life = 1100;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 500;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}
