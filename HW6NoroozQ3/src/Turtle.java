public class Turtle extends Animal {
    public Turtle() {
        super();
        energy = 230;
        life = 350;
        attackTags[0] = "bite";
        attackValue = 200;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 230;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}
