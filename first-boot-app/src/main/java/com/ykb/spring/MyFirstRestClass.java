package com.ykb.spring;

import java.security.Principal;
import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
//@RequestScope
//@SessionScope
//@ApplicationScope
public class MyFirstRestClass {

    public MyFirstRestClass() {
        System.out.println("ben yaratıldım : " + MyFirstRestClass.class);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Post Hello world";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "Put Hello world";
    }

    @DeleteMapping("/hello")
    public String hello4() {
        return "Delete Hello world";
    }

    @GetMapping("/hello2/{abc}/{xyz}")
    public String hello2(@PathVariable("abc") final String name,
                         @PathVariable("xyz") final String surname) {
        return "Hello world 2 " + name + " " + surname;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("abc") final String name,
                         @RequestParam("xyz") final String surname) {
        return "Hello world 3 " + name + " " + surname;
    }

    @GetMapping("/hello4/{qwe}/test")
    public String hello4(@RequestParam("abc") final String name,
                         @RequestParam("xyz") final String surname,
                         @PathVariable("qwe") final int age) {
        return "Hello world 4 " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello5/{qwe}/test")
    public String hello5(@RequestHeader("abc") final String name,
                         @RequestHeader("xyz") final String surname,
                         @PathVariable("qwe") final int age) {
        return "Hello world 5 " + name + " " + surname + " " + age;
    }

    @PostMapping("/hello6")
    public String hello6(@RequestBody final Person person) {
        return "Hello world 6 " + person.getName() + " " + person.getSurname() + " " + person.getAge();
    }

    @PostMapping("/hello7")
    public Person hello7(@RequestBody final Person person) {
        person.setAge(99);
        person.setCurrentTime(ZonedDateTime.now());
        return person;
    }

    @PostMapping("/hello8")
    public Person hello8(@RequestBody final Person person) {
        if (person.getAge() < 10) {
            throw new IllegalArgumentException("person age 10 dan küçük olamaz");
        }
        if (person.getAge() == 10) {
            throw new NullPointerException();
        }
        person.setAge(99);
        person.setCurrentTime(ZonedDateTime.now());
        return person;
    }

    @PostMapping("/hello9")
    public Person hello9(@Validated @RequestBody final Person person) {
        person.setAge(99);
        person.setCurrentTime(ZonedDateTime.now());
        return person;
    }

    @PostMapping(value = "/hello10",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              "application/xml"
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person hello10(@Validated @RequestBody final Person person) {
        person.setAge(99);
        person.setCurrentTime(ZonedDateTime.now());
        return person;
    }

    @PostMapping("/hello11")
    public Person hello11(@Validated @RequestBody final Person person,
                          final HttpServletRequest hs,
                          final Principal p) {
        person.setAge(99);
        person.setCurrentTime(ZonedDateTime.now());
        return person;
    }


}

