package com.company.Boxes;

import com.company.Exceptions.NoMaterialsException;

public class BoxOfPaper implements Refillable, Usable {
    int amountOfPaper;
    int maxAmountOfPaper = 3;


    public BoxOfPaper(){
        amountOfPaper = maxAmountOfPaper;
    }

    public BoxOfPaper(int amountOfPaper) {
        this.amountOfPaper = amountOfPaper;
    }

    @Override
    public void refill() {
        amountOfPaper = maxAmountOfPaper;
    }

    @Override
    public boolean isEmpty() {
        return (amountOfPaper == 0);
    }

    @Override
    public int getSize() {
        return amountOfPaper;
    }

    @Override
    public void use() throws NoMaterialsException { // jednokrotne pobranie porcji papieru na jeden bilet
        if (!isEmpty()) amountOfPaper--;
        else throw new NoMaterialsException("Brak papieru. ");
    }
}
