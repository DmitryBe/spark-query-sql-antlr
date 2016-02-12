import java.util

import com.antlr.parser.{SparksqlParser, SparksqlLexer}
import com.parser.{CustomErrorListener, SqlInvalidException, SqlQueryParser}
import org.scalatest.{Matchers, FlatSpec}

import scala.util.{Success, Failure}


class TestSqlQueryParser extends FlatSpec with Matchers{

  shouldPass("select current_date() as data, current_timestamp() as ts")
  shouldPass("select col1, CAST(col2 as date) from tab1")
  shouldPass("select col1, CAST(col2 as int) from tab1")
  shouldPass("select avg(col1) from tab1")
  shouldPass("select round(col1) from tab1")
  shouldPass("select * from tab1")
  shouldPass("select a,b,c from table_0")
  shouldPass("select a.c0, a.c1, b.c0, b.c1 from table_a as a, table_b as b where a.c0=b.c0")
  shouldPass("select table_a.c0, table_a.c1, table_b.c0, table_b.c1 from table_a, table_b where table_a.c0=table_b.c0")
  shouldPass("select a.c0, a.c1, b.c0, b.c1 from table_a as a inner join table_b as b on a.c0=b.c0")
  shouldPass("select a.c0, a.c1, b.c0, b.c1 from table_a as a left join table_b as b on a.c0=b.c0")
  shouldPass("select a.c0, a.c1, b.c0, b.c1 from table_a as a right join table_b as b on a.c0=b.c0")
  shouldPass("select a from dummy as t0 union select b from fake as t1")
  shouldPass("select t1.* from (SELECT c0 FROM n0.t0 WHERE (c1 >= 50 AND c1 < 65)) as t1 where t1.c0 > 9778 and t1.c0< 9800")
  shouldPass("with t3 as (SELECT distinct t1.c0 FROM n0.t0 as t1 INNER JOIN n0.t00 as t2 on t2.c1= t1.c0) select count(*) from t3")
  shouldPass("select vcf.*, cv.highest_clinical_significance, cv.hgvs, cv.rs_id, snpf.annotation_impact, snpf.feature_type, snpf.feature_id from vcf.samples as vcf left join annotation.clinvar_rollup as cv on (vcf.chromosome = cv.chromosome and vcf.position = cv.position and vcf.ref = cv.ref and vcf.alt = cv.alt) left join annotation.cadd_flatten as cadd on (vcf.chromosome = cadd.chromosome and vcf.position = cadd.position and vcf.ref = cadd.ref and vcf.alt = cadd.alt) left join annotation.snpeff_flatten as snpf on (vcf.chromosome = snpf.chromosome and vcf.position = snpf.position and vcf.ref = snpf.ref and vcf.alt = snpf.alt) where sample_id = 176444255")
  shouldPass("SELECT chromosome ,position ,ref ,alt ,sum(allele_count) / (count (distinct sample_id)) as allele_frequency FROM (SELECT chromosome ,position ,ref ,alt ,sample_id ,CASE WHEN gt0 = '1' AND gt1 = '1' then 2 else 1 END as allele_count FROM vcf.samples as s WHERE s.filter = 'PASS') as v GROUP BY chromosome ,position ,ref ,alt limit 10")

  shouldFail("sele * from tab1")
  shouldFail("select * from1 tab1")
  shouldFail("select * from tab1 where c ")
  shouldFail("select a, b from")
  shouldFail("delete tab1")
  shouldFail("create tab1(id int)")
  shouldFail("select * from (delete tab1)")

  def shouldPass(sql: String): Unit ={
    it should sql in {
      SqlQueryParser.parse(sql) match {
        case Success(result) =>{}
        case Failure(ex) => {
          throw ex
        }
      }
    }
  }

  def shouldFail(sql: String): Unit ={
    it should "failed " + sql in {
      SqlQueryParser.parse(sql) match {
        case Success(result) =>{
          throw new Exception("expect failure")
        }
        case Failure(ex) => {
        }
      }
    }
  }

}
