package zadanie2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liste zakupów po przecinku:");
        String zakupy = s.nextLine();
        listaZakopow(zakupy);
    }
    public static void listaZakopow(String zakupy){
        Scanner s = new Scanner(System.in);
        String[] listaZakupow = zakupy.split(",");
        for(int i=0; i<listaZakupow.length; i++){
            System.out.println((i+1)+". "+listaZakupow[i]);
        }
        while(true){
            System.out.println("Podaj pozycję wrzuconą do koszyka:");
            if(s.hasNextInt()) {
                int id = s.nextInt();
                if(id>0 && id<=listaZakupow.length) {
                    if(!listaZakupow[id-1].endsWith(" [kupione]")) {
                        listaZakupow[id-1] += " [kupione]";
                    }
                }else System.out.println("Niepoprawny numer");
                for(String str : listaZakupow){
                    System.out.println(str);
                }
            }else break;
        }
    }
}
