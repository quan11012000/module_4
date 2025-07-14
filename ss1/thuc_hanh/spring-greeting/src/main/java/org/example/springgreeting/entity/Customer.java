package org.example.springgreeting.entity;
public class Customer {

    private Integer codeCus;
    private String nameCus;
    private String phoneNumber;
    private Integer accumulatedPoint;
    private String rankCus;

    public Customer() {
    }

    public Customer(Integer codeCus, String nameCus, String phoneNumber, Integer accumulatedPoint, String rankCus) {
        this.codeCus = codeCus;
        this.nameCus = nameCus;
        this.phoneNumber = phoneNumber;
        this.accumulatedPoint = accumulatedPoint;
        this.rankCus = rankCus;
    }

    public Integer getCodeCus() {
        return codeCus;
    }

    public void setCodeCus(Integer codeCus) {
        this.codeCus = codeCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAccumulatedPoint() {
        return accumulatedPoint;
    }

    public void setAccumulatedPoint(Integer accumulatedPoint) {
        this.accumulatedPoint = accumulatedPoint;
    }

    public String getRankCus() {
        return rankCus;
    }

    public void setRankCus(String rankCus) {
        this.rankCus = rankCus;
    }
}

