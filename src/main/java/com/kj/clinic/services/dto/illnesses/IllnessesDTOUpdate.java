/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 04.05.23, 14:02
 *  * @Version: IllnessesDTOUpdate: 1.0
 *
 */

package com.kj.clinic.services.dto.illnesses;

public class IllnessesDTOUpdate {

    private String id;
    private String name;

    public IllnessesDTOUpdate() {
    }

    public IllnessesDTOUpdate(String id, String name) {
        this.id = id;
        this.name = name;
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
}



