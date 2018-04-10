package org.springframework.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.mongodb.entity.Person;
import org.springframework.mongodb.entity.Store;
import org.springframework.mongodb.repository.StoreRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mongodb.xml"})
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void test(){
//        mongoTemplate.save(new Person(108L, "哈哈", 234));
//        Person person = mongoTemplate.findOne(new Query(Criteria.where("name").is("哈哈")), Person.class);
        /*Person person = mongoTemplate.findOne(query(where("name").is("哈哈")), Person.class);
        System.out.println(person);*/

        // update
        /*Query query = query(where("name").is("哈哈"));
        Update update = new Update().inc("age", 1);
        Person person1 = mongoTemplate.findAndModify(query, update, Person.class);
        System.out.println("old --> person="+person1);

        person1 = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Person.class);
        System.out.println("new --> person="+person1);*/

        // 乐观锁机制(Optimistic locking)
        // 报错：org.springframework.dao.OptimisticLockingFailureException: Optimistic lock exception on saving entity: {_class=org.springframework.mongodb.entity.Person, name=zhangsan_3, age=12, version=3} to collection per
        /*Person p1 = new Person(125L, "zhangsan_3", 12);
        mongoTemplate.insert(p1);

        Person p2 = mongoTemplate.findOne(query(where("name").is("zhangsan_3")), Person.class);

        p1.setName("zhangsan_4");
        mongoTemplate.save(p1);

        mongoTemplate.save(p2);

        Circle circle = new Circle(-73.99171, 40.738868, 0.01);*/

        // GeoJSON
//        mongoTemplate.insert(new Store(new GeoJsonPoint(1.2d, -2.4d)));
        List<Store> list = storeRepository.findByLocationWithin(
                new Polygon(
                        new Point(-10d, 100d),
                        new Point(-10d, -100d),
                        new Point(10d, 100d),
                        new Point(10d, -100d)));
        for(Store store : list){
            System.out.println(store);
        }

    }

}
