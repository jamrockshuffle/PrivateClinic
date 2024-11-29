/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:49
 *  * @Version: ClassifierServiceImpl: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 31.10.24, 11:37
 *  * @Version: ClassifierService: 1.0
 *
 */

package com.kj.clinic.medicalImageClassifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public class ClassifierServiceImpl implements IClassifierService{

    @Autowired
    ClassifierRepo classifierRepo;

    @Override
    public List<ClassifierTable> findAll() {
        return classifierRepo.findAll();
    }

    @Override
    public void deleteByFilename(String filename) {
        classifierRepo.deleteByFilename(filename);
        File file = new File("src/main/java/com/kj/clinic/medicalImageClassifier/images/" + filename);
        file.delete();
    }

    @Override
    public ClassifierTable create(String username, String filename, String label) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        ClassifierTable obj = new ClassifierTable();
        obj.setId(id);
        obj.setUsername(username);
        obj.setFilename(filename);
        obj.setLabel(label);
        obj.setDiagnosis("Очікуйте підтвердження.");

        classifierRepo.save(obj);
        return obj;
    }
}
