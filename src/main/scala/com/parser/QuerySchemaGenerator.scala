package com.parser

import com.antlr.parser.{SparksqlParser, SparksqlBaseVisitor}
import org.antlr.v4.runtime.tree.ParseTree
import scala.collection.mutable
import scala.util.{Failure, Try, Success}
import scala.collection.JavaConversions._


case class SelectStatement(tables: scala.collection.mutable.Set[Table], columns: scala.collection.mutable.Set[Column])

object SelectStatement{

  def apply(): SelectStatement = new SelectStatement(scala.collection.mutable.Set[Table](), scala.collection.mutable.Set[Column]())
}

case class Table(name: String, alias: String, isInternal: Boolean)

case class Column(name: String, table: String, alias: String)

object QuerySchemaGenerator{

  def generate(parseTree: ParseTree): Try[scala.collection.mutable.ListBuffer[SelectStatement]] = {

    val generator = new QuerySchemaGenerator()
    generator.getSchema(parseTree)
  }

}

class QuerySchemaGenerator extends SparksqlBaseVisitor[Any]{

  val statements = new scala.collection.mutable.ListBuffer[SelectStatement]()
  val stack = new mutable.Stack[SelectStatement]()

  def getSchema(parseTree: ParseTree): Try[scala.collection.mutable.ListBuffer[SelectStatement]] = {

    try{
      super.visit(parseTree)
      Success(statements)
    }catch{
      case ex: Throwable => {
        Failure(ex)
      }
    }
  }

  override def visitSelect_statement(ctx: SparksqlParser.Select_statementContext) {

    stack.push(SelectStatement())
    super.visitChildren(ctx)
    statements.append(stack.pop())
  }

  override def visitCommon_table_expression(ctx: SparksqlParser.Common_table_expressionContext) {

    val currentScope = stack.top

    val tableName = ctx.id_1().getText()
    val table = Table(tableName, "_", true)
    currentScope.tables.add(table)

    super.visitChildren(ctx)
  }

  override def visitTable_source_item(ctx: SparksqlParser.Table_source_itemContext) {

    val currentScope = stack.top

    val tableAlias = Try(
      ctx.as_table_alias().table_alias().getText()
    ).getOrElse("_")

    Option({
      ctx.derived_table()
    }) match {
      case Some(derivedTable) => {

        // derived (nested) table
        val table = Table("_", tableAlias, true)
        currentScope.tables.add(table)

        super.visit(derivedTable)
      }
      case None => {

        // external table
        val tableName = Try({
          ctx.table_name_with_hint().getText()
        }).getOrElse("_")

        currentScope.tables.toList.find(x => x.name == tableName) match {
          case Some(table) => {}
          case None => {
            val table = Table(tableName, tableAlias, false)
            currentScope.tables.add(table)
          }
        }
      }
    }
  }

  override def visitSelect_list_elem(ctx: SparksqlParser.Select_list_elemContext) {

    val currentScope = stack.top

    Option(ctx.expression()) match {
      case Some(exp) => super.visitChildren(ctx)
      case None => {

        Option(ctx.table_name()) match {
          case Some(tableName) => {

            val column = Column("*", tableName.getText(), "")
            currentScope.columns.add(column)
          }
          case None => {

            val column = Column("*", "_", "")
            currentScope.columns.add(column)
          }
        }
      }
    }
  }

  override def visitFull_column_name(ctx: SparksqlParser.Full_column_nameContext) {

    val currentScope = stack.top

    val colName = Try(
      ctx.column_name().getText()
    ).getOrElse("_")

    val tableName = Try(
      ctx.table_name().getText()
    ).getOrElse("_")

    val column = Column(colName, tableName, "")
    currentScope.columns.add(column)

  }

}


