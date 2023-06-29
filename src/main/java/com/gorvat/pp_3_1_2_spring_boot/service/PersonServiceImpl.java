package com.gorvat.pp_3_1_2_spring_boot.service;


import com.gorvat.pp_3_1_2_spring_boot.dao.PersonDao;
import com.gorvat.pp_3_1_2_spring_boot.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(int id, Person person) {
        personDao.updatePerson(id, person);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        personDao.removePerson(id);
    }

    @Override
    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    @Override
    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }
}
