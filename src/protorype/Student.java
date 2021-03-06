package protorype;

import java.util.Arrays;

public class Student implements Pupil {
    private String name;
    private int[] marks;
    private String[] subjects;

    public Student(String name, int size) {
        this.name = name;
        marks = new int[size];
        subjects = new String[size];
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMark(int index) {
        return marks[index];
    }

    @Override
    public void setMark(int index, int value) {
        this.marks[index] = value;
    }

    @Override
    public String getSubject(int index) {
        return subjects[index];
    }

    @Override
    public void setSubject(int index, String value) {
        this.subjects[index] = value;
    }

    @Override
    public void addSubject(String subject, int mark) {
        subjects = Arrays.copyOf(subjects, subjects.length + 1);
        marks = Arrays.copyOf(marks, marks.length + 1);
        subjects[subjects.length - 1] = subject;
        marks[marks.length - 1] = mark;
    }

    @Override
    public int getSubjectsSize() {
        return marks.length;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        clone.subjects = Arrays.copyOf(subjects, subjects.length);
        clone.marks = Arrays.copyOf(marks, marks.length);
        return clone;
    }

    public Momento createMomento() {
        try {
            return new Momento(this.clone());
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void setMomento(Momento momento) {
        try {
            Student student = momento.getStudent().clone();
            marks = student.marks;
            subjects = student.subjects;
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }

    public static class Momento {
        private Student student;

        Momento(Student student) {
            this.student = student;
        }

        Student getStudent() {
            return student;
        }

    }
}
