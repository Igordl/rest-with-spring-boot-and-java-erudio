package br.com.erudio.rest_with_spring_boot_and_java_erudio.mapper;


import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.data.vo.v2.PersonVOV2;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonMapper {

    public PersonVOV2 toPresentation(Person person) {
        PersonVOV2 presentation = new PersonVOV2();
        presentation.setId(person.getId());
        presentation.setFirstName(person.getFirstName());
        presentation.setLastName(person.getLastName());
        presentation.setAddress(person.getAddress());
        presentation.setGender(person.getGender());
        presentation.setBirthday(new Date());
        return presentation;
    }
    public List<PersonVOV2> toListPresentation(List<Person> persons) {
        List<PersonVOV2> presentations = new ArrayList<>();
        for (Person person : persons) {
            presentations.add(toPresentation(person));
        }
        return presentations;
    }

    public Person toModel(PersonVOV2 personVO) {
        Person person = new Person();
        person.setId(personVO.getId());
        person.setFirstName(personVO.getFirstName());
        person.setLastName(personVO.getLastName());
        person.setAddress(personVO.getAddress());
        person.setGender(personVO.getGender());
        return person;
    }
}
