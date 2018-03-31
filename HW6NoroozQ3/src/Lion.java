public class Lion extends Animal {

    public Lion() {
        super();
        energy = 1000;
        life = 900;
        attackTags[0] = "injure";
        attackTags[1] = "kill";
        attackValue = 150;
        attackValue2 = 500;
    }

    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 1000;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }


}
