package pro.sky.HogwardsRefactorMap.data;


public class Ravenclaw extends Student { // факультет Когтевран  ========================

    private int mind;        // ум от 0 до 100
    private int wisdom;      // мудрость от 0 до 100
    private int wit;         // остроумие от 0 до 100
    private int creativity;  // творчество от 0 до 100

    public Ravenclaw (String name, int magic, int apparition, int mind, int wisdom, int wit,int creativity) {
        super(name, magic, apparition);
        this.mind = mind;
        this.wisdom = wisdom;
        this.wit = wit;
        this.creativity = creativity;
    }


    public int getMind() {
        return mind;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getWit() {
        return wit;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setWit(int wit) {
        this.wit = wit;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + ": Сила магии-" + getMagic() +
                ". Трансгрессия-" + getApparition() +
                ". Ум-" +
                mind + ". Мудрость-" +
                wisdom + ". Творчество-" + creativity;
    }
}
