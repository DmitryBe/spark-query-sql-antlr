package com.parser

import com.antlr.parser.{SparksqlParser, SparksqlBaseVisitor}

import scala.util.Try


class CustomVisitor extends SparksqlBaseVisitor[Any]{

  //var tables = scala.collection.mutable.Map[String, scala.collection.mutable.Set[String]]()

  var tables = scala.collection.mutable.Map[String, String]()

  var columns = scala.collection.mutable.Map[String, scala.collection.mutable.Set[String]]()

  override def visitColumn_name(ctx: SparksqlParser.Column_nameContext) {

//    println("visit column name")
//
//    val text = ctx.getText()
//    println("Test: " + text)

    super.visitChildren(ctx)
  }

  override def visitFull_column_name(ctx: SparksqlParser.Full_column_nameContext) {

    val text = ctx.getText()

    val tName = Try(ctx.table_name().getText())
    val cName = ctx.column_name()

    val tableName = tName.getOrElse("")
    val columnName = cName.getText()

    var cols = columns.getOrElseUpdate(tableName, scala.collection.mutable.Set[String]())
    cols.add(columnName)

    //columns.getOrElseUpdate(columnName, tableName)
    super.visitChildren(ctx)
  }

  override def visitTable_source_item(ctx: SparksqlParser.Table_source_itemContext) {

    //val text = ctx.getText()

    Option(ctx.table_name_with_hint()) match {
      case Some(hint) => {

        val tName = hint.table_name()
        val tableName = tName.getText()

        val asTableAlias = ctx.as_table_alias()
        val alias = asTableAlias.table_alias()
        val aliasName = alias.getText()

        tables.getOrElseUpdate(tableName, aliasName)
      }
      case None => {}
    }

    Option(ctx.derived_table()) match {
      case Some(derivedTable) => {
        //super.visitDerived_table(derivedTable)
        super.visit(derivedTable)

      }
      case None => {}
    }

    //super.visitChildren(ctx)
  }

  override def visitDerived_table(ctx: SparksqlParser.Derived_tableContext) {
    super.visitChildren(ctx)
  }

}