/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:39
 *  * @Version: QualificationDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.qualification;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.model.Results;
import com.kj.clinic.repository.QualificationRepo;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class QualificationDAOImpl implements IQualificationDAO {

    @Autowired
    QualificationRepo repository;

    @Override
    public List<Qualification> findAll() {
        return repository.findAll();
    }

    @Override
    public Qualification findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Qualification> deleteById(String id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    @Override
    public Qualification create(QualificationDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        Qualification obj = new Qualification();
        obj.setId(id);
        obj.setName(dtoObj.getName());

        repository.save(obj);
        return obj;
    }

    @Override
    public Qualification update(QualificationDTOUpdate dtoObj) {

        Qualification obj = new Qualification();
        obj.setId(repository.findById(dtoObj.getId()).get().getId());
        obj.setName(dtoObj.getName());

        repository.save(obj);

        return obj;
    }
}
