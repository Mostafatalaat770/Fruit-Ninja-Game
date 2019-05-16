package Interfaces.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}