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

@Document("Results")
public class Results {

    @Id
    private String id;

    private Patients patient;
    private LocalDate examinationDate;
    private String prescription;

    public Results() {
    }

    public Results(String id, Patients patient, LocalDate examinationDate, String prescription) {
        this.id = id;
        this.patient = patient;
        this.examinationDate = examinationDate;
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

    public LocalDate getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(LocalDate examinationDate) {
        this.examinationDate = examinationDate;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Results{" +
                "id='" + id + '\'' +
                ", patient=" + patient +
                ", examinationDate=" + examinationDate +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}
