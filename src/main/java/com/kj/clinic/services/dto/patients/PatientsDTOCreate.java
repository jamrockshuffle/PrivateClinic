/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: PatientsDTOCreate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 12:42
 *  * @Version: PatientsDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.patients;

public class PatientsDTOCreate {

    private String name;
    private String birthday;
    private String phone;
    private String email;
    private String illnesses;
    private String category;
    private String username;

    public PatientsDTOCreate() {
    }

    public PatientsDTOCreate(String name, String birthday, String phone, String email, String illnesses, String category, String username) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.illnesses = illnesses;
        this.category = category;
        this.username = username;
    }

    public PatientsDTOCreate(String name, String birthday, String phone, String email, String illnesses, String username) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.illnesses = illnesses;
        this.username = username;
    }

    public PatientsDTOCreate(String name, String birthday, String phone, String email, String illnesses) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.illnesses = illnesses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public String getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(String illnesses) {
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
}
