package com.company.IU;

import com.company.Exceptions.NoMaterialsException;
import com.company.Exceptions.NoMoneyException;
import com.company.Tickets.Ticket;
import com.company.TicketMachine;
import com.company.Tickets.SemesterTicket;
import com.company.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

public class BuySemesterTicket implements Observer {
    private String sign = "S";
    private SemesterTicket semesterTicket4 = new SemesterTicket(155.0, 4);
    private SemesterTicket semesterTicket5 = new SemesterTicket(180.0, 5);

    public void payment(SemesterTicket ticket, TicketMachine ticketMachine, Wallet wallet, ArrayList<Ticket> tickets, Scanner scanner){
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

        System.out.println("Na ile miesiecy chcesz kupic bilet? ");
        System.out.println("4 = 4 miesiace");
        System.out.println("5 = 5 miesiecy");
        System.out.println("Wybieram: ");
        answer = scanner.nextInt();
        switch (answer) {
            case 4:
               payment(semesterTicket4, ticketMachine, wallet, tickets, scanner);
                break;
            case 5:
                payment(semesterTicket5, ticketMachine, wallet, tickets, scanner);
                break;
            default:
                System.out.println("Zla odpowiedz. ");
                break;
        }


    }
}
