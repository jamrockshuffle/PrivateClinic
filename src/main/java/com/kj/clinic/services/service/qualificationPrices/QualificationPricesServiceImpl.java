/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 13:11
 *  * @Version: QualificationPricesServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.qualificationPrices;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.services.dao.qualificationPrices.QualificationPricesDAOImpl;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QualificationPricesServiceImpl implements IQualificationPricesService{

    @Autowired
    QualificationPricesDAOImpl dao;

    @Override
    public List<QualificationPrices> findAll() {
        return dao.findAll();
    }

    @Override
    public QualificationPrices findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<QualificationPrices> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public QualificationPrices create(QualificationPricesDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public QualificationPrices update(QualificationPricesDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
