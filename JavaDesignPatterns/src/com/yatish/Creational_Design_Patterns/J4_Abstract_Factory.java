package com.yatish.Creational_Design_Patterns;

/*
    What is Abstract Factory design pattern?
        It is a factory of factories. In this pattern we will have number of factories to give the objects and there
        will be a master/Abstract Factory which will give us the object of specific factory we want.

        Fist we get the required specific factory object from the abstract factory and then from that factory we will
        get specific objects.
 */
public class J4_Abstract_Factory {

    public static void main(String[] args) {
        AbstractFactoryClass abstractFactory = AbstractFactoryClass.abstractFactory;
        FruitFactory factory = (FruitFactory) abstractFactory.getFactory("fruit"); // Getting Fruit Factory first
        factory.getFruit("mango");                                         // Then getting object in that factory.
    }
}




/*
    This interface was not necessary. we have just added to show that here also we can do abstraction.
 */
interface AbstractFactory {
    FoodFactory getFactory(String str);
}


/*
    Abstract Factory
    ----------------
    This is the Abstract factory class which will return the factory objects.

    NOTE: this factory also has to be singleton mandatorily so we have achieved it using enum.
 */
enum AbstractFactoryClass implements AbstractFactory {
    abstractFactory;

    public FoodFactory getFactory(String name) {
        switch(name) {
            case "fruit": return FruitFactory.fruitFactory;
            case "vegetable": return VegetablesFactory.vegetableFactory;
        }
        return null;
    }
}


/*
    We need an interface to be implemented by all the factory classes because. In 'AbstractFactory' method 'getFactory()'
        needs a return type, this method can return 'FruitFactory' or 'VegetablesFactory' objects. so if we implement
        this interface in both 'FruitFactory' or 'VegetablesFactory' classes. then we can use this interface as return
        type.
 */
interface FoodFactory {}


// Factory 1
// we are using 'enum' to make the factory class singleton.
enum FruitFactory implements FoodFactory{
    fruitFactory; // singleton instance

    Fruit getFruit(String name) {
        switch(name) {
            case "mango" : return new Mango();
            case "orange" : return new Orange();
            case "papaya" : return new Papaya();
        }
        return null;
    }
}

// Factory 2
enum VegetablesFactory implements FoodFactory{
    vegetableFactory;

    Vegetables getVegetable(String name) {
        switch(name) {
            case "caret" : return new Caret();
            case "beetroot" : return new Beetroot();
            case "cucumber" : return new Cucumber();
        }
        return null;
    }

}


interface Fruit {}
class Mango implements Fruit{}
class Orange implements Fruit{}
class Papaya implements Fruit{}


interface Vegetables {}
class Caret implements Vegetables{}
class Beetroot implements Vegetables{}
class Cucumber implements Vegetables{}
