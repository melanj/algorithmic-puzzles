import java.util.HashSet;
import java.util.Set;

public class FishInTheSea {

    /**
     * @param matrix a matrix represented by 2D integer array.
     * @return max weight if available, otherwise -1.
     */
    public int solve(int[][] matrix) {
        final Set<Integer> pathList = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            traverse(matrix, i, 0, pathList, sum);
        }
        System.out.println(pathList.size());
        return pathList.stream().max(Integer::compare).orElse(-1);
    }

    /**
     * Traverse a matrix by given position and list weight of cell in each path towards to end column
     * by navigating right, right-up, right-down direction. only distinct values hold in the pathList.
     *
     * @param matrix      a matrix represented by 2D integer array.
     * @param posY        current row index.
     * @param posX        current column index.
     * @param pathList    a set weight on paths.
     * @param accumulator current value of the given path.
     */
    private void traverse(final int[][] matrix, final int posY, final int posX, final Set<Integer> pathList, final int accumulator) {
        if (posX < matrix[posY].length) {
            int cellValue = matrix[posY][posX];
            if (cellValue < 0) {
                throw new IllegalArgumentException("only positive values are allowed");
            }
            int sum = accumulator + cellValue;
            if (posX == matrix[posY].length - 1) { // if we are in a right-most cell, add calculated sum as a path.
                pathList.add(sum);
            } else {
                if (posY > 0) { // if we not in a top most cell, navigating a row up and traverse.
                    traverse(matrix, posY - 1, posX + 1, pathList, sum);
                }
                traverse(matrix, posY, posX + 1, pathList, sum); // navigate to right.
                if (posY < matrix.length - 1) { // if we not in a bottom most cell, navigate a row down and traverse.
                    traverse(matrix, posY + 1, posX + 1, pathList, sum);
                }
            }
        }
    }
}
