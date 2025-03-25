import org.junit.platform.commons.util.ExceptionUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class logger {
  private static final boolean consoleLogging = true;
  private static final String logFilePath = "application.log";

  private static final SimpleDateFormat formatter = new SimpleDateFormat("[yy.MM.dd.u zzz kk:mm:ss:SSS]", Locale.US);
  private static BufferedWriter logWriter = null;

  static {initializeLogFile();}




  public static void log(String message) {
    String formatted = formatMessage(message);
    writeToFile(formatted);
    if (consoleLogging) {
      System.out.println(formatted);
    }
  }

  public static void log(Object obj) {
    if (obj != null) {
      log("Object type: " + obj.getClass());
      log(obj.toString());
    } else {
      log("null");
    }
  }

  public static void log(String code, Object object){
    switch(code){
      case "n":
        log("new object");
        log(object);
        break;

      case "c":
        log("object changed");
        log(object);
        break;
    }

  }

  public static void log(Exception e) {
    String exceptName = e.getClass().getSimpleName();
    String exceptMessage = e.getMessage();
    String formatted = formatMessage("Exception: " + exceptName + " - " + exceptMessage);
    String stackTrace = ExceptionUtils.readStackTrace(e);
    writeToFile(formatted);
    writeToFile(stackTrace);
    if (consoleLogging) {
      System.err.println(formatted);
      System.err.println(stackTrace);
    }
  }


  public static void print(String message){
    String formatted = formatMessage(message);
    System.out.println(message);
    writeToFile(formatted);
  }


  public static void startup(){
    logger.log("~~~~~~~~~~~~~~~~~~~");
    logger.log("Application started");

  }

  public static void shutdown(){
    logger.log("~~~~~~~~~~~~~~~~~~~");
    logger.log("~Application Closed");
    logger.log("~~~Shutting Down~~~");
    logger.close();
  }




  // Utility methods
  private static String formatMessage(String message) {
    return formatter.format(new Date()) + " " + message;
  }

  private static void writeToFile(String message) {
    if (logWriter == null) return;

    try {
      logWriter.write(message);
      logWriter.newLine();
      logWriter.flush();
    } catch (IOException e) {
      System.err.println("Log write error: " + e.getMessage());
    }
  }
  private static void restartLogger() {
    close();
    initializeLogFile();
  }

  public static void close() {
    if (logWriter != null) {
      try {
        logWriter.close();
      } catch (IOException e) {
        System.err.println("Log closure error: " + e.getMessage());
      }
      logWriter = null;
    }
  }

  private static void initializeLogFile() {
    try {
      logWriter = new BufferedWriter(new FileWriter(logFilePath, true));
    } catch (IOException e) {
      System.err.println("Logger initialization failed: " + e.getMessage());
    }
  }
}