package dao;

import factory.Student;

public interface Dao {
    Student getById(long id);
    Student[] getAll();
    long insert(Student student);
    void update(long id, Student student);
    void delete(long id);
}
