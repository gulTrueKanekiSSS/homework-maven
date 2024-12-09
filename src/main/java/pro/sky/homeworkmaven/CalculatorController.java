package pro.sky.homeworkmaven;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final String basePath = "/calculator";

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    public String getBasePath(){
        return basePath;
    }

    @GetMapping(path = basePath)
    public String mainPage(){
        return calculatorService.mainPage();
    }

    @GetMapping(path = basePath + "/plus")
    public String plusOperation(@RequestParam(value = "num1", required = true) Integer num1,
                             @RequestParam(value = "num2", required = true) Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        return calculatorService.plusOperation(num1, num2);
    }

    @GetMapping(path = basePath + "/minus")
    public String minusOperation(@RequestParam(value = "num1", required = true) Integer num1,
                              @RequestParam(value = "num2", required = true) Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        return calculatorService.minusOperation(num1, num2);
    }

    @GetMapping(path = basePath + "/multiply")
    public String multipleOperation(@RequestParam(value = "num1", required = true) Integer num1,
                              @RequestParam(value = "num2", required = true) Integer num2) {
        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("Вы не передали один из параметров");
        }
        return calculatorService.multipleOperation(num1, num2);
    }

    @GetMapping(path = basePath + "/divide")
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
