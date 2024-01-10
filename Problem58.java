import acm.program.ConsoleProgram;

public class Problem58 extends ConsoleProgram{

	public void run() {
		int[][] matrix1 = {{1, 2, 3}, {6, 9, 8}, {5, 4, 7}};
		int[][] matrix2 = {{1, 2, 3, 4, 5}, {5, 6, 7, 8, 9}};
		int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 1}};
		println(magicMatrix(matrix1));
		println(magicMatrix(matrix2));
		println(magicMatrix(matrix3));
	}
	private boolean magicMatrix(int[][] matrix) {
		if(matrix.length == matrix[0].length && containsAllNumbers(matrix)) return true;
		return false;
		
	}
	
	private boolean containsAllNumbers(int[][] matrix) {
		int numRows = matrix.length;
		int[] containingIntArr = new int[numRows * numRows];
		for(int r = 0; r < numRows; r++) {
			for(int c = 0; c < numRows; c++) {
				if(matrix[r][c] > 0 && matrix[r][c] <= (numRows * numRows)) {
					containingIntArr[matrix[r][c] - 1]++;
				}
			}
		}
		for(int i = 0; i < (numRows * numRows); i++) {
			if(containingIntArr[i] != 1) return false;
		}
		
		return true;
	}

}
