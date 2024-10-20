package br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.services;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.model.Person;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PersonService.class);
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(long id) {
        log.info("Finding a person by id: " + id);
        return mockPerson(id);
    }

    public List<Person> findAll() {
        List<Person> listPerson = new ArrayList<>();
        for (int i = 0; i< 8; i++){
            listPerson.add(mockPerson(i));
        }
        return listPerson;
    }

    public Person create(Person person) {
        log.info("Creating a new person!");

        return person;
    }

    public Person update(Person person) {
        log.info("Update a person!");
        return person;
    }
    public void delete(String id) {
        log.info("Delete a person!");
    }

    private Person mockPerson(long id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Igor " + id);
        person.setLastName("Lucena " + id);
        person.setAddress("Campina Grande - PB " + id);
        person.setGender(id%2==0?"Male":"Female");
        return person;
    }
}
