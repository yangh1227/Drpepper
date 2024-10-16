import java.util.Scanner;

public class CalculatorLevel2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.performCalculation();
    }
}

class Calculator {
    public void performCalculation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("연산자를 입력하세요 (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("두 번째 숫자를 입력하세요: ");
        double secondNumber = scanner.nextDouble();

        double result = 0;

        switch (operator) {
            case '+':
                result = add(firstNumber, secondNumber);
                break;
            case '-':
                result = subtract(firstNumber, secondNumber);
                break;
            case '*':
                result = multiply(firstNumber, secondNumber);
                break;
            case '/':
                try {
                    result = divide(firstNumber, secondNumber);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("유효하지 않은 연산자입니다.");
                return;
        }

        System.out.println("결과: " + result);
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("에러: 0으로 나눌 수 없습니다.");
        }
        return a / b;
    }
}
