package com.company.Tickets;

public class SemesterTicket extends Ticket {

    private int months;

    public SemesterTicket(double price, int months) {
        super(price);
        this.months = months;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    @Override
    public String toString() {
        return super.toString() + " months= " + months;
    }
}

