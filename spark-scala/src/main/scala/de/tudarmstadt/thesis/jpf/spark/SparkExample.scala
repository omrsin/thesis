package de.tudarmstadt.thesis.jpf.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SparkExample {
  
   def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Example").setMaster("local")
    val spark = new SparkContext(conf)
    
    val numbers = spark.parallelize(Seq(1,2,3,3,4))
    val filteredNumbers = numbers.filter { x => x > 1 && x <= 3 }
    val mappedNumbers = filteredNumbers.map { x => if(x==2) 7 else x }
    val numbersSum = mappedNumbers.reduce(_+_)
    
    println(numbersSum)        
  }
}