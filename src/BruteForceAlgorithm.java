public class BruteForceAlgorithm {
    public static void searchingword(char[][] puzzle, String[] word, int[][] puzzleStat) {
        int i, j, k, n, sum, sumFind, sumAll = 0;
        
        Long totalWaktu = (long) 0;
        for (n = 0; n < word.length; n++) {
            char[] arrword = word[n].toCharArray();
            i = 0;
            boolean found = false;
            sumFind = 0;
            Long startTimeTemp = System.nanoTime();

            while ( i < puzzle.length && !found) {
                j = 0;
                while (j < puzzle[i].length && !found) {
                    if (j <= puzzle[i].length - arrword.length && !found) {
                        sum = DirectionHeuristic.checkRight(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i][j+k] = (n%25)+196;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }
                    if (i <= puzzle.length - arrword.length && j <= puzzle[i].length - arrword.length && !found) {
                        sum = DirectionHeuristic.checkDownRight(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i+k][j+k] = (n%25)+17;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan atas dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }  

                    if (i <= puzzle.length - arrword.length && !found) {
                        sum = DirectionHeuristic.checkDown(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i+k][j] = (n%25)+58;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah bawah dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    } 

                    if (i <= puzzle.length - arrword.length && j - arrword.length + 1 >= 0 && !found) {
                        sum = DirectionHeuristic.checkDownLeft(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i+k][j-k] = (n%25)+214;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kiri atas dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    } 

                    if (j - arrword.length + 1 >= 0 && !found) {
                        sum = DirectionHeuristic.checkLeft(puzzle, arrword, i, j);
                            if (sum == arrword.length+1) {
                                found = true;
                                for (k = 0; k < arrword.length; k++) {
                                    puzzleStat[i][j-k] = (n%25)+112;
                                }
                                System.out.printf("%s ditemukan dalam pencarian ke arah kiri dengan ", word[n]);
                                sumFind += sum - 1;
                            } else {
                                sumFind += sum;
                            }
                    } 

                    if (i - arrword.length + 1 >= 0 && j - arrword.length + 1 >= 0 && !found) {
                        sum = DirectionHeuristic.checkUpLeft(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i-k][j-k] = (n%25)+178;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kiri atas dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }

                    if (i - arrword.length + 1 >= 0 && j <= puzzle[i].length - arrword.length && !found) {
                        sum = DirectionHeuristic.checkUpRight(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i-k][j+k] = (n%25)+154;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan bawah dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }

                    if (i - arrword.length + 1 >= 0 && !found) {
                        sum = DirectionHeuristic.checkUp(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i-k][j] = (n%25)+246;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah atas dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }
                    
                    j++;
                }      
                i++;
            }
            Long endTimeTemp = System.nanoTime();
            sumAll += sumFind;
            Long totalWaktuTemp = endTimeTemp - startTimeTemp;
            totalWaktu += totalWaktuTemp;
            Double time = (double) totalWaktuTemp/1000000;
            if (found) {
                System.out.printf("total perbandingan : %d kali dan total waktu cari : %.3f ms\n", sumFind, time);
                System.out.println();
            } else {
                System.out.printf("%s tidak berada didalam puzzle " , word[n]);
                System.out.printf("total perbandingan : %d kali dan total waktu cari : %.3f ms\n", sumFind, time);
                System.out.println();
            }
        }

        System.out.println("Berikut ini puzzle yang telah ditandai huruf yang sudah ditemukannya :");
        for (i = 0; i < puzzle.length; i++) {
            for (j = 0; j < puzzle[i].length; j++) {
                System.out.print(Helper.coloring(puzzleStat[i][j]) + puzzle[i][j] + " ");  
            }
            System.out.println();
        }
        System.out.println(Helper.coloring(-1));
        Double time = (double) totalWaktu/1000000;
        System.out.printf("Data keseluruhan : %nTotal perbandingan : %d kali %nTotal waktu cari : %.3f ms\n", sumAll, time);
    } 

    public static void searchingwordv2(char[][] puzzle, String[] word, int[][] puzzleStat) {
        int i, j, k, n, sum, sumFind, sumAll = 0;
        
        Long totalWaktu = (long) 0;
        for (n = 0; n < word.length; n++) {
            char[] arrword = word[n].toCharArray();
            i = 0;
            boolean found = false;
            sumFind = 0;
            Long startTimeTemp = System.nanoTime();
            
            while ( i < puzzle.length && !found) {
                j = 0;
                while (j < puzzle[i].length && !found) {
                    if (!found) {
                        sum = Direction.checkRight(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i][j+k] = (n%25)+196;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }

                    if (!found) {
                        sum = Direction.checkDownRight(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i+k][j+k] = (n%25)+17;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }

                    if (!found) {
                        sum = Direction.checkDown(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i+k][j] = (n%25)+58;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }

                        sum = Direction.checkDownLeft(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i+k][j-k] = (n%25)+214;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }

                    if (!found) {
                        sum = Direction.checkLeft(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i][j-k] = (n%25)+112;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }

                        sum = Direction.checkUpLeft(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i-k][j-k] = (n%25)+178;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }

                    if (!found) {
                        sum = Direction.checkUp(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i-k][j] = (n%25)+246;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }

                    if (!found) {
                        sum = Direction.checkUpRight(puzzle, arrword, i, j);
                        if (sum == arrword.length+1) {
                            found = true;
                            for (k = 0; k < arrword.length; k++) {
                                puzzleStat[i-k][j+k] = (n%25)+154;
                            }
                            System.out.printf("%s ditemukan dalam pencarian ke arah kanan dengan ", word[n]);
                            sumFind += sum - 1;
                        } else {
                            sumFind += sum;
                        }
                    }
                    j++;
                }      
                i++;
            }
            Long endTimeTemp = System.nanoTime();
            sumAll += sumFind;
            Long totalWaktuTemp = endTimeTemp - startTimeTemp;
            totalWaktu += totalWaktuTemp;
            Double time = (double) totalWaktuTemp/1000000;
            if (found) {
                System.out.printf("total perbandingan : %d kali dan total waktu cari : %.3f ms\n", sumFind, time);
                System.out.println();
            } else {
                System.out.printf("%s tidak berada didalam puzzle " , word[n]);
                System.out.printf("total perbandingan : %d kali dan total waktu cari : %.3f ms\n", sumFind, time);
                System.out.println();
            }
        }    
      
        System.out.println("Berikut ini puzzle yang telah ditandai huruf yang sudah ditemukannya :");
        for (i = 0; i < puzzle.length; i++) {
            for (j = 0; j < puzzle[i].length; j++) {
                System.out.print(Helper.coloring(puzzleStat[i][j]) + puzzle[i][j] + " ");  
            }
            System.out.println();
        }
        System.out.println(Helper.coloring(-1));
        Double time = (double) totalWaktu/1000000;
        System.out.printf("Data keseluruhan : %nTotal perbandingan : %d kali %nTotal waktu cari : %.3f ms\n", sumAll, time);
    } 
}
