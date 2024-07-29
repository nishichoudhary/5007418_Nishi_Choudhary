package ObserverPatternExample;

interface Stock
{
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}
