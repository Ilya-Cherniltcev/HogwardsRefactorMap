package pro.sky.HogwardsRefactorMap.interfaces;

import pro.sky.HogwardsRefactorMap.data.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StudentInterface {
    String addNewGriff(String studentName, int magic, int apparition, int nobility, int honor, int bravery);

    String addNewSlyth(String studentName, int magic, int apparition, int trick, int determination, int ambition,
                       int ingenuity, int lustForPower);

    String addNewRaven(String studentName, int magic, int apparition, int mind, int wisdom, int wit, int creativity);

    String addNewHuffle(String studentName, int magic, int apparition, int diligence, int loyalty, int honesty);
    Student findStudent(String studentName);

    String deleteStudent(String studentName);

    Map<String,Student> printAllStudents();

    String whoIsTheBestOfGriff(String student1, String student2);

    String whoIsTheBestOfSlyth(String student1, String student2);

    String whoIsTheBestOfRaven(String student1, String student2);

    String whoIsTheBestOfHuffle(String student1, String student2);

    String whoIsTheBestOfPowerMagic(String student1, String student2);
}
