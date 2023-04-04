/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 22:09
 *  * @Version: IResultsDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.results;

import com.kj.clinic.model.Results;
import com.kj.clinic.services.dto.results.ResultsDTOCreate;
import com.kj.clinic.services.dto.results.ResultsDTOUpdate;

import java.util.List;

public interface IResultsDAO {
    List<Results> findAll();
    Results findById(String id);
    List<Results> deleteById (String id);
    Results create (ResultsDTOCreate dtoObj);
    Results update (ResultsDTOUpdate dtoObj);
}
