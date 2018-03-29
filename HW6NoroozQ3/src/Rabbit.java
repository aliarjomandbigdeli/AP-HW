public class Rabbit extends Animal {
    public Rabbit() {
        super();
        energy = 350;
        life = 200;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 350;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}
