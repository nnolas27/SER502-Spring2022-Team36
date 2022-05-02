package com.plan.compiler;
// Generated from PLan.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PLanParser}.
 */
public interface PLanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PLanParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PLanParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PLanParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(PLanParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(PLanParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PLanParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PLanParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#announce_list}.
	 * @param ctx the parse tree
	 */
	void enterAnnounce_list(PLanParser.Announce_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#announce_list}.
	 * @param ctx the parse tree
	 */
	void exitAnnounce_list(PLanParser.Announce_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#announce}.
	 * @param ctx the parse tree
	 */
	void enterAnnounce(PLanParser.AnnounceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#announce}.
	 * @param ctx the parse tree
	 */
	void exitAnnounce(PLanParser.AnnounceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#var_announce}.
	 * @param ctx the parse tree
	 */
	void enterVar_announce(PLanParser.Var_announceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#var_announce}.
	 * @param ctx the parse tree
	 */
	void exitVar_announce(PLanParser.Var_announceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#int_announce}.
	 * @param ctx the parse tree
	 */
	void enterInt_announce(PLanParser.Int_announceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#int_announce}.
	 * @param ctx the parse tree
	 */
	void exitInt_announce(PLanParser.Int_announceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#bool_announce}.
	 * @param ctx the parse tree
	 */
	void enterBool_announce(PLanParser.Bool_announceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#bool_announce}.
	 * @param ctx the parse tree
	 */
	void exitBool_announce(PLanParser.Bool_announceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(PLanParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(PLanParser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(PLanParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(PLanParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(PLanParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(PLanParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(PLanParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(PLanParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(PLanParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(PLanParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#for_range_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_range_statement(PLanParser.For_range_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#for_range_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_range_statement(PLanParser.For_range_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#ternary_statement}.
	 * @param ctx the parse tree
	 */
	void enterTernary_statement(PLanParser.Ternary_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#ternary_statement}.
	 * @param ctx the parse tree
	 */
	void exitTernary_statement(PLanParser.Ternary_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#unary_statement}.
	 * @param ctx the parse tree
	 */
	void enterUnary_statement(PLanParser.Unary_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#unary_statement}.
	 * @param ctx the parse tree
	 */
	void exitUnary_statement(PLanParser.Unary_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#display_statement}.
	 * @param ctx the parse tree
	 */
	void enterDisplay_statement(PLanParser.Display_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#display_statement}.
	 * @param ctx the parse tree
	 */
	void exitDisplay_statement(PLanParser.Display_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#procedure_statement}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_statement(PLanParser.Procedure_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#procedure_statement}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_statement(PLanParser.Procedure_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(PLanParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(PLanParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#procedure_call_statement}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_call_statement(PLanParser.Procedure_call_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#procedure_call_statement}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_call_statement(PLanParser.Procedure_call_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#conditional_exp}.
	 * @param ctx the parse tree
	 */
	void enterConditional_exp(PLanParser.Conditional_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#conditional_exp}.
	 * @param ctx the parse tree
	 */
	void exitConditional_exp(PLanParser.Conditional_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#bool_exp}.
	 * @param ctx the parse tree
	 */
	void enterBool_exp(PLanParser.Bool_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#bool_exp}.
	 * @param ctx the parse tree
	 */
	void exitBool_exp(PLanParser.Bool_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(PLanParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(PLanParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PLanParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PLanParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(PLanParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(PLanParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLanParser#bool_component}.
	 * @param ctx the parse tree
	 */
	void enterBool_component(PLanParser.Bool_componentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLanParser#bool_component}.
	 * @param ctx the parse tree
	 */
	void exitBool_component(PLanParser.Bool_componentContext ctx);
}