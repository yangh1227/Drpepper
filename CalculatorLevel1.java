import java.util.Scanner;

public class CalculatorLevel1 {
    public static void main(String[] args) {
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
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                // 예외 처리: 0으로 나누기
                if (secondNumber == 0) {
                    System.out.println("에러: 0으로 나눌 수 없습니다.");
                    return;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                System.out.println("유효하지 않은 연산자입니다.");
                return;
        }

        System.out.println("결과: " + result);
    }
}
