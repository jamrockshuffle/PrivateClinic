/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 12:18
 *  * @Version: IllnessesDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.illnesses;

import com.kj.clinic.model.Illnesses;
import com.kj.clinic.model.Qualification;
import com.kj.clinic.repository.IllnessesRepo;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IllnessesDAOImpl implements IIllnessesDAO{

    @Autowired
    IllnessesRepo illnessesRepo;

    @Override
    public List<Illnesses> findAll() {
        return illnessesRepo.findAll();
    }

    @Override
    public Illnesses findById(String id) {
        return illnessesRepo.findById(id).orElse(null);
    }

    @Override
    public List<Illnesses> deleteById(String id) {
        illnessesRepo.deleteById(id);
        return illnessesRepo.findAll();
    }

    @Override
    public Illnesses create(IllnessesDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        Illnesses obj = new Illnesses();
        obj.setId(id);
        obj.setName(dtoObj.getName());

        illnessesRepo.save(obj);
        return obj;
    }

    @Override
    public Illnesses update(IllnessesDTOUpdate dtoObj) {

        Illnesses obj = new Illnesses();
        obj.setId(illnessesRepo.findById(dtoObj.getId()).get().getId());
        obj.setName(dtoObj.getName());

        illnessesRepo.save(obj);

        return obj;
    }
}
