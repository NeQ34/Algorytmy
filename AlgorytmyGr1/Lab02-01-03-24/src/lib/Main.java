package lib;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //zadanie1();
        //zadanie2();
        try {
            zadanie4();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void zadanie1(){
        Scanner s = new Scanner(System.in);
        Stack<String> ksiazki = new Stack<>();
        System.out.println("Podaj 5 ostatnio przeczytanych książek:");
        for(int i=0; i<5; i++){
            ksiazki.push(s.nextLine());
        }
        System.out.println("Odwrócona kolejność:");
        while(!ksiazki.isEmpty()){
            System.out.println(ksiazki.pop());
        }

    }
    public static void zadanie2(){
        TStack<Integer> st = new TStack<>();
        int num=23;
        System.out.println("Spr: "+num);
        System.out.println("głębokość elementu: "+st.deepLevel(num));
        st.push(5);
        st.push(10);
        st.push(23);
        st.push(15);
        System.out.println("Spr: "+num);
        System.out.println("głębokość elementu: "+st.deepLevel(num));
        st.deleteBottom();
    }
//    public static void zadanie3() throws FileNotFoundException {
//        //Scanner s = new Scanner(new File("D:\\AlgorytmyGr1\\Lab02-01-03-24\\src\\kochanowski.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("D:\\AlgorytmyGr1\\Lab02-01-03-24\\src\\kochanowski.txt"));
//        Stack<String> wiersz = new Stack<>();
//        String line;
//        while((line = reader.readLine()) != null){
//            String[] words = line.split("\\s+");
//            for (String word : words) {
//                wiersz.push(word.replaceAll("[^a-zA-ZęóąśłżźćńĘÓĄŚŁŻŹĆŃ]", ""));
//            }
//        }
//        while (!wiersz.isEmpty()) {
//            System.out.print(wiersz.pop() + " ");
//        }
//    }
    public static void zadanie4() throws FileNotFoundException {
        String directory = "D:\\AlgorytmyGr1\\Lab02-01-03-24\\src\\brackets";
        String tmp = Path.of(directory,"inventory.txt").toString();
        String[] fileList = loadAListOfFiles(tmp);

        for(String fileName : fileList){
            tmp = Path.of(directory,"inventory.txt").toString();
            if(checkFile(tmp)) System.out.println("Plik ma poprawnie zamknięte zawiasy "+fileName);
            else System.out.println("Plik nie ma poprawnie zamkniętych nawiasów "+fileName);
        }
    }
    private static boolean checkFile(String fileName) {
        File f = new File(fileName);
        TStack<Character> stackC = new TStack<>();
        try(FileReader r = new FileReader(f))
        {
            char[] chars = new char[(int) f.length()];
            r.read(chars);
            for(char sign : chars){
                if(sign == '(' || sign=='[' || sign=='{') stackC.push(sign);
                else if(sign==')' || sign==']' || sign=='}'){
                    if(stackC.isEmpty()) return false;
                    else if(stackC.top() == mirrorBracket(sign)) stackC.pop();
                }
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }
        if(!stackC.isEmpty()) return false;
        else return true;
    }
    private static String[] loadAListOfFiles(String fileName){
        String[] out = null;
        try(FileInputStream fin = new FileInputStream(fileName)){
            Scanner s = new Scanner(fin);
            StringBuilder str = new StringBuilder();
            if(!s.hasNext()) throw new IOException();
            while(s.hasNext()){
                str.append(s.next()).append(',');
            }
            out = str.toString().split(",");
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Wyjątek "+e.toString());
            return null;
        }
        return out; //zwraca tablicę z nazwami plików w pliku inventory.txt
    }
    private static char mirrorBracket(char b){
        if(b == ')') return '(';
        else if(b==']') return '[';
        else if(b=='}') return '{';
        else return '\0';
    }
}
