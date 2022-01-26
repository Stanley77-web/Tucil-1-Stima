import java.util.Scanner;

public class SearchWord {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.print("Masukan nama file (lengkap dengan .txt nya) : ");
        String path = key.nextLine();
        solve(path);
        key.close();
    }
    
    public static void solve(String path) {
        Query filQuery = Query.readPuzzle(path);
        
        char[][] puzzle = filQuery.puzzle;
        String[] word = filQuery.word;
        int[][] puzzleStat = filQuery.puzzleStat;
        System.out.printf("Masukan versi bruteforce yang diinginkan (1/2) : %n1. Dengan Heuristik %n2. Tanpa Heuristik %n>> ");
        Scanner op = new Scanner(System.in);
        int ver = op.nextInt();
        if (ver == 1) {
            BruteForceAlgorithm.searchingword(puzzle, word, puzzleStat);
        } else {
            BruteForceAlgorithm.searchingwordv2(puzzle, word, puzzleStat);
        }
        op.close();        
    }
}