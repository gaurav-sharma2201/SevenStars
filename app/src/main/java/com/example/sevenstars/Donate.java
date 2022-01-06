package com.example.sevenstars;

public class Donate {
    public Donate(String trust_name, String Rupees) {
        this.trust_name=trust_name;
        this.Rupees=Rupees;
    }

    public String getTrust_name() {
        return trust_name;
    }

    public void setTrust_name(String trust_name) {
        this.trust_name = trust_name;
    }

    public String getRupees() {
        return Rupees;
    }

    public void setRupees(String rupees) {
        Rupees = rupees;
    }

    String trust_name;
    String Rupees;

}
