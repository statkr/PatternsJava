package command;

import factory.Student;
import org.junit.Test;

import java.io.IOException;

public class CommandTest {

    @Test
    public void testPrintRows() throws IOException {
        Student student = new Student("Ilya Kurganskiy", 1);

        student.setCommand(new PrintRows(student));
        student.printCommand(System.out);
    }

    @Test
    public void testPrintColumnts() throws IOException {
        Student student = new Student("Ilya Kurganskiy", 1);

        student.setCommand(new PrintColumn(student));
        student.printCommand(System.out);
    }
}