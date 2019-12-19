package org.tangdao.modules.sys.utils;

import javax.servlet.http.HttpServletRequest;

public class ValidCodeUtils {
   public static final String VALID_CODE = "validCode";

   public static boolean validate(HttpServletRequest request, String validCode) {
      return validate(request, VALID_CODE, validCode);
   }

   public static boolean validate(HttpServletRequest request, String attributeName, String validCode) {
      return validate(request, attributeName, validCode, true);
   }

   public static boolean validate(HttpServletRequest request, String attributeName, String validCode, boolean isClear) {
      String a = (String)request.getSession().getAttribute(attributeName);
      boolean result = validCode != null && validCode.equalsIgnoreCase(a);
      if (result && isClear) {
         request.getSession().removeAttribute(attributeName);
      }
      return result;
   }
}
