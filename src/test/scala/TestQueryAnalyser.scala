import com.antlr.parser.{SparksqlParser, SparksqlBaseVisitor}
import com.parser.{SqlQueryParser, Table, SelectStatement, QuerySchemaGenerator}
import org.antlr.v4.runtime.tree.ParseTree
import org.scalatest.{Matchers, FlatSpec}

import scala.util.{Failure, Success, Try}


class QueryAnalyser extends SparksqlBaseVisitor[Any] {

  def analyse(parseTree: ParseTree): Try[String] = {

    try{
      super.visit(parseTree)
      Success("OK")
    }catch{
      case ex: Throwable => {
        Failure(ex)
      }
    }
  }

  override def visitTable_source_item(ctx: SparksqlParser.Table_source_itemContext) {

    val tableAlias = Try(
      ctx.as_table_alias().table_alias().getText()
    ).getOrElse("_")

    Option({
      ctx.derived_table()
    }) match {
      case Some(derivedTable) => {

        // derived (nested) table
        val table = Table("_", tableAlias, true)

        super.visit(derivedTable)
      }
      case None => {

        // external table
        val tableName = Try({
          ctx.table_name_with_hint().getText()
        }).getOrElse("_")


      }
    }
  }


}



class TestQueryAnalyser extends FlatSpec with Matchers{

  it should "case1" in {

    val sql = "select * from tab1"
    val tree = SqlQueryParser.parse(sql).get.tree

    val analyser = new QueryAnalyser()
    analyser.analyse(tree)

  }

}
