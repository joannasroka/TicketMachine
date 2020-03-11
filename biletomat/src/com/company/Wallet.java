package com.company;

public class Wallet {
    private CreditCard creditCard;
    private double cash;

    public Wallet(){
        creditCard = new CreditCard(0.0);
        cash = 0.0;
    }

    public Wallet(double creditCardCash, double cash) {
        this.creditCard = new CreditCard(creditCardCash);
        this.cash = cash;
    }

    public Wallet(CreditCard creditCard, double cash) {
        this.creditCard = creditCard;
        this.cash = cash;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
