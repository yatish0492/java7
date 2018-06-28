package com.yatish.Creational_Design_Patterns;

/*
 * What is Factory Design Pattern?
 * A class will take care of creating/instantiating objects. we don't directly create a object of a class whenever we want. We will ask the factory to create the object and give it to us.
 * 
 * NOTE: Here the Factory class can be make as Singleton class.
 */
public class J3_Factory implements Factory {
	
	/*
	 * We have implemented the factory class 'J3_Factory' using singleton design pattern.
	 */
	private static Factory factoryInstance;
	
	private J3_Factory() {}
	
	public static Factory getFactoryInstance() {
		if(factoryInstance == null) {
			synchronized(J3_Factory.class) {
				if(factoryInstance == null) {
					factoryInstance = new J3_Factory();
				}
			}
		}
		return factoryInstance;
	}
	
	/*
	 * This method is responsible for instantiating the objects and returning the objects. it also should be 'public' and 'non-static' as we call this method using factory single instance.
	 */
	public Object getObject(String s) {
		switch(s) {
		case "car" : return new Car();
		case "bike" : return new Bike();
		case "cycle" : return new Cycle();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Factory factory = J3_Factory.getFactoryInstance();
		factory.getObject("car");
		factory.getObject("Bike");
		factory.getObject("Cycle");
	}

}

/*
 * We are simply using an interface also to show that using 'Factory Pattern' we can achieve abstraction also. In this case if we just expose this interface to outside world is enough.
 * They will get it that they need to call '.getObject' to get the instance of that object that's it.
 */
interface Factory {
	Object getObject(String s);
}

class Car {}
class Bike {}
class Cycle {}