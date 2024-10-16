import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class CalculatorLevel3 {
    public static void main(String[] args) {
        GenericCalculator<Double> calculator = new GenericCalculator<>();
        calculator.performCalculation();
    }
}

enum Operation {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("에러: 0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Double, Double, Double> operation;

    Operation(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Double apply(Double a, Double b) {
        return operation.apply(a, b);
    }

    public String getSymbol() {
        return symbol;
    }

    public static Optional<Operation> fromSymbol(String symbol) {
        return Stream.of(values())
                .filter(op -> op.getSymbol().equals(symbol))
                .findFirst();
    }
}

class GenericCalculator<T extends Number> {
    public void performCalculation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        Double firstNumber = scanner.nextDouble();

        System.out.print("연산자를 입력하세요 (+, -, *, /): ");
        String operatorInput = scanner.next();

        System.out.print("두 번째 숫자를 입력하세요: ");
        Double secondNumber = scanner.nextDouble();

        Optional<Operation> operationOpt = Operation.fromSymbol(operatorInput);

        if (!operationOpt.isPresent()) {
            System.out.println("유효하지 않은 연산자입니다.");
            return;
        }

        Operation operation = operationOpt.get();

        try {
            Double result = operation.apply(firstNumber, secondNumber);
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
