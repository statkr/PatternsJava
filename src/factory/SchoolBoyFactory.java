package factory;

public class SchoolBoyFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String name, int size) {
        return new SchoolBoy(name, size);
    }
}
