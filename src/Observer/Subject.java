package Observer;

public interface Subject {
     void register (Observer O);
     void unregister (Observer O);

    void notifyAllObservers();

}
