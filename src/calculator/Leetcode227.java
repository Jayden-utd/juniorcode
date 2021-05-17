package calculator;

/**
 * @Description:
 * @author: Jayden
 * @date:3/1/21 4:59 PM
 */
public class Leetcode227 {
    public static void main(String[] args) {
        System.out.println(calculate("1+3*7"));

    }
    public static int calculatess(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
//    public int calculate(String s) {
//        int n = s.length(), res = 0, num = 0, curRes = 0;
//        char op = '+';
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) {
//                num = num * 10 + c - '0';
//            }
//            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
//                switch (op) {
//                    case '+': curRes += num; break;
//                    case '-': curRes -= num; break;
//                    case '*': curRes *= num; break;
//                    case '/': curRes /= num; break;
//                    default: break;
//                }
//                if (c == '+' || c == '-' || i == n - 1) {
//                    res += curRes;
//                    curRes = 0;
//                }
//                op = c;
//                num = 0;
//            }
//        }
//        return res;
//    }



    public static int calculate(String s) {
        int n = s.length(), res = 0, num = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
                switch (op) {
                    case '+': res += num; break;
                    case '-': res -= num; break;
                    case '*': res *= num; break;
                    case '/': res /= num; break;
                    default: break;
                }
                op = c;
                num = 0;
            }
        }
        return res;
    }
}
