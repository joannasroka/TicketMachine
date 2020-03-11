package com.company.IU;

import com.company.Exceptions.NoMaterialsException;
import com.company.Exceptions.NoMoneyException;
import com.company.Tickets.Ticket;
import com.company.TicketMachine;
import com.company.Tickets.TimeTicket;
import com.company.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

public class BuyTimeTicket implements Observer {
    private String sign = "C";
    private TimeTicket timeTicket30 = new TimeTicket(5.0, 30);
    private TimeTicket timeTicket60 = new TimeTicket(7.5, 60);

    public void payment(TimeTicket ticket, TicketMachine ticketMachine, Wallet wallet, ArrayList<Ticket> tickets, Scanner scanner){
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

    @Override
    public void update(String sign, TicketMachine ticketMachine, Wallet wallet, ArrayList<Ticket> tickets, Scanner scanner) {
        if (!this.sign.equals(sign.toUpperCase())) return;

        int answer;

        System.out.println("Na jaki czas chcesz kupic bilet? ");
        System.out.println("30 = 30 minut");
        System.out.println("60 = 60 minut");
        System.out.println("Wybieram: ");
        answer = scanner.nextInt();
        switch (answer) {
            case 30:
                payment(timeTicket30, ticketMachine, wallet, tickets, scanner);
                break;
            case 60:
                payment(timeTicket60, ticketMachine, wallet, tickets, scanner);
                break;
            default:
                System.out.println("Zla odpowiedz. ");
                break;
        }


    }
}
