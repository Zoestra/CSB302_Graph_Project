public static void main(String[] args) {
  logger.startup();
    try {
        graphSettings.setup();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    Boolean run = true;

  while(run){
    try{
      run = Cli.run(run);
    } catch(Exception e){
      logger.log(e);
      run = false;
    }
  }

  logger.shutdown();
}


