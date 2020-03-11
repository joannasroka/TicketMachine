package com.company.Boxes;

import com.company.Exceptions.NoMoneyException;
import com.company.Money;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoxOfMoney implements Refillable {
    private int maxAmountOfMoney = 4;
    private Map <Money, Integer> cashRegister = new HashMap<>();
    private ArrayList <Money> typesOfMoney = new ArrayList<>();

    public BoxOfMoney (){
        for (Money money: Money.values()) {
            cashRegister.put(money, maxAmountOfMoney);
            typesOfMoney.add(money);
        }
    }

    @Override
    public void refill() { // wypełnij puste szufladki
        for(Money key: cashRegister.keySet()){
            if (cashRegister.get(key) == 0) cashRegister.replace(key, 0,  maxAmountOfMoney);
        }
    }

    @Override
    public boolean isEmpty() { // czy jakikolwiek jest pusty
        for (int value: cashRegister.values()) {
            if (value == 0) return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return cashRegister.size();
    }

    public void takeMoney(Money money) throws NoMoneyException {
        int oldAmonut = cashRegister.get(money);
        if(cashRegister.containsKey(money) && oldAmonut != 0)  {
            cashRegister.replace(money, oldAmonut, oldAmonut-1);
        }
        else throw new NoMoneyException("Brak pieniedzy. ");
    }

    public Map<Money, Integer> getCashRegister() {
        return cashRegister;
    }

    public ArrayList<Money> getTypesOfMoney() {
        return typesOfMoney;
    }
}
