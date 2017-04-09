package de.tudarmstadt.thesis.jpf.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SparkWordCount{
  
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Example").setMaster("local")
    val spark = new SparkContext(conf)
    val wordCount = spark.textFile("input/log.txt", 1)
                         .flatMap(_.split(" "))
                         .map((_,1))
                         .reduceByKey(_+_)
                         .collect()
                         .map(println(_))    
  }
}