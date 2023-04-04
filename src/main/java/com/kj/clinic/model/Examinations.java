/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:33
 *  * @Version: Examinations: 1.0
 *
 */

package com.kj.clinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("Examinations")
public class Examinations {

    @Id
    private String id;

    private Patients patient;
    private Personnel doctor;
    private LocalDateTime examinationTime;
    private BigDecimal price;

    public Examinations() {
    }

    public Examinations(String id, Patients patient, Personnel doctor, LocalDateTime examinationTime, BigDecimal price) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.examinationTime = examinationTime;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Personnel getDoctor() {
        return doctor;
    }

    public void setDoctor(Personnel doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getExaminationTime() {
        return examinationTime;
    }

    public void setExaminationTime(LocalDateTime examinationTime) {
        this.examinationTime = examinationTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Examinations{" +
                "id='" + id + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", examinationTime=" + examinationTime +
                ", price=" + price +
                '}';
    }
}
