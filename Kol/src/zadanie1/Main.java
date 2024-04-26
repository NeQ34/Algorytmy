package zadanie1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> liczbyParzyste = new Stack<>();
        TQueue<Character> samogloski = new TQueue<>();

        try {
            File file = new File("F:\\studia\\semestr-IV\\Algorytmy\\Kol\\src\\zadanie1\\liczby.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",\\s*");

            while (scanner.hasNext()) {
                String token = scanner.next();
                try {
                    int liczba = Integer.parseInt(token);
                    if (liczba % 2 == 0) {
                        liczbyParzyste.add(liczba);
                    }
                } catch (NumberFormatException e) {
                    char znak = token.charAt(0);
                    if (znak == 'a' || znak == 'e' || znak == 'i' || znak == 'o' || znak == 'u') {
                        samogloski.put(znak);
                    }
                }
            }
            scanner.close();
            System.out.println("Parzyste liczby w odwrotnej kolejności:");
            for (int i = liczbyParzyste.size() - 1; i >= 0; i--) {
                System.out.print(liczbyParzyste.get(i) + " ");
            }
            System.out.println();
            System.out.println("Samogłoski w kolejności ich występowania:");
            for (char samogloska : samogloski) {
                System.out.print(samogloska + " ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Plik liczby.txt nie został znaleziony.");
            e.printStackTrace();
        }
    }
}

//package zadanie1;
//        import java.io.File;
//        import java.io.IOException;
//        import java.util.Scanner;
//        import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) {
//        TQueue<Integer> liczbyParzyste = new TQueue<>();
//        Stack<Integer> liczbynieParzyste = new Stack<>();
//        try{
//            Scanner s = new Scanner(new File("F:\\studia\\semestr-IV\\Algorytmy\\Kol\\src\\zadanie1\\liczby.txt"));
//            String line;
//            while(s.hasNext()){
//                line = s.nextLine().trim();
//                String[] liczby = line.split(",");
//                char[] znaki = line.toCharArray();
//                for(char liczba : znaki){
//                    if(Character.isDigit(liczba) && Character.getNumericValue(liczba)%2==0){
//                        liczbyParzyste.put(Character.getNumericValue(liczba));
//                    }else if(Character.isDigit(liczba) && Character.getNumericValue(liczba)%2!=0){
//                        liczbynieParzyste.push(Character.getNumericValue(liczba));
//                    }
//                }
//            }
//            s.close();
//            System.out.println("Liczby parzyste:");
//            while(!liczbyParzyste.isEmpty()){
//                System.out.print(liczbyParzyste.get()+" ");
//            }
//            System.out.println();
//            System.out.println("Liczby nieparzyste: ");
//            while(!liczbynieParzyste.isEmpty()){
//                System.out.print(liczbynieParzyste.pop()+" ");
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//}

//    @Override
//    public int indexOf(E element) {
//        TForwardListNode<E> tmp = first;
//        int ind = 0;
//        while(tmp!=null){
//            if(tmp.getData().equals(element)){
//                return ind;
//            }
//            ind++;
//            tmp = tmp.getNext();
//        }
//        return -1;
//    }
