package com.hf.laf.util;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Hzldex on 2018/3/1.
 */
public class AdminTool {
    public static boolean isAdmin(HttpSession session) {
        return session.getAttribute("isadmin") != null && session.getAttribute("isadmin").equals("666");
    }
    public static boolean isAdmin(Map sessionMap) {
        return sessionMap.get("isadmin") != null && sessionMap.get("isadmin").equals("666");
    }
}
