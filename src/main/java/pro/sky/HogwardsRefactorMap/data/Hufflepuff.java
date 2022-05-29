package pro.sky.HogwardsRefactorMap.data;

public class Hufflepuff extends Student { // факультет Пуффендуй    ========================
    private int diligence;    // трудолюбие от 0 до 100
    private int loyalty;      // верность от 0 до 100
    private int honesty;      // честность от 0 до 100

    public Hufflepuff(String name, int magic, int apparition, int diligence, int loyalty, int honesty) {
        super(name, magic, apparition);
        this.diligence = diligence;
        this.loyalty = loyalty;
        this.honesty = honesty;
    }

    public int getDiligence() {
        return diligence;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getHonesty() {
        return honesty;
    }

    public void setDiligence(int diligence) {
        this.diligence = diligence;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public void setHonesty(int honesty) {
        this.honesty = honesty;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + ": Сила магии-" + getMagic() +
                ". Трансгрессия-" + getApparition() +
                ". Трудолюбие-" +
                diligence + ". Верность-" +
                loyalty + ". Честность-" + honesty;
    }

}
