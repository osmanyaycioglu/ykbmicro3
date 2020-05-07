package com.ykb.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/personext")
public class PersonRestExt {

    @Autowired
    @Qualifier("osman")
    private PersonManager       pm;

    private final PersonManager pm2;

    @Autowired
    public PersonRestExt(@Qualifier("osman") final PersonManager pmParam) {
        this.pm2 = pmParam;
        //  this.pm.getAllPersons(); null pointer
    }

    @Autowired
    public void xyz(@Qualifier("osman") final PersonManager pm3) {

    }

    @PostConstruct
    public void name() {
        this.pm.getAllPersons();
    }

    @PostMapping("/add")
    @ApiOperation(notes = "test notes", value = "value test")
    @ApiResponses({
                    @ApiResponse(code = 800, message = "Error oluştuğunda döner"),
                    @ApiResponse(code = 801, message = "xyz Error oluştuğunda döner")
    })
    public String addPerson(@RequestBody final Person personParam) {
        this.pm.addPerson(personParam);
        return "OK";
    }

    @PostMapping("/update")
    public String updatePerson(@RequestBody final Person personParam) {
        this.pm.addPerson(personParam);
        return "OK";
    }

    @GetMapping("/get")
    public String getPerson(@RequestParam("name") final String nameParam) {
        this.pm.getPerson(nameParam);
        return "OK";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("name") final String nameParam) {
        this.pm.deletePerson(nameParam);
        return "OK";
    }


}
