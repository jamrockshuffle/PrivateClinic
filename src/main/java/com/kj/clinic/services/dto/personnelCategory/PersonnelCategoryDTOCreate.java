/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: PersonnelCategoryDTOCreate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 12:48
 *  * @Version: PersonnelCategoryDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.personnelCategory;

public class PersonnelCategoryDTOCreate {

    private String name;

    public PersonnelCategoryDTOCreate() {
    }

    public PersonnelCategoryDTOCreate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
