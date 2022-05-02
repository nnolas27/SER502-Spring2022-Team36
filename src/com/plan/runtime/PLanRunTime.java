package com.plan.runtime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import com.plan.common.*;

public class PLanRunTime {

    static int totalCount = 1;
    static int whileIterator = 0;
    static boolean isForLoop = false;
    static boolean isWhileLoop = false;

    static ArrayList<String> codeList = new ArrayList<String>();
    static Stack<Boolean> boolStack = new Stack<Boolean>();
    static HashMap<String,Integer> variablesMap = new HashMap<String,Integer>();
    static Stack<Integer> stackNestedInteger = new Stack<Integer>();
    static HashMap<String,Boolean> boolMap = new HashMap<String,Boolean>();
    static Stack<Integer> scopeIntStack = new Stack<Integer>();
    static Stack<Integer> stackForIntegers = new Stack<Integer>();
    static Stack<Boolean> statusOfLoopStack = new Stack<Boolean>();
    static Stack<Integer> traceIntStack = new Stack<Integer>();

    public static void main(String[] args) {

        String filename = "";
        filename = "modelPrograms/sample.planint";
        if (args.length > 0){
            filename = args[0];
        } else {
            System.out.println(" Given input file cannot be Empty input file with .planint extension");
            return;
        }
        if (!filename.contains(".planint")) {
            return;
        }

        try {
            for (String line : Files.readAllLines(Paths.get(filename))) {
                codeList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (whileIterator =0; whileIterator<codeList.size(); whileIterator++) {
            execute();
        }
    }

    public static void MoveForward(String label) {
        boolean yesRno = label.contains(PLanConstants.ELSE.trim())? true : false;
        int id = 0;
        if (yesRno) {
            String[] temp = label.split("_");
            id = Integer.parseInt(temp[1]);
        }
        int i = whileIterator;
        while(i < codeList.size()) {
        	String code = codeList.get(i);
        	if ((yesRno && code.trim().contains(PLanConstants.END_IF.trim() + "_" + id)) || code.trim().equals(label.trim())) {
        		whileIterator = i;
        		 if (code.trim().contains(PLanConstants.END_IF.trim() + "_" + id)) {
                     stackNestedInteger.pop();
                 }
                 break;
        	}
        	i++;
        }
    }

    public static void ForwardProcCall(String label) { 	
    	int i = 0;
    	while(i < codeList.size()) {
    		String code = codeList.get(i);
    		if (code.contains(label.trim())) {
    			whileIterator = i;
                break;
            }
    		i++;
    	}
    }

    public static void ReverseProcCall(String label) {
    	int i = whileIterator;
    	while(i >= 0) {
    		String code = codeList.get(i);
            if (code.equals(label.trim())) {
            	whileIterator = i-1;
                break;
            }
    		i--;
    	}
    }

    static public void execute(){

        String listOfCode = codeList.get(whileIterator);
        String[] split = listOfCode.split(" ");

        int tempNest = 0;
        if (listOfCode.contains(PLanConstants.IF.trim()) || listOfCode.contains(PLanConstants.ELSE.trim())
                || listOfCode.contains(PLanConstants.END_IF.trim()) || listOfCode.contains(PLanConstants.FORLOOP.trim())
                || listOfCode.contains(PLanConstants.END_FORLOOP.trim()) || listOfCode.contains(PLanConstants.WHILELOOP.trim())
                || listOfCode.contains(PLanConstants.END_WHILELOOP.trim())) {
            split = listOfCode.split("_");
            tempNest = Integer.parseInt(split[1]);
            if (listOfCode.contains(PLanConstants.IF.trim()) ||listOfCode.contains(PLanConstants.FORLOOP.trim())
                    ||listOfCode.contains(PLanConstants.WHILELOOP.trim())) {
                stackNestedInteger.push(tempNest);
            }
        } else if (listOfCode.contains(PLanConstants.CALL_PROCEDURE.trim())
                || listOfCode.contains(PLanConstants.TAKE_PROCEDURE.trim()) || listOfCode.contains(PLanConstants.BACKFROM_PROCEDURE.trim())) {
            split = listOfCode.split("_");
        }
        int accumulator = 0;


        switch(split[0] + " ") {
        	
        	//Declare
            case PLanConstants.TAKE_INT:               
                if (!(scopeIntStack.isEmpty())) {
                	 if (!variablesMap.containsKey(getScope() + split[1])) {
                         variablesMap.put(getScope() + split[1], 0);
                     } else {
                         throwException(" Variable " + split[1] + " is already declared above");
                     }

                } else {
                	if (!variablesMap.containsKey(split[1])) {
                        variablesMap.put(split[1], 0);
                    } else {
                        throwException(" Variable " + split[1] + " is already declared above");
                    }
                }
                break;
            
            case PLanConstants.TAKE_BOOL:
                if (scopeIntStack.isEmpty()) {
                    if (!boolMap.containsKey(split[1])) {
                        boolMap.put(split[1], false);
                    } else {
                        throwException("Exception variable " + split[1] + " already declared");
                    }

                } else {
                    if (!boolMap.containsKey(getScope() + split[1])) {
                        boolMap.put(getScope() + split[1], false);
                    } else {
                        throwException("Exception variable " + split[1] + " already declared");
                    }
                }
                break;
            
            //Assignment
            case PLanConstants.DESIGNATE :
                if (scopeIntStack.isEmpty()) {
                    if (variablesMap.containsKey(split[1])) {
                        variablesMap.put(split[1], stackForIntegers.pop());
                    }
                    else if (boolMap.containsKey(split[1])) {
                        boolMap.put(split[1], boolStack.pop());
                    } else{
                        variablesMap.put(split[1], stackForIntegers.pop());
                    }
                } else {
                    if (variablesMap.containsKey(getScope() + split[1])) {
                        variablesMap.put(getScope() + split[1], stackForIntegers.pop());
                    }
                    else if (boolMap.containsKey(getScope() + split[1])) {
                        boolMap.put(getScope() + split[1], boolStack.pop());
                    } else{
                        variablesMap.put(getScope() + split[1], stackForIntegers.pop());
                    }
                }
                break;

           case PLanConstants.INSERT:
                if  (split[1].equals("true") || split[1].equals("false")) {
                    boolStack.push(Boolean.parseBoolean(split[1]));
                } else
                    stackForIntegers.push(Integer.parseInt(split[1]));

                break;

            case PLanConstants.STOCK:
                if (scopeIntStack.isEmpty()) {
                    if (boolMap.containsKey(split[1])) {
                        if (Boolean.toString(boolMap.get(split[1])).equals("true")) {
                            boolStack.push(true);
                        }
                        if (Boolean.toString(boolMap.get(split[1])).equals("false")) {
                            boolStack.push(false);
                        }
                    } else if (variablesMap.containsKey(split[1])) {
                        stackForIntegers.push(variablesMap.get(split[1]));

                    }
                    else {
                        throwException("Undeclared variable " + split[1] + " is used.");
                    }
                } else {
                    if (boolMap.containsKey(getScope() +split[1])) {
                        if (Boolean.toString(boolMap.get(getScope() + split[1])).equals("true")) {
                            boolStack.push(true);

                        }
                        if (Boolean.toString(boolMap.get(getScope() + split[1])).equals("false")) {
                            boolStack.push(false);

                        }
                    }else if (variablesMap.containsKey(getScope() + split[1])) {

                        stackForIntegers.push(variablesMap.get(getScope() + split[1]));
                    } else {
                        throwException("Undeclared variable" + getScope() + split[1] + " is used.");
                    }
                }
                break;

            case PLanConstants.DISPLAY:
                System.out.println(stackForIntegers.pop());
                break;
            
            // Arithmetic operations
            case PLanConstants.INCREASE :
                accumulator = stackForIntegers.pop() + stackForIntegers.pop();
                stackForIntegers.push(accumulator);
                break;

            case PLanConstants.DECREASE:
                accumulator = stackForIntegers.pop();
                accumulator = stackForIntegers.pop() - accumulator;
                stackForIntegers.push(accumulator);
                break;

            case PLanConstants.INCREASE_BY:
                stackForIntegers.push((stackForIntegers.pop() * stackForIntegers.pop()));
                break;

            case PLanConstants.DECREASE_BY:
                accumulator = stackForIntegers.pop();
                if (accumulator != 0) {
                    accumulator = stackForIntegers.pop()/accumulator;
                    stackForIntegers.push(accumulator);
                } else {
                    throwException("Exception can't divide number by 0");
                }
                break;

            case PLanConstants.MODULUS:
                accumulator = stackForIntegers.pop();
                accumulator = stackForIntegers.pop() % accumulator;
                stackForIntegers.push(accumulator);
                break;

                
           case PLanConstants.INCREMENT_BY_ONE:
                accumulator = stackForIntegers.pop();
                accumulator++;
                stackForIntegers.push(accumulator);
                break;
                    
           case PLanConstants.DECREMENT_BY_ONE:
                accumulator = stackForIntegers.pop();
                accumulator--;
                stackForIntegers.push(accumulator);
                break;
                    
            //Conditional Expressions      
            case PLanConstants.MATCH:
                if ((stackForIntegers.pop() == stackForIntegers.pop())) {
                    boolStack.push(true);
                } else {
                    boolStack.push(false);
                }
                break;

            case PLanConstants.ABOVE:
                accumulator = stackForIntegers.pop();
                if (stackForIntegers.pop() > accumulator) {
                    boolStack.push(true);
                } else {
                    boolStack.push(false);
                }
                break;

            case PLanConstants.BELOW:
                accumulator = stackForIntegers.pop();
                if (stackForIntegers.pop() <= accumulator) {
                    boolStack.push(true);
                } else {
                    boolStack.push(false);
                }
                break;
                
            case PLanConstants.ABOVE_MATCH:
                accumulator = stackForIntegers.pop();
                if (stackForIntegers.pop() >= accumulator) {
                    boolStack.push(true);
                } else {
                    boolStack.push(false);
                }
                break;

            case PLanConstants.BELOW_MATCH:
                accumulator = stackForIntegers.pop();
                if (stackForIntegers.pop() < accumulator) {
                    boolStack.push(true);
                } else {
                    boolStack.push(false);
                }
                break;

            case PLanConstants.NOT_MATCH:
                if (stackForIntegers.pop() != stackForIntegers.pop()) {
                    boolStack.push(true);
                } else {
                    boolStack.push(false);
                }
                break;

            case PLanConstants.CONDITION_END:
                if (statusOfLoopStack.pop()) {
                    if (!boolStack.pop()) {
                        if(isForLoop)
                        {
                            MoveForward(PLanConstants.END_FORLOOP.trim() + "_" + stackNestedInteger.pop());
                        }
                        else if (isWhileLoop)
                        {
                            MoveForward(PLanConstants.END_WHILELOOP.trim() + "_" + stackNestedInteger.pop());
                        }
                    }
                } else {
                    if (!boolStack.pop()) {
                        accumulator = stackNestedInteger.pop();
                        stackNestedInteger.push(accumulator);
                        MoveForward(PLanConstants.ELSE.trim() + "_" + accumulator);
                    }
                }
                break;
            
            //Conditional Statements and Loops
            case PLanConstants.IF:
                statusOfLoopStack.push(false);
                break;

            case "true ":
                boolStack.push(true);
                break;

            case "false ":
                boolStack.push(false);
                break;

            case PLanConstants.END_IF:
                stackNestedInteger.pop();
                break;

            case PLanConstants.ELSE:
                MoveForward(PLanConstants.END_IF.trim() + "_" + tempNest);
                break;

            case PLanConstants.FORLOOP:
                isForLoop = true;
                statusOfLoopStack.push(true);
                break;

            case PLanConstants.END_FORLOOP:
            	ReverseProcCall(PLanConstants.FORLOOP.trim() + "_" + stackNestedInteger.pop());
                break;

            case PLanConstants.WHILELOOP:
                isWhileLoop = true;
                statusOfLoopStack.push(true);
                break;


            case PLanConstants.END_WHILELOOP:
            	ReverseProcCall(PLanConstants.WHILELOOP.trim() + "_" + stackNestedInteger.pop());
                break;
            
            //Procedure call
            case PLanConstants.CALL_PROCEDURE :
                traceIntStack.push(whileIterator);
                ForwardProcCall(PLanConstants.TAKE_PROCEDURE.trim() + "_" + split[1]);
                break;

            case PLanConstants.END_PROCEDURE :
                scopeIntStack.pop();
                whileIterator = traceIntStack.pop();
                break;

            case PLanConstants.TAKE_PROCEDURE :
                MoveForward(PLanConstants.END_PROCEDURE.trim() + "_" + split[1]);
                break;

            case PLanConstants.PARAMETER_PROCEDURE :
                scopeIntStack.push(totalCount);
                totalCount++;
                for (int i = split.length-1; i > 0; i--) {
                    variablesMap.put(getScope() + split[i], stackForIntegers.pop());
                }
                break;

            case PLanConstants.BACKFROM_PROCEDURE:
                scopeIntStack.pop();
                whileIterator = traceIntStack.pop();
                break;

            default:
                break;
        }

    }

    public static int getScope() {
        int temp = scopeIntStack.peek();
        return temp;
    }

    static public void throwException(String ex) {
        System.out.println("\n" + ex);
        whileIterator = codeList.size();
    }
}