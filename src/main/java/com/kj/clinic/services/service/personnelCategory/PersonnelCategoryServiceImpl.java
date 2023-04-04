/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:07
 *  * @Version: PersonnelCategoryServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.personnelCategory;

import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.services.dao.personnelCategory.PersonnelCategoryDAOImpl;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonnelCategoryServiceImpl implements IPersonnelCategoryService{

    @Autowired
    PersonnelCategoryDAOImpl dao;

    @Override
    public List<PersonnelCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public PersonnelCategory findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<PersonnelCategory> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public PersonnelCategory create(PersonnelCategoryDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public PersonnelCategory update(PersonnelCategoryDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
