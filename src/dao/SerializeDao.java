package dao;

import factory.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SerializeDao extends AbstractDao {

    private final File file;

    public SerializeDao(String fileName) {
        this.file = new File(fileName);
        init();
    }

    @Override
    protected Map<Long, Student> firstRead() {
        Map<Long, Student> dict = new HashMap<>();
        try {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                long id = input.readLong();
                Student student = (Student) input.readObject();
                dict.put(id, student);
            }
        } catch (IOException ignored) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dict;
    }

    @Override
    protected void save(Map<Long, Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeInt(students.size());
            for (long i : students.keySet()) {
                out.writeLong(i);
                out.writeObject(students.get(i));
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
