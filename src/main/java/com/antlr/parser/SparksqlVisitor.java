// Generated from /Users/dmitry/github/spark-query-sql-antlr/Sparksql.g4 by ANTLR 4.5.1
package com.antlr.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SparksqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SparksqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(SparksqlParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_statement(SparksqlParser.Select_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#limit_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit_clause(SparksqlParser.Limit_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_clause(SparksqlParser.Order_by_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_expression(SparksqlParser.Order_by_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#query_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_expression(SparksqlParser.Query_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#with_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_expression(SparksqlParser.With_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#common_table_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommon_table_expression(SparksqlParser.Common_table_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#column_name_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name_list(SparksqlParser.Column_name_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#query_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_specification(SparksqlParser.Query_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(SparksqlParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_source(SparksqlParser.Table_sourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_source_item_joined}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_source_item_joined(SparksqlParser.Table_source_item_joinedContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_source_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_source_item(SparksqlParser.Table_source_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#group_by_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_by_item(SparksqlParser.Group_by_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#derived_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerived_table(SparksqlParser.Derived_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_value_constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_value_constructor(SparksqlParser.Table_value_constructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(SparksqlParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(SparksqlParser.SubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#join_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_part(SparksqlParser.Join_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_name_with_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name_with_hint(SparksqlParser.Table_name_with_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#as_table_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_table_alias(SparksqlParser.As_table_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_alias(SparksqlParser.Table_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#with_table_hints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_table_hints(SparksqlParser.With_table_hintsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_hint(SparksqlParser.Table_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#index_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_value(SparksqlParser.Index_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#column_alias_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_alias_list(SparksqlParser.Column_alias_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#column_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_alias(SparksqlParser.Column_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SparksqlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#case_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_expr(SparksqlParser.Case_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregate_windowed_function(SparksqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(SparksqlParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#all_distinct_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll_distinct_expression(SparksqlParser.All_distinct_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(SparksqlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(SparksqlParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(SparksqlParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#select_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_list(SparksqlParser.Select_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_list_elem(SparksqlParser.Select_list_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#full_column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_column_name(SparksqlParser.Full_column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name(SparksqlParser.Column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#id_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_2(SparksqlParser.Id_2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(SparksqlParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#search_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch_condition(SparksqlParser.Search_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#search_condition_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch_condition_or(SparksqlParser.Search_condition_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#search_condition_not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch_condition_not(SparksqlParser.Search_condition_notContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(SparksqlParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#id_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_1(SparksqlParser.Id_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_operator(SparksqlParser.Comparison_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#simple_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_id(SparksqlParser.Simple_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#null_notnull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_notnull(SparksqlParser.Null_notnullContext ctx);
	/**
	 * Visit a parse tree produced by {@link SparksqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type(SparksqlParser.Data_typeContext ctx);
}