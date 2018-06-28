package com.yatish.NestedClasses;

public class J2_Why_NestedClass {


}

/*
 * In 'Human' class, we are using other 2 classes 'Mouth' and 'Eye' as data members. We know that these 2 classes will be used only in 'Human' class. then why to write them as a seperate
 * class and use them as data members in 'Human' class. we can write these 2 classes inside 'Human' class only right as nested/inner classes.
 * 
 * NOTE: if the scenario is like 'Mouth' and 'Eye' classes are required by other classes also apart from 'Human' class then. writing them as seperate classes is best instead of writing
 * 		 nested classes in those classes. But if the intension is that only 'Human' class uses these 2 classed then nested class is the best approach.
 * 
 * Disadvantages of writing 'Mouth' and 'Eye' as seperate classes.
 * ---------------------------------------------------------------
 * 1) security concern, any other classed other than 'Human' class will be able to use the 'Mouth' and 'Eye' classes either by including them as data members or by creating instance of
 * 		them.
 * 2) the code is more when compared to nested class approach.
 * 
 * Advantages of writing 'Mouth' and 'Eye' as nested classes.
 * ----------------------------------------------------------
 * 1) Security. apart from 'Human' class no other class can access the 'Mouth' and 'Eye' classes. even if they want to access also they have to access it through 'Human' class only. The 
 * 		details about how to access the inner classes from 'Human' class will be shared in following tutorial code.
 * 2) it enhances encapsulation. and readability of the code.
 */
class Human {
	Mouth mouth;
	Eye eye;
}

class Mouth {
	int numOfTooths;
	String colorOfTooths;
	String MouthDiseases;
}

class Eye {
	String colorOfEyes;
	boolean EyeDisabled;
	String EyeDiseases;
}
