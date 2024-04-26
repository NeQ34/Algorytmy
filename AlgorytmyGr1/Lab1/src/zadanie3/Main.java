package zadanie3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] tab = new int[5];
        int i = 0;
        while(s.hasNextInt()) {
            tab[i] = s.nextInt();
            i++;
            double suma = 0;
            for(int j=0; j<i; j++) {
                suma += tab[j];
            }
            System.out.println("średnia: "+suma/i);
            System.out.print("odczyty: ");
            for(int j=0; j<i; j++) {
                System.out.print(tab[j]+" ");
            }
            System.out.println();
        }
    }
}
