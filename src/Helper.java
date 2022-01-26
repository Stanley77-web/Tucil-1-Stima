public class Helper {
    public static String coloring(int n) { 
        if (n == -1) {
            return "\033[0m";
        } else {
            return "\033[38;5;" + Integer.toString(n) + "m";
        } 
    } 
}