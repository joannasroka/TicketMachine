package com.company.Tickets;

public class TimeTicket extends Ticket {

    private int minutes;

    public TimeTicket(double price, int minutes) {
        super(price);
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return super.toString() + " minutes= " + minutes;
    }
}
