/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 04.05.23, 14:02
 *  * @Version: IllnessesDTOCreate: 1.0
 *
 */

package com.kj.clinic.services.dto.illnesses;

public class IllnessesDTOCreate {

    private String name;

    public IllnessesDTOCreate() {
    }

    public IllnessesDTOCreate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
