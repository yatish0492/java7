package com.yatish.Creational_Design_Patterns;

/*
 * What is Singleton design pattern?
 * Singleton design patterns restricts the instantiation of the class and ensures that only once instance of the class exists in JVM.
 * 
 * Where do we use Singleton desin pattern?
 * Usually for 'logging' or 'driver object' etc we use this design pattern. In HPE, we were using singleton pattern for 'Adapters'.
 * 
 * NOTE: singleton design patterns is used in other design patterns like - Abstract Factory, Builder, Prototype, Facade etc.
 * 
 * NOTE: singleton design pattern is used in core java classes also like 'java.lang.Runtime, java.awt.Desktop.'
 */
public class J2_Singleton {
	
	/*
	 * make sure it is make 'private' and 'static'.
	 * 'private' because --> This should not be able to access outside this class directly like 'J2_Singleton.singletonInstance'
	 * 'static' because --> This is singleton hence only one instance will be there hence make it static so that no one should be able to instantiate.
	 */
	private static J2_Singleton singletonInstance;
	
	
	/*
	 * **************************************** IMPORTANT *****************************************************
	 * make sure to make the default constructor as 'private'.
	 * 'private' because --> The instance of this class should not be able to create outside this class like 'J2_Singleton obj = new J2_Singleton()'. we can all this constructor only 
	 * 						within this class.
	 */
	private J2_Singleton() {}
	
	
	/*
	 * On one method will be make public for the outside world to get the singleton instance.
	 * 
	 * make sure to make it 'public' and 'static'.
	 * 'public' because --> There should be only method to for the outer world to get the singleton instance.
	 * 'static' because --> The outer world cannot create an instance of this class if we make it non-static as we have made the constructor as 'private'.
	 * 
	 * We could have initialized the singleton instance in a static block in this class right, then we are we creating it in this method?
	 * If we create a instance in a static method, then that instance will be created when the class loads. Consider if that instance is used by JVM/application after 50 days or never 
	 * used at all. In this case simply it will be residing in the memory. So lazy loading is better, let's create the instance when a request is recieved. hence we are doing lazy loading
	 * here.
	 * 
	 * Why have we put the synchronized block inside the null check condition. we could have put synchronized on the method itself know?
	 * only when the first thread is accessing 'geInstance' method, the 'singletonInstance' value will be null, then it will populate it. From the next time 'singletonInstance' is already
	 * initialized, all the threads executing this thread will just read/get 'singletonInstance'. if we put synchronized on the method itself, all the threads will be executed 
	 * sequentially/synchronously which is not required for just reading it. hence performance hit. So only have specifically put synchronized block under null check condition.
	 * 
	 * First of all whey do we need synchronized here in this function?
	 * Consider if there are lot of threads accessing this instance. consider for the first time before 'singletonInstance' is initialized 2 threads check the null check condition 
	 * simultaneously and found it is null, then both threads will enter inside the null check condition simultaneously. each thread will execute 'singletonInstance = new J2_Singleton();'
	 * and return the object hence there are 2 objects/instances created which voids the purpose of this design pattern. hence we used synchronized here so that if 2 threads come 
	 * simultaneously and check that 'singletonInstance' is null and goes inside and finds a synchronized block. hence only one thread consider 'Thread1' is sent inside, again it will 
	 * check for the null check condition, then it will instantiate the instance and returns. Then the other thread 'Thrad2' is allowed to enter inside synchronized, it will check the 
	 * null check condition and finds that already it is initialized hence will not enter inside the condition to create new instance due to this only we have 2 null checks here.
	 */
	public static J2_Singleton getInstance() {
		if(singletonInstance == null ) {
			synchronized(J2_Singleton.class) {
				if(singletonInstance == null) {
					singletonInstance = new J2_Singleton();
				}
			}
		}
		return singletonInstance;
	}

}
