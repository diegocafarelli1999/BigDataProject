package esempio

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}


object JsonParser {
  val config = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
  val sparkCont = new SparkContext(config)
  val sqlContext = new SQLContext(sparkCont)
  val inp = "C:\\Users\\HP\\Desktop\\etlabora\\BigData\\big Data\\2018-03-01-0 (1).json"



  def main(args: Array[String]){
    val df = sqlContext.read.json(inp)
    df.registerTempTable("miaTabella")
    val rows: RDD[Row] = df.rdd
    val dataToShow = sqlContext.sql("select * from miaTabella")
    dataToShow.show()
    val data2 = sqlContext.sql("select actor from tabella")
    data2.show()
    sparkCont.stop
    val data3  = sqlContext.sql("select  repo from miaTabella")
    data3.show()
    val data4  = sqlContext.sql("select count(actor) repo from miaTabella")
    data4.show()
    sparkCont.stop()
}
}
