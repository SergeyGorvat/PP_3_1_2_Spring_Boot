package com.gorvat.pp_3_1_2_spring_boot.service;

import com.gorvat.pp_3_1_2_spring_boot.model.Person;
import com.gorvat.pp_3_1_2_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        repository.save(person);
    }

    @Override
    @Transactional
    public void updatePerson(int id, Person person) {
        person.setId(id);
        repository.save(person);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Person getPersonById(int id) {
        Optional<Person> person = repository.findById(id); //  getReferenceById
        return person.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> getAllPeople() {
        return repository.findAll();
    }
}

