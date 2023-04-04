/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: PersonnelDTOCreate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:58
 *  * @Version: PersonnelDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.personnel;

import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.model.Qualification;

public class PersonnelDTOCreate {

    private String name;
    private String qualification;
    private String personnelCategory;

    public PersonnelDTOCreate() {
    }

    public PersonnelDTOCreate(String name, String qualification, String personnelCategory) {
        this.name = name;
        this.qualification = qualification;
        this.personnelCategory = personnelCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPersonnelCategory() {
        return personnelCategory;
    }

    public void setPersonnelCategory(String personnelCategory) {
        this.personnelCategory = personnelCategory;
    }

}
