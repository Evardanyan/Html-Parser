import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        Matcher match = Pattern.compile("<.+?>").matcher(input);
        Deque<String> deque = new ArrayDeque<>();
        while (match.find()) {
            if (match.group().contains("/")) {
                System.out.println(deque.pop());
            } else {
                Matcher p = Pattern.compile("<(\\w+)>(.*?)</\\1>").matcher(input);
                p.find(match.start());
                deque.push(p.group(2));
            }
        }
    }
}
