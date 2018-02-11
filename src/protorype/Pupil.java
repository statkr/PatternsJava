package protorype;

public interface Pupil extends Cloneable {
    String getName();

    void setName(String name);

    int getMark(int index);

    void setMark(int index, int value);

    String getSubject(int index);

    void setSubject(int index, String value);

    void addSubject(String subject, int mark);

    int getSubjectsSize();

    Pupil clone() throws CloneNotSupportedException;
}
