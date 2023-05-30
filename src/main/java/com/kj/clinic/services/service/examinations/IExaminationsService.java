/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:06
 *  * @Version: IExaminationsService: 1.0
 *
 */

package com.kj.clinic.services.service.examinations;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;

import java.util.List;

public interface IExaminationsService {
    List<Examinations> findAll();
    Examinations findById(String id);
    List<Examinations> deleteById (String id);
    Examinations create (ExaminationsDTOCreate dtoObj);
    Examinations update (ExaminationsDTOUpdate dtoObj);
    Examinations createUI (ExaminationsDTOCreate dtoObj);
    Examinations updateUI (ExaminationsDTOUpdate dtoObj);
}
