package com.company.IU;

import com.company.IU.Observer;
import com.company.TicketMachine;
import com.company.Tickets.Ticket;
import com.company.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowTickets implements Observer {
    private String sign = "P";

    @Override
    public void update(String sign, TicketMachine ticketMachine, Wallet wallet, ArrayList<Ticket> tickets, Scanner scanner) {
        if (!this.sign.equals(sign.toUpperCase())) return;

        System.out.println("Twoje bilety: ");
        for (Ticket ticket: tickets) {
            System.out.println(ticket.toString()+" ");
        }


    }
}
