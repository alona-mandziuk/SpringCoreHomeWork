package servicesTest;

import com.data.models.Person;
import com.data.repositories.PeopleRepository;
import com.data.services.PeopleServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PeopleServicesTest {
    @Mock
    private PeopleRepository peopleRepository;
    @InjectMocks
    private PeopleServices peopleServices;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        peopleServices = new PeopleServices(peopleRepository);
    }

    @Test
    public void findAllTest() {
        var person1 = new Person();
        person1.setId(1);
        person1.setAge(15);
        person1.setName("John Doe");
        person1.setEmail("jonhdoe@gmail.com");
        var person2 = new Person();
        person2.setId(2);
        person2.setAge(16);
        person2.setName("Jane Doe");
        person2.setEmail("janedoe@gmail.com");

        List<Person> people = Arrays.asList(person1, person2);
        when(peopleRepository.findAll()).thenReturn(people);

        List<Person> result = peopleServices.findAll();
        assertEquals(2, result.size());
        assertEquals(person1, result.get(0));
        assertEquals(person2, result.get(1));

    }

    @Test
    public void findByIdTest() {
        var person = new Person();
        person.setId(1);
        person.setAge(15);
        person.setName("John Doe");
        person.setEmail("jonhdoe@gmail.com");

        when(peopleRepository.findById(1)).thenReturn(Optional.of(person));

        var result = peopleServices.findById(1);

        assertNotNull(result);
        assertEquals(person, result);
    }

    @Test
    public void deletePersonByIdTest() {
        peopleServices.deletePersonById(2);
        verify(peopleRepository, times(1)).deletePersonById(2);
    }

    @Test
    public void updatePersonByIdTest() {
        var updatedPerson = new Person();
        updatedPerson.setId(1);
        updatedPerson.setAge(18);
        updatedPerson.setName("Updated John Doe");
        updatedPerson.setEmail("updatedjohndoe@gmail.com");

        peopleServices.updatePersonById(1, updatedPerson);
        verify(peopleRepository, times(1))
                .updatePersonInfoById(1, updatedPerson.getAge(), updatedPerson.getEmail(),
                        updatedPerson.getName());
    }

    @Test
    public void deletePersonByInvalidId() {
        assertThrows(Exception.class, () -> peopleServices.deletePersonById(0));
    }

    @Test
    public void updatePersonByIdWithNullPerson() {
        assertThrows(NullPointerException.class,
                () -> peopleServices.updatePersonById(1, null));
    }
}
