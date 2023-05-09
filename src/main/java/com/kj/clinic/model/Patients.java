/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:27
 *  * @Version: Patients: 1.0
 *
 */

package com.kj.clinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("Patients")
public class Patients {

    @Id
    private String id;

    private String name;
    private LocalDate birthday;
    private String phone;
    private String email;
    private Illnesses illnesses;
    private String category;
    private String username;

    public Patients() {
    }

    public Patients(String id, String name, LocalDate birthday, String phone, String email, Illnesses illnesses, String category, String username) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.illnesses = illnesses;
        this.category = category;
        this.username = username;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Illnesses getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(Illnesses illnesses) {
        this.illnesses = illnesses;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", illnesses='" + illnesses + '\'' +
                ", category='" + category + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
