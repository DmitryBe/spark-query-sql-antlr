import com.antlr.parser.{SparksqlParser, SparksqlBaseVisitor}
import com.parser._
import org.antlr.v4.runtime.tree.{TerminalNodeImpl, ParseTree}
import org.scalatest.{Matchers, FlatSpec}
import scala.collection.JavaConversions._
import scala.util.{Failure, Success, Try}

class TestQueryAnalyser extends FlatSpec with Matchers{

  it should "case1" in {

    val sql = "select * from tab1 where col1 = 1"
    val tree = SqlQueryParser.parse(sql).get.tree

    val analyser = new QueryAnalyser()
    val r = analyser.analyse(tree)

    true should equal(true)
  }

}
