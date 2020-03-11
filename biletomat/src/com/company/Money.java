package com.company;

public enum Money {
    JEDENGR (0.01),
    DWAGR (0.02),
    PIECGR (0.05),
    DZIESIECGR (0.10),
    DWADZIESCIAGR (0.20),
    PIECDZIESIACGR (0.50),
    JEDENZL (1.0),
    DWAZL (2.0),
    PIECZL (5.0),
    DZIESIECZL (10.0),
    DWADZIESCIAZL (20.0),
    PIECDZIESIACZL (50.0),
    STOZL (100.0),
    DWIESCIEZL (200.0);

    private final double value;

    Money(double value){
        this.value = value;
    }

    public double getValue() { return value; }

}
