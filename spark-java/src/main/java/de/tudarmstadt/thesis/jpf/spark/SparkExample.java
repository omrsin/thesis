package de.tudarmstadt.thesis.jpf.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

public class SparkExample {
	
	public static void main(String[] args) {
		System.out.println("Java Spark Test");
	
		SparkConf conf = new SparkConf()
				.setAppName("JavaNumbers")
				.setMaster("local");
		
		JavaSparkContext spark = new JavaSparkContext(conf);
		
		List<Integer> numberList = Arrays.asList(1,2,3,3,4);
		JavaRDD<Integer> numbers = spark.parallelize(numberList);		
		
		JavaRDD<Integer> filteredNumbers = numbers.filter(new Function<Integer, Boolean>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Boolean call(Integer v1) throws Exception {
				return v1 > 1 && v1 <=3;
			}
		});
		
		JavaRDD<Integer> mappedNumbers = filteredNumbers.map(new Function<Integer, Integer>() {

			@Override
			public Integer call(Integer v1) throws Exception {
				if(v1 == 2) {
					return 7;
				} else {
					return v1;
				}
			}			
		});
		
		Integer numbersSum = mappedNumbers.reduce(new Function2<Integer, Integer, Integer>() {			
			@Override
			public Integer call(Integer v1, Integer v2) throws Exception {
				if(v1 < 5) return v1+v2;
				else return v1;
			}
		});

		System.out.println(filteredNumbers.collect());
		System.out.println(mappedNumbers.collect());
		System.out.println(numbersSum);
		
		spark.stop();
		spark.close();
	}
}