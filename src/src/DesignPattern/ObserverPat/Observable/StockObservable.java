package DesignPattern.ObserverPat.Observable;

import DesignPattern.ObserverPat.Observer.Notification;

public interface StockObservable
{
    public void addObserver(Notification observer);

    public void removeObserver(Notification observer);

    public void notifyObservers();

    public void setStockCount(int stockCount);

    public int getStockCount();
}
