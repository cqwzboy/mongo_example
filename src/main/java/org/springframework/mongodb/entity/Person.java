package org.springframework.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @TypeAlias 控制MongoDB中的_class的值
 * @Document 打破默认的集合名称，自定义的集合名称
 * @Id 标明该字段是主键
 * @Version 乐观锁机智的版本管理字段
 *
 * */
//@TypeAlias("Per")
@Document(collection = "per")
public class Person {

    @Id
    private Long idMark;
    private String name;
    private int age;
    @Version
    private Long version;

    public Person(){}

    public Person(Long idMark, String name, int age){
        this.idMark = idMark;
        this.name = name;
        this.age = age;
    }

    public Long getIdMark() {
        return idMark;
    }

    public void setIdMark(Long idMark) {
        this.idMark = idMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("idMark=").append(idMark);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}
