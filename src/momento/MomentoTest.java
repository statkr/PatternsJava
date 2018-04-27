package momento;

import org.junit.Test;
import protorype.Student;

import java.io.IOException;
import java.util.Iterator;

public class MomentoTest {

    @Test
    public void testMomento() throws IOException {
        Student schoolBoy = new Student("Ilya Kurganskiy", 0);
        schoolBoy.addSubject("Math", 5);
        Student.Momento momento = schoolBoy.createMomento();

        schoolBoy.addSubject("Prog", 5);
        schoolBoy.addSubject("Russian", 4);

        System.out.println(schoolBoy.getSubjectsSize());

        schoolBoy.setMomento(momento);
        System.out.println(schoolBoy.getSubjectsSize());
    }


}
