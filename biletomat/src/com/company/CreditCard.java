package com.company;

import com.company.Exceptions.NoMoneyException;

public class CreditCard {
    private double contents; // zawartosc

    public CreditCard() {
        this.contents = 0.0;
    }

    public CreditCard(double contents) {
        this.contents = contents;
    }

    public void cashOut(double value) throws NoMoneyException { // zmniejsz wartość karty o podaną kwotę, wyplac
        if (value > 0.0) {
            if (value > contents) throw new NoMoneyException("Brak pieniedzy na karcie. ");
            else contents -= value;
        }
    }

    public void topUp(double value) { // doładuj konto
        if (value > 0.0) contents += value;
    }

    public double getContents() { // zwroc zawartosc karty
        return contents;
    }

}
