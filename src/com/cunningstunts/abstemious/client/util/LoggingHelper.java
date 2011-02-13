package com.cunningstunts.abstemious.client.util;

import com.google.gwt.core.client.GWT;


public class LoggingHelper {
  public static void log(String msg) {
    StackTraceElement trace = new Throwable().getStackTrace()[1];
    GWT.log("[" + trace.getFileName() + ":" + trace.getLineNumber() + "] " + msg);
  }

  public static void log(String msg, Throwable throwable) {
    StackTraceElement trace = new Throwable().getStackTrace()[1];
    GWT.log("[" + trace.getFileName() + ":" + trace.getLineNumber() + "] " + msg, throwable);
  }
}
