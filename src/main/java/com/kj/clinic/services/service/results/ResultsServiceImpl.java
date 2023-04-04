/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:07
 *  * @Version: ResultsServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.results;

import com.kj.clinic.model.Results;
import com.kj.clinic.services.dao.results.ResultsDAOImpl;
import com.kj.clinic.services.dto.results.ResultsDTOCreate;
import com.kj.clinic.services.dto.results.ResultsDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResultsServiceImpl implements IResultsService{

    @Autowired
    ResultsDAOImpl dao;

    @Override
    public List<Results> findAll() {
        return dao.findAll();
    }

    @Override
    public Results findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Results> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Results create(ResultsDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public Results update(ResultsDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
