package com.parser

import com.antlr.parser.{SparksqlParser, SparksqlBaseVisitor}
import org.antlr.v4.runtime.tree.{TerminalNodeImpl, ParseTree}
import scala.collection.JavaConversions._
import scala.util.{Failure, Success, Try}

object QueryAnalyser{

  def generate(parseTree: ParseTree): Try[Map[String, Any]] ={

    val analyser = new QueryAnalyser()
    analyser.analyse(parseTree)
  }
}

class QueryAnalyser extends SparksqlBaseVisitor[Any] {

  var extTables = 0
  var nestedTables = 0

  var comparisonPredicate = 0
  var inPredicateItems = 0
  var betweenPredicate = 0
  var likePredicate = 0
  var rlikePredicate = 0

  var joinTotal = 0
  var joinLeft = 0
  var joinRight = 0
  var joinInner = 0
  var joinOuter = 0
  var joinCross = 0

  var groupBy = 0
  var groupByItems = 0
  var having = 0

  def analyse(parseTree: ParseTree): Try[Map[String, Any]] = {

    try{

      super.visit(parseTree)

      val res = Map(
        "extTables" -> extTables,
        "nestedTables" -> nestedTables,
        "comparisonPredicate" -> comparisonPredicate,
        "inPredicateItems" -> inPredicateItems,
        "betweenPredicate" -> betweenPredicate,
        "likePredicate" -> likePredicate,
        "rlikePredicate" -> rlikePredicate,
        "joinTotal" -> joinTotal,
        "joinLeft" -> joinLeft,
        "joinRight" -> joinRight,
        "joinInner" -> joinInner,
        "joinOuter" -> joinOuter,
        "joinCross" -> joinCross,
        "groupBy" -> groupBy,
        "groupByItems" -> groupByItems,
        "having" -> having
      )

      Success(res)
    }catch{
      case ex: Throwable => {
        println(ex.getMessage)
        Failure(ex)
      }
    }
  }

  override def visitQuery_specification(ctx: SparksqlParser.Query_specificationContext) {

    (Option(ctx.WHERE), Option(ctx.search_condition)) match {
      case (Some(v1), Some(searchConditionList)) =>{

        for {
          scItem <- searchConditionList
          scOr <- scItem.search_condition_or()
          scNot <- scOr.search_condition_not()
          scPredicate = scNot.predicate()
        } countWhereConditionPredicate(scPredicate)

      }
      case _ => {}
    }

    Option(ctx.GROUP) match {
      case Some(v) => {groupBy += 1}
      case _ => {}
    }

    Option(ctx.HAVING) match {
      case Some(v) => {having += 1}
      case _ => {}
    }

    visitChildren(ctx)
  }

  def countWhereConditionPredicate(ctx: SparksqlParser.PredicateContext) {

    // count search predicates
    if (classOf[SparksqlParser.Search_condition_notContext] == ctx.parent.getClass) {

      Option(ctx.search_condition()) match {
        case Some(v) =>{

          for {
            scItem <- v.search_condition_or
            scNot <- scItem.search_condition_not
            scPredicate = scNot.predicate()
          } countWhereConditionPredicate(scPredicate)
        }
        case _ => {}
      }

      Option(ctx.LIKE) match {
        case Some(v) => {likePredicate += 1}
        case _ => {}
      }

      Option(ctx.RLIKE) match {
        case Some(v) => {rlikePredicate += 1}
        case _ => {}
      }

      Option(ctx.BETWEEN) match {
        case Some(v) => {betweenPredicate += 1}
        case _ => {}
      }

      Option(ctx.comparison_operator()) match {
        case Some(v) =>{ comparisonPredicate += 1 }
        case _ =>{}
      }

      (Option(ctx.IN), Option(ctx.expression_list)) match {
        case (Some(v), Some(v2)) => { inPredicateItems += v2.expression().length }
        case _ => {}
      }

    }
  }

  override def visitJoin_part(ctx: SparksqlParser.Join_partContext) {

    joinTotal += 1

    Option(ctx.LEFT) match {
      case Some(v) => {
        joinLeft += 1
      }
      case _ =>{}
    }

    Option(ctx.RIGHT) match {
      case Some(v) => {
        joinRight += 1
      }
      case _ =>{}
    }

    Option(ctx.INNER) match {
      case Some(v) => {
        joinInner += 1
      }
      case _ =>{}
    }

    Option(ctx.OUTER) match {
      case Some(v) => {
        joinOuter += 1
      }
      case _ =>{}
    }

    Option(ctx.CROSS) match {
      case Some(v) => {
        joinCross += 1
      }
      case _ =>{}
    }

    visitChildren(ctx)
  }

  override def visitGroup_by_item(ctx: SparksqlParser.Group_by_itemContext) {

    groupByItems += 1
    visitChildren(ctx)
  }

  override def visitTable_source_item(ctx: SparksqlParser.Table_source_itemContext) {

    Option(ctx.derived_table) match {

      case Some(derivedTable) => {

        nestedTables += 1
        super.visit(derivedTable)
      }
      case None => {
        extTables += 1
      }
    }
  }

}

