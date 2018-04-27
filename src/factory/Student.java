package factory;

import command.Command;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Student implements Pupil {
    private String name;
    private int[] marks;
    private String[] subjects;
    private Command command;

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

    public void setCommand(Command command) {
        this.command = command;
    }

    public void printCommand(OutputStream stream) throws IOException {
        command.print(stream);
    }
}
