package br.com.erudio.rest_with_spring_boot_and_java_erudio.restController;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.services.MathService;
import org.springframework.web.bind.annotation.*;



@RestController
public class MathController {

    private final MathService service = new MathService();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return service.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return service.subtraction(numberOne, numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return service.division(numberOne, numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return service.multiplication(numberOne, numberTwo);
    }

    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return service.average(numberOne, numberTwo);
    }

    @RequestMapping(value = "/sqrt/{number}",
            method = RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "number") String number) throws Exception {
        return  service.sqrt(number);
    }


}
