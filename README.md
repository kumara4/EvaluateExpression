# Evaluate Expression

## Requirements
    java -version
java version "1.8.0_121"  
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)  
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)  

    javac -version
javac 1.8.0_121  


    JUnit 4
## Execution
Execution from command line:
```
> javac EvaluateExpression.java
> java EvaluateExpression
Enter expression to evaluate ("exit" to exit): 4+90/9-4.s33
4.s33 is not a valid input.
Enter expression to evaluate ("exit" to exit): 453 + 9908 / 820.22 * 4003
453 + 9908 / 820.22 * 4003 = 48807.98280949014
Enter expression to evaluate ("exit" to exit): exit
Exiting...
```  

## API
public class EvaluateExpression:
* public double evalExpression(String e) throws Exception  
    /* parses and evaluates a mathematical expression using PEMDAS order.  	*/
    


## Usage
Enter an expression that you want to evaluate. Accepted operators: * / + - 
Numbers must be between -1000000 and 1000000, inclusive. 
Examples:  

- input: 5+4+3+2 --> output: 14

- input: 5+3/4/2-3-5 --> output: -2.625

- input: 409 + 34/4.s24 --> output: 4.s is not a valid input.

## Future Work
* Implement parenthesis and exponent evaluation