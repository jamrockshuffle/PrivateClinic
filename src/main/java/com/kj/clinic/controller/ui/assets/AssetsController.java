/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 25.04.23, 13:20
 *  * @Version: AssetsUI: 1.0
 *
 */

package com.kj.clinic.controller.ui.assets;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Controller
public class AssetsController {

    @GetMapping("/assets/{fileName}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) throws IOException {

        File imgPath = new File("src\\main\\resources\\templates\\a-assets\\" + fileName);
        byte[] image = Files.readAllBytes(imgPath.toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(image.length);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

}
