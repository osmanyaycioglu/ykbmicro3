package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/person")
public class PersonRest {

    @Autowired
    @Qualifier("personManager")
    private PersonManager pm;

    @PutMapping
    public String addPerson(@RequestBody final Person personParam) {
        this.pm.addPerson(personParam);
        return "OK";
    }

    @PatchMapping
    public String updatePerson(@RequestBody final Person personParam) {
        this.pm.addPerson(personParam);
        return "OK";
    }

    @GetMapping
    public String getPerson(@RequestParam("name") final String nameParam) {
        this.pm.getPerson(nameParam);
        return "OK";
    }

    @DeleteMapping
    public String deletePerson(@RequestParam("name") final String nameParam) {
        this.pm.deletePerson(nameParam);
        return "OK";
    }


}
