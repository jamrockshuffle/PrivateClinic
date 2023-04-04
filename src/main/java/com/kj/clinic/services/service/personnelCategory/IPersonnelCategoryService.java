/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:07
 *  * @Version: IPersonnelCategoryService: 1.0
 *
 */

package com.kj.clinic.services.service.personnelCategory;

import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOUpdate;

import java.util.List;

public interface IPersonnelCategoryService {
    List<PersonnelCategory> findAll();
    PersonnelCategory findById(String id);
    List<PersonnelCategory> deleteById (String id);
    PersonnelCategory create (PersonnelCategoryDTOCreate dtoObj);
    PersonnelCategory update (PersonnelCategoryDTOUpdate dtoObj);
}
