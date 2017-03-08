package com.kosta.example.person.service;

import com.kosta.example.person.domain.Person;
import com.kosta.example.person.store.PersonStoreLogic;

public class PersonServiceLogic {

	
	private PersonStoreLogic store;
	
	public PersonServiceLogic(){
		store = new PersonStoreLogic();
	}
	
	public Person getPerson(String name){
		
		return store.getPerson(name);
	}
}
