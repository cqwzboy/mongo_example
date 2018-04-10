package org.springframework.mongodb.entity;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 * 店铺，测试Mongo对地理坐标的支持
 * */
public class Store {

    private String id;
    private GeoJsonPoint location;

    public Store(){}

    public Store(GeoJsonPoint location){
        this.location = location;
    }

    public  Store(String id, GeoJsonPoint location){
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Store{");
        sb.append("id='").append(id).append('\'');
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}
