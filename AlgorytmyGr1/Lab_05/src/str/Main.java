package str;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TForwardList<String> str = new TForwardList<>();
        long startTimeArrayList = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            str.add("cos"+i);
        }
        long stop = System.currentTimeMillis();
        System.out.println("TForwardList:"+(stop-startTimeArrayList));

        ArrayList<String> str2 = new ArrayList<>();
        long start2 = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            str2.add("cos"+i);
        }
        long stop2 = System.currentTimeMillis();
        System.out.println("ArrayList: "+(stop2-start2));
    }
}
