import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Введите выражение: ");
        String expression = scanner.nextLine();
        System.out.println("Ответ: ");
        System.out.println(calculator.parse(expression));
    }
}