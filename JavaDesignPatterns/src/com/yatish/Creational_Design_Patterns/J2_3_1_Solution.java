package com.yatish.Creational_Design_Patterns;

/*
    To solve the breaking of singleton using serializable, we need to implement 'readResolve()' method of 'Serializable'
        interface. This method is called when preparing the deserialized object before returning. it actually creates
        new object. when we implement that method we will return the same object as shown below,


            protected Object readResolve() {
                return singletonInstance;
            }

       If we place the above method in 'J2_Singleton' then even if we serialize and deserialize also we get the same
       object instead of new object created.

 */
public class J2_3_1_Solution {
}

