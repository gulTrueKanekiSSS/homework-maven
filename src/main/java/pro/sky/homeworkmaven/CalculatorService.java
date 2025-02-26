package pro.sky.homeworkmaven;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorServiceIntarface {
    public String mainPage(){
        return "Добро пожаловать в калькулятор";
    }

    public String plusOperation(Integer num1, Integer num2){
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        int result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }

    public String minusOperation(Integer num1, Integer num2){
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        int result = num1 - num2;
        return num1 + " - " + num2 + " = " + result;
    }

    public String multipleOperation(Integer num1, Integer num2){
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        int result = num1 * num2;
        return num1 + " * " + num2 + " = " + result;
    }

    public String divideOperation(Integer num1, Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        if (num2 != 0) {
            int result = num1 / num2;
            return num1 + " / " + num2 + " = " + result;
        }

        throw new IllegalArgumentException("Нельзя делить на 0");
    }
}

