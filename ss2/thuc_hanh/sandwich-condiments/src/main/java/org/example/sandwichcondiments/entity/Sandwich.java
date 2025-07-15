package org.example.sandwichcondiments.entity;

public class Sandwich {

    private String condiment;

    public Sandwich(String condiment) {
        this.condiment = condiment;
    }

    public String getCondiment() {
        return condiment;
    }

    public void setCondiment(String condiment) {
        this.condiment = condiment;
    }
}
