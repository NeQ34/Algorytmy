import java.util.Stack;

public class RPNCalculation {
    private Stack<Integer> stack;

    public RPNCalculation() {
        stack = new Stack<>();
    }
    public int calculate(String onp){
        String[] wyrazenia = onp.split("\\s");

        for(String wyrazenie: wyrazenia){
            if(isNumeric(wyrazenie)){
                stack.push(Integer.parseInt(wyrazenie));
            }else{
                int b = stack.pop();
                int a = stack.pop();

                switch(wyrazenie){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                    case "%":
                        stack.push(a%b);
                        break;
                    default:
                        throw new IllegalArgumentException("Niepoprawny znak!");
                }
            }
        }
        return stack.pop();
    }
    public boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
