package de.tudarmstadt.thesis.jpf.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class SparkExample {
	
	public static void main(String[] args) {
		System.out.println("Java Spark test");
	
		SparkConf conf = new SparkConf()
				.setAppName("JavaNumbers")
				.setMaster("local");
		
		JavaSparkContext spark = new JavaSparkContext(conf);
		
		List<Integer> numberList = Arrays.asList(1,2,3,4);
		JavaRDD<Integer> numbers = spark.parallelize(numberList);		
		JavaRDD<Integer> filteredNumbers = numbers.filter(new Function<Integer, Boolean>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Boolean call(Integer v1) throws Exception {
				return v1 > 1 && v1 <=3;
			}
		});
		
		System.out.println(filteredNumbers);
		
		spark.stop();
		spark.close();
	}
}
