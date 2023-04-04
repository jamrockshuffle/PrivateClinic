/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: PersonnelDTOUpdate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:56
 *  * @Version: PersonnelDTOUpdate: 1.0
 *
 */

package com.kj.clinic.services.dto.personnel;

import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.model.Qualification;

public class PersonnelDTOUpdate {

    private String id;
    private String name;
    private String qualification;
    private String personnelCategory;

    public PersonnelDTOUpdate() {
    }

    public PersonnelDTOUpdate(String id, String name, String qualification, String personnelCategory) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.personnelCategory = personnelCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
