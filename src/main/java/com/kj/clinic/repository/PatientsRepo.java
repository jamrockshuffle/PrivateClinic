/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:49
 *  * @Version: PatientsRepo: 1.0
 *
 */

package com.kj.clinic.repository;

import com.kj.clinic.model.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepo extends MongoRepository<Patients, String> {
}
