package br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.services;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.model.Person;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.exception.ResourceNotFoundException;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PersonService.class);
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public Person findById(long id) {
        log.info("Finding a person by id: " + id);
        return personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        log.info("Creating a new person!");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        log.info("Update a person!");

        Person entity = personRepository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }
    public void delete(long id) {
        log.info("Delete a person!");
        Person entity = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));
        personRepository.delete(entity);
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
