package factory;

public class StudentsFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String name, int size) {
        return new Student(name, size);
    }
}
