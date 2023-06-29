package com.gorvat.pp_3_1_2_spring_boot.dao;



import com.gorvat.pp_3_1_2_spring_boot.model.Person;

import java.util.List;

public interface PersonDao {
     void addPerson(Person person);

     void updatePerson(int id, Person person);

     void removePerson(int id);

     Person getPersonById(int id);

    List<Person> getAllPeople();
}
