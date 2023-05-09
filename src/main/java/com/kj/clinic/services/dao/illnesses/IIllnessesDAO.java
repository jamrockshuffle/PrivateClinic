/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 12:17
 *  * @Version: IIllnessesDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.illnesses;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.model.Illnesses;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;

import java.util.List;

public interface IIllnessesDAO {
    List<Illnesses> findAll();
    Illnesses findById(String id);
    List<Illnesses> deleteById (String id);
    Illnesses create (IllnessesDTOCreate dtoObj);
    Illnesses update (IllnessesDTOUpdate dtoObj);
}
