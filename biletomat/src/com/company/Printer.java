package com.company;

import com.company.Boxes.BoxOfInk;
import com.company.Boxes.BoxOfPaper;
import com.company.Exceptions.NoMaterialsException;

public class Printer {
    private BoxOfPaper boxOfPaper = new BoxOfPaper();
    private BoxOfInk boxOfInk = new BoxOfInk();

    public void printOneTicket() throws NoMaterialsException {
        try {
            boxOfPaper.use();
        } catch (NoMaterialsException exc){
            boxOfPaper.refill();
            throw new NoMaterialsException("Brak papieru. ");
        }
        try {
        boxOfInk.use();
        } catch (NoMaterialsException exc){
            boxOfInk.refill();
            throw new NoMaterialsException("Brak tuszu. ");
        }
    }
}
