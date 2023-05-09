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

    private String examinationId;

    private Patients patient;
    private Personnel doctor;
    private QualificationPrices qualification;
    private LocalDateTime examinationTime;
    private BigDecimal price;

    public Examinations() {
    }

    public Examinations(String id, String examinationId, Patients patient, Personnel doctor, QualificationPrices qualification, LocalDateTime examinationTime, BigDecimal price) {
        this.id = id;
        this.examinationId = examinationId;
        this.patient = patient;
        this.doctor = doctor;
        this.qualification = qualification;
        this.examinationTime = examinationTime;
        this.price = price;
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

    public QualificationPrices getQualification() {
        return qualification;
    }

    public void setQualification(QualificationPrices qualification) {
        this.qualification = qualification;
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
                ", examinationId='" + examinationId + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", qualification=" + qualification +
                ", examinationTime=" + examinationTime +
                ", price=" + price +
                '}';
    }
}
