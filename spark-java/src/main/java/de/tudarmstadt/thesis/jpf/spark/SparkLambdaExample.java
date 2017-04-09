package de.tudarmstadt.thesis.jpf.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkLambdaExample {
	
	public static void main(String[] args) {
		System.out.println("Java Spark Test With Lambdas");
		
		SparkConf conf = new SparkConf()
				.setAppName("JavaNumbers")
				.setMaster("local");
		
		JavaSparkContext spark = new JavaSparkContext(conf);
		
		List<Integer> numberList = Arrays.asList(1,2,3,3,4);
		JavaRDD<Integer> numbers = spark.parallelize(numberList);		
		JavaRDD<Integer> filteredNumbers = numbers.filter(x -> x > 1 && x <= 3);		
		JavaRDD<Integer> mappedNumbers = filteredNumbers.map( x -> x==2 ? 7 : x);		
		Integer numbersSum = mappedNumbers.reduce((x,y) -> {
			if(x < 5) return x+y;
			else return x;
		});
		
		System.out.println(filteredNumbers.collect());
		System.out.println(mappedNumbers.collect());
		System.out.println(numbersSum);
		
		spark.stop();
		spark.close();			
	}

}
