
/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 02.05.23, 12:54
 *  * @Version: IndexUIController: 1.0
 *
 */

/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.04.23, 12:48
 *  * @Version: IndexUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide;

import com.kj.clinic.security.AuthService;
import com.kj.clinic.security.controller.rest.AuthController;
import com.kj.clinic.security.controller.ui.AuthUIController;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexUIController {

    @RequestMapping("/")
    public String display(Model model,
                                  SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());
            return "mainPage/index-logged";
        } else {
            return "mainPage/index";
        }
    }
}
