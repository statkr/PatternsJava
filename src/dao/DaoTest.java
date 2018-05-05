package dao;

import command.PrintColumn;
import command.PrintRows;
import factory.Student;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class DaoTest {

    @Test
    public void testFileDaoSave() throws IOException {
        Student student = new Student("Ilya Kurganskiy", 0);
        student.addSubject("Math", 5);
        student.addSubject("Math", 5);
        Dao dao = new FileDao("daoFile.txt");
        dao.insert(student);
        dao.insert(student);
        dao.insert(student);
    }

    @Test
    public void testFileDaoRead() throws IOException {
        Dao dao = new FileDao("daoFile.txt");
        System.out.println(Arrays.toString(dao.getAll()));
        System.out.println(dao.getById(1));
    }

    @Test
    public void testSerializeDaoSave() throws IOException {
        Student student = new Student("Ilya Kurganskiy", 0);
        student.addSubject("Math", 5);
        student.addSubject("Math", 5);
        Dao dao = new SerializeDao("daoSerialize.txt");
        dao.insert(student);
        dao.insert(student);
        dao.insert(student);
    }

    @Test
    public void testSerializeDaoRead() throws IOException {
        Dao dao = new SerializeDao("daoSerialize.txt");
        System.out.println(Arrays.toString(dao.getAll()));
        System.out.println(dao.getById(1));
    }
}