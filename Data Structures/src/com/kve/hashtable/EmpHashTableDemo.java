package com.kve.hashtable;

public class EmpHashTableDemo {

	public static void main(String[] args) {
		EmpHashTable empHashTable = new EmpHashTable(8);
		empHashTable.add(new Emp(9, "zhang3"));
		empHashTable.add(new Emp(1, "zhang3"));
		empHashTable.add(new Emp(1, "zhang4"));
		empHashTable.add(new Emp(2, "zhang3"));
		empHashTable.add(new Emp(3, "zhang3"));
		empHashTable.list();
		empHashTable.findById(1);
	}

}
