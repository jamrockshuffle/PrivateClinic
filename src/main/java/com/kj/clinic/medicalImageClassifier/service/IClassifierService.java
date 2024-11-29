/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:49
 *  * @Version: IClassifierService: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:42
 *  * @Version: IClassifierService: 1.0
 *
 */

package com.kj.clinic.medicalImageClassifier.service;

import java.util.List;

public interface IClassifierService {

    List<ClassifierTable> findAll();
    void deleteByFilename (String filename);
    ClassifierTable create (String username, String filename, String label);
}
