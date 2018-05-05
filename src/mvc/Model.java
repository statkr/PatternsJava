package mvc;

import java.util.ArrayList;

public class Model {
    private ArrayList<Float> x = new ArrayList<>();

    public void add() {
        add(0);
    }

    public void add(float value) {
        x.add(value);
        x.sort(Float::compare);
    }

    public void delete(int index) {
        x.remove(index);
        x.sort(Float::compare);
    }

    public void changeX(int index, float value) {
        x.set(index, value);
        x.sort(Float::compare);
    }

    public int getSize() {
        return x.size();
    }


    public float getX(int index) {
        return getAllX().get(index);
    }

    public float getY(int index) {
        float x = getX(index);
        return x * x;
    }

    private ArrayList<Float> getAllX() {
        return x;
    }
}
