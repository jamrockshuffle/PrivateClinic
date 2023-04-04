/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:08
 *  * @Version: IResultsService: 1.0
 *
 */

package com.kj.clinic.services.service.results;

import com.kj.clinic.model.Results;
import com.kj.clinic.services.dto.results.ResultsDTOCreate;
import com.kj.clinic.services.dto.results.ResultsDTOUpdate;

import java.util.List;

public interface IResultsService {
    List<Results> findAll();
    Results findById(String id);
    List<Results> deleteById (String id);
    Results create (ResultsDTOCreate dtoObj);
    Results update (ResultsDTOUpdate dtoObj);
}
