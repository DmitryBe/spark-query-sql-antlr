package com.parser

import com.antlr.parser.SparksqlListener
import com.antlr.parser.SparksqlParser._
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{ErrorNode, TerminalNode}


class CustomListener extends SparksqlListener{
  override def enterRoot(ctx: RootContext): Unit = {
    println("enter root")
  }

  override def exitSelect_list_elem(ctx: Select_list_elemContext): Unit = {
    println("exit select list elem")
  }

  override def exitTable_name_with_hint(ctx: Table_name_with_hintContext): Unit = {
    println("exit table name with hint")
  }

  override def exitExpression(ctx: ExpressionContext): Unit = {
    println("exit expression")
  }

  override def enterWith_table_hints(ctx: With_table_hintsContext): Unit = {
    println("enter with table")
  }

  override def enterNumber(ctx: NumberContext): Unit = {
    println("enter num")
  }

  override def exitJoin_part(ctx: Join_partContext): Unit = {
    println("exit join")
  }

  override def exitOrder_by_expression(ctx: Order_by_expressionContext): Unit = {
    println("exit order")
  }

  override def exitId_1(ctx: Id_1Context): Unit = {
    println("exit id")
  }

  override def enterTable_name(ctx: Table_nameContext): Unit = {
    val token = ctx.getStart()
    val text = token.getText()
    println("enter table name: " + text)
  }

  override def exitNull_notnull(ctx: Null_notnullContext): Unit = {
    println("exit null")
  }

  override def exitOrder_by_clause(ctx: Order_by_clauseContext): Unit = {
    println("exit order")
  }

  override def enterTable_hint(ctx: Table_hintContext): Unit = {
    println("enter table hint")
  }

  override def exitNumber(ctx: NumberContext): Unit = {
    println("exit num")
  }

  override def exitGroup_by_item(ctx: Group_by_itemContext): Unit = {
    println("exit group by")
  }

  override def enterSelect_list(ctx: Select_listContext): Unit = {
    println("enter select list")
  }

  override def enterColumn_alias(ctx: Column_aliasContext): Unit = {
    println("enter column alias")
  }

  override def enterAs_table_alias(ctx: As_table_aliasContext): Unit = {
    println("enter as table")
  }

  override def exitSelect_list(ctx: Select_listContext): Unit = {
    println("exit select list")
  }

  override def exitTable_source_item(ctx: Table_source_itemContext): Unit = {
    println("exit table")
  }

  override def enterConstant(ctx: ConstantContext): Unit = {
    println("enter const")
  }

  override def enterFull_column_name(ctx: Full_column_nameContext): Unit = {
    println("enter full col")
  }

  override def enterTable_source_item(ctx: Table_source_itemContext): Unit = {
    val str = String.valueOf(ctx.getText())
    println("enter table source item")
  }

  override def enterComparison_operator(ctx: Comparison_operatorContext): Unit = {
    println("enter compar op")
  }

  override def exitTable_source_item_joined(ctx: Table_source_item_joinedContext): Unit = {
    println("exit table source")
  }

  override def exitWith_table_hints(ctx: With_table_hintsContext): Unit = {
    println("exit with table")
  }

  override def exitLimit_clause(ctx: Limit_clauseContext): Unit = {
    println("exit lim")
  }

  override def enterPredicate(ctx: PredicateContext): Unit = {
    println("enter predicate")
  }

  override def enterSign(ctx: SignContext): Unit = {
    println("enter sign")
  }

  override def enterQuery_expression(ctx: Query_expressionContext): Unit = {
    println("enter query")
  }

  override def enterAll_distinct_expression(ctx: All_distinct_expressionContext): Unit = {
    println("enter all distinct")
  }

  override def exitTable_source(ctx: Table_sourceContext): Unit = {
    println("exit table source")
  }

  override def enterExpression(ctx: ExpressionContext): Unit = {
    println("enter exp")
  }

  override def enterWith_expression(ctx: With_expressionContext): Unit = {
    println("enter with exp")
  }

  override def exitAs_table_alias(ctx: As_table_aliasContext): Unit = {
    println("exit as table")
  }

  override def enterJoin_part(ctx: Join_partContext): Unit = {
    println("enter join")
  }

  override def enterColumn_name_list(ctx: Column_name_listContext): Unit = {
    println("enter column name list")
  }

  override def exitQuery_specification(ctx: Query_specificationContext): Unit = {
    println("exit query spec")
  }

  override def enterOrder_by_expression(ctx: Order_by_expressionContext): Unit = {
    println("enter order exp")
  }

  override def enterAggregate_windowed_function(ctx: Aggregate_windowed_functionContext): Unit = {
    println("enter agg wind func")
  }

  override def exitSearch_condition_or(ctx: Search_condition_orContext): Unit = {
    println("exit search cond")
  }

  override def exitColumn_name_list(ctx: Column_name_listContext): Unit = {
    println("exit column name list")
  }

  override def exitCase_expr(ctx: Case_exprContext): Unit = {
    println("exit case")
  }

  override def enterSearch_condition_not(ctx: Search_condition_notContext): Unit = {
    println("enter search cond")
  }

  override def enterUnion(ctx: UnionContext): Unit = {
    println("enter union")
  }

  override def exitFull_column_name(ctx: Full_column_nameContext): Unit = {
    println("exit full col name")
  }

  override def exitSubquery(ctx: SubqueryContext): Unit = {
    println("exit subquery")
  }

  override def enterId_1(ctx: Id_1Context): Unit = {
    println("enter id")
  }

  override def exitRoot(ctx: RootContext): Unit = {
    println("exit root")
  }

  override def enterSelect_statement(ctx: Select_statementContext): Unit = {
    println("enter select")
  }

  override def exitQuery_expression(ctx: Query_expressionContext): Unit = {
    println("exit query")
  }

  override def enterTable_value_constructor(ctx: Table_value_constructorContext): Unit = {
    println("enter table")
  }

  override def exitColumn_alias(ctx: Column_aliasContext): Unit = {
    println("exit column alias")
  }

  override def enterCommon_table_expression(ctx: Common_table_expressionContext): Unit = {
    println("enter common table exp")
  }

  override def exitSelect_statement(ctx: Select_statementContext): Unit = {
    println("exit select")
  }

  override def enterExpression_list(ctx: Expression_listContext): Unit = {
    println("enter exp list")
  }

  override def exitAll_distinct_expression(ctx: All_distinct_expressionContext): Unit = {
    println("exit all distinct")
  }

  override def exitSimple_id(ctx: Simple_idContext): Unit = {
    println("exit simple id")
  }

  override def enterTable_name_with_hint(ctx: Table_name_with_hintContext): Unit = {
    println("enter table name with")
  }

  override def exitCommon_table_expression(ctx: Common_table_expressionContext): Unit = {
    println("exit com tab exp")
  }

  override def exitAggregate_windowed_function(ctx: Aggregate_windowed_functionContext): Unit = {
    println("exit aggr win func")
  }

  override def enterIndex_value(ctx: Index_valueContext): Unit = {
    println("enter index")
  }

  override def exitWith_expression(ctx: With_expressionContext): Unit = {
    println("exit with exp")
  }

  override def exitComparison_operator(ctx: Comparison_operatorContext): Unit = {
    println("exit comparison")
  }

  override def exitConstant(ctx: ConstantContext): Unit = {
    println("exit const")
  }

  override def enterNull_notnull(ctx: Null_notnullContext): Unit = {
    println("enter null")
  }

  override def exitIndex_value(ctx: Index_valueContext): Unit = {
    println("exit index")
  }

  override def enterLimit_clause(ctx: Limit_clauseContext): Unit = {
    println("enter lim")
  }

  override def enterColumn_alias_list(ctx: Column_alias_listContext): Unit = {
    println("enter column alias list")
  }

  override def exitColumn_alias_list(ctx: Column_alias_listContext): Unit = {
    println("exit column aliase list")
  }

  override def exitUnion(ctx: UnionContext): Unit = {
    println("exit union")
  }

  override def enterSearch_condition(ctx: Search_conditionContext): Unit = {
    println("enter search cond")
  }

  override def exitSearch_condition(ctx: Search_conditionContext): Unit = {
    println("exit search condition")
  }

  override def enterDerived_table(ctx: Derived_tableContext): Unit = {
    println("enter derived table")
  }

  override def exitTable_hint(ctx: Table_hintContext): Unit = {
    println("exit table hint")
  }

  override def enterOrder_by_clause(ctx: Order_by_clauseContext): Unit = {
    println("enter order by")
  }

  override def enterTable_source(ctx: Table_sourceContext): Unit = {
    println("enter table source")
  }

  override def enterCase_expr(ctx: Case_exprContext): Unit = {
    println("enter case exp")
  }

  override def exitTable_value_constructor(ctx: Table_value_constructorContext): Unit = {
    println("exit table value")
  }

  override def exitTable_name(ctx: Table_nameContext): Unit = {
    println("exit table name")
  }

  override def enterColumn_name(ctx: Column_nameContext): Unit = {
    println("enter col name")
  }

  override def exitSign(ctx: SignContext): Unit = {
    println("exit sign")
  }

  override def exitColumn_name(ctx: Column_nameContext): Unit = {
    println("exit col name")
  }

  override def exitSearch_condition_not(ctx: Search_condition_notContext): Unit = {
    println("exit search condiftion not")
  }

  override def enterSimple_id(ctx: Simple_idContext): Unit = {
    val token = ctx.getStart()
    val text = token.getText()
    println("enter sample id: " + text)
  }

  override def exitExpression_list(ctx: Expression_listContext): Unit = {
    println("exit exp list")
  }

  override def enterTable_alias(ctx: Table_aliasContext): Unit = {
    println("enter table alias")
  }

  override def enterTable_source_item_joined(ctx: Table_source_item_joinedContext): Unit = {
    println("enter table source item joined")
  }

  override def enterGroup_by_item(ctx: Group_by_itemContext): Unit = {
    println("enter group by item")
  }

  override def exitDerived_table(ctx: Derived_tableContext): Unit = {
    println("exit derived table")
  }

  override def enterSearch_condition_or(ctx: Search_condition_orContext): Unit = {
    println("enter search cond")
  }

  override def exitTable_alias(ctx: Table_aliasContext): Unit = {
    println("exit table alias")
  }

  override def enterQuery_specification(ctx: Query_specificationContext): Unit = {
    println("enter query spec")
  }

  override def exitPredicate(ctx: PredicateContext): Unit = {
    println("exit predicate")
  }

  override def enterSubquery(ctx: SubqueryContext): Unit = {
    println("enter subquery")
  }

  override def enterSelect_list_elem(ctx: Select_list_elemContext): Unit = {
    val token = ctx.getStart()
    val text = token.getText()
    println("enter select list elem: " + text)
  }

  override def visitTerminal(terminalNode: TerminalNode): Unit = {
    //println("terminal")
  }

  override def visitErrorNode(errorNode: ErrorNode): Unit = {
    println("error node")
  }

  override def exitEveryRule(parserRuleContext: ParserRuleContext): Unit = {
    //println("exit every rule")
  }

  override def enterEveryRule(parserRuleContext: ParserRuleContext): Unit = {
    //println("enter every rule")
  }
}

