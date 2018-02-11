package factory;

public class Pupils {
    private static PupilFactory factory = new StudentsFactory();

    public static synchronized void setFactory(PupilFactory factory) {
        Pupils.factory = factory;
    }

    public static Pupil createPupil(String name, int size) {
        return factory.createInstance(name, size);
    }

    public static void showSubjectsTable(Pupil pupil) {
        for (int i = 0; i < pupil.getSubjectsSize(); i++) {
            System.out.println(String.format("%10s %2d", pupil.getSubject(i), pupil.getMark(i)));
        }
    }

    public static float getAverageMark(Pupil pupil) {
        float summ = 0;
        for (int i = 0; i < pupil.getSubjectsSize(); i++) {
            summ += pupil.getMark(i);
        }
        return summ / pupil.getSubjectsSize();
    }
}
