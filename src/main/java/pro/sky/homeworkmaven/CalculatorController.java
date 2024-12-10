package pro.sky.homeworkmaven;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String mainPage(){
        return calculatorService.mainPage();
    }

    @GetMapping("/plus")
    public String plusOperation(@RequestParam(value = "num1", required = true) Integer num1,
                             @RequestParam(value = "num2", required = true) Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        return calculatorService.plusOperation(num1, num2);
    }

    @GetMapping("/minus")
    public String minusOperation(@RequestParam(value = "num1", required = true) Integer num1,
                              @RequestParam(value = "num2", required = true) Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        return calculatorService.minusOperation(num1, num2);
    }

    @GetMapping("/multiply")
    public String multipleOperation(@RequestParam(value = "num1", required = true) Integer num1,
                              @RequestParam(value = "num2", required = true) Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        return calculatorService.multipleOperation(num1, num2);
    }

    @GetMapping("/divide")
    public String divideOperation(@RequestParam(value = "num1", required = true) Integer num1,
                              @RequestParam(value = "num2", required = true) Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        } else if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return calculatorService.divideOperation(num1, num2);
    }

}
