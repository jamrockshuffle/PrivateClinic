/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:31
 *  * @Version: Personnel: 1.0
 *
 */

package com.kj.clinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Personnel")
public class Personnel {

    @Id
    private String id;

    private String name;
    private Qualification qualification;
    private PersonnelCategory personnelCategory;

    public Personnel() {
    }

    public Personnel(String id, String name, Qualification qualification, PersonnelCategory personnelCategory) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.personnelCategory = personnelCategory;
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

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public PersonnelCategory getPersonnelCategory() {
        return personnelCategory;
    }

    public void setPersonnelCategory(PersonnelCategory personnelCategory) {
        this.personnelCategory = personnelCategory;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", qualification=" + qualification +
                ", personnelCategory=" + personnelCategory +
                '}';
    }
}
