public class Cow extends Animal {
    public Cow() {
        super();
        energy = 400;
        life = 750;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 400;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}
