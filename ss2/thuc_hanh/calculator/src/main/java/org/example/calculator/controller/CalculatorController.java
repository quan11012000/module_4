package org.example.calculator.controller;

import org.example.calculator.entity.Calculator;
import org.example.calculator.exception.CalculationException;
import org.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController  {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "index"; // trang form
    }
    @Autowired
    private CalculatorService service;
    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Calculator calculator, Model model) {
        double result = service.calculate(calculator);

        // Biểu thức: "5 + 3 = 8"
        String expression = calculator.getFirstNumber() + " " + calculator.getOperator() + " " +
                calculator.getSecondNumber() + " = " + result;

        model.addAttribute("expression", expression);
        model.addAttribute("result", result);
        model.addAttribute("calculator", calculator);
        return "index";
    }
    // 🎯 BẮT LỖI custom
    @ExceptionHandler(CalculationException.class)
    public String handleCalculationError(CalculationException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "index"; // chuyển sang trang error.jsp
    }

    // 🎯 BẮT LỖI nhập sai định dạng (chữ thay vì số)
    @ExceptionHandler({NumberFormatException.class, org.springframework.validation.BindException.class})
    public String handleInputError(Exception ex, Model model) {
        model.addAttribute("error", "Vui lòng nhập đúng định dạng số!");
        return "index";
    }
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == 404) {
                return "errors/404"; // Tức là /WEB-INF/views/error/404.jsp
            }
        }
        return "errors/general"; // fallback
    }
    @RequestMapping("/a")
    public String test(){
        String a=null;
        a.length();
        return "index";
    }
}
