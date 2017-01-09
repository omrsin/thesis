package org.apache.spark.api.java;

import java.util.List;

import org.apache.spark.api.java.function.Function;

public class JavaRDD<T> {
	
	private List<T> list_t;
		
	public JavaRDD(List<T> list_t) {	
		this.list_t = list_t;
	}

	public JavaRDD<T> filter(Function<T,Boolean> f) {
		System.out.println("JavaRDD.filter");
		try {
			f.call(list_t.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}