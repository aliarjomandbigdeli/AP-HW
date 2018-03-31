public class Elephant extends Animal {
    public Elephant() {
        super();
        energy = 500;
        life = 1200;
        attackTags[0] = "hurt";
        attackTags[1] = "attack";
        attackValue = 70;
        attackValue2 = 50;
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
