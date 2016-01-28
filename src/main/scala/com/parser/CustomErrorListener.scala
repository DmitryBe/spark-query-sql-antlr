package com.parser

import org.antlr.v4.runtime.{Parser, RecognitionException, Recognizer, BaseErrorListener}


class CustomErrorListener extends BaseErrorListener{

  override def syntaxError(recognizer: Recognizer[_, _], offendingSymbol: AnyRef, line: Int, charPositionInLine: Int, msg: String, e: RecognitionException): Unit ={

    val stack = recognizer.asInstanceOf[Parser].getRuleInvocationStack()
    throw new SqlInvalidException(msg, line, charPositionInLine, stack)
  }

}