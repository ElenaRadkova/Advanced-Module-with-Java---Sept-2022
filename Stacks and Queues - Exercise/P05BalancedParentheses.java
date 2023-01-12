import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();
        boolean isBalanced = true;
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char currentBrackets = brackets.charAt(i);
            if (currentBrackets == '(' || currentBrackets == '{' || currentBrackets == '[') {
                openingBrackets.push(currentBrackets);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBrackets = openingBrackets.pop();
                if (currentBrackets == '}' && lastOpeningBrackets != '{') {
                    isBalanced = false;
                    break;
                } else if (currentBrackets == ']' && lastOpeningBrackets != '[') {
                    isBalanced = false;
                    break;
                } else if (currentBrackets == ')' && lastOpeningBrackets != '(') {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
