package com.criteo.vizatra.vizsql

object hsqldb {
  implicit val dialect = new Dialect {
    def parser = new SQL99Parser
    val functions = SQLFunction.standard orElse {
      case "timestamp" => new SQLFunction2 {
        def result = { case ((_, t1), (_, t2)) => Right(TIMESTAMP(nullable = t1.nullable || t2.nullable)) }
      }
    }: PartialFunction[String,SQLFunction]
    override def toString = "HSQLDB"
  }
}
