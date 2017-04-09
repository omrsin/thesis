package de.tudarmstadt.thesis.jpf.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object LibraryCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Example").setMaster("local")
    val spark = new SparkContext(conf)
    val booksCount = spark.textFile("input/books.csv", 1)
                          .filter(_.contains("Thriller"))
                          .map(x => (x.split(",")(1),1))
                          .reduceByKey(_+_)
                          .collect()
                          .map(println(_))
//                         .flatMap(_.split(" "))
//                         .map((_,1))
//                         .reduceByKey(_+_)
//                         .collect()
//                         .map(println(_))    
  }
}