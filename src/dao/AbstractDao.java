package dao;

import factory.Student;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDao implements Dao {
    private long lastId = 0;
    private Map<Long, Student> dict;

    protected void init() {
        dict = firstRead();
    }

    @Override
    public Student getById(long id) {
        return dict.get(id);
    }

    @Override
    public Student[] getAll() {
        return dict.values().toArray(new Student[dict.size()]);
    }

    @Override
    public long insert(Student student) {
        dict.put(++lastId, student);
        save(dict);
        return lastId;
    }

    @Override
    public void update(long id, Student student) {
        dict.put(id, student);
        save(dict);
    }

    @Override
    public void delete(long id) {
        dict.remove(id);
        save(dict);
    }

    protected abstract Map<Long, Student> firstRead();

    protected abstract void save(Map<Long, Student> student);
}
