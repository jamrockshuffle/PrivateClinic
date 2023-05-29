/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 12:41
 *  * @Version: QualificationPricesDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.qualificationPrices;

import com.kj.clinic.model.Illnesses;
import com.kj.clinic.model.Qualification;
import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.repository.QualificationPricesRepo;
import com.kj.clinic.repository.QualificationRepo;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class QualificationPricesDAOImpl implements IQualificationPricesDAO{

    @Autowired
    QualificationPricesRepo qualificationPricesRepo;

    @Autowired
    QualificationRepo qualificationRepo;

    public Qualification getByQualification(String name) {
        return qualificationRepo.findAll().stream()
                .filter(item -> item.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<QualificationPrices> findAll() {
        return qualificationPricesRepo.findAll();
    }

    @Override
    public QualificationPrices findById(String id) {
        return qualificationPricesRepo.findById(id).orElse(null);
    }

    @Override
    public List<QualificationPrices> deleteById(String id) {
        qualificationPricesRepo.deleteById(id);
        return qualificationPricesRepo.findAll();
    }

    @Override
    public QualificationPrices create(QualificationPricesDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        QualificationPrices obj = new QualificationPrices();
        obj.setId(id);
        obj.setName(dtoObj.getName());
        obj.setQualification(qualificationRepo.findById(dtoObj.getQualification()).get());
        obj.setPrice(new BigDecimal(dtoObj.getPrice()));

        qualificationPricesRepo.save(obj);
        return obj;
    }

    @Override
    public QualificationPrices update(QualificationPricesDTOUpdate dtoObj) {

        QualificationPrices obj = new QualificationPrices();
        obj.setId(qualificationPricesRepo.findById(dtoObj.getId()).get().getId());
        obj.setName(dtoObj.getName());
        obj.setQualification(qualificationRepo.findById(dtoObj.getQualification()).get());
        obj.setPrice(new BigDecimal(dtoObj.getPrice()));

        qualificationPricesRepo.save(obj);

        return obj;
    }

    @Override
    public QualificationPrices createUI(QualificationPricesDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        QualificationPrices obj = new QualificationPrices();
        obj.setId(id);
        obj.setName(dtoObj.getName());
        obj.setQualification(getByQualification(dtoObj.getQualification()));
        obj.setPrice(new BigDecimal(dtoObj.getPrice()));

        qualificationPricesRepo.save(obj);
        return obj;
    }

    @Override
    public QualificationPrices updateUI(QualificationPricesDTOUpdate dtoObj) {

        QualificationPrices obj = new QualificationPrices();
        obj.setId(qualificationPricesRepo.findById(dtoObj.getId()).get().getId());
        obj.setName(dtoObj.getName());
        obj.setQualification(getByQualification(dtoObj.getQualification()));
        obj.setPrice(new BigDecimal(dtoObj.getPrice()));

        qualificationPricesRepo.save(obj);

        return obj;
    }
}
