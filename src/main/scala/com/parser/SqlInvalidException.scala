package com.parser


case class SqlInvalidException(msg: String, line: Int, position: Int, stack: java.util.List[String]) extends Exception {
  override def toString() = {
    "line %s:%s %s".format(line, position, msg)
  }
}