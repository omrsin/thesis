package de.tudarmstadt.thesis.jpf.examples;

public class MinimalSymbolicExample {
	
	private static Integer simpleMethod(Integer param) {
		if((int)param > 1) {
			return 0;
		} else {
			return 1;
		}
	}
	
	interface DummyInnerInterface {
		public Integer call(Integer param);
	}
	
	public static Integer testDummyInnerInterface(DummyInnerInterface i) {
		return i.call(1);
	}

	public static void main(String[] args) {
//		simpleMethod(1);
		
		testDummyInnerInterface(new DummyInnerInterface() {			
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}
		});
	}
}
