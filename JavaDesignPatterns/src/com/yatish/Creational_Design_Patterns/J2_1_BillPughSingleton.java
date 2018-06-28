package com.yatish.Creational_Design_Patterns;

/*
 * One more guy call 'Bill Pugh' also gave one more approach for implementing 'singleton', which is shown in this class. he uses 'inner/nested' class to achieve it.
 * 
 * We are using inner class to achieve it, fine. But what about lazy loading?
 * The static inner classes are not loaded to class area when parent class loads, it loads only when a reference to it is made. hence lazy loading is also handled.
 */
public class J2_1_BillPughSingleton {

    private J2_1_BillPughSingleton(){}
    
    private static class SingletonHelper{
        private static final J2_1_BillPughSingleton INSTANCE = new J2_1_BillPughSingleton();
    }
    
    public static J2_1_BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}