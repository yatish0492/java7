package com.yatish.Creational_Design_Patterns;

/*
 * What is Factory Design Pattern?
 * A class will take care of creating/instantiating objects. we don't directly create a object of a class whenever we want. We will ask the factory to create the object and give it to us.
 * 
 * NOTE: Here the Factory class should be make as Singleton class.
 */
public class J3_Factory {
	

	public static void main(String[] args) {
		VehicleFactory factory = VehicleFactory.factoryInstance;
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

/*
	This is out factory class which gives us the objects.
 */
enum VehicleFactory implements Factory{

	/*
	 * We have implemented the factory class 'OurFactory' using singleton design pattern using enum.
	 */
	factoryInstance;

	/*
	 * This method is responsible for instantiating the objects and returning the objects. it also should be 'public' and 'non-static' as we call this method using factory single instance.
	 */
	public Vehicle getObject(String s) {
		switch(s) {
			case "car" : return new Car();
			case "bike" : return new Bike();
			case "cycle" : return new Cycle();
		}
		return null;
	}

}


/*
	This is mandatory. Make sure you have an interface which is implemented by all the objects returned by factory. because 'getObject(String)'
	method needs a return type. we cannot give 'Car' or 'Bike' or 'Cycle' because we don't know which object it returns so we need to have
	have this interface which is implemented by all those objects and use this as the return type.

	We could have used 'Object' as return type right. instead of this interface?
		In that case we are leaving a chance that someone can return some other object which we don't intend to with this interface we can restict
		that returning object should be of this interface type only.
 */
interface Vehicle {}

class Car implements Vehicle{}
class Bike implements Vehicle{}
class Cycle implements Vehicle{}