import com.antlr.parser._
import com.parser.{SqlQueryParser, Table, SelectStatement, QuerySchemaGenerator}
import com.sun.tools.javac.util.ListBuffer
import org.antlr.v4.runtime.{BailErrorStrategy, CommonTokenStream, ANTLRInputStream, ParserRuleContext}
import org.scalatest.prop.Tables
import org.scalatest.{Matchers, FlatSpec}
import scala.collection.JavaConversions._
import scala.collection.mutable._

import scala.util.{Failure, Success}


class TestTreeParser extends FlatSpec with Matchers{

  it should "test1" in {

    //val sql = "select t.col2, t2.col1, CASE WHEN t.gt0 = '1' AND t.gt1 = '1' then 2 else 1 END as allele_count from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1"
    //val sql = "select t.col2, t.col1 from tab1 as t inner join tab2 as t2 on t1.c1 = t2.c1"
    //val sql = "select a.c0, a.c1, b.c0, b.c1 from table_a as a, table_b as b where a.c0=b.c0"
    //val sql = "select t1.c0 from (SELECT c0 FROM n0.t0 WHERE (c1 >= 50 AND c1 < 65)) as t1 where t1.c0 > 9778"
    //val sql = "select * from phenotype.lake_view_microbiome"
    //val sql = "select superkingdom, hli_microbiome_id from phenotype.lake_view_microbiome"
    //val sql = "select * from phenotype.lake_view_microbiome where hli_microbiome_id = 'Sample_1573' AND abundance = '0.00000359922' AND name = 'family'"
    //val sql = "select superkingdom, hli_microbiome_id, site from phenotype.lake_view_microbiome where hli_microbiome_id = 'Sample_1573' AND abundance = '0.00000359922' AND name = 'family'"
    //val sql = "select * from phenotype.lake_view_microbiome t where t.superkingdom is not null and t.hli_microbiome_id is not null and t.name is not null and t.family is not null and t.site is not null and t.species is not null and t.abundance is not null and t.reads is not null and t.phylum is not null and t.individual_id is not null and t.v is not null and t.hli_id is not null and t.tax_name is not null and t.genus is not null and t.order is not null and t.tax_id is not null and t.class is not null"
    //val sql = "select t.order, t.class from phenotype.lake_view_microbiome as t where t.class = 'Gammaproteobacteria' and t.order = 'Xanthomonadales' and t.hli_microbiome_id = 'Sample_TW-DH-001' and t.name = 'order' and t.order is not null"
    //val sql = "select * from phenotype.lake_view_microbiome where hli_microbiome_id = 'Sample_1573' LIMIT 3"
    //val sql = "select t1.phenotype_id from phenotype.mesh_view_phenotype_snomed_aggregate as t1 INNER JOIN phenotype.lake_view_pit_individual_values as t2 on t2.themata_individual_id = t1.individual_id where (t2.field_label = '3-Hydroxy-3-methylglutaryl-coenzyme A reductase inhibitor (substance)' AND t2.field_value = 'Yes')"
    //val sql = "SELECT t1.phenotype_id FROM phenotype.mesh_view_phenotype_snomed_aggregate as t1 INNER JOIN phenotype.lake_view_pit_individual_values as t2 on t2.themata_individual_id = t1.individual_id WHERE (t2.field_label = '3-Hydroxy-3-methylglutaryl-coenzyme A reductase inhibitor (substance)' AND t2.field_value = 'Yes') UNION SELECT t3.phenotype_id FROM phenotype.mesh_view_phenotype_snomed_aggregate as  t3 INNER JOIN phenotype.lake_view_pit_individual_values_numeric as t4 on t4.themata_individual_id = t3.individual_id WHERE (t4.field_label = 'Creatinine (substance)' AND t4.field_value BETWEEN '-0.000001' AND '20')"
    //val sql = "select t1.* from (SELECT phenotype_id FROM phenotype.mesh_view_phenotype_snomed WHERE (age >= 50 AND age < 65) OR (age >= 35 AND age < 50) OR (age >= 65)) as t1 where t1.phenotype_id > 9778 and t1.phenotype_id < 9800"
    //val sql = "select distinct tax_id from phenotype.lake_view_microbiome order by tax_id"


    val sql = "select t1.* from (SELECT phenotype_id FROM phenotype.mesh_view_phenotype_snomed WHERE (age >= 50 AND age < 65) OR (age >= 35 AND age < 50) OR (age >= 65) ) as t1 where t1.phenotype_id > 9778 and t1.phenotype_id < 9800"
    SqlQueryParser.parse(sql) match {
      case Success(tree) => {
        val visitor = new QuerySchemaGenerator()
        val schema = visitor.getSchema(tree)
        println()
        println(schema)

        assert(schema.length == 2)

        var f =schema.find(
          x => x.tables.find(t => t.name == "phenotype.mesh_view_phenotype_snomed" && t.isInternal == false).isDefined
        ).isDefined
        assert(f)

        println("end")
      }
      case Failure(ex) => println(ex)
    }

  }

}
