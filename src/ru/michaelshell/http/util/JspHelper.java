package ru.michaelshell.http.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {

    private static final String TEMPLATE = "WEB-INF/jsp/%s.jsp";

    public static String getPath(String fileName) {
        return String.format(TEMPLATE, fileName);
    }
}
