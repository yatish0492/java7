package com.yatish.Creational_Design_Patterns;

import java.lang.reflect.Constructor;
/*
 * Since we are able to break singleton using reflection. How can we write a singleton which is not breakable by reflection also?
 * We can implement it suing 'Enum' which will be not breakable by reflection also. But we don't have much of flexibility with 'Enum' like lazy loading etc.
 *  
 */
public class J2_2_BreakingSingleton_Using_Reflection {

	public static void main(String[] args) {
		
		/*
		 * We have created the instance of singleton using legal way by calling '.getInstance()' method.
		 */
		J2_Singleton instanceOne = J2_Singleton.getInstance();
		
		/*
		 * Using the 'java.lang.reflect.Constructor' of reflection, we get all the constructors of the class using 'J2_Singleton.class.getDeclaredConstructors();', we can change its 
		 * access modifier using '.setAccessible(true)'. The private constructor is accessible now. by calling '.newInstance()' on the constructor returns a new instance. hence singlton
		 * broken using Reflection.
		 */
        J2_Singleton instanceTwo = null;
        try {
            Constructor[] constructors = J2_Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (J2_Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}

