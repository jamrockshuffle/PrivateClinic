/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:47
 *  * @Version: IPersonnelCategoryDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.personnelCategory;

import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOUpdate;

import java.util.List;

public interface IPersonnelCategoryDAO {
    List<PersonnelCategory> findAll();
    PersonnelCategory findById(String id);
    List<PersonnelCategory> deleteById (String id);
    PersonnelCategory create (PersonnelCategoryDTOCreate dtoObj);
    PersonnelCategory update (PersonnelCategoryDTOUpdate dtoObj);
}
