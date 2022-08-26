import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FishesInTheSeaTest {

    private FishInTheSea fishInTheSea;

    @BeforeEach
    void setUp() {
        fishInTheSea = new FishInTheSea();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void  solveWhen3x3Matrix() {
        int[][] mat = {{1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}};
        int actual = fishInTheSea.solve(mat);
        assertEquals(12, actual);
    }

    @Test
    void solveWhen4x4Matrix() {
        int[][] mat = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
        int actual = fishInTheSea.solve(mat);
        assertEquals(16, actual);
    }

    @Test
    void solveWhen4x4Matrix2() {
        int[][] mat = {{10, 33, 13, 15},
                {22, 21, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
        int actual = fishInTheSea.solve(mat);
        assertEquals(83, actual);
    }

    @Test
    void solveWhenEmptyMatrix() {
        int[][] mat = {{}};
        int actual = fishInTheSea.solve(mat);
        assertEquals(-1, actual);
    }

    @Test
    void solveWhenRowMatrix() {
        int[][] mat = {{10, 33, 3, 15}};
        int actual = fishInTheSea.solve(mat);
        assertEquals(61, actual);
    }

    @Test
    void solveWhen4x4Matrix21() {
        int[][] mat = {{10},
                {22},
                {5},
                {0}};
        int actual = fishInTheSea.solve(mat);
        assertEquals(22, actual);
    }

    @Test
    void solveWhenMatrixHasNegativeValues() {
        int[][] mat = {{10, 33, 13, 15},
                {22, 21, -4, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
        assertThrows(IllegalArgumentException.class,() -> fishInTheSea.solve(mat));
    }
}
