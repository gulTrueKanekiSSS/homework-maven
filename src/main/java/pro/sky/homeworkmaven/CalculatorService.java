package pro.sky.homeworkmaven;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String mainPage(){
        return "Добро пожаловать в калькулятор";
    }

    public String plusOperation(int num1, int num2){
        int result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }

    public String minusOperation(int num1, int num2){
        int result = num1 - num2;
        return num1 + " - " + num2 + " = " + result;
    }

    public String multipleOperation(int num1, int num2){
        int result = num1 * num2;
        return num1 + " * " + num2 + " = " + result;
    }

    public String divideOperation(int num1, int num2) {
        int result = num1 / num2;
        return num1 + " / " + num2 + " = " + result;
    }
}
