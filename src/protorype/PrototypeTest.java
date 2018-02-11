package protorype;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PrototypeTest {

    @Parameterized.Parameters
    public static Collection<Pupil> data() {
        return Arrays.asList(new Student("Student", 0), new SchoolBoy("Boy", 0));
    }

    @Parameterized.Parameter // first data value (0) is default
    public Pupil pupil;

    @Before
    public void init(){
        pupil.addSubject("Math", 5);
    }
    @Test
    public void testClone() throws CloneNotSupportedException {
        Pupil clone = pupil.clone();
        Assert.assertEquals(clone.getName(), pupil.getName());
        Assert.assertEquals(clone.getSubjectsSize(), pupil.getSubjectsSize());
    }

    @Test
    public void testDeepCloneSubject() throws CloneNotSupportedException {
        Pupil clone = pupil.clone();
        clone.setSubject(0, "Java");
        Assert.assertNotEquals(clone.getSubject(0), pupil.getSubject(0));
    }

    @Test
    public void testDeepCloneMark() throws CloneNotSupportedException {
        Pupil clone = pupil.clone();
        clone.setMark(0, 4);
        Assert.assertNotEquals(clone.getMark(0), pupil.getMark(0));
    }
}
