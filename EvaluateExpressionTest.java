/**
 * Created by ashmita on 5/29/17.
 */
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
public class EvaluateExpressionTest extends EvaluateExpression {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    EvaluateExpression eval_expr = new EvaluateExpression();

    @Test
    public void unaryPlus() {
        String input = "+ 42";
        double expected = 42.0;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unaryPlusDecimal() {
        String input = "+ 42.8";
        double expected = 42.8;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unaryMinusDecimal(){
        String input = "- 27.5";
        double expected = -27.5;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unaryDoubleMinus()throws Exception {
        String input = "-+ 27.5";
        double expected = -27.5;
        thrown.expectMessage("one too many unary signs");
        double actual = eval_expr.evalExpression(input);
        assert (expected==actual);
    }
    @Test
    public void unaryMinusDecimalSpace(){
        String input = "-    12.3    ";
        double expected = -12.3;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unaryMinusDecimalSpace2(){
        String input = "-    12.3";
        double expected = -12.3;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unaryMinusDecimalNoSpace(){
        String input = "-55.4";
        double expected = -55.4;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unsignedDecimalNoSpace(){
        String input = "55.4";
        double expected = 55.4;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unsignedMult(){
        String input = "4*3";
        double expected = 12;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unsignedMultiplicationMultipleOps() throws Exception{
        String input = "4*/3";
        thrown.expectMessage("/3 is not a valid input.");
        double actual = eval_expr.evalExpression(input);
    }
    @Test
    public void unsignedDivisionSpaces() {
        String input = "40 /   4 ";
        double expected = 10;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void signedDivision() {
        String input = "-16 /   -4 ";
        double expected = 4;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void divideByZero() throws Exception {
        String input = "-16 /   0 ";
        thrown.expectMessage("Cannot divide by 0.");
        double actual = eval_expr.evalExpression(input);
    }
    @Test
    public void divideZero()  {
        String input = "0 /   -4 ";
        double expected = 0;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void unsignedSum()  {
        String input = "  5.1 + 10.3 ";
        double expected = 15.4;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void operationWithoutFactor() throws Exception {
        String input = "-16 /   ";
        thrown.expectMessage("Missing factor after operation.");
        double actual = eval_expr.evalExpression(input);
    }
    @Test
    public void outOfBounds() throws RuntimeException, Exception {
        String input = "1000003 /   10 ";
        thrown.expectMessage("1000003 is out of bounds.");
        double actual = eval_expr.evalExpression(input);
    }
    @Test
    public void negativeOutOfBounds() throws RuntimeException, Exception {
        String input = "-1000003 /   10 ";
        thrown.expectMessage("-1000003 is out of bounds.");
        double actual = eval_expr.evalExpression(input);
    }
    @Test
    public void expression1(){
        String input = "6*2 + 4*3";
        double expected = 24;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void expression2(){
        String input = "6*3 - 4*3";
        double expected = 6;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void expression3(){
        String input = "5+4+3+2";
        double expected = 14;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void expression4(){
        String input = "2*3*4";
        double expected = 24;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void expression5(){
        String input = "5+3+4*2-3-5";
        double expected = 8;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void expression6(){
        String input = "5+3/4/2-3-5";
        double expected = -2.625;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void expression7(){
        String input = "5 + 3*2";
        double expected = 11;
        try {
            double actual = eval_expr.evalExpression(input);
            assert (expected==actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void expression8() throws Exception{
        String input = "7.2s + 3";
        thrown.expectMessage("7.2s is not a valid input.");
        double actual = eval_expr.evalExpression(input);
    }
    @Test
    public void expression9() throws Exception{
        String input = "409 + 34/4.s24";
        thrown.expectMessage("4.s24 is not a valid input.");
        double actual = eval_expr.evalExpression(input);
    }
    @Test
    public void expression10() throws Exception{
        String input = "4+90/9-4.s33";
        thrown.expectMessage("4.s33 is not a valid input.");
        double actual = eval_expr.evalExpression(input);
    }
}