package com.company.Boxes;

import com.company.Exceptions.NoMaterialsException;

public class BoxOfInk implements Refillable, Usable {

    private int amountOfInk;
    private int maxAmountOfInk = 5;

    public BoxOfInk() {
        amountOfInk = maxAmountOfInk;
    }

    public BoxOfInk(int amountOfInk) {
        this.amountOfInk = amountOfInk;
    }

    @Override
    public void refill() {
        amountOfInk = maxAmountOfInk;
    } // uzupełnij

    @Override
    public boolean isEmpty() {
        return (amountOfInk == 0);
    }

    @Override
    public int getSize() {
        return amountOfInk;
    }

    @Override
    public void use() throws NoMaterialsException { // jednokrotne pobranie porcji tuszu na jeden bilet
        if (!isEmpty()) amountOfInk--;
        else throw new NoMaterialsException("Brak tuszu. ");
    }
}