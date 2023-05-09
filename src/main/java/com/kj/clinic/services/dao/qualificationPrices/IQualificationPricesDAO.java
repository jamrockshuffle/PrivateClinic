/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 12:41
 *  * @Version: IQualificationPricesDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.qualificationPrices;

import com.kj.clinic.model.Illnesses;
import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOUpdate;

import java.util.List;

public interface IQualificationPricesDAO {

    List<QualificationPrices> findAll();
    QualificationPrices findById(String id);
    List<QualificationPrices> deleteById (String id);
    QualificationPrices create (QualificationPricesDTOCreate dtoObj);
    QualificationPrices update (QualificationPricesDTOUpdate dtoObj);
}
