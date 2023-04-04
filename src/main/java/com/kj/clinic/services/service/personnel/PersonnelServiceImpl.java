/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:07
 *  * @Version: PersonnelServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.personnel;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.services.dao.personnel.PersonnelDAOImpl;
import com.kj.clinic.services.dto.personnel.PersonnelDTOCreate;
import com.kj.clinic.services.dto.personnel.PersonnelDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonnelServiceImpl implements IPersonnelService {

    @Autowired
    PersonnelDAOImpl dao;

    @Override
    public List<Personnel> findAll() {
        return dao.findAll();
    }

    @Override
    public Personnel findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Personnel> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Personnel create(PersonnelDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public Personnel update(PersonnelDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
