/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.03.23, 11:50
 *  * @Version: ResultsRepo: 1.0
 *
 */

package com.kj.clinic.repository;

import com.kj.clinic.model.Results;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepo extends MongoRepository<Results, String> {
}
