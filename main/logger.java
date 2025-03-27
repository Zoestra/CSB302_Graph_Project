import org.junit.platform.commons.util.ExceptionUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.Double.POSITIVE_INFINITY;

public class logger {
// Made by Zoestra Hammer
// zoestrahammer@gmail.com
// @zoestra on GitHub



  private static boolean consoleLogging = true;
  private static final String logFilePath = "application.log";
  private static final SimpleDateFormat formatter = new SimpleDateFormat("[yy.MM.dd.u zzz kk:mm:ss:SSS]", Locale.US);
  private static BufferedWriter logWriter = null;

  static {
    initializeLogFile();
  }

  public static void log(String message) {
    String formatted = formatMessage(message);
    writeToFile(formatted);
    if (consoleLogging) {
      System.out.println(message);
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

  public static void log(Character code, Object object){
    switch(code){
      case 'n':
        line();
        log("new object");
        log(object);
        line();
        break;

      case 'c':
        line();
        log("object changed");
        log(object);
        line();
        break;
    }

  }

  public static void log(double[][] matrix){
    line();
    log("Current Matrix");
    int n = matrix.length;
    for(double[] y : matrix){
      String line = "";
      String entry = "";
      for(double x : y){
        if(x == POSITIVE_INFINITY){
          entry = "∞";
        }
        else{
          entry = ((int) x + "");
        }
        while(entry.length() < 4){
          entry = entry + " ";
        }
        line += entry;
      }
      log(line);
    }
    line();
  }

  public static void log(Character code, Object object, String name){
    switch(code){
      case 'n':
        line();
        log("new object: " + name);
        log(object);
        break;
      case 'c':
        line();
        log("updated object: " + name);
        log(object);
        break;
    }
  }

  public static void line(){
    String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    writeToFile(line);
    if(consoleLogging){
      System.out.println(line);
    }
  }
  public static void log(Exception e) {
    String exceptName = e.getClass().getSimpleName();
    String exceptMessage = e.getMessage();
    String message = "Exception: " + exceptName + " - " + exceptMessage;
    String formatted = formatMessage(message);
    String stackTrace = ExceptionUtils.readStackTrace(e);
    writeToFile(formatted);
    writeToFile(stackTrace);
    if (consoleLogging) {
      System.err.println(message);
      System.err.println(stackTrace);
    }
  }


  public static void startup(){
    log("Application started");
    zoeskull();

  }

  public static void shutdown(){
    line();
    log("~Application Closed");
    log("~~~Shutting Down~~~");
    line();
    close();
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

  public static void setConsoleLogging(boolean consoleLogging) {
    logger.consoleLogging = consoleLogging;
  }

  public static void zoeskull() {
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    log("         0                      1        ");
    log("        367     1321426910    842        ");
    log("        001367 132142691084 20013        ");
    log("         6713214269   1084200136         ");
    log("          71321426     91084200          ");
    log("         1367132142   6910842001         ");
    log("        3671321426910842001   367        ");
    log("        132      1426910       84        ");
    log("        200       136713       21        ");
    log("        426       91 084       20        ");
    log("         013   67132  14269 10842        ");
    log("           00136713214269108420          ");
    log("      0      136713214269108     4       ");
    log("      200     13 671  32  14   2691      ");
    log("      08420       0    1     367132      ");
    log("    142691084200         136713214269    ");
    log("    1084   200136713  2142691            ");
    log("                  0842001                ");
    log("              3671321   4269108  4200    ");
    log("      13   671321            4269108     ");
    log("      4200136                  713       ");
    log("        214                     26       ");
    log("        910                              ");
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    log("~~~~~~~~~~~~~~~~~~made by~~~~~~~~~~~~~~~~");
    log("~~~~~~~~~~~~~~~Zoestra Hammer~~~~~~~~~~~~");
    log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }


}