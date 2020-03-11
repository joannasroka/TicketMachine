package com.company.IU;

import com.company.Tickets.Ticket;
import com.company.TicketMachine;
import com.company.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

public class OtherAnswer implements Observer {
    @Override
    public void update(String sign, TicketMachine ticketMachine, Wallet wallet, ArrayList<Ticket> tickets, Scanner scanner) {
        if (sign.toUpperCase().equals("J") || sign.toUpperCase().equals("C") || sign.toUpperCase().equals("S") ||
                sign.toUpperCase().equals("E") || sign.toUpperCase().equals("K") || sign.toUpperCase().equals("G")  ||
                sign.toUpperCase().equals("P"))
            return;
        else System.out.println("Bledne dane. ");
    }
}
