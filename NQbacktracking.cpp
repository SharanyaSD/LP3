#include <iostream>
#define N 8
using namespace std;

void
printSolution (int board[N][N])
{
  for (int i = 0; i < N; i++)
    {
      for (int j = 0; j < N; j++)
	if (board[i][j])
	  cout << "Q ";
	else
	  cout << ". ";
      printf ("\n");
    }
}

bool
isSafe (int board[N][N], int row, int col)
{
  int i, j;
// checks if there is any queen in the same row on the left side of the current position. 
  for (i = 0; i < col; i++)
    if (board[row][i])
      return false;
//This loop checks the upper-left diagonal of the current position.
  for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
    if (board[i][j])
      return false;
//This loop checks the lower-left diagonal of the current position. It iterates from the current position 
  for (i = row, j = col; j >= 0 && i < N; i++, j--)
    if (board[i][j])
      return false;

  return true;
}


//The function takes the chessboard represented by a 2D array board and the current column col as parameters. It checks if all the columns have been processed. If so, it means that queens have been successfully placed in all columns, and it returns true to indicate a valid solution.
bool
solveNQUtil (int board[N][N], int col)
{
  if (col >= N)
    return true;

  for (int i = 0; i < N; i++)
    {
      if (isSafe (board, i, col))
	{
	  board[i][col] = 1;

	  if (solveNQUtil (board, col + 1))
	    return true;

	  board[i][col] = 0;
	}
    }

  return false;
}

bool
solveNQ ()
{
  int board[N][N] = { {0} };
  //check if soln exists
  if (solveNQUtil (board, 0) == false)
    {
      cout << "Solution does not exist";
      return false;
    }

  printSolution (board);
  return true;
}

int
main ()
{
  solveNQ ();
  return 0;
}
