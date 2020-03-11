package com.company.IU;

import com.company.Exceptions.NoMaterialsException;
import com.company.Exceptions.NoMoneyException;
import com.company.Tickets.Ticket;
import com.company.TicketMachine;
import com.company.Tickets.SingleTicket;
import com.company.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

public class BuySingleTicket implements Observer {
    private String sign = "J";
    private SingleTicket ticket = new SingleTicket(3.4);

    @Override
    public void update(String sign, TicketMachine ticketMachine, Wallet wallet, ArrayList<Ticket> tickets, Scanner scanner) {
        if (!this.sign.equals(sign.toUpperCase())) return;

        String answer;
        System.out.println("Jak chcesz zaplacic? ");
        System.out.println("K = place karta");
        System.out.println("G = place gotowka");
        System.out.println("Wybieram: ");
        answer = scanner.next().toUpperCase();
        switch (answer) {
            case "K":
                try {
                    ticketMachine.payByCard(wallet, ticket.getPrice());
                    tickets.add(ticket);
                    System.out.println("Twoj bilet: " + ticket.toString());
                } catch (NoMoneyException exc) {
                    System.out.println("Brak pieniedzy na karcie.");
                } catch (NoMaterialsException exc) {
                    System.out.println("Brak materialow. ");
                }
                break;
            case "G":
                try {
                    ticketMachine.payByCash(wallet, ticket.getPrice());
                    tickets.add(ticket);
                    System.out.println("Twoj bilet: " + ticket.toString());
                } catch (NoMoneyException exc) {
                    System.out.println("Brak pieniedzy w portfelu.");
                } catch (NoMaterialsException exc) {
                    System.out.println("Brak materialow. ");
                }
                break;
            default:
                System.out.println("Zla odpowiedz. ");
                break;
        }


    }
}
