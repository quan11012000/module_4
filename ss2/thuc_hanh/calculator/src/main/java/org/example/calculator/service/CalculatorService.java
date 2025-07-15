package org.example.calculator.service;

import org.example.calculator.entity.Calculator;
import org.example.calculator.exception.CalculationException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CalculatorService {
    public double calculate(Calculator calculator) {
        double num1 = calculator.getFirstNumber();
        double num2 = calculator.getSecondNumber();
        String op = calculator.getOperator();

        double result;

        switch (op) {
            case "+":
                result = num1 + num2; break;
            case "-":
                result = num1 - num2; break;
            case "*":
                result = num1 * num2; break;
            case "/":
                if (num2 == 0) throw new CalculationException("Không thể chia cho 0!");
                result = num1 / num2; break;
            default:
                throw new CalculationException("Phép toán không hợp lệ!");
        }

        // Làm tròn 3 chữ số
        DecimalFormat df = new DecimalFormat("#.###");
        return Double.parseDouble(df.format(result));
    }
}
