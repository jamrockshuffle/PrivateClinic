/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 04.05.23, 14:05
 *  * @Version: QualificationPricesDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.qualificationPrices;

public class QualificationPricesDTOCreate {

    private String name;
    private String qualification;
    private String price;

    public QualificationPricesDTOCreate() {
    }

    public QualificationPricesDTOCreate(String name, String qualification, String price) {
        this.name = name;
        this.qualification = qualification;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
