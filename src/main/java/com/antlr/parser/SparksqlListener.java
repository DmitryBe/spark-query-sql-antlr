// Generated from /Users/dmitry/github/spark-query-sql-antlr/Sparksql.g4 by ANTLR 4.5.1
package com.antlr.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SparksqlParser}.
 */
public interface SparksqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(SparksqlParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(SparksqlParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelect_statement(SparksqlParser.Select_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelect_statement(SparksqlParser.Select_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void enterLimit_clause(SparksqlParser.Limit_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void exitLimit_clause(SparksqlParser.Limit_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_clause(SparksqlParser.Order_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_clause(SparksqlParser.Order_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_expression(SparksqlParser.Order_by_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_expression(SparksqlParser.Order_by_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuery_expression(SparksqlParser.Query_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuery_expression(SparksqlParser.Query_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#with_expression}.
	 * @param ctx the parse tree
	 */
	void enterWith_expression(SparksqlParser.With_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#with_expression}.
	 * @param ctx the parse tree
	 */
	void exitWith_expression(SparksqlParser.With_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#common_table_expression}.
	 * @param ctx the parse tree
	 */
	void enterCommon_table_expression(SparksqlParser.Common_table_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#common_table_expression}.
	 * @param ctx the parse tree
	 */
	void exitCommon_table_expression(SparksqlParser.Common_table_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#column_name_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name_list(SparksqlParser.Column_name_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#column_name_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name_list(SparksqlParser.Column_name_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void enterQuery_specification(SparksqlParser.Query_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void exitQuery_specification(SparksqlParser.Query_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(SparksqlParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(SparksqlParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_source}.
	 * @param ctx the parse tree
	 */
	void enterTable_source(SparksqlParser.Table_sourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_source}.
	 * @param ctx the parse tree
	 */
	void exitTable_source(SparksqlParser.Table_sourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_source_item_joined}.
	 * @param ctx the parse tree
	 */
	void enterTable_source_item_joined(SparksqlParser.Table_source_item_joinedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_source_item_joined}.
	 * @param ctx the parse tree
	 */
	void exitTable_source_item_joined(SparksqlParser.Table_source_item_joinedContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void enterTable_source_item(SparksqlParser.Table_source_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void exitTable_source_item(SparksqlParser.Table_source_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void enterGroup_by_item(SparksqlParser.Group_by_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void exitGroup_by_item(SparksqlParser.Group_by_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#derived_table}.
	 * @param ctx the parse tree
	 */
	void enterDerived_table(SparksqlParser.Derived_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#derived_table}.
	 * @param ctx the parse tree
	 */
	void exitDerived_table(SparksqlParser.Derived_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_value_constructor}.
	 * @param ctx the parse tree
	 */
	void enterTable_value_constructor(SparksqlParser.Table_value_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_value_constructor}.
	 * @param ctx the parse tree
	 */
	void exitTable_value_constructor(SparksqlParser.Table_value_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(SparksqlParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(SparksqlParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(SparksqlParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(SparksqlParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void enterJoin_part(SparksqlParser.Join_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void exitJoin_part(SparksqlParser.Join_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_name_with_hint}.
	 * @param ctx the parse tree
	 */
	void enterTable_name_with_hint(SparksqlParser.Table_name_with_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_name_with_hint}.
	 * @param ctx the parse tree
	 */
	void exitTable_name_with_hint(SparksqlParser.Table_name_with_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#as_table_alias}.
	 * @param ctx the parse tree
	 */
	void enterAs_table_alias(SparksqlParser.As_table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#as_table_alias}.
	 * @param ctx the parse tree
	 */
	void exitAs_table_alias(SparksqlParser.As_table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void enterTable_alias(SparksqlParser.Table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void exitTable_alias(SparksqlParser.Table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#with_table_hints}.
	 * @param ctx the parse tree
	 */
	void enterWith_table_hints(SparksqlParser.With_table_hintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#with_table_hints}.
	 * @param ctx the parse tree
	 */
	void exitWith_table_hints(SparksqlParser.With_table_hintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_hint}.
	 * @param ctx the parse tree
	 */
	void enterTable_hint(SparksqlParser.Table_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_hint}.
	 * @param ctx the parse tree
	 */
	void exitTable_hint(SparksqlParser.Table_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#index_value}.
	 * @param ctx the parse tree
	 */
	void enterIndex_value(SparksqlParser.Index_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#index_value}.
	 * @param ctx the parse tree
	 */
	void exitIndex_value(SparksqlParser.Index_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#column_alias_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_alias_list(SparksqlParser.Column_alias_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#column_alias_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_alias_list(SparksqlParser.Column_alias_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_alias(SparksqlParser.Column_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_alias(SparksqlParser.Column_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SparksqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SparksqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#case_expr}.
	 * @param ctx the parse tree
	 */
	void enterCase_expr(SparksqlParser.Case_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#case_expr}.
	 * @param ctx the parse tree
	 */
	void exitCase_expr(SparksqlParser.Case_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 */
	void enterAggregate_windowed_function(SparksqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 */
	void exitAggregate_windowed_function(SparksqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(SparksqlParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(SparksqlParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#all_distinct_expression}.
	 * @param ctx the parse tree
	 */
	void enterAll_distinct_expression(SparksqlParser.All_distinct_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#all_distinct_expression}.
	 * @param ctx the parse tree
	 */
	void exitAll_distinct_expression(SparksqlParser.All_distinct_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SparksqlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SparksqlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(SparksqlParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(SparksqlParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(SparksqlParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(SparksqlParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#select_list}.
	 * @param ctx the parse tree
	 */
	void enterSelect_list(SparksqlParser.Select_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#select_list}.
	 * @param ctx the parse tree
	 */
	void exitSelect_list(SparksqlParser.Select_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void enterSelect_list_elem(SparksqlParser.Select_list_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void exitSelect_list_elem(SparksqlParser.Select_list_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#full_column_name}.
	 * @param ctx the parse tree
	 */
	void enterFull_column_name(SparksqlParser.Full_column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#full_column_name}.
	 * @param ctx the parse tree
	 */
	void exitFull_column_name(SparksqlParser.Full_column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(SparksqlParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(SparksqlParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#id_2}.
	 * @param ctx the parse tree
	 */
	void enterId_2(SparksqlParser.Id_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#id_2}.
	 * @param ctx the parse tree
	 */
	void exitId_2(SparksqlParser.Id_2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(SparksqlParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(SparksqlParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#search_condition}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition(SparksqlParser.Search_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#search_condition}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition(SparksqlParser.Search_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#search_condition_or}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition_or(SparksqlParser.Search_condition_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#search_condition_or}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition_or(SparksqlParser.Search_condition_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#search_condition_not}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition_not(SparksqlParser.Search_condition_notContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#search_condition_not}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition_not(SparksqlParser.Search_condition_notContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SparksqlParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SparksqlParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#id_1}.
	 * @param ctx the parse tree
	 */
	void enterId_1(SparksqlParser.Id_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#id_1}.
	 * @param ctx the parse tree
	 */
	void exitId_1(SparksqlParser.Id_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operator(SparksqlParser.Comparison_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operator(SparksqlParser.Comparison_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#simple_id}.
	 * @param ctx the parse tree
	 */
	void enterSimple_id(SparksqlParser.Simple_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#simple_id}.
	 * @param ctx the parse tree
	 */
	void exitSimple_id(SparksqlParser.Simple_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#null_notnull}.
	 * @param ctx the parse tree
	 */
	void enterNull_notnull(SparksqlParser.Null_notnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#null_notnull}.
	 * @param ctx the parse tree
	 */
	void exitNull_notnull(SparksqlParser.Null_notnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparksqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterData_type(SparksqlParser.Data_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparksqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitData_type(SparksqlParser.Data_typeContext ctx);
}