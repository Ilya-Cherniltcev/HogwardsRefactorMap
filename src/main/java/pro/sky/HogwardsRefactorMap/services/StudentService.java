package pro.sky.HogwardsRefactorMap.services;

import org.springframework.stereotype.Service;
import pro.sky.HogwardsRefactorMap.data.*;
import pro.sky.HogwardsRefactorMap.exceptions.AlreadyExistsException;
import pro.sky.HogwardsRefactorMap.exceptions.EmployeeNotFoundException;
import pro.sky.HogwardsRefactorMap.exceptions.EmptyBaseException;
import pro.sky.HogwardsRefactorMap.interfaces.StudentInterface;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class StudentService implements StudentInterface {
    private int id = 0;
    Map<String, Student> hogward = new HashMap<>(Map.of(
            "Гарри Поттер", new Gryffindor("Гарри Поттер", 85, 7, 90, 90, 90),
            "Гермиона Грейнджер", new Gryffindor("Гермиона Грейнджер", 55, 15, 85, 100, 50),
  //  Map<String, Slytherin> slyth = new HashMap<>(Map.of(
            "Драко Малфой", new Slytherin("Драко Малфой", 44, 9, 80, 80, 90, 70, 100),
            "Грэхэм Монтегю", new Slytherin("Грэхэм Монтегю", 32, 2, 53, 49, 38, 20, 50),
 //   Map<String, Ravenclaw> raven = new HashMap<>(Map.of(
            "Чжоу Чанг", new Ravenclaw("Чжоу Чанг", 33, 5, 82, 74, 69, 88),
            "Падма Патил", new Ravenclaw("Падма Патил", 35, 3, 63, 45, 32, 54),
 //   Map<String, Hufflepuff> huff = new HashMap<>(Map.of(
            "Седрик Диггори", new Hufflepuff("Седрик Диггори", 39, 4, 67, 77, 85),
            "Захария Смит", new Hufflepuff("Захария Смит", 56, 6, 57, 88, 90)));


    // +++++++++++++++++++++++ Добавляем нового студента +++++++++++++++++++++++++++
    @Override
    public String addNewGriff (String studentName, int magic, int apparition, int nobility, int honor, int bravery) throws AlreadyExistsException {
        // =====   если студент уже есть в базе, вызываем ошибку 400 Bad Request =======
        if (hogward.containsKey(studentName)) {
            throw new AlreadyExistsException("Такой студент уже существует");
        }
        Gryffindor stud = new Gryffindor(studentName, magic, apparition, nobility, honor, bravery);
        hogward.put(studentName, stud);
        return studentName;
    }

    @Override
    public String addNewSlyth (String studentName, int magic, int apparition, int trick, int determination, int ambition,
                               int ingenuity, int lustForPower) throws AlreadyExistsException {
        // =====   если студент уже есть в базе, вызываем ошибку 400 Bad Request =======
        if (hogward.containsKey(studentName)) {
            throw new AlreadyExistsException("Такой студент уже существует");
        }
        Slytherin stud = new Slytherin(studentName, magic, apparition, trick, determination, ambition,
        ingenuity, lustForPower);
        hogward.put(studentName, stud);
        return studentName;
    }

    @Override
    public String addNewRaven (String studentName, int magic, int apparition, int mind, int wisdom, int wit, int creativity) throws AlreadyExistsException {
        // =====   если студент уже есть в базе, вызываем ошибку 400 Bad Request =======
        if (hogward.containsKey(studentName)) {
            throw new AlreadyExistsException("Такой студент уже существует");
        }
        Ravenclaw stud = new Ravenclaw(studentName, magic, apparition,  mind,  wisdom,  wit,  creativity);
        hogward.put(studentName, stud);
        return studentName;
    }

    @Override
    public String addNewHuffle (String studentName, int magic, int apparition, int diligence, int loyalty, int honesty) throws AlreadyExistsException {
        // =====   если студент уже есть в базе, вызываем ошибку 400 Bad Request =======
        if (hogward.containsKey(studentName)) {
            throw new AlreadyExistsException("Такой студент уже существует");
        }
        Hufflepuff stud = new Hufflepuff(studentName, magic, apparition,   diligence,  loyalty,  honesty);
        hogward.put(studentName, stud);
        return studentName;
    }



    // ----------------- Находим студента по Ф.И.О. ------------------------------------
    @Override
    public Student findStudent(String studentName) {
        // =====   если студент не найден, вызываем ошибку 404 Not Found =======
        if (hogward.containsKey(studentName)) {
            return hogward.get(studentName);
        }
        throw new EmployeeNotFoundException("Студент не найден");
    }


    // ----------------- Удаляем студента по Ф.И.О. ------------------------------------
    @Override
    public String deleteStudent(String studentName) {
        if (hogward.isEmpty()) {
            throw new EmptyBaseException("Список студентов пустой");
        }
        if (hogward.containsKey(studentName)) {
             hogward.remove(studentName);
             return studentName;
        }
        throw new EmployeeNotFoundException("Студент не найден");
    }

//    // ========= внутренний метод для присваивания id каждому сотруднику ======
//    private Integer getNewId() {
//        int result = id;
//        id++;
//        return result;
//    }

    // ----------------- Печатаем всех студеетов ------------------------------------
    @Override
    public Map<String,Student> printAllStudents() {
       return hogward;
    }

    // **************************************************************************

    // ********** (1) сравниваем Гриффинорцев ******************************
    @Override
    public String whoIsTheBestOfGriff(String student1, String student2) {
        if (!hogward.containsKey(student1) || !hogward.containsKey(student2)) {
            throw new EmployeeNotFoundException("Студент не найден");
        }
        Gryffindor griff1 = (Gryffindor)hogward.get(student1);
        Gryffindor griff2 = (Gryffindor)hogward.get(student2);
        int sum1 = griff1.getBravery() + griff1.getHonor() + griff1.getNobility();
        int sum2 = griff2.getBravery() + griff2.getHonor() + griff2.getNobility();
        if (sum1 > sum2) {
            return (student1 + " лучший Гриффиндорец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                return (student2 + " лучший Гриффиндорец, чем " + student1);
            }
        }
        return ("И " + student1 + ", и " + student2 + " одинаково равны!");
    }

    // ********** (2) сравниваем  Слизеринцев  ******************************
    @Override
    public String whoIsTheBestOfSlyth(String student1, String student2) {
        if (!hogward.containsKey(student1) || !hogward.containsKey(student2)) {
            throw new EmployeeNotFoundException("Студент не найден");
        }
        Slytherin slyth1 = (Slytherin) hogward.get(student1);
        Slytherin slyth2 = (Slytherin)hogward.get(student2);
        int sum1 = slyth1.getAmbition() + slyth1.getDetermination() + slyth1.getIngenuity()
                + slyth1.getLustForPower() + slyth1.getTrick();
        int sum2 = slyth2.getAmbition() + slyth2.getDetermination() + slyth2.getIngenuity()
                + slyth2.getLustForPower() + slyth2.getTrick();
        if (sum1 > sum2) {
            return (student1 + " лучший Слизеринец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                return (student2 + " лучший Слизеринец, чем " + student1);
            }
        }
        return ("И " + student1 + ", и " + student2 + " одинаково равны!");
    }

    // ********** (3) сравниваем  Когтевранцев ******************************
    @Override
    public String whoIsTheBestOfRaven(String student1, String student2) {
        if (!hogward.containsKey(student1) || !hogward.containsKey(student2)) {
            throw new EmployeeNotFoundException("Студент не найден");
        }
        Ravenclaw raven1 = (Ravenclaw) hogward.get(student1);
        Ravenclaw raven2 = (Ravenclaw) hogward.get(student2);
        int sum1 = raven1.getCreativity() + raven1.getMind() + raven1.getWisdom()
                + raven1.getWit();
        int sum2 = raven2.getCreativity() + raven2.getMind() + raven2.getWisdom()
                + raven2.getWit();
        if (sum1 > sum2) {
            return (student1 + " лучший Когтевранец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                return (student2 + " лучший Когтевранец, чем " + student1);
            }
        }
        return ("И " + student1 + ", и " + student2 + " одинаково равны!");
    }
    // ********** (4) сравниваем  Пуффендуйцев  ******************************
    @Override
    public String whoIsTheBestOfHuffle(String student1, String student2) {
        if (!hogward.containsKey(student1) || !hogward.containsKey(student2)) {
            throw new EmployeeNotFoundException("Студент не найден");
        }
        Hufflepuff huff1 = (Hufflepuff) hogward.get(student1);
        Hufflepuff huff2 = (Hufflepuff) hogward.get(student2);
        int sum1 = huff1.getDiligence() + huff1.getHonesty() + huff1.getLoyalty();
        int sum2 = huff2.getDiligence() + huff2.getHonesty() + huff2.getLoyalty();
        if (sum1 > sum2) {
            return (student1 + " лучший Пуффендуец, чем " + student2);
        } else {
            if (sum1 < sum2) {
                return (student2 + " лучший Пуффендуец, чем " + student1);
            }
        }
        return ("И " + student1 + ", и " + student2 + " одинаково равны!");
    }

    // ===================  сравниваем  2-х разных учеников по силе магии и расстоянию трансгрессии  ===================
    @Override
    public String whoIsTheBestOfPowerMagic(String student1, String student2) {
        if (!hogward.containsKey(student1) || !hogward.containsKey(student2)) {
            throw new EmployeeNotFoundException("Студент не найден");
        }
        Student studentFirst = (Student) hogward.get(student1);
        Student studentSecond = (Student) hogward.get(student2);
        int magicPower1 = studentFirst.getMagic();
        int magicPower2 = studentSecond.getMagic();
        int apparition1 = studentFirst.getApparition();
        int apparition2 = studentSecond.getApparition();
        String whoIs = new String();
        if (magicPower1 > magicPower2) {
            whoIs = student1 + " обладает бОльшей мошностью магии, чем " + student2;
        } else {
            if (magicPower1 < magicPower2) {
                whoIs = student2 + " обладает бОльшей мошностью магии, чем " + student1;
            } else {
                whoIs =  "И " + student1 + ", и " + student2 + " обладает одинаковой мошностью магии!";
            }
        }
        if (apparition1 > apparition2) {
            whoIs = whoIs + (". Также " + student1 + " трансгрессирует на бОльшее расстояние, чем " + student2);
        } else {
            if (apparition1 < apparition2) {
                whoIs = whoIs + (". Также " + student2 + " трансгрессирует на бОльшее расстояние, чем " + student1);
            } else {
                whoIs = whoIs + (". Также " + "И " + student1 + ", и " + student2 + " одинаково трансгрессируют!");
            }
        }
        return whoIs;
    }


}

