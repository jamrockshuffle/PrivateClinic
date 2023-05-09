/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 04.05.23, 12:47
 *  * @Version: QualificationPrices: 1.0
 *
 */

package com.kj.clinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("QualificationPrices")
public class QualificationPrices {

    @Id
    private String id;

    private String name;
    private Qualification qualification;
    private BigDecimal price;

    public QualificationPrices() {
    }

    public QualificationPrices(String id, String name, Qualification qualification, BigDecimal price) {
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

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "QualificationPrices{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", qualification=" + qualification +
                ", price=" + price +
                '}';
    }
}
