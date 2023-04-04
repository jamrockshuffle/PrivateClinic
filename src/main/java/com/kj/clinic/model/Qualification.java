/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:29
 *  * @Version: Qualification: 1.0
 *
 */

package com.kj.clinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Qualification")
public class Qualification {

    @Id
    private String id;

    private String name;

    public Qualification() {
    }

    public Qualification(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
