package com.yatish.Creational_Design_Patterns;

/*
   This solves all the problems we had,
        1) it doesn't have problem of breakages using Reflection. as there is no constructor
        2) It takes care of serializable problem it returns same object. No need to implement Serializable as 'enum' is
            by default serializable.
        2) the 'singletonInstance' is lazy initialized when we access it using 'FinalSolutionSingleTon.singletonInstance'
            because all enum are static variables. All static variables are initialized when we access them. It doesn't
            get initialized when class is loaded to JVM.
 */
public class J2_3_Enum_Final_Solution_For_All {

    public static void main(String[] args) {
        FinalSolutionSingleTon obj = FinalSolutionSingleTon.singletonInstance;
    }

}


enum FinalSolutionSingleTon {
    singletonInstance;

}
