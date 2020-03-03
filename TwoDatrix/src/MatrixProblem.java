public class MatrixProblem {	
		
		public void SolveSudko(int [][] mat) {
			if(findSolution(mat,9,9)) {
				
				for(int s =0; s < 9; s++) {
					for(int t = 0; t < 9;t++) {
						System.out.print(mat[s][t]);
					}
					System.out.println(" ");
				}
			}
		else {
			System.out.println("no solution found");
		}
		} 
		
		public static Boolean findSolution(int [][] mat, int r, int c) {
			boolean solutionFound = true;
			int row = -1;
			int col = -1;
			for(int i = 0; i < r ;i++) {
				for(int j = 0; j < c; j++) {
					if(mat[i][j] == 0) {
						row = i;
						col = j;
						solutionFound = false;
						break;					
					}
					
				}
				if(!solutionFound) {
					break;
				}
		}
			if(solutionFound) {
				return true;
			}
			
			for(int k = 1; k < 10; k++) {
				if(CanAdd(row,r,col,c,k,mat)) {
					mat[row][col]=k;
					if(findSolution(mat,r,c)) {
						return true;
					}
				
				else {
					mat[row][col] = 0;
				}
				
			}
			}
			return false;
			
	}
		
public static Boolean CanAdd(int i, int r, int j, int c, int value, int[][]  mat ) {
			
			for(int m = 0; m < c  ; m++) {
				if(mat[i][m]==value) {
					return false;
				}
			}
			for(int m = 0; m < r  ; m++) {
				if(mat[m][j]==value) {
					return false;
				}
			}
			int iStart = (i/3)*3;
			int jStart = (j/3)*3;
			for(int m = iStart; m < iStart+3; m++) {
				for(int n = jStart; n < jStart+3; n++) {
					if(mat[m][n]==value) {
						return false;
					}
				}
			}
			
			return true;
			
		}
		
		
	}
