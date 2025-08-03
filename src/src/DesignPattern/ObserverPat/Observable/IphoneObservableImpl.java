package DesignPattern.ObserverPat.Observable;

import DesignPattern.ObserverPat.Observer.Notification;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable
{
    private int stockCount;
    private List<Notification> observers = new ArrayList<>();

    @Override
    public void addObserver(Notification observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Notification observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Notification n : observers) {
            // Notify each observer
            // This could be a method call on the observer, e.g., n.update(stockCount);
            n.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if(this.stockCount == 0) {
            notifyObservers();
        }
        this.stockCount += stockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

}
