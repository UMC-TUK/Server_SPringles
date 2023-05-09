// 숫자를 입력받아 10으로 나눈 값을 출력하는 프로그램을 작성하세요.
// 예외 처리를 이용하여, 0으로 나누려는 경우 "Cannot divide by zero"라는 메시지를 출력하세요.

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        try {
            double result = 10.00 / num;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }
}
