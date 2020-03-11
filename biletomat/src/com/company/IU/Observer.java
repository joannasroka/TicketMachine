package com.company.IU;

import com.company.Tickets.Ticket;
import com.company.TicketMachine;
import com.company.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

public interface Observer {
    void update (String sign, TicketMachine ticketMachine, Wallet wallet, ArrayList<Ticket> tickets, Scanner scanner);
}
