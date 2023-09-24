package com.data.repositories;

import com.data.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Person p SET p.age = :age, p.email = :email, p.name = :name WHERE p.id = :id")
    int updatePersonInfoById(int id, Person person);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Person WHERE id = :id", nativeQuery = true)
    void deletePersonById(int id);
}
