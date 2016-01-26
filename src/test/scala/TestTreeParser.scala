import com.antlr.parser._
import com.parser.CustomVisitor
import org.antlr.v4.runtime.{BailErrorStrategy, CommonTokenStream, ANTLRInputStream, ParserRuleContext}
import org.scalatest.{Matchers, FlatSpec}
import scala.collection.JavaConversions._

import scala.util.{Failure, Success}


class TestTreeParser extends FlatSpec with Matchers{

  it should "test1" in {

    val sql = "select t.col2, t.col1 from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1"
    //val sql = "select a.c0, a.c1, b.c0, b.c1 from table_a as a, table_b as b where a.c0=b.c0"
    //val sql = "select t1.* from (SELECT c0 FROM n0.t0 WHERE (c1 >= 50 AND c1 < 65)) as t1 where t1.c0 > 9778 and t1.c0< 9800"

    val input: ANTLRInputStream = new ANTLRInputStream(sql)
    val lexer: SparksqlLexer = new SparksqlLexer(input)
    val tokens: CommonTokenStream = new CommonTokenStream(lexer)
    val parser: SparksqlParser = new SparksqlParser(tokens)
    parser.removeErrorListeners()
    parser.setErrorHandler(new BailErrorStrategy())

    // custom visitor
//    parser.removeParseListeners()
//    val listener1 = new Listener1()
//    parser.addParseListener(listener1)

    try {

      val tree = parser.root()
      val str_tree = tree.toStringTree(parser)
      println(str_tree)

      val visitor = new CustomVisitor()
      visitor.visit(tree)

      val c = visitor.columns
      val t = visitor.tables

      println("end")
    }
    catch {
      case ex: RuntimeException => {
        var e = ex.getMessage

        println(ex.getMessage())
      }
    }



  }

}
