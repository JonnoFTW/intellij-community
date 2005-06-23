/**
 * @author cdr
 */
/*
 * Copyright (c) 2000-2004 by JetBrains s.r.o. All Rights Reserved.
 * Use is subject to license terms.
 */
package com.intellij.openapi.util;

public class PasswordUtil {
  private PasswordUtil() {}

  // weak encryption just to avoid plain text passwords in text files
  public static String encodePassword(String password) {
    String result = "";
    if (password == null) return result;
    for (int i =0; i< password.length(); i++) {
      int c = password.charAt(i);
      c ^= 0xdfaa;
      result += Integer.toHexString(c);
    }
    return result;
  }

  public static String decodePassword(String password) {
    String result = "";
    if (password == null) return result;
    for (int i =0; i< password.length(); i+=4) {
      String s = password.substring(i,i+4);
      int c = Integer.parseInt(s, 16);
      c ^= 0xdfaa;
      result += new Character((char)c).charValue();
    }
    return result;
  }
  public static String requestPassword(String prompt, String title, final String defaultValue) {
    final PasswordPromptDialog dialog = new PasswordPromptDialog(prompt, title, defaultValue);
    dialog.show();
    if (dialog.isOK()) {
      return dialog.getPassword();
    } else {
      return null;
    }
  }


}