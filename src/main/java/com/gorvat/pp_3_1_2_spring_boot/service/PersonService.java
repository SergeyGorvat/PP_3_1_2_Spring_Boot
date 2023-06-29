package com.gorvat.pp_3_1_2_spring_boot.service;



import com.gorvat.pp_3_1_2_spring_boot.model.Person;

import java.util.List;

public interface PersonService {

     void addPerson(Person person);

     void updatePerson(int id, Person person);

     void removePerson(int id);

     Person getPersonById(int id);

    List<Person> getAllPeople();
}
