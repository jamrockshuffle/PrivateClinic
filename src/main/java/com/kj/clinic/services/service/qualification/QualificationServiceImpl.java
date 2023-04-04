/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:07
 *  * @Version: QualificationsServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.qualification;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.services.dao.qualification.QualificationDAOImpl;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QualificationServiceImpl implements IQualificationService {

    @Autowired
    QualificationDAOImpl dao;

    @Override
    public List<Qualification> findAll() {
        return dao.findAll();
    }

    @Override
    public Qualification findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Qualification> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Qualification create(QualificationDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public Qualification update(QualificationDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
