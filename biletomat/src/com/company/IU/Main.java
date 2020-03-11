package com.company.IU;

import com.company.*;
import com.company.Tickets.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Observer> observerList = new ArrayList<>();
        observerList.add(new BuySingleTicket());
        observerList.add(new BuyTimeTicket());
        observerList.add(new BuySemesterTicket());
        observerList.add(new ShowTickets());
        observerList.add(new OtherAnswer());

        TicketMachine ticketMachine = new TicketMachine();
        ArrayList<Ticket> tickets = new ArrayList<>();

        Wallet wallet = new Wallet();
        double cashValue = 0.0;
        double cardValue = 0.0;

        Scanner scanner = new Scanner(System.in);
        String answer;
        double money;
        boolean program = true;

        System.out.println("Dzien dobry!");

        System.out.println("Ile chcesz miec w portfelu gotowki: ");
        money = scanner.nextDouble();
        if (money >= 0.0) cashValue = money;

        System.out.println("Ile chcesz miec na karcie gotowki: ");
        money = scanner.nextDouble();
        if (money >= 0.0) cardValue = money;

        wallet = new Wallet(new CreditCard(cardValue), cashValue);

        while (program) {
            System.out.println("Twoje dane: ");
            System.out.println("gotowka: "+ wallet.getCash() +" | karta platnicza: " + wallet.getCreditCard().getContents());
            System.out.println();
            System.out.println("MENU");
            System.out.println("J = kup bilet jednorazowy");
            System.out.println("C = kup bilet czasowy");
            System.out.println("S = kup bilet semestralny");
            System.out.println("P = pokaz posiadane bilety");
            System.out.println("E = wyjdz z programu");
            System.out.println("Wybieram: ");
            answer = scanner.next().toUpperCase();

            if (answer.toUpperCase().equals("E")) program = false;
            else {
                for (int i = 0; i < observerList.size(); i++) {
                    observerList.get(i).update(answer, ticketMachine, wallet, tickets,  scanner);
                }
            }

        }
    }
}
