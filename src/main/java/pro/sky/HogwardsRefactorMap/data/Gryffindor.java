package pro.sky.HogwardsRefactorMap.data;

public class Gryffindor extends Student { // факультет Гриффиндор ========================

    private int nobility;   // благородство от 0 до 100
    private int honor;      // честь от 0 до 100
    private int bravery;    // храбрость от 0 до 100

    public Gryffindor(String name, int magic, int apparition, int nobility, int honor, int bravery) {
        super(name, magic, apparition);
        this.nobility = nobility;
        this.honor = honor;
        this.bravery = bravery;
    }


    public int getNobility() {
        return nobility;
    }

    public int getHonor() {
        return honor;
    }

    public int getBravery() {
        return bravery;
    }



    public void setNobility(int nobility) {
        this.nobility = nobility;
    }

    public void setHonor(int honor) {
        this.honor = honor;
    }

    public void setBravery(int bravery) {
        this.bravery = bravery;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + ": Сила магии-" + getMagic() +
                ". Трансгрессия-" + getApparition() +
                ". Благородство-" +
                nobility + ". Честь-" +
                honor + ". Храбрость-" + bravery;
    }

}
