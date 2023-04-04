/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:06
 *  * @Version: IPersonnelService: 1.0
 *
 */

package com.kj.clinic.services.service.personnel;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.services.dto.personnel.PersonnelDTOCreate;
import com.kj.clinic.services.dto.personnel.PersonnelDTOUpdate;

import java.util.List;

public interface IPersonnelService {
    List<Personnel> findAll();
    Personnel findById(String id);
    List<Personnel> deleteById (String id);
    Personnel create (PersonnelDTOCreate dtoObj);
    Personnel update (PersonnelDTOUpdate dtoObj);
}
