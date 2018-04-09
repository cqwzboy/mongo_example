package org.springframework.mongodb;

import com.mongodb.MongoClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mongodb.entity.Person;

import java.net.UnknownHostException;

public class MainTest {

    private static final Log log = LogFactory.getLog(MainTest.class);

    public static void main(String[] args) throws UnknownHostException {

        MongoOperations operations = new MongoTemplate(new MongoClient("192.168.1.105", 27017), "stu");
//        operations.insert(new Person(102L, "王麻子", 12));

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("王麻子"));
        System.out.println(operations.findOne(query, Person.class));

    }

}
