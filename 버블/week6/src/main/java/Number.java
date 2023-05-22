// 짝수와 홀수를 구분하는 isEven() 메서드를 작성하세요.
// 이 메서드는 int형 매개변수를 받아, 짝수인 경우 true, 홀수인 경우 false를 반환합니다.
// isEven() 메서드를 사용하여, 1부터 10까지의 수 중에서 짝수인 수를 출력해보세요.

public class Number {
    public static boolean isEven(int num) {
        if (num % 2 == 0) { return true;
        } else { return false; }
    }
}

