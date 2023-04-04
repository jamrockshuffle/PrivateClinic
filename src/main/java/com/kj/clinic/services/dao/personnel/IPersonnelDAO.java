/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:31
 *  * @Version: IPersonnelDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.personnel;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.services.dto.personnel.PersonnelDTOCreate;
import com.kj.clinic.services.dto.personnel.PersonnelDTOUpdate;

import java.util.List;

public interface IPersonnelDAO {
    List<Personnel> findAll();
    Personnel findById(String id);
    List<Personnel> deleteById (String id);
    Personnel create (PersonnelDTOCreate dtoObj);
    Personnel update (PersonnelDTOUpdate dtoObj);
}
