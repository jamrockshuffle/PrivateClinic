/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 13:08
 *  * @Version: IllnessesServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.illnesses;

import com.kj.clinic.model.Illnesses;
import com.kj.clinic.model.Qualification;
import com.kj.clinic.services.dao.illnesses.IllnessesDAOImpl;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IllnessesServiceImpl implements IIllnessesService{

    @Autowired
    IllnessesDAOImpl dao;

    @Override
    public List<Illnesses> findAll() {
        return dao.findAll();
    }

    @Override
    public Illnesses findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Illnesses> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Illnesses create(IllnessesDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public Illnesses update(IllnessesDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
