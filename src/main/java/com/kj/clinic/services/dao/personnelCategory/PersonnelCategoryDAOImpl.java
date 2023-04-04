/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:47
 *  * @Version: PersonnelCategoryDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.personnelCategory;

import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.model.Qualification;
import com.kj.clinic.repository.PersonnelCategoryRepo;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonnelCategoryDAOImpl implements IPersonnelCategoryDAO {

    @Autowired
    PersonnelCategoryRepo repository;

    @Override
    public List<PersonnelCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public PersonnelCategory findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PersonnelCategory> deleteById(String id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    @Override
    public PersonnelCategory create(PersonnelCategoryDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        PersonnelCategory obj = new PersonnelCategory();
        obj.setId(id);
        obj.setName(dtoObj.getName());

        repository.save(obj);
        return obj;
    }

    @Override
    public PersonnelCategory update(PersonnelCategoryDTOUpdate dtoObj) {

        PersonnelCategory obj = new PersonnelCategory();
        obj.setId(repository.findById(dtoObj.getId()).get().getId());
        obj.setName(dtoObj.getName());

        repository.save(obj);

        return obj;
    }
}
