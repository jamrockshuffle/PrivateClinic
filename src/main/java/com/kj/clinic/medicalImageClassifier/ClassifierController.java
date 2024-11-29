/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 20.08.24, 21:25
 *  * @Version: ClassifierController: 1.0
 *
 */

package com.kj.clinic.medicalImageClassifier;

import com.kj.clinic.medicalImageClassifier.service.ClassifierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class ClassifierController {

    @Autowired
    ClassifierServiceImpl service;

    private List<String> pythonScriptOutputToList(InputStream inputStream) {
        BufferedReader output = new BufferedReader(new InputStreamReader(inputStream));
        return output.lines().collect(Collectors.toList());
    }

    private List<String> predictDiagnosis(String filepath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "venv/Scripts/python.exe",
                "src/main/java/com/kj/clinic/medicalImageClassifier/classifier.py",
                filepath);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        // System.out.println(pythonScriptOutputToList(process.getInputStream()));
        return pythonScriptOutputToList(process.getInputStream());
    }

    @GetMapping("/classifier")
    public String getClassifier(SecurityContextHolderAwareRequestWrapper requestWrapper,
                                Model model,
                                @RequestParam(required = false) String diagnosis){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            if (diagnosis != null){
                model.addAttribute("diagnosis", diagnosis);
                return "a-classifierTest/classifier-diagnosis-confirmed";
            } else {
                return "a-classifierTest/classifier";
            }
        } else {
            return "redirect:/logIn";
        }
    }

    // TODO: allow doctors to change diagnoses in admin UI
    @PostMapping(value = "/classifier", consumes = {"multipart/form-data"})
    public String getClassifier(@RequestParam(value = "imageSent", required = false) MultipartFile imageSent,
                                SecurityContextHolderAwareRequestWrapper requestWrapper)
            throws IOException {

        String username = requestWrapper.getUserPrincipal().getName();
        UUID fileId = UUID.randomUUID();
        String filename = username + "-" + fileId.toString() + ".jpeg";

        String filepath = "src/main/java/com/kj/clinic/medicalImageClassifier/images/" + filename;
        Files.write(Path.of(filepath), imageSent.getBytes());

        List<String> results = predictDiagnosis(filepath);
        String result = results.get(results.size()-1);

        service.create(username, filename, result);

        return "redirect:/classifier?diagnosis=" + result;
    }

    @GetMapping("/deleteDiagnosis/{filename}")
    public String deleteDiagnosis(SecurityContextHolderAwareRequestWrapper requestWrapper,
                         @PathVariable String filename){
        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            service.deleteByFilename(filename);
            return "redirect:/cabinet";
        } else {
            return "redirect:/logIn";
        }
    }
}
