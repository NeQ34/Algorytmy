import java.io.*;
import java.util.Stack;

public class RPNGenerator {
    Stack<Character> stack;

    public RPNGenerator() {
        stack = new Stack<>();
    }
    public String readFile(File filename){
        StringBuilder result = new StringBuilder();
        try(BufferedReader r = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = r.readLine())!=null){
                result.append(convertToONP(line)).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }
    public String convertToONP(String wyrazenie){
        StringBuilder result = new StringBuilder();
        for(char c : wyrazenie.toCharArray()){
            if(Character.isLetterOrDigit(c)) result.append(c);
            else if(c=='(') stack.push(c);
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result.append(stack.pop());
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }
    public int getPriority(char operator){
        switch(operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
