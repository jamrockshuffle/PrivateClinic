/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:16
 *  * @Version: QualificationDTOCreate: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 12:49
 *  * @Version: QualificationDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.qualification;

public class QualificationDTOCreate {

    private String name;

    public QualificationDTOCreate() {
    }

    public QualificationDTOCreate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
