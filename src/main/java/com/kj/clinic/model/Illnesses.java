/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 04.05.23, 12:37
 *  * @Version: Illnesses: 1.0
 *
 */

package com.kj.clinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Illnesses")
public class Illnesses {

    @Id
    private String id;

    private String name;

    public Illnesses() {
    }

    public Illnesses(String id, String name) {
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
        return "Illnesses{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

