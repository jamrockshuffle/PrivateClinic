/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 25.05.23, 11:37
 *  * @Version: GetClientIP: 1.0
 *
 */

package com.kj.clinic.security.bruteForce;

import javax.servlet.http.HttpServletRequest;

public class GetClientIP {

    public static String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
