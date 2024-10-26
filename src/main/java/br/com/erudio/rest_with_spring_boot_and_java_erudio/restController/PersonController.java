package br.com.erudio.rest_with_spring_boot_and_java_erudio.restController;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.data.vo.v1.PersonVO;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.model.Person;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.services.PersonService;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.mapper.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final PersonService service = new PersonService();


    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") long id) {
        return DozerMapper.map(service.findById(id), PersonVO.class);
    }
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return DozerMapper.map(service.findAll(), PersonVO.class);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO PersonVO) {
        return DozerMapper.map(service.create(
                DozerMapper.map(PersonVO, Person.class)), PersonVO.class);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO PersonVO) {
        return DozerMapper.map(service.update(DozerMapper.map(PersonVO, Person.class)), PersonVO.class);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
