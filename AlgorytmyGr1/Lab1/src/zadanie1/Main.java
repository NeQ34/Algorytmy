package zadanie1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj tekst:");
        String text = s.nextLine();
        System.out.println(odwroconyNapis(text));
    }
    public static String odwroconyNapis(String s){
        String odwroconyNapis="";
        for(int i=s.length()-1; i>=0; i--){
            odwroconyNapis+=s.charAt(i);
        }
        return odwroconyNapis;
    }
}
