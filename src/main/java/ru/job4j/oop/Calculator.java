package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int devide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + devide(y) + multiply(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(10);
        System.out.println(result);
        int result1 = minus(10);
        System.out.println(result1);
        int result2 = calculator.devide(10);
        System.out.println(result2);
        int result3 = calculator.multiply(10);
        System.out.println(result3);
        int result4 = calculator.sumAllOperation(10);
        System.out.println(result4);
    }
}
