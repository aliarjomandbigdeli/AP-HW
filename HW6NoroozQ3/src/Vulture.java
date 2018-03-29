public class Vulture extends Animal {
    public Vulture() {
        super();
        energy = 600;
        life = 350;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 600;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}
