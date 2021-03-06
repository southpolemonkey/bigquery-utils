/**
 * this file is the main file for the command line tool. The first argument is a txt file
 * containing the queries. The second argument, which is optional, is a time limit that we
 * impose on processing a single query. The third argument, which is optional, is a file
 * that we want to write the results to.
 */
public class QueryBreakdown {
  public static void main(String[] args) {
    String inputFile = null;
    double timeLimit = 0.0;
    String outputFile = null;

    if (args[0] != null) {
      inputFile = args[0];
    }
    else {
      System.out.println("You have not specified the input file");
    }
    if (args[1] != null) {
      timeLimit = Double.parseDouble(args[1]);
    }
    if (args[2] != null) {
      outputFile = args[2];
    }

    // this is where we will put the file I/O logic through the input reader.
    String originalQuery = InputReader.readInput(inputFile);

    /* this is where we feed in the original query to the UnparseableDetector, which will find
       all the unparseable components of the query and output them into the output file if
       specified. Otherwise, it will be autogenerated.
     */
    UnparseableDetector.run(originalQuery, outputFile, timeLimit);
  }
}
