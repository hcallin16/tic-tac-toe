import java.util.Scanner;
import java.util.Random;

public class TicTacToe
{
   
    
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      char[][] board = new char[3][3];
      boolean readyup = false, playerfirst = false, over = false, valid = false;
      String userinput = "", input = "Y";
      
      while (input.equals("Y")){
      over = false;
      readyup = false;
      
      resetBoard(board);
      printBoard(board);
      readyup = userInputWelcome(readyup);
      playerfirst = whoGoesFirst(playerfirst);
      
      if (playerfirst == false){
         board = computerFirstTurn(board);}
         
      outerloop:
      while (over == false){
      do { 
      printBoard(board);
      userinput = userInput(board);
      valid = validateUserInput(userinput, board, valid);
      if (valid == false && over == false)
         System.out.println("Invalid move! A piece is already there! Try again!");
      } while (valid == false && over == false);
      
      userTurn(userinput, board);
      printBoard(board);
      over = victory(board, over);
      if (over == true){
         break outerloop;}
      computerTurn(board);
      victory(board, over);
      }
      
      System.out.println("Would you like to play again? Y for yes, Q to quit: ");
      input = kb.nextLine();
      input = input.toUpperCase();
      
      loop1:
      do {
      if (input.equals("Y") || input.equals("Q"))
         break loop1;
      else{
         System.out.println("Input invalid! Try again!");
         input = kb.nextLine();
         input = input.toUpperCase();}
         
      }while (input != "Y" || input != "Q");
      
      }
      
      System.out.println("Thanks for playing!");
   }
   public static void resetBoard(char[][] board) {
      for (int i = 0; i < 3; i++)
         for (int j = 0; j < 3; j++)
            board[i][j] = '-';   
   
   }
   
   public static void printBoard(char[][] board) {
      System.out.println("1.  | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
      System.out.println("2.  | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
      System.out.println("3.  | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
      System.out.println("      A.  B.  C.");     
   }
   
   public static boolean userInputWelcome(boolean readyup) {
      Scanner kb = new Scanner(System.in);
      String input = "";
      System.out.println("Welcome to Tic-Tac-Toe!");
      System.out.println("Refer to the above board for input!");
      System.out.println("Input number first, then letter! Format as such: ");
      System.out.println("1A; 3A; 2B; 3A; etc. All other inputs are invalid!"); 
      System.out.println("To proceed, type Y!");
      input = kb.nextLine();
      
      do {
      if (input.equals("Y"))
         return true;
      else{
         System.out.println("Invalid input! Just type Y!");
         input = kb.nextLine();
         }
      } while (input !="Y");    
      return true;
   }
   
   public static String userInput(char[][] board) {
   Scanner kb = new Scanner(System.in);
   String input = "";
   
   System.out.println("Input number first, then letter! Format as such: ");
   System.out.println("1A; 3A; 2B; 3A; etc. All other inputs are invalid!");
   input = kb.nextLine();
   input = input.toUpperCase();
   
   do {
   if (input.equals("1A") || input.equals("2A") || input.equals("3A") || input.equals("1B") || input.equals("2B") || input.equals("3B") || input.equals("1C") || input.equals("2C") || input.equals("3C")){
      return input;
   }
   else{
      System.out.println("Invalid input! Try again!");
      input = kb.nextLine();}
   }while (input != "1A" || input != "2A" || input != "3A" || input != "1B" || input != "2B" || input != "3B" || input != "1C" || input != "2C" || input != "3C");
   return input;
   
   }
   
   public static char[][] userTurn(String input, char[][] board) {
      switch (input)
      {
         case "1A":
            board[0][0] = 'X';
         break;
         
         case "2A":
            board[1][0] = 'X';
         break;
         
         case "3A":
            board[2][0] = 'X';
         break;
         
         case "1B":
            board[0][1] = 'X';
         break;
         
         case "2B":
            board[1][1] = 'X';
         break;
         
         case "3B":
            board[2][1] = 'X';
         break;
         
         case "1C":
            board[0][2] = 'X';
         break;
         
         case "2C":
            board[1][2] = 'X';
         break;
         
         case "3C":
            board[2][2] = 'X';
         break;
      }
      return board;
   }
   
   public static boolean whoGoesFirst(boolean first) {
      int max = 2, min = 1;
      Random randomNum = new Random();
      int num = min + randomNum.nextInt(max);
      System.out.println("Randomizing who starts...");
      
      if (num == 1){
         System.out.println("---------------------");
         System.out.println("Computer goes first!");
         System.out.println("---------------------");
         return false;}
      else{
         System.out.println("---------------");
         System.out.println("You go first!");
         System.out.println("---------------");   
         return true;}
   }
   
   public static char[][] computerTurn(char[][] board) {
      int max = 3, min = 0,move1=0, move2=0;
      Random randomNum = new Random();
      
             
      do {
      move1 = min + randomNum.nextInt(max);
      move2 = min + randomNum.nextInt(max);
      } while (board[move1][move2] == 'X' || board[move1][move2] == 'O');
      
      board[move1][move2] = 'O';
      
      System.out.println("Computer's turn....");
      
      return board;
      
      
   }
   
   public static char[][] computerFirstTurn(char[][] board) {
      int max = 3, min = 0, firstmove1, firstmove2;
      Random randomNum = new Random();
      
      do {
      firstmove1 = min + randomNum.nextInt(max);
      firstmove2 = min + randomNum.nextInt(max);
      } while (board[firstmove1][firstmove2] == 'X' || board[firstmove1][firstmove2] == 'O');
      
      board[firstmove1][firstmove2] = 'O';
      return board;
      
   }
   
   public static boolean validateUserInput(String input, char[][] board, boolean valid) {
      switch (input)
      {
         case "1A":
            if (board[0][0] == 'X' || board[0][0] == 'O')
               return false;
         break;
         
         case "2A":
            if (board[1][0] == 'X' || board[1][0] == 'O')
               return false;
         break;
         
         case "3A":
            if (board[2][0] == 'X' || board[2][0] == 'O')
               return false;
         break;
         
         case "1B":
            if (board[0][1] == 'X' || board[0][1] == 'O')
               return false;
         break;
         
         case "2B":
            if (board[1][1] == 'X' || board[1][1] == 'O')
               return false;
         break;
         
         case "3B":
            if (board[2][1] == 'X' || board[2][1] == 'O')
               return false;
         break;
         
         case "1C":
            if (board[0][2] == 'X' || board[0][2] == 'O')
               return false;
         break;
         
         case "2C":
            if (board[1][2] == 'X' || board[1][2] == 'O')
               return false;
         break;
         
         case "3C":
            if (board[2][2] == 'X' || board[2][2] == 'O')
               return false;
         break;
      }
      return true;
   }
   
   public static boolean victory(char[][] board, boolean over) {
      if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X'){
         System.out.println("You win!!!");
         return true;}
      if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X'){
         System.out.println("You win!!!");
         return true;}
      if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X'){
         System.out.println("You win!!!");
         return true;}
      if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X'){
         System.out.println("You win!!!");
         return true;}
      if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'){
         System.out.println("You win!!!");
         return true;}
      if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X'){
         System.out.println("You win!!!");
         return true;}
      if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
         System.out.println("You win!!!");
         return true;}
      if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'){ 
         System.out.println("You win!!!");
         return true;}
         
      if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'){
         System.out.println("Computer wins!!!");
         return true;}
      
      int counter = 0;   
      for (int i = 0; i < 3; i++)
         for (int j = 0; j < 3; j++)
            if (board[i][j] == 'X' || board[i][j] == 'O'){
               
               counter += 1;
               if (counter == 9){
                  System.out.println("Game is a tie! Terminating program...");
                  System.exit(0);
               }  
            }
      
   
      return false;
   }
   
}