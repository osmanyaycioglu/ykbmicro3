package com.ykb.spring;

import java.time.ZonedDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private String        name;
    @Size(min = 3, max = 30, message = "surname 3 ila 30 uzunluğunda olamlı")
    private String        surname;
    @Max(value = 120, message = "person age 120 dan büyük olamaz")
    @Min(value = 10, message = "person age 10 dan küçük olamaz")
    private int           age;
    private ZonedDateTime currentTime;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }


    public ZonedDateTime getCurrentTime() {
        return this.currentTime;
    }


    public void setCurrentTime(final ZonedDateTime currentTimeParam) {
        this.currentTime = currentTimeParam;
    }


}
