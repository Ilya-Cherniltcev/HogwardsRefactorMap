package pro.sky.HogwardsRefactorMap.data;

public class Slytherin extends Student { // факультет Слизерин   ========================
    private int trick;              // хитрость от 0 до 100
    private int determination;      // решительность от 0 до 100
    private int ambition;           // амбициозность от 0 до 100
    private int ingenuity;          // находчивость от 0 до 100
    private int lustForPower;       // жажда власти от 0 до 100

    public Slytherin(String name, int magic,int apparition,int trick, int determination, int ambition, int ingenuity, int lustForPower) {
        super(name, magic, apparition);
        this.trick = trick;
        this.determination = determination;
        this.ambition = ambition;
        this.ingenuity = ingenuity;
        this.lustForPower = lustForPower;
    }

    public int getTrick() {
        return trick;
    }

    public int getDetermination() {
        return determination;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getIngenuity() {
        return ingenuity;
    }

    public int getLustForPower() {
        return lustForPower;
    }

    public void setTrick(int trick) {
        this.trick = trick;
    }

    public void setDetermination(int determination) {
        this.determination = determination;
    }

    public void setAmbition(int ambition) {
        this.ambition = ambition;
    }

    public void setIngenuity(int ingenuity) {
        this.ingenuity = ingenuity;
    }

    public void setLustForPower(int lustForPower) {
        this.lustForPower = lustForPower;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + ": Сила магии-" + getMagic() +
                ". Трансгрессия-" + getApparition() +
                ". Хитрость-" +
                trick + ". Решительность-" +
                determination + ". Амбициозность-" + ambition +
                ". Находчивость-" + ingenuity +
                ". Жажда власти-" + lustForPower;
    }

}
