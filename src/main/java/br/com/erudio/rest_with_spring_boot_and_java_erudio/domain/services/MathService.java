package br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.services;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.utils.MathUtil;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        return MathUtil.convertToDoble(numberOne) + MathUtil.convertToDoble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        return MathUtil.convertToDoble(numberOne) - MathUtil.convertToDoble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        return MathUtil.convertToDoble(numberOne) * MathUtil.convertToDoble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        return MathUtil.convertToDoble(numberOne) / MathUtil.convertToDoble(numberTwo);
    }

    public Double average(String numberOne, String numberTwo) {
        return (MathUtil.convertToDoble(numberOne) + MathUtil.convertToDoble(numberTwo)) / 2;
    }

    public Double sqrt(String number) {
        return Math.sqrt(MathUtil.convertToDoble(number));
    }

}
