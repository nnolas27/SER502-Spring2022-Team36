package com.plan.compiler;

import java.util.ArrayList;
import java.util.Stack;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.plan.common.*;


public class PLanIntermediateCodeGenerator extends PLanBaseListener{

	private static PLanIntermediateCodeGenerator INSTANCE = null;
    private static int nestedCount = 1;
    private static ArrayList<String> code;
    private static Stack<String> stackFunc = new Stack<String>();
    private static Stack<Integer> stackNested = new Stack<Integer>();

    public static PLanIntermediateCodeGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PLanIntermediateCodeGenerator();
            code = new ArrayList<String>();
        }
        return INSTANCE;
    }

    @Override public void enterVar_announce(PLanParser.Var_announceContext ctx) {

        if (!(stackFunc.isEmpty())) {
            String accumulator = stackFunc.pop();
            stackFunc.push(accumulator);
            code.add(PLanConstants.TAKE_INT + accumulator + ctx.IDENTIFIER().getText());
            
        } else {
        	code.add(PLanConstants.TAKE_INT + ctx.IDENTIFIER().getText());
        }

    }

    @Override public void exitVar_announce(PLanParser.Var_announceContext ctx) { }

    @Override public void enterInt_announce(PLanParser.Int_announceContext ctx) {
       
        if (!(stackFunc.isEmpty())) {
        	String accumulator = stackFunc.pop();
            stackFunc.push(accumulator);
            code.add(PLanConstants.TAKE_INT + accumulator + ctx.IDENTIFIER().getText());
            
        } else {

        	code.add(PLanConstants.TAKE_INT + ctx.IDENTIFIER().getText());
        }

    }

    @Override public void exitInt_announce(PLanParser.Int_announceContext ctx) { }

    @Override public void enterBool_announce(PLanParser.Bool_announceContext ctx) {
        
        if (!(stackFunc.isEmpty())) {
        	String accumulator = stackFunc.pop();
            stackFunc.push(accumulator);
            code.add(PLanConstants.TAKE_BOOL + accumulator + ctx.IDENTIFIER().getText());
            
        } else {

        	code.add(PLanConstants.TAKE_BOOL + ctx.IDENTIFIER().getText());
        }

    }
    @Override public void enterUnary_statement(PLanParser.Unary_statementContext ctx) {
		
		
    }

	@Override public void exitUnary_statement(PLanParser.Unary_statementContext ctx) {	
		 if (stackFunc.isEmpty()) {
			 	if(ctx.getText().contains("++")) {
			 		code.add(PLanConstants.INCREMENT_BY_ONE + ctx.IDENTIFIER().getText());
			 	}else if(ctx.getText().contains("--")) {
			 		code.add(PLanConstants.DECREMENT_BY_ONE + ctx.IDENTIFIER().getText());
			 	}
	        } else {

	            String accumulator = stackFunc.pop();
	            stackFunc.push(accumulator);
	            if (ctx.getText().contains("++")) {
	            	code.add(PLanConstants.INCREMENT_BY_ONE + accumulator + ctx.IDENTIFIER().getText());          
	            }else if(ctx.getText().contains("--")) {
	            	code.add(PLanConstants.DECREMENT_BY_ONE + accumulator + ctx.IDENTIFIER().getText());
	            }
	        }
	}

    @Override public void exitBool_announce(PLanParser.Bool_announceContext ctx) { }

    @Override public void enterAssignment_statement(PLanParser.Assignment_statementContext ctx) { }

    @Override public void exitAssignment_statement(PLanParser.Assignment_statementContext ctx) {
        
        if (!(stackFunc.isEmpty())) {
        	String accumulator = stackFunc.pop();
            stackFunc.push(accumulator);
            code.add(PLanConstants.DESIGNATE + accumulator + ctx.IDENTIFIER().getText());            
        } else {
        	code.add(PLanConstants.DESIGNATE + ctx.IDENTIFIER().getText());
        }

    }

    @Override public void enterIf_statement(PLanParser.If_statementContext ctx) {

        code.add(PLanConstants.IF.trim() +"_" + nestedCount);
        stackNested.push(nestedCount);
        nestedCount++;

    }

    @Override public void exitIf_statement(PLanParser.If_statementContext ctx) {

        code.add(PLanConstants.END_IF.trim() + "_" + stackNested.pop());

    }

    @Override public void enterElse_statement(PLanParser.Else_statementContext ctx) {

        int accumulator = stackNested.pop();
        stackNested.push(accumulator);
        code.add(PLanConstants.ELSE.trim() + "_" + accumulator);

    }

    @Override public void exitElse_statement(PLanParser.Else_statementContext ctx) { }

    @Override public void enterWhile_statement(PLanParser.While_statementContext ctx) {

        code.add(PLanConstants.WHILELOOP.trim() + "_" + stackNested.push(nestedCount));
        nestedCount++;

    }

    @Override public void exitWhile_statement(PLanParser.While_statementContext ctx) {

        code.add(PLanConstants.END_WHILELOOP.trim() + "_" + stackNested.pop());

    }

    @Override public void enterFor_statement(PLanParser.For_statementContext ctx) {

        code.add(PLanConstants.FORLOOP.trim() + "_" + stackNested.push(nestedCount));
        nestedCount++;

    }

    @Override public void exitFor_statement(PLanParser.For_statementContext ctx) {

        code.add(PLanConstants.END_FORLOOP.trim() + "_" + stackNested.pop());

    }
   
    @Override public void enterDisplay_statement(PLanParser.Display_statementContext ctx) { }
    
    @Override
	public void exitDisplay_statement(PLanParser.Display_statementContext ctx) {
        if (ctx.exp() != null) {
            code.add(PLanConstants.DISPLAY);
        }
	}
    
    @Override public void enterProcedure_statement(PLanParser.Procedure_statementContext ctx) {

        if (ctx.IDENTIFIER() != null) {
            stackFunc.push("#"+ctx.IDENTIFIER(0).getText());
            code.add(PLanConstants.TAKE_PROCEDURE.trim() + "_" + ctx.IDENTIFIER(0).getText());
            String func = "";
            func = PLanConstants.PARAMETER_PROCEDURE.trim();
            for (int i = 1; i < ctx.IDENTIFIER().size(); i++) {
                func = func + " #" +ctx.IDENTIFIER(0).getText() + ctx.IDENTIFIER(i).getText();
            }

            code.add(func);
        }

    }

    @Override public void exitProcedure_statement(PLanParser.Procedure_statementContext ctx) {

        if (ctx.IDENTIFIER(0) != null) {
            code.add(PLanConstants.END_PROCEDURE.trim() + "_" + ctx.IDENTIFIER(0).getText());
            stackFunc.pop();
        }

    }

    @Override public void enterReturn_statement(PLanParser.Return_statementContext ctx) { }

    @Override public void exitReturn_statement(PLanParser.Return_statementContext ctx) {

        code.add(PLanConstants.PARAMETER_PROCEDURE);

    }

    @Override public void enterProcedure_call_statement(PLanParser.Procedure_call_statementContext ctx) { }

    @Override public void exitProcedure_call_statement(PLanParser.Procedure_call_statementContext ctx) {

        code.add(PLanConstants.CALL_PROCEDURE.trim() + "_" + ctx.IDENTIFIER().getText());

    }

    @Override public void enterConditional_exp(PLanParser.Conditional_expContext ctx) { }

    @Override public void exitConditional_exp(PLanParser.Conditional_expContext ctx) {

        if (ctx.getText().contains("==")) {
            code.add(PLanConstants.MATCH);
        } else if (ctx.getText().contains("<")) {
            code.add(PLanConstants.BELOW);
        } else if (ctx.getText().contains(">")) {
            code.add(PLanConstants.ABOVE);
        }else if (ctx.getText().contains("<=")) {
            code.add(PLanConstants.BELOW_MATCH);
        } else if (ctx.getText().contains(">=")) {
            code.add(PLanConstants.ABOVE_MATCH);
        } else if (ctx.getText().contains("!=")) {
            code.add(PLanConstants.NOT_MATCH);
        } else if (ctx.getText().contains("? ")) {
            code.add("? ");
        }

        code.add(PLanConstants.CONDITION_END);

    }

    @Override public void enterBool_exp(PLanParser.Bool_expContext ctx) { }

    @Override public void exitBool_exp(PLanParser.Bool_expContext ctx) { }

    @Override public void enterExp(PLanParser.ExpContext ctx) { }

    @Override public void exitExp(PLanParser.ExpContext ctx) {

        if (ctx.getText().contains("+")) {
            code.add(PLanConstants.INCREASE);
        } else if (ctx.getText().contains("-")) {
            code.add(PLanConstants.DECREASE);
        }

    }

    @Override public void enterTerm(PLanParser.TermContext ctx) { }

    @Override public void exitTerm(PLanParser.TermContext ctx) {

        if (ctx.getText().contains("*")) {
            code.add(PLanConstants.INCREASE_BY);
        } else if (ctx.getText().contains("/")) {
            code.add(PLanConstants.DECREASE_BY);
        } else if (ctx.getText().contains("%")) {
            code.add(PLanConstants.MODULUS);

        }

    }

    @Override public void enterComponent(PLanParser.ComponentContext ctx) { }

    @Override public void exitComponent(PLanParser.ComponentContext ctx) {

        if (ctx.NUMBER() != null) {
            code.add(PLanConstants.INSERT + ctx.NUMBER().getText());
        } else if (ctx.IDENTIFIER() != null ) {
            if (stackFunc.isEmpty()) {
                code.add(PLanConstants.STOCK + ctx.IDENTIFIER().getText());
            } else {
                String accumulator = stackFunc.pop();
                stackFunc.push(accumulator);
                code.add(PLanConstants.STOCK + accumulator + ctx.IDENTIFIER().getText());
            }
        }

    }

    @Override public void enterBool_component(PLanParser.Bool_componentContext ctx) { }

    @Override public void exitBool_component(PLanParser.Bool_componentContext ctx) {

        if (ctx.BOOLEAN() != null)
        {
            code.add(PLanConstants.INSERT + ctx.BOOLEAN().getText());
        } else if (ctx.IDENTIFIER() != null ) {
            if (stackFunc.isEmpty()) {
                code.add(PLanConstants.STOCK + ctx.IDENTIFIER().getText());
            } else {
                String accumulator = stackFunc.pop();
                stackFunc.push(accumulator);
                code.add(PLanConstants.STOCK + accumulator + ctx.IDENTIFIER().getText());
            }
        }

    }

    @Override public void enterProgram(PLanParser.ProgramContext ctx) { }

    @Override public void exitProgram(PLanParser.ProgramContext ctx) { }

    @Override public void enterStatement_list(PLanParser.Statement_listContext ctx) { }

    @Override public void exitStatement_list(PLanParser.Statement_listContext ctx) { }

    @Override public void enterStatement(PLanParser.StatementContext ctx) { }

    @Override public void exitStatement(PLanParser.StatementContext ctx) { }

    @Override public void enterAnnounce_list(PLanParser.Announce_listContext ctx) { }

    @Override public void exitAnnounce_list(PLanParser.Announce_listContext ctx) { }

    @Override public void enterAnnounce(PLanParser.AnnounceContext ctx) { }

    @Override public void exitAnnounce(PLanParser.AnnounceContext ctx) { }

    @Override public void enterEveryRule(ParserRuleContext ctx) { }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }

    @Override public void visitTerminal(TerminalNode node) { }

    @Override public void visitErrorNode(ErrorNode node) { }

    public ArrayList<String> getCode() {
        return code;
    }
}
