package strategy;

import factory.Student;

import static factory.Pupils.getAverageMark;

public class QuickSort implements Strategy {
    private Student students[];

    public Student[] sort(Student[] students) {
        this.students = students;
        doSort(0, students.length - 1);
        return students;
    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (getAverageMark(students[i]) <= getAverageMark(students[cur]))) {
                i++;
            }
            while (j > cur && (getAverageMark(students[cur]) <= getAverageMark(students[j]))) {
                j--;
            }
            if (i < j) {
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur + 1, end);
    }
}

