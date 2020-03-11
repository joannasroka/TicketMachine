package com.company.Tickets;

public abstract class Ticket {
    private double price;

    public Ticket(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket: " +
                "price=" + price;
    }
}
