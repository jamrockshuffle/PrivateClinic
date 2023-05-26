/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 10:58
 *  * @Version: TableListUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Examinations;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/database/")
@Controller
public class TableListUIController {

    @RequestMapping("/main")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            return "x-database/table-list";
        } else {
            return "redirect:/database/dbentry";
        }
    }
}
