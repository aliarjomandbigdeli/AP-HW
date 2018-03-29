public class Wolf extends Animal {
    public Wolf() {
        super();
        energy = 700;
        life = 450;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 700;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}
