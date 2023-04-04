/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:39
 *  * @Version: IQualificationDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.qualification;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;

import java.util.List;

public interface IQualificationDAO {
    List<Qualification> findAll();
    Qualification findById(String id);
    List<Qualification> deleteById (String id);
    Qualification create (QualificationDTOCreate dtoObj);
    Qualification update (QualificationDTOUpdate dtoObj);
}
