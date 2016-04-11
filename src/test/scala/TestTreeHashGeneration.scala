import com.antlr.parser.{SparksqlParser, SparksqlBaseVisitor}
import com.parser.{SqlQueryHashGenerator, QueryHashGenerator, SqlQueryParser}
import com.sun.net.httpserver.Authenticator
import org.antlr.v4.runtime.tree.{RuleNode, TerminalNode, ParseTree}
import org.scalatest.{Matchers, FlatSpec}
import scala.collection.JavaConversions._
import scala.util.{Failure, Success}


class TestTreeHashGeneration extends FlatSpec with Matchers{

  _validate(
    ( "select col1 col2, col3 from table1",
      "select col2 col1, col3 from table1",
      true
      )
  )

  _validate(
    ( "select col1 col3 from table1",
      "select col2 col1, col3 from table1",
      false
      )
  )

  _validate(
    ( "select t.col2, t.col1 from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1",
      "select t.col1, t.col2 from tab1 as t inner join tab2 as t2 on t2.c1 = t1.c1",
      true
      )
  )

  _validate(
    ( "select t.col2, t.col1 from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c2",
      "select t.col1, t.col2 from tab1 as t inner join tab2 as t2 on t2.c1 = t1.c1",
      false
      )
  )

  _validate(
    ( "select t1.c0 from (SELECT c0 FROM n0.t0 WHERE (c1 >= 50 AND c1 < 65)) as t1 where t1.c0 > 9778",
      "select t1.c0 from (SELECT c0 FROM n0.t0 WHERE (c1 < 65 AND c1 >= 50)) as t1 where t1.c0 > 9778",
      true
      )
  )

  _validate(
    ( "select t1.c0 from (SELECT c0 FROM n0.t0 WHERE (c1 >= 50 AND c1 < 65)) as t1 where t1.c0 > 9771",
      "select t1.c0 from (SELECT c0 FROM n0.t0 WHERE (c1 < 65 AND c1 >= 50)) as t1 where t1.c0 > 9778",
      false
      )
  )

  _validate(
    ( "select t.col2, t2.col1, CASE WHEN t.gt0 = '1' AND t.gt1 = '1' then 2 else 1 END as allele_count from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1",
      "select t2.col1, t.col2, CASE WHEN t.gt0 = '1' AND t.gt1 = '1' then 2 else 1 END as allele_count from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1",
      true
      )
  )

  _validate(
    ( "select t1.* from (SELECT phenotype_id FROM pheno_table1 WHERE (age < 65 and age >= 50 ) OR (age >= 35 AND age < 50) OR (age >= 65)) as t1 where t1.phenotype_id > 11 and t1.phenotype_id < 22",
      "select t1.* from (SELECT phenotype_id FROM pheno_table1 WHERE (age >= 50 AND age < 65) OR (age >= 35 AND age < 50) OR (age >= 65)) as t1 where t1.phenotype_id > 11 and t1.phenotype_id < 22",
      true
      )
  )

  _validate(
    ( "select t1.* from (SELECT phenotype_id FROM pheno_table1 WHERE (age < 1 and age >= 50 ) OR (age >= 35 AND age < 50) OR (age >= 65)) as t1 where t1.phenotype_id > 11 and t1.phenotype_id < 22",
      "select t1.* from (SELECT phenotype_id FROM pheno_table1 WHERE (age >= 50 AND age < 65) OR (age >= 35 AND age < 50) OR (age >= 65)) as t1 where t1.phenotype_id > 11 and t1.phenotype_id < 22",
      false
      )
  )

  def _validate(data: (String, String, Boolean)): Unit ={

    val sql1 = data._1
    val sql2 = data._2
    val areEqualExpected = data._3

    println()
    println("1:" + sql1)
    println("2:" + sql2)
    println("expected to be equal?: " + areEqualExpected)

    it should "1-> " + sql1 + " -> should be equal[" + areEqualExpected + "] to -> " + sql2  in {

      val areEqualResult = for {

        parse1 <- SqlQueryParser.parse(sql1)
        hash1 <- SqlQueryHashGenerator.generate(parse1.tree)

        parse2 <- SqlQueryParser.parse(sql2)
        hash2 <- SqlQueryHashGenerator.generate(parse2.tree)

        f = hash1.hashMD5 == hash2.hashMD5

      } yield f

      areEqualResult match {
        case Success(r) => {
          r should equal(areEqualExpected)
        }
        case Failure(ex) => {
          throw ex
        }
      }

    }

  }


}
