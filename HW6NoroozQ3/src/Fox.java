public class Fox extends Animal {
    public Fox() {
        super();
        energy = 600;
        life = 400;
        attackTags[0] = "injure";
        attackValue = 90;
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
