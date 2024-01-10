import acm.program.ConsoleProgram;

public class Problem59 extends ConsoleProgram{ 
	public void run() {
		int[][] matrix1 = {
				        {1, 0, 0, 0, 1, 0, 0}, 
				        {0, 1, 1, 0 ,1 ,0 ,1}, 
				        {0, 0, 0, 1, 1, 1, 1},
				        {1, 1, 1, 1, 1, 1, 1}};
		
		int[][] matrix2 = {
		                {1, 1, 1, 1, 1, 0, 0}, 
		                {0, 1, 1, 0 ,1 ,0 ,1}, 
		                {0, 0, 0, 1, 1, 1, 1},
		                {1, 1, 1, 1, 1, 1, 1}};
		
		int[][] matrix3 = {
		                {1, 0, 0, 0, 1, 0, 0}, 
		                {0, 1, 1, 0 ,1 ,0 ,1}, 
		                {0, 0, 0, 1, 1, 1, 1},
		                {1, 1, 1, 1, 1, 1, 1},
		                {1, 0, 0, 1 ,1, 1, 1},
		                {0, 0, 1, 0, 1, 1, 1}};
		
		println(largestGoodRectSize(matrix1));
		println(largestGoodRectSize(matrix2));
		println(largestGoodRectSize(matrix3));
	}
	
	private int largestGoodRectSize(int[][] matrix) {
		int largestSize = 1;
		for(int r1 = 0; r1 < matrix.length; r1++) {
			for(int r2 = r1; r2 < matrix.length; r2++) {
				for(int c1 = 0; c1 < matrix[0].length; c1++) {
					for(int c2 = c1; c2 < matrix[0].length; c2++) {
						int[][] currRect = new int[r2 - r1 + 1][c2 - c1 + 1];
						for(int r = r1; r <= r2; r++) {
							for(int c = c1; c <= c2; c++) {
								currRect[r - r1][c - c1] = matrix[r][c];
							}
						}
						if(isGoodRect(currRect)) largestSize = Math.max(largestSize, sizeOfRect(currRect));
					}
				}
			}
		}
		
		return largestSize;
	}
	
	private boolean isGoodRect(int[][] matrix) {
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[0].length; c++) {
				if(matrix[r][c] != 0) return false;
			}
		}
		return true;
	}

	private int sizeOfRect(int[][] matrix) {
		return matrix.length * matrix[0].length;
	}
	
}
