package com.gorvat.pp_3_1_2_spring_boot.service;

import com.gorvat.pp_3_1_2_spring_boot.model.Person;
import com.gorvat.pp_3_1_2_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addPerson(Person person) {
        repository.save(person);
    }

    @Override
    public void updatePerson(int id, Person person) {
        person.setId(id);
        repository.save(person);
    }

    @Override
    public void removePerson(int id) {
        repository.deleteById(id);
    }

    @Override
    public Person getPersonById(int id) {
        Optional<Person> person = repository.findById(id); //  getReferenceById
        return person.orElse(null);
    }

    @Override
    public List<Person> getAllPeople() {
        return repository.findAll();
    }
}

//    private final PersonDao personDao;
//
//@Autowired
//    public PersonServiceImpl(PersonDao personDao) {
//        this.personDao = personDao;
//    }
//
//    @Override
//    @Transactional
//    public void addPerson(Person person) {
//        personDao.addPerson(person);
//    }
//
//    @Override
//    @Transactional
//    public void updatePerson(int id, Person person) {
//        personDao.updatePerson(id, person);
//    }
//
//    @Override
//    @Transactional
//    public void removePerson(int id) {
//        personDao.removePerson(id);
//    }
//
//    @Override
//    public Person getPersonById(int id) {
//        return personDao.getPersonById(id);
//    }
//
//    @Override
//    public List<Person> getAllPeople() {
//        return personDao.getAllPeople();
//    }

