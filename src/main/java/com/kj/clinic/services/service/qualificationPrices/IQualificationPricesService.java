/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 13:11
 *  * @Version: IQualificationPricesService: 1.0
 *
 */

package com.kj.clinic.services.service.qualificationPrices;

import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOUpdate;

import java.util.List;

public interface IQualificationPricesService {

    List<QualificationPrices> findAll();
    QualificationPrices findById(String id);
    List<QualificationPrices> deleteById (String id);
    QualificationPrices create (QualificationPricesDTOCreate dtoObj);
    QualificationPrices update (QualificationPricesDTOUpdate dtoObj);
    QualificationPrices createUI (QualificationPricesDTOCreate dtoObj);
    QualificationPrices updateUI (QualificationPricesDTOUpdate dtoObj);
}
