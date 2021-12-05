package Games.Arkanoid;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    void clear() {
        matrix = new char[height+2][width+2];
    }

    void print() {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    void setPoint(double x, double y, char c) {
        int X = (int)Math.round(x);
        int Y = (int)Math.round(y);
        if (X < 0 || X > matrix[0].length || Y < 0 || Y > matrix.length) return;
        matrix[Y][X] = c;
    }

    void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) setPoint(x+j, y+i, c);
            }
        }
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height+2][width+2];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}