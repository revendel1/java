import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите исходную строку: ");
        String str = in.nextLine();

        Stack<Character> deck = new Stack<>();
        char character, last_char;
        for(int i = 0; i < str.length(); i++){
            character = str.charAt(i);
            if (deck.size() == 0) {
                deck.push(character);
                continue;
            }
            last_char = deck.peek();
            if (character == ')' && last_char == '(') {
                deck.pop();
            } else if (character == '}' && last_char == '{') {
                deck.pop();
            } else if (character == ']' && last_char == '[') {
                deck.pop();
            } else {
                deck.push(character);
            }
        }
        if (deck.size() == 0) {
            System.out.println("Строка правильная");
        } else {
            System.out.println("Строка неправильная");
        }
    }
}