package com.yatish.Creational_Design_Patterns;

/*
    What is Builder Pattern?
      Basically builder pattern helps in creating immutable class. Which also solves other problems mentioned below
      while creating an object.
    NOTE: It is the best pattern to use when we want to add new data members to the class in future and make it more
            adaptable for future. In builder pattern we can add the data members easily in future as the code is not
            tightly coupled.

    NOTE: here we are trying to create a immutable class.

    Problem with initializing parameters using constructor
    ------------------------------------------------------
    Consider, we initialize all the data members of the class in constructor. If there are 10 or more data members, then
        we loose track about which position of parameter maps to which data member. its hectic.

    Solution
    ---------
    We can initialize only mandatory data members in constructor and others using setter methods for other data members.

    Problem with above Solution
    ---------------------------
    We might miss out calling some setter after creating the object. Hence incomplete data. And if we have setters
    then


    Solution for both above mentioned Problems
    ------------------------------------------
        'Builder Pattern'



 */
public class J5_Builder {

    public static void main(String[] args) {
        /*
            Creating object in builder pattern
            -----------------------------------
                We need to call 'build()' method mandatorily at last as this method is the one which creates object.
                    others just the set the property, which doesn't create object.

                The reason why we returned 'Builder' object in all setters in 'Builder' class instead of 'void' is.
                here, we are calling '.set' methods one after other. say like after first set method 'setName("Yatish")'
                returns 'void' then the '.setBalance()' method doesn't have a object to call on, it cannot call on 'void'
                So only we returned 'Builder' object in all setters of 'Builder' class. its mandatory in builder pattern.
         */
        BankAccount account = new BankAccount.Builder(123456789).setName("Yatish").setBalance(0).build();
    }
}



class BankAccount {

    private long accountNumber; // This is mandatory so will pass this in constructor.
    private String name;
    private long balance;

    // To make this class immutable we add only getters here and not setters.
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }


    // Making the constructor private to make this class immutable. This constructor will be called from only builder
    // class which is inner class.
    // NOTE: Remember to take builder object as input and assign each data member of builder to 'BankAccount' object
    //          data members one by one.
    private BankAccount(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.name = builder.name;
        this.balance = builder.balance;
    }

    //Make sure to make the default constructor also as private. otherwise it will take default definition which is public.
    private BankAccount() {}


    /*
      Builder Class (Inner Class)
      ----------------------------
      This should be static class because we can access 'Builder' class using 'BankAccount' class. we need not create
        object of 'BankAccount' to access 'Builder'.

       NOTE: Builder class will have only setter methods and no getter methods.
     */

    public static class Builder {

        // we will have the same parameters
        private long accountNumber; // This is mandatory so will pass this in constructor.
        private String name;
        private long balance;

        // constructor
        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        // ****** make sure all setters return 'Builder' object after assigning **************
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBalance(long balance) {
            this.balance = balance;
            return this;
        }

        // 'build()' method. It is mandatory, this is where we call the private constructor of outer class passing this
        // 'Builder' class object where we have set the values.
        public BankAccount build() {
            return new BankAccount(this);   // Remember this will be same definition of the 'build()' method for
        }                                          //       any class. we will pass 'this' parameter to the constructor
    }                                              //       of passing each data member to constructor. we need to
}                                                  //       make sure that 'BankAccount' constructor also takes 'Builder'
                                                   //       object and assigns each data member separately there.
