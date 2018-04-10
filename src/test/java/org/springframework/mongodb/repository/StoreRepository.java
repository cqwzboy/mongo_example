package org.springframework.mongodb.repository;

import org.springframework.data.geo.Polygon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.mongodb.entity.Store;

import java.util.List;

public interface StoreRepository extends CrudRepository<Store, String> {

    List<Store> findByLocationWithin(Polygon polygon);

}
