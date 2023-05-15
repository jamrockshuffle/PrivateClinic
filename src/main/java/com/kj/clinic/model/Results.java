/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:39
 *  * @Version: Results: 1.0
 *
 */

package com.kj.clinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("Results")
public class Results {

    @Id
    private String id;

    private Patients patient;
    private String examinationId;
    private LocalDateTime examinationDate;
    private QualificationPrices qualification;
    private String prescription;

    public Results() {
    }

    public Results(String id, Patients patient, String examinationId, LocalDateTime examinationDate, QualificationPrices qualification, String prescription) {
        this.id = id;
        this.patient = patient;
        this.examinationId = examinationId;
        this.examinationDate = examinationDate;
        this.qualification = qualification;
        this.prescription = prescription;
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

    public LocalDateTime getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(LocalDateTime examinationDate) {
        this.examinationDate = examinationDate;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
        this.examinationId = examinationId;
    }

    public QualificationPrices getQualification() {
        return qualification;
    }

    public void setQualification(QualificationPrices qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Results{" +
                "id='" + id + '\'' +
                ", patient=" + patient +
                ", examinationId='" + examinationId + '\'' +
                ", examinationDate=" + examinationDate +
                ", qualification=" + qualification +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}
