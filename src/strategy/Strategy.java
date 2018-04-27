package strategy;

import factory.Student;

public interface Strategy {
    Student[] sort(Student[] students);
}
