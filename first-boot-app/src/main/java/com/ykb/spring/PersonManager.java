package com.ykb.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PersonManager {

    private final Map<String, Person> personMap = new HashMap<>();

    public void addPerson(final Person person) {
        this.personMap.put(person.getName(),
                           person);
    }

    public Person getPerson(final String name) {
        return this.personMap.get(name);
    }

    public Person deletePerson(final String name) {
        return this.personMap.remove(name);
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(this.personMap.values());
    }
}
