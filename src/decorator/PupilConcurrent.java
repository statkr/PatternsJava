package decorator;


import factory.Pupil;

public class PupilConcurrent implements Pupil {
    private Pupil pupil;

    public PupilConcurrent(Pupil pupil) {
        this.pupil = pupil;
    }

    @Override
    public synchronized String getName() {
        return pupil.getName();
    }

    @Override
    public synchronized void setName(String name) {
        pupil.setName(name);
    }

    @Override
    public synchronized int getMark(int index) {
        return pupil.getMark(index);
    }

    @Override
    public synchronized void setMark(int index, int value) {
        pupil.setMark(index, value);
    }

    @Override
    public synchronized String getSubject(int index) {
        return pupil.getSubject(index);
    }

    @Override
    public synchronized void setSubject(int index, String value) {
        pupil.setSubject(index, value);
    }

    @Override
    public synchronized void addSubject(String subject, int mark) {
        pupil.addSubject(subject, mark);
    }

    @Override
    public synchronized int getSubjectsSize() {
        return pupil.getSubjectsSize();
    }
}
