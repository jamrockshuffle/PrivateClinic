/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: ExaminationsDTOCreate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:55
 *  * @Version: ExaminationsDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.examinations;

import com.kj.clinic.model.Patients;
import com.kj.clinic.model.Personnel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExaminationsDTOCreate {

    private String patient;
    private String doctor;
    private String examinationTime;
    private String price;

    public ExaminationsDTOCreate() {
    }

    public ExaminationsDTOCreate(String patient, String doctor, String examinationTime, String price) {
        this.patient = patient;
        this.doctor = doctor;
        this.examinationTime = examinationTime;
        this.price = price;
    }

    public ExaminationsDTOCreate(String patient, String doctor, String examinationTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.examinationTime = examinationTime;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
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
}
