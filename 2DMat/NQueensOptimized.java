import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensOptimized
{
    int n;
    int[] rows, cols, rDiag, lDiag;
    List<List<String>> answers;

    String[] availableRows;

    void addAnswer()
    {
        if (availableRows == null) {
            availableRows = new String[n];

            StringBuilder line = new StringBuilder();
            for (int i = 0; i < n; i++)
                line.append(".");

            for (int i = 0; i < n; i++) {
                line.setCharAt(i, 'Q');
                availableRows[i] = line.toString();
                line.setCharAt(i, '.');
            }
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++)
            answer.add(availableRows[rows[i]]);

        answers.add(answer);
    }

    void tryRow (int row)
    {
        if (row == n) {
            addAnswer();
            return;
        }

        int LDi, RDi;
        for (int i = 0; i < n; i++) {
            LDi = n - 1 - row + i;
            RDi = row + i;
            if (cols[i] == -1 && rDiag[LDi] == -1 && lDiag[RDi] == -1){
                rows[row] = i;
                cols[i] = row;
                rDiag[LDi] = row;
                lDiag[RDi] = row;
                tryRow(row + 1);
                rows[row] = -1;
                cols[i] = -1;
                rDiag[LDi] = -1;
                lDiag[RDi] = -1;
            }
        }
    }

    public List<List<String>> solveNQueens(int n)
    {
        this.n = n;

        this.rows = new int[n];
        this.cols = new int[n];
        this.rDiag = new int[2 * n];
        this.lDiag = new int[2 * n];

        Arrays.fill(rows, -1);
        Arrays.fill(cols, -1);
        Arrays.fill(rDiag, -1);
        Arrays.fill(lDiag, -1);

        this.answers = new ArrayList<>();
        tryRow(0);

        return answers;
    }
}