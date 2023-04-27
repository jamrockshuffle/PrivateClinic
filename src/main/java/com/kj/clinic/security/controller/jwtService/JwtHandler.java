/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.04.23, 15:19
 *  * @Version: JwtHandlerImpl: 1.0
 *
 */

package com.kj.clinic.security.controller.jwtService;

import com.kj.clinic.model.Examinations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class JwtHandler {
    private String jwt;

    public JwtHandler() {
    }

    public JwtHandler(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String create(String jwt) {
        return new JwtHandler(jwt).getJwt();
    }
}
