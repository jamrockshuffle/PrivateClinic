/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:36
 *  * @Version: PersonnelDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.personnel;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.repository.PersonnelCategoryRepo;
import com.kj.clinic.repository.PersonnelRepo;
import com.kj.clinic.repository.QualificationRepo;
import com.kj.clinic.services.dto.personnel.PersonnelDTOCreate;
import com.kj.clinic.services.dto.personnel.PersonnelDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonnelDAOImpl implements IPersonnelDAO{

    @Autowired
    PersonnelRepo personnelRepo;

    @Autowired
    PersonnelCategoryRepo personnelCategoryRepo;

    @Autowired
    QualificationRepo qualificationRepo;

    @Override
    public List<Personnel> findAll() {
        return personnelRepo.findAll();
    }

    @Override
    public Personnel findById(String id) {
        return personnelRepo.findById(id).orElse(null);
    }

    @Override
    public List<Personnel> deleteById(String id) {
        personnelRepo.deleteById(id);
        return personnelRepo.findAll();
    }

    @Override
    public Personnel create(PersonnelDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        Personnel obj = new Personnel();
        obj.setId(id);
        obj.setName(dtoObj.getName());
        obj.setQualification(qualificationRepo.findById(dtoObj.getQualification()).get());
        obj.setPersonnelCategory(personnelCategoryRepo.findById(dtoObj.getPersonnelCategory()).get());

        personnelRepo.save(obj);
        return obj;
    }

    @Override
    public Personnel update(PersonnelDTOUpdate dtoObj) {
        Personnel obj = new Personnel();
        obj.setId(personnelRepo.findById(dtoObj.getId()).get().getId());
        obj.setName(dtoObj.getName());
        obj.setQualification(qualificationRepo.findById(dtoObj.getQualification()).get());
        obj.setPersonnelCategory(personnelCategoryRepo.findById(dtoObj.getPersonnelCategory()).get());

        personnelRepo.save(obj);

        return obj;
    }
}
