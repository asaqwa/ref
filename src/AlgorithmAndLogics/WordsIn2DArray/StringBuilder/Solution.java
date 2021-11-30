package AlgorithmAndLogics.WordsIn2DArray.StringBuilder;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'e'},
                {'u', 's', 'm', 'm', 'm', 'm'},
                {'l', 'n', 'm', 'o', 'm', 'o'},
                {'m', 'l', 'm', 'm', 'm', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> foundedWords = detectAllWords(crossword, "mom"); // "g", "ok", "same", "");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

        for (Word word : foundedWords) System.out.println(word);
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> foundedWords = new ArrayList<>();
        for (String word : words) {
            if (word == null || word.isEmpty()) continue;

            // line
            for (int y = 0; y < crossword.length; y++) {
                StringBuilder line = new StringBuilder();
                for (int x = 0; x < crossword[y].length; x++) {
                    line.append((char) crossword[y][x]);
                }
                int fromIndex = -1;
                while ((fromIndex = line.indexOf(word, ++fromIndex)) >= 0) {
                    foundedWords.add(getWord(word, fromIndex, y, fromIndex + (word.length() - 1), y));
                }
                // one-letter word
                if (word.length() < 2) continue;

                line.reverse();
                while ((fromIndex = line.indexOf(word, ++fromIndex)) >= 0) {
                    int x = crossword[y].length - 1 - fromIndex;
                    foundedWords.add(getWord(word, x, y, x - (word.length() - 1), y));
                }
            }

            // one-letter word
            if (word.length() < 2) continue;

            // column
            for (int x = 0; x < crossword[0].length; x++) {
                StringBuilder column = new StringBuilder();
                for (int[] ints : crossword) {
                    column.append((char) ints[x]);
                }
                int fromIndex = -1;
                while ((fromIndex = column.indexOf(word, ++fromIndex)) >= 0) {
                    foundedWords.add(getWord(word, x, fromIndex, x, fromIndex + (word.length() - 1)));
                }
                column.reverse();
                while ((fromIndex = column.indexOf(word, ++fromIndex)) >= 0) {
                    int y = crossword.length - 1 - fromIndex;
                    foundedWords.add(getWord(word, x, y, x, y - (word.length() - 1)));
                }
            }

            // diagonal left
            for (int i = (2 - crossword.length); i < (crossword[0].length - 1); i++) {
                StringBuilder diaLeft = new StringBuilder();
                int x = Math.max(i, 0), y = Math.abs(Math.min(i, 0)), xx = x, yy = y;
                while (xx < crossword[0].length && yy < crossword.length) diaLeft.append((char) crossword[yy++][xx++]);

                int fromIndex = -1;
                while ((fromIndex = diaLeft.indexOf(word, ++fromIndex)) >= 0) {
                    int xStart = x + fromIndex, yStart = y + fromIndex,
                            xEnd = xStart + word.length() - 1, yEnd = yStart + word.length() - 1;
                    foundedWords.add(getWord(word, xStart, yStart, xEnd, yEnd));
                }
                diaLeft.reverse();
                while ((fromIndex = diaLeft.indexOf(word, ++fromIndex)) >= 0) {
                    int xStart = x + diaLeft.length() - 1 - fromIndex, yStart = y + diaLeft.length() - 1 - fromIndex,
                            xEnd = xStart - word.length() + 1, yEnd = yStart - word.length() + 1;
                    foundedWords.add(getWord(word, xStart, yStart, xEnd, yEnd));
                }
            }

            // diagonal right
            for (int i = 1; i < (crossword[0].length + crossword.length - 2); i++) {
                StringBuilder diaRight = new StringBuilder();
                int x = Math.min(i, (crossword[0].length - 1)), y = i < (crossword[0].length) ? 0 : i - (crossword[0].length - 1), xx = x, yy = y;
                while (xx >= 0 && yy < crossword.length) diaRight.append((char) crossword[yy++][xx--]);

                int fromIndex = -1;
                while ((fromIndex = diaRight.indexOf(word, ++fromIndex)) >= 0) {
                    int xStart = x - fromIndex, yStart = y + fromIndex,
                            xEnd = xStart - word.length() + 1, yEnd = yStart + word.length() - 1;
                    foundedWords.add(getWord(word, xStart, yStart, xEnd, yEnd));
                }
                diaRight.reverse();
                while ((fromIndex = diaRight.indexOf(word, ++fromIndex)) >= 0) {
                    int xStart = x - diaRight.length() + 1 + fromIndex, yStart = y + diaRight.length() - 1 - fromIndex,
                            xEnd = xStart + word.length() - 1, yEnd = yStart - word.length() + 1;
                    foundedWords.add(getWord(word, xStart, yStart, xEnd, yEnd));
                }

            }
        }
        return foundedWords;
    }

    private static Word getWord(String text, int x, int y, int endX, int endY) {
        Word word = new Word(text);
        word.setStartPoint(x, y);
        word.setEndPoint(endX, endY);
        return word;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
