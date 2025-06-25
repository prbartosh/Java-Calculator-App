package com.pajor.calculator.service.impl;

import com.pajor.calculator.service.api.CalculatorService;
import com.pajor.calculator.core.operations.api.Operation;
import com.pajor.calculator.core.operations.impl.Addition;
import com.pajor.calculator.core.operations.impl.Division;
import com.pajor.calculator.core.operations.impl.Factorial;
import com.pajor.calculator.core.operations.impl.Multiplication;
import com.pajor.calculator.core.operations.impl.Neg;
import com.pajor.calculator.core.operations.impl.Percetage;
import com.pajor.calculator.core.operations.impl.Power;
import com.pajor.calculator.core.operations.impl.Sqrt;
import com.pajor.calculator.core.operations.impl.Root;
import com.pajor.calculator.core.operations.impl.Subtraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    /* */
    private final Map<String, Operation> operations = new HashMap<>();
    private final Map<String, Integer> precedence = Map.ofEntries(
    Map.entry("+", 1),
    Map.entry("-", 1),
    Map.entry("*", 2),
    Map.entry("×", 2),
    Map.entry("÷", 2),
    Map.entry("/", 2),
    Map.entry("%", 2),
    Map.entry("power", 3),
    Map.entry("^", 3),
    Map.entry("**", 3),
    Map.entry("sqrt", 3),
    Map.entry("√", 3),
    Map.entry("!", 3),
    Map.entry("neg", 3),
    Map.entry("n√a", 3)
    );
    private final List<HistoryEntry> history = new ArrayList<>();

    private static int historyIndex;
    static {
        historyIndex = 0;
    }

    @Override
    public void addToHistory(String equation, double result) {
        history.add(new HistoryEntry(equation, result));
        historyIndex++;
    }

    @Override
    public String getFromHistory(int direction) {
        System.out.println("history size: " + history.size());
        System.out.println("HistoryIndex before: " + historyIndex);
        if (direction >= 0 && (historyIndex - 1 >= 0)) {
            historyIndex--;
        } else if (direction < 0 && historyIndex + 1 <= history.size()-1) {
            historyIndex++;
        } else if (direction < 0 && historyIndex + 1 == history.size()) {
            historyIndex++;
        }
        System.out.println("HIstoryIndex after: " + historyIndex);
        
        if (history.size() > 0 && historyIndex < history.size()) {
            HistoryEntry entry = history.get(historyIndex);
            String entryString = entry.getEquation() + " = " + entry.getResult();
            return entryString;
        } else if (history.size() == historyIndex){
            return "";
        } else {
            return "No history yet!";
        }
        
    }


    public CalculatorServiceImpl() {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("×", new Multiplication());
        operations.put("÷", new Division());
        operations.put("/", new Division());
        operations.put("%", new Percetage());
        operations.put("^", new Power());
        operations.put("**", new Power());
        operations.put("power", new Power());
        operations.put("√", new Sqrt());
        operations.put("sqrt", new Sqrt());
        operations.put("root", new Root());
        operations.put("n√a", new Root());
        operations.put("!", new Factorial());
        operations.put("neg", new Neg());

    }

    // public boolean isUnaryOperator(String op) {
    //     return op.equalsIgnoreCase("sqrt");
    // }

   

    @Override
    public double performCalculation(String expr) {
        // Convert tokens to RPN
        List<String> tokens = tokenize(expr);
        List<String> rpn = toRPN(tokens);

        double result = evaluateRPN(rpn);
        addToHistory(expr, result);
        // calculate from RPN
        return result;
    }

    @Override
    public List<String> tokenize(String expr) {
        return Arrays.asList(expr.replace("(", " ( ").replace(")", " ) ").trim().split("\\s+"));
    }

    

    @Override
    public List<String> toRPN(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+") || token.matches("-?\\d*\\.\\d+")) {
                output.add(token);
            } else if (precedence.containsKey(token)) {
                while (!stack.isEmpty() &&
                       precedence.containsKey(stack.peek()) &&
                       precedence.get(stack.peek()) >= precedence.get(token)) {
                    // if (token.matches("(?i)sqrt|√")) {}
                        output.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    throw new IllegalArgumentException("Uncorrect braces");
                }
                stack.pop(); // remove "("
            } else {
                throw new IllegalArgumentException("Unknown token: " + token);
            }
        }

        // After processing all tokens, empty the operator stack.
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(") || top.equals(")")) {
                throw new IllegalArgumentException("Uncorrect braces");
            }
            output.add(top);
        }
        
        return output;
    }

    @Override
    public double evaluateRPN(List<String> rpn) {
        Stack<Double> stack = new Stack<>();
        for (String token : rpn) {
            if (token.matches("\\d+") || token.matches("-?\\d*\\.\\d+")) {
                stack.push(Double.parseDouble(token));
                continue;
            }
            Operation op = operations.get(token);
            
            if (op.arity() == 2) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(op.apply(a, b));
            } else {
                double a = stack.pop();
                stack.push(op.apply(a));
            }
                // } else if (token.equals("sqrt")) {
            //     Operation op = operations.get(token);
            //     double b = stack.pop();
            //     double a = b;
            //     stack.pop();
            //     stack.push(op.apply(a, b));
            // } else {
            //     double b = stack.pop();
            //     double a = stack.pop();
            //     Operation op = operations.get(token);
            //     if (op == null) {
            //         throw new IllegalArgumentException("Operator not found: " + token);
            //     }
            //     stack.push(op.apply(a, b));
            // }
        }
        return stack.pop();
    }


    @Override
    public final boolean validateOperator(String operator) {
        if (operations.containsKey(operator)) {
            return true;
        }
        return false;
    }

    
}