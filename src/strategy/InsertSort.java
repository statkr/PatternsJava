package strategy;

import factory.Pupils;
import factory.Student;

public class InsertSort implements Strategy {
    @Override
    public Student[] sort(Student[] students) {
        int n = students.length;
        for (int i = 1; i < n; ++i) {
            Student key = students[i];
            int j = i - 1;

            while (j >= 0 && Pupils.getAverageMark(students[j]) > Pupils.getAverageMark(key)) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }
        return students;
    }
}
