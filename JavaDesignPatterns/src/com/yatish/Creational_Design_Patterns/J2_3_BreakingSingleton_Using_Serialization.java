package com.yatish.Creational_Design_Patterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
    When we serialize and deserialize a singleton object. The deserialized object is a new object generated. Hence we
    have 2 seperate objects of singleton class which is breaking
 */
public class J2_3_BreakingSingleton_Using_Serialization {

    public static void main(String[] args) {

        J2_Singleton obj = J2_Singleton.getInstance();
        J2_Singleton deserializedObj = null;

        try {
            //Serialize - writing object to a file.
            FileOutputStream fileOutputStream = new FileOutputStream("obj.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(obj);

            //Deserialize - Read object from file
            FileInputStream fileInputStream = new FileInputStream("obj.ser");
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            deserializedObj = (J2_Singleton)in.readObject();

            // closing connnections
            fileInputStream.close();
            fileOutputStream.close();
            out.close();
            in.close();

        } catch(Exception e) {
            System.out.println(e);
        }

        System.out.println(obj.hashCode());
        System.out.println(deserializedObj.hashCode());
    }
}

