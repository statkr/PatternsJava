package command;

import factory.Student;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PrintRows implements Command {
    private Student student;

    public PrintRows(Student student) {
        this.student = student;
    }

    @Override
    public void print(OutputStream stream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(stream);
        dataOutputStream.writeChars(String.format("Student [%s]: ", student.getName()));
        for (int i = 0; i < student.getSubjectsSize(); i++) {
            dataOutputStream.writeChars(String.format("mark:%d subject:%s ", student.getMark(i), student.getSubject(i)));
        }
        dataOutputStream.writeChar('\n');

    }
}
