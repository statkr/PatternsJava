package factory;

import java.util.Arrays;

public class SchoolBoy implements Pupil {
    private String name;
    private Register[] registers;

    public SchoolBoy(String name, int count) {
        this.name = name;
        registers = new Register[count];
        for (int i = 0; i < count; i++) {
            registers[i] = new Register();
        }
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
        return registers[index].getMark();
    }

    @Override
    public void setMark(int index, int value) {
        registers[index].setMark(value);
    }

    @Override
    public String getSubject(int index) {
        return registers[index].getSubject();
    }

    @Override
    public void setSubject(int index, String value) {
        registers[index].setSubject(value);
    }

    @Override
    public void addSubject(String subject, int mark) {
        registers = Arrays.copyOf(registers, registers.length + 1);
        registers[registers.length - 1] = new Register(subject, mark);
    }

    @Override
    public int getSubjectsSize() {
        return registers.length;
    }

    private class Register {
        private String subject;
        private int mark;

        public Register() {
        }

        public Register(String subject, int mark) {
            this.subject = subject;
            this.mark = mark;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }
    }
}
