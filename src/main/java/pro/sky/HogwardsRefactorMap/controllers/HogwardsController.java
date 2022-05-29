package pro.sky.HogwardsRefactorMap.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HogwardsRefactorMap.data.Student;
import pro.sky.HogwardsRefactorMap.interfaces.StudentInterface;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/hogwards")
public class HogwardsController {
    private final StudentInterface studentService;

    public HogwardsController( StudentInterface studentService) {
        this.studentService = studentService;
    }

    // ++++++++  добавить Гриффиндорца +++++++++++++++++++++++++++++++++++++++++++
    @GetMapping(path = "/addgriff")
    public String addGriff(String Name, int magic, int apparition, int nobility, int honor, int bravery)
    {
        return studentService.addNewGriff(Name, magic, apparition, nobility, honor, bravery);
    }
 // ++++++++  добавить Слизеринца +++++++++++++++++++++++++++++++++++++++++++
    @GetMapping(path = "/addslyth")
    public String addSlyth(String studentName, int magic, int apparition, int trick, int determination, int ambition,
                           int ingenuity, int lustForPower)
    {
        return studentService.addNewSlyth(studentName, magic, apparition, trick, determination, ambition,
        ingenuity, lustForPower);
    }
    // ++++++++  добавить Когтевранца +++++++++++++++++++++++++++++++++++++++++++
    @GetMapping(path = "/addraven")
    public String addRaven(String studentName, int magic, int apparition,
                           int mind, int wisdom, int wit, int creativity)
    {
        return studentService.addNewRaven(studentName, magic,  apparition,
        mind, wisdom, wit,  creativity);
    }
    // ++++++++  добавить Пуффендуйца +++++++++++++++++++++++++++++++++++++++++++
    @GetMapping(path = "/addhuffle")
    public String addHuffle(@RequestParam("name")String studentName, @RequestParam("magic")int magic,
                            @RequestParam("apparition")int apparition,
                            @RequestParam("diligence")int diligence,
                            @RequestParam("loyalty")int loyalty, @RequestParam("honesty")int honesty)
    {
        return studentService.addNewHuffle( studentName,  magic,  apparition,
         diligence,  loyalty,  honesty);
    }
    // ???????????  найти студента ?????????????
    @GetMapping(path = "/find")
    public Student findStudent(@RequestParam("name") String Name) {
        return studentService.findStudent(Name);
    }

    // ----------  удалить студента -------------
    @GetMapping(path = "/remove")
    public String deleteStudent(@RequestParam("name")  String studentName) {
        return studentService.deleteStudent(studentName);
    }

    // ===========  печать всех студентов =========
    @GetMapping(path = "/printall")
    public Map<String,Student> printAllStudents() {
        return studentService.printAllStudents();
    }

    // ===========  сравниваем 2-х студентов по силе магии и трансгрессии
    @GetMapping(path = "/powermagic")
    public String whoIsTheBestOfPowerMagic(@RequestParam("name1")  String student1,
                                           @RequestParam("name2")  String student2) {
        return studentService.whoIsTheBestOfPowerMagic(student1, student2);
    }
}