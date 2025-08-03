package DesignPattern.ObserverPat.Observer;

import DesignPattern.ObserverPat.Observable.StockObservable;

public class EmailNotifyImpl implements Notification
{
    private String email;
    private StockObservable observable;

    public EmailNotifyImpl(String email, StockObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(this.email, "Stock available");
    }

    private void sendEmail(String email, String message) {
        // Simulate sending an email
        System.out.println("Sending email to " + email + ": " + message);
    }
}
