package zadanie3;

import lib.TQueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TQueue<Character> queChar = new TQueue<>();
        Stack<Character> stack = new Stack<>();

        try(FileInputStream fin = new FileInputStream("D:\\AlgorytmyGr1\\Lab06-12-04-24\\dane.txt")){
            Scanner sc = new Scanner(fin);
            while(sc.hasNext()){
                String line = sc.nextLine();
                for(Character c : line.toCharArray()){
                    if(Character.isDigit(c)) stack.push(c);
                    else if(Character.isLetter(c)) queChar.put(c);
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
            System.out.print(", ");
        }
        System.out.println();
        while(!queChar.isEmpty()){
            System.out.print(queChar.get());
            System.out.print(", ");
        }
        System.out.println();
    }
}
