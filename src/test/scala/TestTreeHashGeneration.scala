import com.antlr.parser.{SparksqlParser, SparksqlBaseVisitor}
import com.parser.SqlQueryParser
import org.scalatest.{Matchers, FlatSpec}
import scala.collection.JavaConversions._
import scala.util.{Failure, Success}

class HashGenerator extends SparksqlBaseVisitor[String]{


  val stack = scala.collection.mutable.Stack[String]()

  override def visitSelect_list (ctx: SparksqlParser.Select_listContext): String = {

    //super.visitChildren(ctx)

    val l = ctx.select_list_elem()
      .toList
      .map(x => super.visit(x))
      .sortWith(_ < _)

    val _text = l.foldLeft(new StringBuilder())(_ append _)
      .toString()

    stack.push(_text)
    //_text
    ""
  }

  override def visitSelect_list_elem(ctx: SparksqlParser.Select_list_elemContext): String = {

    val _text = super.visit(ctx.expression())
    //stack.push(_text)
    _text
  }

  override def visitExpression(ctx: SparksqlParser.ExpressionContext): String = {

    //super.visitExpression(ctx)
    //super.visitChildren(ctx)
    val _text = ctx.getText
    _text
  }

//  override def visitSearch_condition(ctx: SparksqlParser.Search_conditionContext): String = {
//    //return visitChildren(ctx)
//
//    ctx.search_condition_or()
//    ""
//  }

}

class TestTreeHashGeneration extends FlatSpec with Matchers{

  it should "" in {

    //val sql = "select col2, col1, col3 from tab1"
    val sql = "select t2.col1, t.col2,  CASE WHEN t.gt0 = '1' then 2 else 1 END as allele_count from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1"

    SqlQueryParser.parse(sql) match {
      case Success(result) => {

        println(result.treeStr)

        val hashGenerator = new HashGenerator()
        val a = hashGenerator.visit(result.tree)
        val l = hashGenerator.stack.toList.reverse


        println(l)
      }
      case Failure(ex) => {
        println(ex)
      }
    }

  }

}
