import com.parser.{SqlQueryParser, Table, SelectStatement, QuerySchemaGenerator}
import org.scalatest._
import org.scalatest.Matchers._
import scala.collection.JavaConversions._

import scala.util.{Failure, Success}


class TestQuerySchemaGenerator extends FlatSpec with Matchers{

  validateSQL(
    "select t.col2, t2.col1, CASE WHEN t.gt0 = '1' AND t.gt1 = '1' then 2 else 1 END as allele_count from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1",
    List[(String, String)](("tab1", "t"), ("tab2", "t2")),
    List[(String,String)](("col1","t2"), ("col2", "t"), ("gt0", "t"), ("gt1", "t"), ("c1", "t1"), ("c1", "t2"))
  )

  validateSQL(
    "select t.col2, t.col1 from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1",
    List[(String, String)](("tab1", "t"), ("tab2", "t2")),
    List[(String, String)](("col1", "t"), ("col2", "t"), ("c1", "t1"), ("c1", "t2"))
  )

  validateSQL(
    "select t1.c0 from (SELECT c0 FROM n0.t0 WHERE (c1 >= 50 AND c1 < 65)) as t1 where t1.c0 > 9778",
    List[(String, String)](("n0.t0", "_"), ("_", "t1")),
    List[(String, String)](("c0", "t1"), ("c0", "_"), ("c1", "_"))
  )

  validateSQL(
    "select a.c0, a.c1, b.c0, b.c1 from table_a as a, table_b as b where a.c0=b.c0",
    List[(String, String)](("table_a", "a"), ("table_b", "b")),
    List[(String, String)](("c0", "a"), ("c1", "a"), ("c0", "b"), ("c1", "b"))
  )

  validateSQL(
    "select * from pmb",
    List[(String, String)](("pmb", "_")),
    List[(String, String)](("*", "_"))
  )

  validateSQL(
    "select c1, c2 from db1.tab1",
    List[(String, String)](("db1.tab1", "_")),
    List[(String, String)](("c1", "_"), ("c2", "_"))
  )

  validateSQL(
    "select * from lake_view_microbiome where microbiome_id = '111' AND abundance = '0.111' AND name = 'bbb'",
    List[(String, String)](("lake_view_microbiome", "_")),
    List[(String, String)](("*", "_"), ("microbiome_id", "_"), ("abundance", "_"), ("name","_"))
  )

  validateSQL(
    "select distinct tax_id from microbiome order by tax_id",
    List[(String, String)](("microbiome", "_")),
    List[(String, String)](("tax_id", "_"))
  )

  validateSQL(
    "select t1.phenotype_id from phenotype.snomed as t1 INNER JOIN individual_values as t2 on t2.individual_id = t1.individual_id where (t2.field_label = 'some_lable' AND t2.field_value = 'Yes')",
    List[(String, String)](("phenotype.snomed", "t1"), ("individual_values", "t2")),
    List[(String, String)](("phenotype_id", "t1"), ("individual_id", "t1"), ("individual_id", "t2"), ("field_label", "t2"), ("field_value", "t2"))
  )

  validateSQL(
    "select t1.* from (SELECT phenotype_id FROM pheno_table1 WHERE (age >= 50 AND age < 65) OR (age >= 35 AND age < 50) OR (age >= 65)) as t1 where t1.phenotype_id > 11 and t1.phenotype_id < 22",
    List[(String, String)](("pheno_table1", "_"), ("_", "t1")),
    List[(String, String)](("*", "t1"), ("phenotype_id", "t1"))
  )

  validateSQL(
    "select * from microbiome where microbiome_id = 'Sample_15731111' LIMIT 3",
    List[(String, String)](("microbiome", "_")),
    List[(String, String)](("microbiome_id", "_"))
  )

  validateSQL(
    "select * from microbiome as t where t.superkingdom  is not null and t.microbiome_id is not null and t.name is not null",
    List[(String, String)](("microbiome", "t")),
    List[(String, String)](("*", "_"), ("superkingdom", "t"), ("microbiome_id", "t"), ("name", "t"))
  )

  validateSQL(
    "select t.order, t.class from microbiome as t where t.class = 'clasas1' and t.order = 'o1' and t.microbiome_id = '01111' and t.name = 'order' and t.order is not null",
    List[(String, String)](("microbiome", "t")),
    List[(String, String)](("order", "t"), ("class", "t"), ("microbiome_id", "t"), ("name", "t"))
  )

  def validateSQL(
                   sql:String,
                   expectedTables: List[(String, String)],
                   expectedColumns: List[(String, String)]
                 ): Unit ={

    it should "run: " + sql in {

      SqlQueryParser.parse(sql) match{

        case Success(tree) => {
          println()
          println(sql)

          QuerySchemaGenerator.generate(tree.tree) match{

            case Success(schema) => {

              println(schema)

              // expected tables
              val tab_length = schema.flatMap(x => x.tables.toList)
                .filter(x => expectedTables.contains((x.name, x.alias)))
                .length
              expectedTables.length should equal (tab_length)

              // expected columns
              val col_length = schema.flatMap(x => x.columns)
                .filter(x => expectedColumns.contains((x.name, x.table)))
                .length
//              expectedColumns.length should equal (col_length)
            }
            case Failure(ex) => {

              throw ex
            }
          }

        }

        case Failure(ex) => {
          throw ex
        }
      }

    }

  }



}
