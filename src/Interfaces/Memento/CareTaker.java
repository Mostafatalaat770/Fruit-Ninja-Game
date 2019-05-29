package Interfaces.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
class CareTaker {
    private final List<Memento> mementoList = new ArrayList<>();

    void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}