package com.kosta.example.person.store;

import java.util.ArrayList;

import com.kosta.example.person.domain.Person;

public class PersonStoreLogic {
	
	private ArrayList<Person> list;
	
	public PersonStoreLogic(){
		list = new ArrayList<>();
		
		list.add(new Person("정택진",27,"서울 관악구"));
		list.add(new Person("이소영",26,"서울 관악구"));
		list.add(new Person("김진원",25,"서울 관악구"));
		list.add(new Person("강민기",24,"서울 관악구"));
	}
	
	public Person getPerson(String name){
		Person person = null;
		for(Person p : list){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return person;
	}

	
}
