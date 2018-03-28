package factory;

import org.junit.Assert;
import org.junit.Test;

/*
 Название и классификация паттерна
    Абстрактная фабрика – паттерн, порождающий объекты.
 Назначение
    Предоставляет интерфейс для создания семейств взаимосвязанных или взаимозависимых объектов,
    не специфицируя их конкретных классов.
 */
public class FactoryTest {

    @Test
    public void testCreateStudent() {
        Pupils.setFactory(new StudentsFactory());
        Pupil pupil = Pupils.createPupil("Test", 2);
        Assert.assertTrue(pupil instanceof Student);
    }

    @Test
    public void testCreateSchoolBoy() {
        Pupils.setFactory(new SchoolBoyFactory());
        Pupil pupil = Pupils.createPupil("Test", 2);
        Assert.assertTrue(pupil instanceof SchoolBoy);
    }

    @Test
    public void testShowSchoolBoySubjects() {
        Pupils.setFactory(new SchoolBoyFactory());
        Pupil pupil = Pupils.createPupil("Test", 2);
        pupil.setSubject(0, "Math");
        pupil.setMark(0, 5);
        pupil.setSubject(1, "Java");
        pupil.setMark(1, 5);
        pupil.addSubject("English", 4);
        Pupils.showSubjectsTable(pupil);
    }

    @Test
    public void testShowStudentSubjects() {
        Pupils.setFactory(new StudentsFactory());
        Pupil pupil = Pupils.createPupil("Test", 2);
        pupil.setSubject(0, "Math");
        pupil.setMark(0, 5);
        pupil.setSubject(1, "Java");
        pupil.setMark(1, 5);
        pupil.addSubject("English", 4);
        Pupils.showSubjectsTable(pupil);
    }

    @Test
    public void testAverageStudentSubject() {
        Pupils.setFactory(new StudentsFactory());
        Pupil pupil = Pupils.createPupil("Test", 2);
        pupil.setSubject(0, "Math");
        pupil.setMark(0, 4);
        pupil.setSubject(1, "Java");
        pupil.setMark(1, 5);
        pupil.addSubject("English", 4);
        Assert.assertEquals(Pupils.getAverageMark(pupil), (4 + 4 + 5) / 3.0, 0.001);
    }

    @Test
    public void testAverageSchoolSubject() {
        Pupils.setFactory(new SchoolBoyFactory());
        Pupil pupil = Pupils.createPupil("Test", 2);
        pupil.setSubject(0, "Math");
        pupil.setMark(0, 4);
        pupil.setSubject(1, "Java");
        pupil.setMark(1, 5);
        pupil.addSubject("English", 4);
        Assert.assertEquals(Pupils.getAverageMark(pupil), (4 + 4 + 5) / 3.0, 0.001);
    }


}
