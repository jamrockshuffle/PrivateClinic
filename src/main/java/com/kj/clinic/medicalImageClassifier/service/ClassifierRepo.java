/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:49
 *  * @Version: ClassifierRepo: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:41
 *  * @Version: ClassifierRepo: 1.0
 *
 */

package com.kj.clinic.medicalImageClassifier.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifierRepo extends MongoRepository<ClassifierTable, String> {
    void deleteByFilename(String username);
}
