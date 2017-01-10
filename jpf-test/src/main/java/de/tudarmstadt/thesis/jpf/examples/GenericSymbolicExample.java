package de.tudarmstadt.thesis.jpf.examples;

public class GenericSymbolicExample {
	
	private static Integer simpleMethod(Integer param) {
		if((int)param > 1) {
			return 0;
		} else {
			return 1;
		}
	}	
	
	/*---------- Inner Classes ----------*/
	static class DummyInnerClass {
		public static Integer call(Integer param) {
			return simpleMethod(param);
		}
	}
	
	class DummyInnerGenericClass<T> {
		public Integer call(T param){
			return simpleMethod((Integer)param);
		}
	}
	
	class DummyInnerClassWithImplementedInterface implements DummyInnerInterface {
		@Override
		public Integer call(Integer param) {
			return simpleMethod(param);
		}		
	}
	
	class DummyInnerClassWithImplementedGenericInterface implements DummyInnerGenericInterface<Integer> {
		@Override
		public Integer call(Integer param) {
			return simpleMethod(param);
		}		
	}
	
	/*---------- Interfaces ----------*/
	interface DummyInnerInterface {
		public Integer call(Integer param);
	}
	
	interface DummyInnerGenericInterface<T> {
		public T call(Integer param);
	}
	
	interface DummyInnerGenericInterface2<T> {
		public Integer call(T param);
	}
		
	interface DummyInnerDoubleGenericInterface<T, R> {
		public R call(T param);
	}
	
	/*---------- Methods ----------*/
	public static Integer testDummyInnerInterface(DummyInnerInterface i) {
		return i.call(1);
	}
	
	public static Integer testDummyInnerGenericInterface(DummyInnerGenericInterface<Integer> i) {
		return i.call(1);
	}
	
	public static Integer testDummyInnerGenericInterface2(DummyInnerGenericInterface2<Integer> i) {
		return i.call(1);
	}
	
	public static Integer testDummyInnerDoubleGenericInterface(DummyInnerDoubleGenericInterface<Integer, Integer> i) {
		return i.call(1);
	}
	
	public static void main(String args[]) {
		
		/*---------- Call to Classes ----------*/		
		DummyInnerClass.call(1);
		new GenericSymbolicExample().new DummyInnerGenericClass<Integer>().call(1);
		new GenericSymbolicExample().new DummyInnerClassWithImplementedInterface().call(1);
		testDummyInnerInterface(new GenericSymbolicExample().new DummyInnerClassWithImplementedInterface());
		new GenericSymbolicExample().new DummyInnerClassWithImplementedGenericInterface().call(1);
		testDummyInnerGenericInterface(new GenericSymbolicExample().new DummyInnerClassWithImplementedGenericInterface());
		
		
		/*---------- Calls to Interfaces as Anonymous Classes ----------*/
		testDummyInnerInterface(new DummyInnerInterface() {			
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}
		});
		
		new DummyInnerInterface() {			
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}
		}.call(1);
		
		testDummyInnerGenericInterface(new DummyInnerGenericInterface<Integer>() {
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}			
		});
		
		new DummyInnerGenericInterface<Integer>() {
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}			
		}.call(1);
		
		testDummyInnerGenericInterface2(new DummyInnerGenericInterface2<Integer>() {
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}
		});
		
		new DummyInnerGenericInterface2<Integer>() {
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}
		}.call(1);
		
		testDummyInnerDoubleGenericInterface(new DummyInnerDoubleGenericInterface<Integer, Integer>() {
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}
		});
		
		new DummyInnerDoubleGenericInterface<Integer, Integer>() {
			@Override
			public Integer call(Integer param) {
				return simpleMethod(param);
			}
		}.call(1);		
	}
}
