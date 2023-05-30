/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 22:06
 *  * @Version: IExaminationsDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.examinations;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;

import java.util.List;

public interface IExaminationsDAO {
    List<Examinations> findAll();
    Examinations findById(String id);
    List<Examinations> deleteById (String id);
    Examinations create (ExaminationsDTOCreate dtoObj);
    Examinations update (ExaminationsDTOUpdate dtoObj);
    Examinations createUI (ExaminationsDTOCreate dtoObj);
    Examinations updateUI (ExaminationsDTOUpdate dtoObj);
}
