public class Hipppopotamus extends Animal {
    public Hipppopotamus() {
        super();
        energy = 360;
        life = 1000;
        attackTags[0] = "attack";
        attackValue = 110;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 360;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }

}
