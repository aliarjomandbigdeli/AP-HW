public class Tiger extends Animal {
    public Tiger() {
        super();
        energy = 850;
        life = 850;
        attackTags[0] = "injure";
        attackTags[1] = "kill";
        attackValue = 120;
        attackValue2 = 650;
    }


    @Override
    public void recovery() {
        if (numOfRecovery < 3) {
            energy = 850;
            numOfRecovery++;
        } else {
            System.out.println("can't recovery any more!");
        }
    }
}