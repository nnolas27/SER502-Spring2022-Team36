package com.plan.compiler;
// Generated from PLan.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PLanParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PLanVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PLanParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PLanParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(PLanParser.Statement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PLanParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#announce_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnounce_list(PLanParser.Announce_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#announce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnounce(PLanParser.AnnounceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#var_announce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_announce(PLanParser.Var_announceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#int_announce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_announce(PLanParser.Int_announceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#bool_announce}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_announce(PLanParser.Bool_announceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#assignment_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_statement(PLanParser.Assignment_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(PLanParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(PLanParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(PLanParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(PLanParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#for_range_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_range_statement(PLanParser.For_range_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#ternary_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernary_statement(PLanParser.Ternary_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#unary_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_statement(PLanParser.Unary_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#display_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay_statement(PLanParser.Display_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#procedure_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_statement(PLanParser.Procedure_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(PLanParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#procedure_call_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_call_statement(PLanParser.Procedure_call_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#conditional_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_exp(PLanParser.Conditional_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#bool_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_exp(PLanParser.Bool_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(PLanParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PLanParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(PLanParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PLanParser#bool_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_component(PLanParser.Bool_componentContext ctx);
}