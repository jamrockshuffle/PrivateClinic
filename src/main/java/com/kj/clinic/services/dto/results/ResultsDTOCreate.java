/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: ResultsDTOCreate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 22:02
 *  * @Version: ResultsDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.results;

public class ResultsDTOCreate {

    private String patient;
    private String examinationId;
    private String examinationDate;
    private String qualification;
    private String prescription;


    public ResultsDTOCreate() {
    }

    public ResultsDTOCreate(String patient, String examinationId, String examinationDate, String qualification, String prescription) {
        this.patient = patient;
        this.examinationId = examinationId;
        this.examinationDate = examinationDate;
        this.qualification = qualification;
        this.prescription = prescription;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(String examinationDate) {
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}

