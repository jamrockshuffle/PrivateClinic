/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:49
 *  * @Version: ClassifierTable: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:37
 *  * @Version: Classifier: 1.0
 *
 */

package com.kj.clinic.medicalImageClassifier.service;

import com.kj.clinic.model.Patients;
import com.kj.clinic.model.Personnel;
import com.kj.clinic.model.QualificationPrices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("ClassifierTable")
@Getter
@Setter
public class ClassifierTable {

    @Id
    private String id;

    private String username;
    private String filename;
    private String label;
    private String diagnosis;

    public ClassifierTable() {
    }

    public ClassifierTable(String id, String filename, String label) {
        this.id = id;
        this.filename = filename;
        this.label = label;
    }

    public ClassifierTable(String id, String username, String filename, String label) {
        this.id = id;
        this.username = username;
        this.filename = filename;
        this.label = label;
    }

    public ClassifierTable(String id, String username, String filename, String label, String diagnosis) {
        this.id = id;
        this.username = username;
        this.filename = filename;
        this.label = label;
        this.diagnosis = diagnosis;
    }
}
