/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:06
 *  * @Version: ExaminationsServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.examinations;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.services.dao.examinations.ExaminationsDAOImpl;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExaminationsServiceImpl implements IExaminationsService{

    @Autowired
    ExaminationsDAOImpl dao;

    @Override
    public List<Examinations> findAll() {
        return dao.findAll();
    }

    @Override
    public Examinations findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Examinations> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Examinations create(ExaminationsDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public Examinations update(ExaminationsDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
