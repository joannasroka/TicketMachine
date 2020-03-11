package com.company;

import com.company.Boxes.BoxOfMoney;
import com.company.Exceptions.NoMaterialsException;
import com.company.Exceptions.NoMoneyException;
import com.company.Tickets.Ticket;

import java.util.ArrayList;

public class TicketMachine {
    private Printer printer = new Printer();
    private BoxOfMoney boxOfMoney = new BoxOfMoney();

    private ArrayList<Money> changeList = new ArrayList<>(); // lista pieniedzy do wydania
    // (za kazdym razem nowa przy kupnie biletu)


    public ArrayList<Money> giveChange(double change) { // wydaj resztę
        changeList = new ArrayList<>();

        int indexOfMoney = boxOfMoney.getTypesOfMoney().size() - 1;
        Money maxMoney; // czyli najwyższy do tej pory pieniądz (na początku 200 zl)
        double maxMoneyValue;

        while (change > 0 && indexOfMoney >= 0) {

            maxMoney = boxOfMoney.getTypesOfMoney().get(indexOfMoney);
            maxMoneyValue = boxOfMoney.getCashRegister().get(maxMoney);

            if (change >= maxMoneyValue) {

                int divResult = (int) (change / maxMoneyValue);
                change = change - (maxMoneyValue * divResult);
                for (int i = 0; i < divResult; i++) {
                    changeList.add(maxMoney);
                    try {
                        boxOfMoney.takeMoney(maxMoney);
                    } catch (NoMoneyException exc) {
                        boxOfMoney.refill();
                    }
                }
            }
            indexOfMoney--;
        }
        return changeList;
    }

    public void payByCard(Wallet wallet, double ticketPrice) throws NoMoneyException, NoMaterialsException {
            wallet.getCreditCard().cashOut(ticketPrice);
            printer.printOneTicket();
    }

    public ArrayList<Money> payByCash(Wallet wallet, double ticketPrice) throws NoMoneyException, NoMaterialsException {
        if (wallet.getCash() < ticketPrice) throw new NoMoneyException("Dano za malo pieniedzy. ");
        else {
            printer.printOneTicket();
            wallet.setCash(wallet.getCash() - ticketPrice);
            return giveChange(wallet.getCash());}
    }


}
