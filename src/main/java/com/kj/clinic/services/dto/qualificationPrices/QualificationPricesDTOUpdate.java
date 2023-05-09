/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 04.05.23, 14:05
 *  * @Version: QualificationPricesDTOUpdate: 1.0
 *
 */

package com.kj.clinic.services.dto.qualificationPrices;

import com.kj.clinic.model.Qualification;

import java.math.BigDecimal;

public class QualificationPricesDTOUpdate {

    private String id;
    private String name;
    private String qualification;
    private String price;

    public QualificationPricesDTOUpdate() {
    }

    public QualificationPricesDTOUpdate(String id, String name, String qualification, String price) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
