/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: ExaminationsDTOUpdate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:55
 *  * @Version: ExaminationsDTOUpdate: 1.0
 *
 */

package com.kj.clinic.services.dto.examinations;

import com.kj.clinic.model.Patients;
import com.kj.clinic.model.Personnel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExaminationsDTOUpdate {

    private String id;
    private String examinationId;
    private String patient;
    private String doctor;
    private String qualification;
    private String examinationTime;
    private String price;
    private String status;

    public ExaminationsDTOUpdate() {
    }

    public ExaminationsDTOUpdate(String id, String examinationId, String patient, String doctor, String qualification, String examinationTime, String price) {
        this.id = id;
        this.examinationId = examinationId;
        this.patient = patient;
        this.doctor = doctor;
        this.qualification = qualification;
        this.examinationTime = examinationTime;
        this.price = price;
    }

    public ExaminationsDTOUpdate(String id, String examinationId, String patient, String doctor, String qualification, String examinationTime, String price, String status) {
        this.id = id;
        this.examinationId = examinationId;
        this.patient = patient;
        this.doctor = doctor;
        this.qualification = qualification;
        this.examinationTime = examinationTime;
        this.price = price;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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
