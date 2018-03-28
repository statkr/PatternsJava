package decorator;

import factory.Pupil;
import factory.Pupils;
import factory.SchoolBoy;
import factory.Student;
import org.junit.Assert;
import org.junit.Test;

public class ConcurrentTest {

    @Test
    public void testCreateConcurrent() {
        Pupil pupil = new Student("test", 0);
        Pupil syncPupil = Pupils.synchronizePupil(pupil);
        Assert.assertTrue(syncPupil instanceof PupilConcurrent);
    }
}
