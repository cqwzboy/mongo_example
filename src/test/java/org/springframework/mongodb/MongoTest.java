package org.springframework.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mongodb.entity.Person;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mongodb.xml"})
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test(){
//        mongoTemplate.insert(new Person(103L, "哈哈", 234));
        Person person = mongoTemplate.findOne(new Query(Criteria.where("name").is("哈哈")), Person.class);
        System.out.println(person);
    }

}
