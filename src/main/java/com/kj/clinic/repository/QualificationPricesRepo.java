/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 04.05.23, 14:22
 *  * @Version: QualificationPricesRepo: 1.0
 *
 */

package com.kj.clinic.repository;

import com.kj.clinic.model.QualificationPrices;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationPricesRepo extends MongoRepository<QualificationPrices, String> {
}
