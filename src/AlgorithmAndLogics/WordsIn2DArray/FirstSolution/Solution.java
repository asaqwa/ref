package AlgorithmAndLogics.WordsIn2DArray.FirstSolution;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд

package com.javarush.task.task20.task2027;
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
        List<Word> foundedWords = detectAllWords(crossword, "home", "same");
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

                        // if the one-letter word
                        if (word.length() == 1) {
                            foundedWords.add(getWord(word, x, y, x, y));
                            continue;
                        }

                        boolean xPlus = x + word.length() <= crossword[y].length;
                        boolean xMinus = x - word.length() > -2;
                        boolean yPlus = y + word.length() <= crossword.length;
                        boolean yMinus = y - word.length() >-2;
                        // find next chars
                        int nextChar = 1;

                        // up
                        if (yMinus) {
                            while (nextChar < word.length()) {
                                if (crossword[y - nextChar][x]!=word.charAt(nextChar)) break;
                                if (nextChar == word.length()-1) {
                                    foundedWords.add(getWord(word, x, y, x, y - nextChar));
                                }
                                nextChar++;
                            }
                            nextChar = 1;
                        }

                        // up & right
                        if (xPlus) {
                            if (yMinus) {
                                while (nextChar < word.length()) {
                                    if (crossword[y - nextChar][x + nextChar]!=word.charAt(nextChar)) break;
                                    if (nextChar == word.length()-1) {
                                        foundedWords.add(getWord(word, x, y, x + nextChar, y - nextChar));
                                    }
                                    nextChar++;
                                }
                                nextChar = 1;
                            }

                            // right
                            while (nextChar < word.length()) {
                                if (crossword[y][x + nextChar]!=word.charAt(nextChar)) break;
                                if (nextChar == word.length()-1) {
                                    foundedWords.add(getWord(word, x, y, x + nextChar, y));
                                }
                                nextChar++;
                            }
                            nextChar = 1;

                            // right & down
                            if (yPlus){
                                while (nextChar < word.length()) {
                                    if (crossword[y + nextChar][x + nextChar]!=word.charAt(nextChar)) break;
                                    if (nextChar == word.length()-1) {
                                        foundedWords.add(getWord(word, x, y, x + nextChar, y + nextChar));
                                    }
                                    nextChar++;
                                }
                                nextChar = 1;
                            }
                        }

                        // down
                        if (yPlus) {
                            while (nextChar < word.length()) {
                                if (crossword[y + nextChar][x]!=word.charAt(nextChar)) break;
                                if (nextChar == word.length()-1) {
                                    foundedWords.add(getWord(word, x, y, x, y + nextChar));
                                }
                                nextChar++;
                            }
                            nextChar = 1;
                        }

                        // left & down
                        if (xMinus) {
                            if (yPlus) {
                                while (nextChar < word.length()) {
                                    if (crossword[y + nextChar][x - nextChar]!=word.charAt(nextChar)) break;
                                    if (nextChar == word.length()-1) {
                                        foundedWords.add(getWord(word, x, y, x - nextChar, y + nextChar));
                                    }
                                    nextChar++;
                                }
                                nextChar = 1;
                            }

                            // left
                            while (nextChar < word.length()) {
                                if (crossword[y][x - nextChar]!=word.charAt(nextChar)) break;
                                if (nextChar == word.length()-1) {
                                    foundedWords.add(getWord(word, x, y, x - nextChar, y));
                                }
                                nextChar++;
                            }
                            nextChar = 1;

                            // left & up
                            if (yMinus) {
                                while (nextChar < word.length()) {
                                    if (crossword[y - nextChar][x - nextChar]!=word.charAt(nextChar)) break;
                                    if (nextChar == word.length()-1) {
                                        foundedWords.add(getWord(word, x, y, x - nextChar, y - nextChar));
                                    }
                                    nextChar++;
                                }
                            }
                        }
                    }
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
