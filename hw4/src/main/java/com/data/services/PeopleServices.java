package com.data.services;

import com.data.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.data.repositories.PeopleRepository;

import java.util.List;


@Service
@Transactional
public class PeopleServices {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServices(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletePersonById(int id) {
        peopleRepository.deletePersonById(id);
    }

    public void updatePersonById(int id, Person person) {
        peopleRepository.updatePersonInfoById(id, person);
    }


}
