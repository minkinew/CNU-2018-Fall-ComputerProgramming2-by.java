
public class Matrix {

	private int row;
	private int col;
	private int rowIndex;
	private double[][] matrix;

	public Matrix(int row, int col) {
		matrix = new double[row][col];
		this.row = row;
		this.col = col;
	}

	public void setMatrix(double... d) {
		for (int i = 0; i < d.length; i++)
			matrix[rowIndex][i] = d[i];
		rowIndex++;
	}

	public Matrix addMatrix(Matrix otherMatrix) {
		Matrix a = this;
		Matrix c = new Matrix(row, col);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				c.matrix[i][j] = a.matrix[i][j] + otherMatrix.matrix[i][j];
		return c;

	}

	public Matrix multiMatrix(Matrix otherMatrix) {
		Matrix a = this;
		Matrix c = new Matrix(a.row, otherMatrix.col);
		for (int i = 0; i < c.row; i++)
			for (int j = 0; j < c.col; j++)
				for (int k = 0; k < a.col; k++)
					c.matrix[i][j] = c.matrix[i][j] + (a.matrix[i][k] * otherMatrix.matrix[k][j]);
		return c;
	}

	public Matrix transposed() {
		Matrix a = new Matrix(col, row);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				a.matrix[j][i] = this.matrix[i][j];

		return a;
	}

	public void print() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print("[" + matrix[i][j] + "]");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Matrix mat1 = new Matrix(3, 2);
		mat1.setMatrix(1, -2);
		mat1.setMatrix(3, 4);
		mat1.setMatrix(5, 6);
		Matrix mat2 = new Matrix(2, 3);
		mat2.setMatrix(1, 2, 3);
		mat2.setMatrix(4, 5, 6);

		System.out.println("첫번째 행렬");
		mat1.print();
		System.out.println();
		System.out.println("두번째 행렬");
		mat2.print();
		System.out.println();
		System.out.println("두 행렬의 곱셈");
		mat1.multiMatrix(mat2).print();
		System.out.println();
		System.out.println("첫번째 행렬 + 첫번쨰 행렬");
		mat1.addMatrix(mat1).print();

		System.out.println();
		System.out.println("두번째 행렬의 전치행렬");
		mat2.transposed().print();
	}

}
