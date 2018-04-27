package strategy;

import factory.Student;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;

public class StrategyTest {

    @Test
    public void testStrategy() {
        Strategy strategy = new QuickSort();

        Student schoolBoy = new Student("Ilya Kurganskiy", 0);
        schoolBoy.addSubject("Math", 5);
        schoolBoy.addSubject("Prog", 5);
        schoolBoy.addSubject("Russian", 4);

        Student schoolBoy2 = new Student("Ilya Kurganskiy", 0);
        schoolBoy2.addSubject("Math", 4);
        schoolBoy2.addSubject("Prog", 3);
        schoolBoy2.addSubject("Russian", 4);

        Student schoolBoy3 = new Student("Ilya Kurganskiy", 0);
        schoolBoy3.addSubject("Math", 4);
        schoolBoy3.addSubject("Prog", 3);
        schoolBoy3.addSubject("Russian", 4);

        System.out.println(strategy.sort(new Student[]{schoolBoy, schoolBoy2, schoolBoy3}));
    }

    @After
    public void tearDown() throws IOException {
    }
}
