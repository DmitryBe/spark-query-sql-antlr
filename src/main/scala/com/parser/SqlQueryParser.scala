package com.parser

import com.antlr.parser._
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.{BailErrorStrategy, CommonTokenStream, ANTLRInputStream}

import scala.util.{Failure, Success, Try}

case class SqlParserResult(tree: ParseTree, treeStr: String)

object SqlQueryParser {

  def parse(sql: String): Try[SqlParserResult] ={

    val input: ANTLRInputStream = new ANTLRInputStream(sql)
    val lexer: SparksqlLexer = new SparksqlLexer(input)
    val tokens: CommonTokenStream = new CommonTokenStream(lexer)
    val parser: SparksqlParser = new SparksqlParser(tokens)
    //parser.removeErrorListeners()
    parser.addErrorListener(new CustomErrorListener())

    try {
      val tree = parser.root()
      val treeStr = tree.toStringTree(parser)
      val result = SqlParserResult(tree, treeStr)
      Success(result)
    }
    catch {
      case ex: SqlInvalidException =>{
        Failure(ex)
      }
      case ex: Throwable => {
        Failure(ex)
      }
    }


  }

}
