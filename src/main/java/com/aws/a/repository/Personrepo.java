   package com.aws.a.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.aws.a.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Personrepo {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Person save(Person person) {
        dynamoDBMapper.save(person);
        return person;
    }

    public Person getPersonById(String aadharid) {
        return dynamoDBMapper.load(Person.class, aadharid);
    }

    public String delete(String aadharid) {
        Person person = dynamoDBMapper.load(Person.class, aadharid);
        dynamoDBMapper.delete(person);
        return "Person Deleted!";
    }

    public String update(String aadharid, Person person) {
        dynamoDBMapper.save(person,
                new DynamoDBSaveExpression()
        .withExpectedEntry("aadharid",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(aadharid)
                )));
        return aadharid;
    }
}