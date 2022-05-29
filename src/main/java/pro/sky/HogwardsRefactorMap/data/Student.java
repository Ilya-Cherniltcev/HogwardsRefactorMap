package pro.sky.HogwardsRefactorMap.data;


import java.util.Objects;

public class Student {      // класс Студент - волшебник
    private String name;    // имя (включая фамилию)
    private int magic;      // сила магии от 0 до 100
    private int apparition; // Трансгрессия (способность перемещаться на расстояние) от 0 до 100 м
    private int id;
    private static int idCount;


    public Student(String name, int magic, int apparition) {
        this.id = ++idCount;
        this.magic = magic;
        this.apparition = apparition;
        this.name = name;
        //idCount = id;
    }


    protected int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getMagic() {
        return magic;
    }

    public int getApparition() {
        return apparition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setApparition(int apparition) {
        this.apparition = apparition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
