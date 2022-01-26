import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;   
import java.io.FileNotFoundException;

public class Query {
    public char[][] puzzle;
    public int[][] puzzleStat;
    public String[] word;

    public Query(char[][] _puzzle, int[][] _puzzleStat, String[] _word) {
        puzzle = _puzzle;
        puzzleStat = _puzzleStat;
        word = _word;
    }

    public static Query readPuzzle(String path) {
        ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>> ();
        ArrayList<String> dump = new ArrayList<String>();

        char[][] puzzlefail = new char[0][0];
        int[][] puzzleStatfail = new int[0][0];
        String[] wordfail = new String[0];

        int i = 0, j;
        String filePath = "../test/" + path;
        File dataFile = new File(filePath);
        Boolean scanPuzzle = true;  
        
        Scanner dataScanner;

        try {
            dataScanner= new Scanner(dataFile);
            

            while (dataScanner.hasNextLine() && scanPuzzle) {
                String line = dataScanner.nextLine();
                if (line == "") {
                    scanPuzzle = false;
                } else {
                    String[] rowPuzzle = line.split(" ");
                    
                    ArrayList<String> tempList = new ArrayList<String>();
                    for (i = 0; i < rowPuzzle.length; i++) {
                        tempList.add(rowPuzzle[i]);
                        
                    }
                    temp.add(tempList);
                }
            }
            while (dataScanner.hasNextLine()) {
                String line = dataScanner.nextLine();
                dump.add(line);
            }
            dataScanner.close(); 

            char[][] puzzle = new char[temp.size()][temp.get(0).size()];
            int[][] puzzleStat = new int[temp.size()][temp.get(0).size()];
            String[] word = new String[dump.size()];

            for (i = 0; i < temp.size(); i++) {
                for (j = 0; j < temp.get(i).size(); j++) {
                    puzzle[i][j] = temp.get(i).get(j).charAt(0);
                    puzzleStat[i][j] = -1;
                }
            }

            for (i = 0; i < dump.size(); i++) {
                word[i] = dump.get(i);
            }
            Query filQuery = new Query(puzzle, puzzleStat, word);
            return filQuery;
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
            System.exit(0);
        } 
        Query filQuery = new Query(puzzlefail, puzzleStatfail, wordfail);
        return filQuery;        
    } 
}
