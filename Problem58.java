import acm.program.ConsoleProgram;

public class Problem58 extends ConsoleProgram{
	public void run() {
		int[][] matrix = new int[3][3];
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j++) {
				matrix[i][j] = i * 3 + j + 1;
			}
		}
		
		println(magicMatrix(matrix));
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
