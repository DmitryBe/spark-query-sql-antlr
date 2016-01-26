package com.parser

import com.antlr.parser._
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.{BailErrorStrategy, CommonTokenStream, ANTLRInputStream}

import scala.util.{Failure, Success, Try}

object SqlQueryParser {

  def parse(sql: String): Try[ParseTree] ={

    val input: ANTLRInputStream = new ANTLRInputStream(sql)
    val lexer: SparksqlLexer = new SparksqlLexer(input)
    val tokens: CommonTokenStream = new CommonTokenStream(lexer)
    val parser: SparksqlParser = new SparksqlParser(tokens)
    parser.removeErrorListeners()
    parser.setErrorHandler(new BailErrorStrategy())

    try {
      val tree = parser.root()
      Success(tree)
    }
    catch {
      case ex: RuntimeException => {
        Failure(ex)
      }
    }


  }

}
