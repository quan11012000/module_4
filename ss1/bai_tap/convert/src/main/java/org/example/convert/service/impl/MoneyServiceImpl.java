package org.example.convert.service.impl;

import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl {
    public String getResultString(String amountStr, String from, String to) {
        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {

            return "Vui lòng nhập một số hợp lệ!";
        }
        double rate = 1.0;
        if (from.equals("USD") && to.equals("VND")) {
            rate = 25000;
        } else if (from.equals("VND") && to.equals("USD")) {
            rate = 1.0 / 25000;
        }
        double resultAmount = amount * rate;
        return String.format("%.0f %s = %.0f %s", amount, from, resultAmount, to);
    }
}
