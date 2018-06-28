package com.yatish.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapImplementation_CustomClass_As_Key {

	public static void main(String[] args) {
		Map<Employee,String> a = new HashMap<Employee,String>();
		Employee obj = new Employee(10);
		Employee obj1 = new Employee(10);
		a.put(obj, "first");
		a.put(obj1, "second");
		System.out.println(a.size());
	}
}


/*
 * If we are using a custom class as key in map or in any collections like Set. We have to override 2 methods as follows,
 * 1) public boolean equals(Object obj)
 * 2) public int hashCode()
 */
class Employee {
	int id;
	
	Employee(int id) { 
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee emp = (Employee)obj;
			if(emp.id == this.id) {
				return true;
			} 
		} 
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(id);
	}
}
