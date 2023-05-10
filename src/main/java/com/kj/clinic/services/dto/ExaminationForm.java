/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 09.05.23, 22:45
 *  * @Version: ExaminationForm: 1.0
 *
 */

package com.kj.clinic.services.dto;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.model.QualificationPrices;

import java.time.LocalDateTime;

public class ExaminationForm {

    private String firstName;
    private String lastName;
    private String qualification;
    private String doctor;
    private String qualificationPrice;
    private String examinationTime;

    public ExaminationForm() {
    }

    public ExaminationForm(String firstName, String lastName, String qualification, String doctor, String qualificationPrice, String examinationTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.doctor = doctor;
        this.qualificationPrice = qualificationPrice;
        this.examinationTime = examinationTime;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getQualificationPrice() {
        return qualificationPrice;
    }

    public void setQualificationPrice(String qualificationPrice) {
        this.qualificationPrice = qualificationPrice;
    }

    public String getExaminationTime() {
        return examinationTime;
    }

    public void setExaminationTime(String examinationTime) {
        this.examinationTime = examinationTime;
    }

    @Override
    public String toString() {
        return "ExaminationForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", qualification='" + qualification + '\'' +
                ", doctor='" + doctor + '\'' +
                ", qualificationPrice='" + qualificationPrice + '\'' +
                ", examinationTime='" + examinationTime + '\'' +
                '}';
    }
}
