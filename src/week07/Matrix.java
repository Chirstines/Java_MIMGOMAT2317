package week07;
import java.util.Random;
import java.util.Scanner;


public class Matrix {

  public static void main(String[] args) {
      Scanner input = new Scanner( System.in);
        System.out.print(" Nhap vao kich thuoc: ");
        int i = input.nextInt();
        int j = input.nextInt();
        // Matrix = i * j
        int[][] matrix = new int [i][j];
    }
  
  /* Method to generate random matrix, used to test program */
  public static int[][] generateMatrix(int rows, int columns) {
    if ((rows <= 0) || (columns <= 0)) {
      return null;
    }
    
    Random randomGenerator = new Random();
    int[][] newMatrix = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        newMatrix[i][j] = Math.abs(randomGenerator.nextInt()) % 100;
      }
    }
    
    return newMatrix;
  }
  
  /* Method to check valid matrix */ 
  public static boolean isValid(int[][] matrix) {
    if ((matrix == null) || (matrix.length == 0) || (matrix[0].length ==0)) {
      return false;
    }
    return true;
  }
  
  /* Method to check valid array */
  public static boolean isValid(int[] array) {
    if ((array == null) || (array.length == 0)) {
      return false;
    }
    
    return true;
  }

  public static void inputMatrix(int[][] matrix, Scanner keyboard) {
    if (!isValid(matrix)) {
      return;
    }
    
    /* TODO */
     for (int i=0; i<matrix.length; i++){
        for (int j=0; j < matrix[0].length; j++){
             matrix[i][j] = keyboard.nextInt();
        }
    
    }
  }


  public static int[][] inputMatrix(int rows, int columns, Scanner keyboard) {
    if ((rows <= 0) || (columns <= 0)) {
      return null;
    }
    
    /* TODO */
    int[][] Matrix = new int [rows][columns];
    for(int i=0; i < Matrix.length; i++){
        for (int j = 0; j < Matrix[0].length; j++){
            Matrix[i][j] =keyboard.nextInt();
        }
    }
    return Matrix;
  }
  
  /* Method to print a array */
  public static void printArray(int[] array) {
    if (!isValid(array)) {
      return;
    }
    
    StringBuilder arrayString = new StringBuilder();
    for (int elem : array) {
      arrayString.append(elem).append(" ");
    }
    System.out.print(arrayString.toString().trim());
  }

  /* Method to print a matrix (2d array) */
  public static void printMatrix(int[][] matrix) {
    if (!isValid(matrix)) {
      return;
    }

    StringBuilder stringRow = new StringBuilder();
    for (int[] row : matrix) {
      stringRow.setLength(0);
      for (int elem : row) {
        stringRow.append(elem).append(" ");
      }
      System.out.println(stringRow.toString().trim());
    }
  }
  
  /* Method to add 2 matrices */
  public static int[][] addMatrices(int[][] leftMatrix, int[][] rightMatrix) {
    if ((!isValid(leftMatrix)) || (!isValid(rightMatrix))) {
      return null;
    }
    
    if ((leftMatrix.length != rightMatrix.length) 
         || (leftMatrix[0].length != rightMatrix[0].length)) {
      return null; 
    }
    
    /* TODO */
    int[][] sumMatrix = new int[leftMatrix.length][leftMatrix[0].length];
    for (int i = 0; i < sumMatrix.length; i++) {
    	for (int j = 0; j < sumMatrix[0].length; j++) {
    		sumMatrix[i][j] = leftMatrix[i][j] + rightMatrix[i][j];
    	}
    }
    return sumMatrix;
  }
  
  /* Method to sum columns of matrix */
  public static int[] sumColumns(int[][] matrix) {
    if (!isValid(matrix)) {
      return null;
    }
    
    /* TODO */
    int[] sumColumnsArray = new int[matrix[0].length];
    for (int i = 0; i < sumColumnsArray.length; i++) {
    	for (int j = 0; j < matrix.length; j++) {
    		sumColumnsArray[j] += matrix[i][j];
    	}
    }
    return sumColumnsArray;
  }
  
  /* Method to print sum of columns of matrix */
  public static void printSumColumns(int[][] matrix) {
    int[] sumArray = sumColumns(matrix);
    printArray(sumArray);
  }
  
  /* Method to delete a column of matrix */
  public static int[][] deleteColumn(int[][] matrix, int index) {
    if (!isValid(matrix)) {
      return null;
    }
    
    if ((index < 0) || (index >= matrix[0].length)) {
      return matrix;
    }
    
    if (matrix[0].length == 1) {
      return null;
    }
    
    /* TODO */
    int[][] newMatrix = new int[matrix.length][matrix[0].length - 1];
    for (int i = 0; i < matrix.length; i++) {
    	for (int j = 0; j < matrix[0].length; j++) {
    		if (j == index) {
    			continue;
    		}
    		if (j < index) {
    			newMatrix[i][j] = matrix[i][j];
    		}else {
    			newMatrix[i][j-1] = matrix[i][j];
    		}
    	}
    }
    return newMatrix;
  }
  
  /* Method to print the matrix having a column deleted */
  public static void printDeleteCulumnMatrix(int[][] matrix, int index) {
    int[][] deleteMatrix = deleteColumn(matrix, index);
    printMatrix(deleteMatrix);
  }
  
  /* Method to get upper triangular matrix of a matrix */
  public static int[][] getUpperTriangularMatrix(int[][] matrix) {
    if (!isValid(matrix)) {
      return null;
    }
    
    if (matrix.length != matrix[0].length) {
      return null;
    }
    
    /* TODO */
    int[][] upperTriangularMatrix = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < upperTriangularMatrix.length; i++) {
    	for (int j = 0; j < upperTriangularMatrix[0].length; j++) {
    		if (j >= i) {
    			upperTriangularMatrix[i][j] = matrix[i][j];
    		}
    	}
    }
    return upperTriangularMatrix;
  }
  
  /* Method to print upper triangular matrix of a matrix */
  public static void printUpperTriangularMatrix(int[][] matrix) {
    int[][] upperTriangularMatrix = getUpperTriangularMatrix(matrix);
    printMatrix(upperTriangularMatrix);
  }
  
  /* Method to check if a number is a prime */
  public static boolean isPrime(int number) {
    /* TODO */
	  if (number <= 1) {
	    	return false;
	    }
	    for (int i = 2; i <= Math.sqrt(number); i++) {
	    	if (number % i == 0) {
	    		return false;
	    	}
	    }
	    return true;
    }
  
  /* Method to get all primes in upper triangular matrix of a matrix */
  public static int[] getPrimesInUpperTriangularMatrix(int[][] matrix) {
    /* TODO */
    int countPrimeNum = 0;
	  for (int i = 0; i < matrix.length; i++) {
    	for (int j = 0; j < matrix[0].length; j++) {
    		if (j >= i) {
    			if (isPrime(matrix[i][j])) {
    				countPrimeNum++;
    			}
    		}
    	}
	  }
    	int[] primeNumArray = new int[countPrimeNum];
  	  countPrimeNum = 0;
  	  for (int i1 = 0; i1 < matrix.length; i1++) {
  	    for (int j = 0; j < matrix[0].length; j++) {
  	    	if (j >= i1) {
  	    		if (isPrime(matrix[i1][j])) {
  	    			primeNumArray[countPrimeNum] = matrix[i1][j];
  	    			countPrimeNum++;
  	    		}
  	    	}
  	    }
  	  }
  	  return primeNumArray;
  }
  
  /* Method to sort an array */
  public static void sortArrayInAscendingOrderUsingSelectionSort(int[] array) {
    if (!isValid(array)) {
      return;
    }

    int temp;
    int minIndex;
    for (int i = 0; i < array.length - 1; i++) {
      minIndex = i;
      // find index of the smallest element
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }

      // swap the smallest element and ith element
      if (minIndex != i) {
        temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
      }
    }
  }
}
