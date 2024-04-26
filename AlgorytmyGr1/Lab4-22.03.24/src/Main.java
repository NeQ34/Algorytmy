import java.io.File;

public class Main {
    public static void main(String[] args) {
        RPNCalculation rpn = new RPNCalculation();
        System.out.println(rpn.calculate("100 50 - 10 / 25 10 % 2 + 4 * +"));
        System.out.println(rpn.calculate("22 5 / 23 6 % 5 * + 10 5 3 - / -"));

        RPNGenerator rpng = new RPNGenerator();
        File f = new File("F:\\studia\\semestr-IV\\Algorytmy\\AlgorytmyGr1\\Lab4-22.03.24\\src\\expression01.txt");
        String result = rpng.readFile(f);
        System.out.println(result);
    }
}