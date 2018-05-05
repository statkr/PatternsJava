package dao;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import factory.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileDao extends AbstractDao {
    private final File file;

    public FileDao(String fileName) {
        this.file = new File(fileName);
        init();
    }

    private String readString(DataInputStream in) throws IOException {
        StringBuilder res = new StringBuilder();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            res.append(in.readChar());
        }
        return res.toString();
    }

    @Override
    protected Map<Long, Student> firstRead() {
        Map<Long, Student> dict = new HashMap<>();
        try {
            FileInputStream fileInput = new FileInputStream(file);
            DataInputStream input = new DataInputStream(fileInput);
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                long id = input.readLong();
                String name = readString(input);
                int subjectSize = input.readInt();
                Student student = new Student(name, 0);
                for (int j = 0; j < subjectSize; j++) {
                    String subject = readString(input);
                    int mark = input.readInt();
                    student.addSubject(subject, mark);
                }
                dict.put(id, student);
            }
        } catch (IOException ignored) {
        }
        return dict;
    }

    @Override
    protected void save(Map<Long, Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            DataOutputStream out = new DataOutputStream(fileOutputStream);
            out.writeInt(students.size());
            for (long i : students.keySet()) {
                //id
                out.writeLong(i);
                Student student = students.get(i);

                out.writeInt(student.getName().length());
                out.writeChars(student.getName());

                out.writeInt(student.getSubjectsSize());

                for (int j = 0; j < student.getSubjectsSize(); j++) {
                    out.writeInt(student.getSubject(j).length());
                    out.writeChars(student.getSubject(j));
                    out.writeInt(student.getMark(j));
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
