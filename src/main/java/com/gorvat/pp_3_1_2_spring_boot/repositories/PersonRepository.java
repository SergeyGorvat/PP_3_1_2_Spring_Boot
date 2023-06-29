package com.gorvat.pp_3_1_2_spring_boot.repositories;

import com.gorvat.pp_3_1_2_spring_boot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
