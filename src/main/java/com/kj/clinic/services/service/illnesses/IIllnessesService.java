/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 13:08
 *  * @Version: IIllnessesService: 1.0
 *
 */

package com.kj.clinic.services.service.illnesses;

import com.kj.clinic.model.Illnesses;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;

import java.util.List;

public interface IIllnessesService {
    List<Illnesses> findAll();
    Illnesses findById(String id);
    List<Illnesses> deleteById (String id);
    Illnesses create (IllnessesDTOCreate dtoObj);
    Illnesses update (IllnessesDTOUpdate dtoObj);
}
