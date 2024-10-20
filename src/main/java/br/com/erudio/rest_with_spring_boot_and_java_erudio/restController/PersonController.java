package br.com.erudio.rest_with_spring_boot_and_java_erudio.restController;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.model.Person;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final PersonService service = new PersonService();

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    }



}
