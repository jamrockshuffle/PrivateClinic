/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 09.05.23, 11:08
 *  * @Version: SignUpForm: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 09.05.23, 11:08
 *  * @Version: SignUpForm: 1.0
 *
 */

package com.kj.clinic.services.dto;

public class SignUpForm {

    private String firstName;
    private String lastName;
    private String birthday;
    private String phone;
    private String email;
    private String illnesses;
    private String username;
    private String password;

    public SignUpForm() {
    }

    public SignUpForm(String firstName, String lastName, String birthday, String phone, String email, String illnesses, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.illnesses = illnesses;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
