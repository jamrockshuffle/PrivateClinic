/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 30.05.23, 10:18
 *  * @Version: ExaminationFormDB: 1.0
 *
 */

package com.kj.clinic.services.dto;

import java.math.BigDecimal;

public class ExaminationFormDB {

    private String id;
    private String examinationId;
    private String firstName;
    private String lastName;
    private String qualification;
    private String doctor;
    private String qualificationPrice;
    private String examinationTime;
    private String price;
    private String status;

    public ExaminationFormDB() {
    }

    public ExaminationFormDB(String id, String examinationId, String firstName, String lastName, String qualification, String doctor, String qualificationPrice, String examinationTime, String price, String status) {
        this.id = id;
        this.examinationId = examinationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.doctor = doctor;
        this.qualificationPrice = qualificationPrice;
        this.examinationTime = examinationTime;
        this.price = price;
        this.status = status;
    }

    public ExaminationFormDB(String id, String examinationId, String firstName, String lastName, String qualification, String doctor, String qualificationPrice, String examinationTime) {
        this.id = id;
        this.examinationId = examinationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.doctor = doctor;
        this.qualificationPrice = qualificationPrice;
        this.examinationTime = examinationTime;
    }

    public ExaminationFormDB(String id, String examinationId, String firstName, String lastName, String qualification, String doctor, String qualificationPrice, String examinationTime, String status) {
        this.id = id;
        this.examinationId = examinationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.doctor = doctor;
        this.qualificationPrice = qualificationPrice;
        this.examinationTime = examinationTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
        this.examinationId = examinationId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
