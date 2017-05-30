/**
 * Created by ashmita on 5/29/17.
 */
import java.util.*;
public class EvaluateExpression {
    int itr;
    String expression;
    int length;

    public EvaluateExpression(){
        expression = "";
        itr = 0;
        length = 0;
    }
    /* parses and evaluates a mathematical expression using PEMDAS order.  	*/
    public double evalExpression(String e) throws Exception {
        expression = e;
        length = expression.length();
        itr = 0;
        /*   call parseExpression to parse the expression   */
        return parseExpression();
    }
    private double parseExpression() throws Exception {
        /*   call parseTerm to get the first product or quotient   */
        double term = parseTerm();
        /*   skip white spaces. if the end of expression is reached, then return the one term   */
        skipWhiteSpace();
        if(itr == length){
            return term;
        }
        /*   otherwise: scan through the rest of the expression for + or -   */
        char current = expression.charAt(itr);
        while(current == '+' || current == '-'){
            itr++;
            if(current == '+'){
                /*   perform addition   */
                term += parseTerm();
            }
            else{
                /*   perform subtraction   */
                term -= parseTerm();
            }
            /*   skip white spaces, again, as far as possible without reaching the end of expression.
                 break if at end of expression.   */
            skipWhiteSpace();
            if(itr < length){
                current = expression.charAt(itr);
            }
            else break;
        }
        return term;
    }
    private double parseTerm() throws Exception {
        /*   call parseFactor to get the first factor   */
        double factor = parseFactor(false, false);
        /*   skip white spaces. if the end of expression is reached, then return the one factor that was the expression   */
        skipWhiteSpace();
        if(itr == length){
            return factor;
        }
        /*   otherwise: scan through the expression for * or /   */
        char current = expression.charAt(itr);
        while(current == '*' || current == '/'){
            itr++;
            if(current == '*'){
                /*   perform multiplication   */
                factor *= parseFactor(false, false);
            }
            else{
                /*   perform division. throw exception if divisor is 0   */
                double divisor = parseFactor(false, false);
                if(divisor == 0){
                    throw new Exception("Cannot divide by 0.");
                }
                factor /= divisor;
            }
            /*   skip white spaces, again, as far as possible without reaching the end of expression.
                 break if at end of expression. */
            skipWhiteSpace();
            if(itr < length){
                current = expression.charAt(itr);
            }
            else break;
        }
        return factor;
    }
    /*   returns a signed/unsigned number (+/-)   */
    private double parseFactor(boolean unarySeen, boolean isNegative) throws Exception {
        skipWhiteSpace();
        if(itr == length){
            throw new Exception("Missing factor after operation.");
        }
        if((expression.charAt(itr)=='+'|| expression.charAt(itr)=='-') && unarySeen){
            /*   throws exception and message if there is more than one +/- signs.   */
            throw new Exception("one too many unary signs");
        }
        /*
            checks to see if there is a unary sign before the number.
         */
        else if(expression.charAt(itr)=='+'){
            itr++;
            return parseFactor(true, false);
        }
        else if(expression.charAt(itr)=='-'){
            itr++;
            return -parseFactor(true, true);
        }
        skipWhiteSpace();   /*   helper method.   */
        int startFactor = itr++;
        /*   iterates through expression until it finds the end of number.   */
        while(itr < length && expression.charAt(itr) != ' ' && expression.charAt(itr) != '+' &&
                expression.charAt(itr) != '-' && expression.charAt(itr) != '*' && expression.charAt(itr) != '/'){
            itr++;
        }
        /*   parses the string value with its sign to a double and returns it.
             or throws an exception if string value contains illegal characters i.e. any non-digits. */
        String val = expression.substring(startFactor, itr);
        try{
            double value = Double.parseDouble(val);
            if(value > 1000000){
                if(isNegative){
                    throw new RuntimeException("-"+val);
                }
                throw new RuntimeException(val);
            }
            return value;
        } catch (NumberFormatException e){
            throw new NumberFormatException(val + " is not a valid input.");
        } catch (RuntimeException r){
            throw new Exception ( r.toString() + " is out of bounds.");
        }
    }
    private void skipWhiteSpace(){
        while (itr < length && expression.charAt(itr)==' ') {
            itr++;
        }
    }
    public static void main (String[] argv){
        Scanner scan = new Scanner(System.in);
        String prompt = "Enter expression to evaluate (\"exit\" to exit): ";
        double output = 0;
        System.out.print(prompt);
        String nextLine = scan.nextLine();
        EvaluateExpression eval_expr = new EvaluateExpression();
        while(!nextLine.equalsIgnoreCase("exit")){
            try{
                output = eval_expr.evalExpression(nextLine);
                System.out.println(nextLine + " = " +output);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.print(prompt);
            nextLine = scan.nextLine();
        }
        if(nextLine.equalsIgnoreCase("exit")){
            System.out.println("Exiting...");
            System.exit(1);
        }
    }
}