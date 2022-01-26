public class DirectionHeuristic {
    public static int checkRight(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[x][i+y] == arrword[i] ) {
            i++;
        }
        return (i+1);
    }

    public static int checkLeft(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[x][y-i] == arrword[i]) {
            i++;
        }
        return (i+1);
    }

    public static int checkUp(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[x-i][y] == arrword[i]) {
            i++;
        }
        return (i+1);
    }

    public static int checkDown(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[i+x][y] == arrword[i]) {
            i++;
        }
        return (i+1);
    }

    public static int checkUpRight(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[x-i][i+y] == arrword[i]) {
            i++;
        }
        return (i+1);
    }

    public static int checkDownRight(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[i+x][i+y] == arrword[i]) {
            i++;
        }
        return (i+1);
    }

    public static int checkUpLeft(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[x-i][y-i] == arrword[i]) {
            i++;
        }
        return (i+1);
    }

    public static int checkDownLeft(char[][] puzzle, char[] arrword, int x, int y) {
        int i = 0;
        while (i < arrword.length && puzzle[i+x][y-i] == arrword[i]) {
            i++;
        }
        return (i+1);
    }
}
