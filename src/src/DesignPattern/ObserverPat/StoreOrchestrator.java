package DesignPattern.ObserverPat;

import DesignPattern.ObserverPat.Observable.IphoneObservableImpl;
import DesignPattern.ObserverPat.Observable.StockObservable;
import DesignPattern.ObserverPat.Observer.EmailNotifyImpl;
import DesignPattern.ObserverPat.Observer.Notification;

public class StoreOrchestrator
{
    public static void main(String[] args)
    {
        StockObservable iphoneObservable = new IphoneObservableImpl();

        Notification observer1 = new EmailNotifyImpl("abc@gmail.com", iphoneObservable);
        Notification observer2 = new EmailNotifyImpl("zxcv@gmail.com", iphoneObservable);

        iphoneObservable.addObserver(observer1);
        iphoneObservable.addObserver(observer2);

        iphoneObservable.setStockCount(100);
        iphoneObservable.getStockCount();
    }
}
