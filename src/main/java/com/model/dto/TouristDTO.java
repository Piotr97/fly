package com.model.dto;

import com.model.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;


public class TouristDTO {


    public String name;
    public String lastName;
    @Enumerated(EnumType.STRING)
    public Gender gender;
    public String country;
    public Date dateOfBirth;

    public TouristDTO() {
    }


    public TouristDTO(Builder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.country = builder.country;
        this.dateOfBirth = builder.dateOfBirth;
    }


    public static class Builder {
        public String name;
        public String lastName;
        @Enumerated(EnumType.STRING)
        public Gender gender;
        public String country;
        public Date dateOfBirth;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public TouristDTO builder() {
            return new TouristDTO(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "TouristDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
