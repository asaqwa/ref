package AlgorithmAndLogics.WordsIn2DArray.EnumDirections;


import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'e'},
                {'u', 's', 'a', 'm', 'e', 'm'},
                {'l', 'n', 'g', 'r', 'o', 'o'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> foundedWords = detectAllWords(crossword, "home", "g", "ok", "same", "");
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
            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[y].length; x++) {
                    // find the first char
                    if (crossword[y][x]==word.charAt(0)) {
                        // is it one-letter word?
                        if (word.length() == 1) {
                            foundedWords.add(getWord(word, x, y, x, y));
                            continue;
                        }

                        // next chars for each direction
                        for (Directions direction : Directions.values()) {
                            // is it out of the array size?
                            if (x + (direction.x * word.length()) > crossword[0].length ||
                                    x + (direction.x * word.length()) < -1 ||
                                    y + (direction.y * word.length()) > crossword.length ||
                                    y + (direction.y * word.length()) < -1)
                                continue;

                            int nextChar = 1;
                            while (nextChar < word.length()) {
                                if (crossword[y + (direction.y * nextChar)][x + (direction.x * nextChar)]!=word.charAt(nextChar)) break;
                                if (nextChar == word.length()-1) {
                                    foundedWords.add(getWord(word, x, y, x + (direction.x * nextChar), y + (direction.y * nextChar)));
                                }
                                nextChar++;
                            }
                        }
                    }
                }
            }

        }
        return foundedWords;
    }

    private enum Directions {
        UP_LEFT (-1, -1),
        UP (0, -1),
        UP_RIGHT (1, -1),
        RIGHT (1, 0),
        DOWN_RIGHT (1, 1),
        DOWN (0, 1),
        DOWN_LEFT (-1, 1),
        LEFT (-1, 0);

        int x;
        int y;

        Directions(int x, int y) {
            this.x = x;
            this.y = y;
        }
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
