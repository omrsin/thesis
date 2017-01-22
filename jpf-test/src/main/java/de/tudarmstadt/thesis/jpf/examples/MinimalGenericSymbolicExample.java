package de.tudarmstadt.thesis.jpf.examples;

public class MinimalGenericSymbolicExample {
	
	private static Integer simpleMethod(Integer param) {
		if(param > 1) {
			return 0;
		} else {
			return 1;
		}
	}
	
	interface DummyInnerGenericInterface<T> {
		public T call(Integer param);
	}
	
	public static Integer testDummyInnerGenericInterface(DummyInnerGenericInterface<Integer> i) {
		return i.call(1);
	}
	
	public static void main(String args[]) {
		
		testDummyInnerGenericInterface(new DummyInnerGenericInterface<Integer>() {
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}			
		});		
	}

}
