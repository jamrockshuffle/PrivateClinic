/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:49
 *  * @Version: ExaminationsRepo: 1.0
 *
 */

package com.kj.clinic.repository;

import com.kj.clinic.model.Examinations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationsRepo extends MongoRepository<Examinations, String> {
}
