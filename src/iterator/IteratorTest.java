package iterator;

import command.PrintColumn;
import command.PrintRows;
import factory.SchoolBoy;
import factory.Student;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

public class IteratorTest {

    @Test
    public void testIterator() throws IOException {
        SchoolBoy schoolBoy = new SchoolBoy("Ilya Kurganskiy", 0);
        schoolBoy.addSubject("Math", 5);
        schoolBoy.addSubject("Prog", 5);
        schoolBoy.addSubject("Russian", 4);

        Iterator<String> iterator = schoolBoy.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
