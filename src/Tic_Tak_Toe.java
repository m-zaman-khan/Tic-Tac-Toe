import java.util.Random;  //Import Random file from library
import java.util.Scanner;  //Import Scanner for getting Input from user
import static java.lang.System.exit; //Import exit file to terminate a program.

//Tic_Tak_Toe class inherit/extend Game Class
public class Tic_Tak_Toe  extends  Game{
    enum enter{  O, X, Empty }                                      //Declare Enum type
    private  enter [][] arr =new enter[3][3];                //Declare enum type Array
    public static   int playercounter;                            //Counter to count that how may time player Wins
    public static int compcounter;                               //Counter to count that how may time Computer Wins
    public static int tiecounter;                                    //Counter to count that how may time Game ties
    public  Scanner in = new Scanner(System.in);   //Create Scanner object which is accessible in ever method which is in this Class

    // Constructor of Tic_Tak_Toe
    public Tic_Tak_Toe() {
        super();
       setEmpty();   //Call setEmpty method  to set all 3-by-3 Array to Empty by using Enum type(enter.Empty)
    }

    //Override Start method which is in parent class (Game)
    @Override
    public int start() {
        while (true) {              //While loop which is only terminate when User want
            playerMove();        //PlayerMove method is used to get move from user
            computerMove();  //ComputerMove method is used to get move from Computer using Random
            start();                     //Calling Start Function Again
            return super.start();
        }
    }

    //Override Stop method which is in parent class (Game)
    @Override
    public int stop() {
        System.out.println("Now your game is Stopped");
        gameBoard();                                                                                               //To display current  Game board  with current Move
        System.out.println("Total times win by Player : "+ playercounter);               //To print counter value that how many time player wins
        System.out.println("Total times win by Computer : "+compcounter);   //To print counter value that how many time Computer wins
        System.out.println("Total Ties : "+tiecounter);                                           //To print counter value that how many time game ties
        System.out.println();                                                                                    //print blank line for Spacing
        System.out.println("Now press 1 to restart and press 2 to terminate");
        int i=in.nextInt();                                                                                            //Getting Input from user
        switch (i)                                                                                                        //Switch
        {
            case 1 -> restart();                                                                                    //Press 1 to Call restart method
            case 2-> exit(0);                                                                          //Press 2 to  Terminate Program
        }
        return super.stop();
    }

    //Override restart method which is in parent class (Game)
    @Override
    public int restart() {
        setEmpty();                                                          // Call setEmpty method  to set all 3-by-3 Array to Empty by using Enum type(enter.Empty)
        compcounter =0;                                               //Initialize Computer Counter to zero  when game is restart
        playercounter = 0;                                                 //Initialize Player Counter to zero  when game is restart
        tiecounter=0;                                                      //Initialize Ties Counter to zero  when game is restart
        System.out.println("\n");                                     //Print Blank line for spacing
        System.out.println("Now game is restart ");
        setPlayer_1(player_1);                                        //Setplayer1 name again when game is restart
        setPlayer_2(player_2);                                      //Setplayer2 name again Computer AI BY-DEFAULT when game is restart
        start();                                                                  //Calling Start Function Again
        return super.restart();
    }

    //setEmpty method is used to set all 3-by-3 Array to Empty by using Enum type(enter.Empty)
    public void setEmpty(){
        for(int i = 0; i<3 ; i++)
        { for(int j = 0; j<3 ; j++)
        { arr[i][j]=enter.Empty; } }
    }

    //Display game board on Console Screen
    public void gameBoard(){
        for(int i = 0; i<3 ; i++)
        { for(int j = 0; j<3 ; j++)
        {
            System.out.print(" |");
            System.out.printf("%7s",arr[i][j]);
            }
            System.out.println();
            System.out.println(" -------   ------   -----"); }
         }

       //This following method is used To get player move from user
    public void playerMove() {
        System.out.println(this.player_1 + "'s Turn (X) ");
        int entry;
        System.out.print("Enter the location of box from (1 to 9) and press 10 to stop : ");
        entry = in.nextInt();                                   //Get move from user
        if(entry==10){stop();}                               //If user enter 10 then stop the game
        boolean result;
        result = validMoveCheck(arr, entry);     //Check validation that whether place is taken or not
        while (!result) { System.out.print("Invalid Move! This place Already taken Enter Again : ");
            entry = in.nextInt();                               //Get move from user
            if(entry==10){stop();}                           //If user enter 10 then stop the game
            result = validMoveCheck(arr, entry); }   //Check validation that whether place is taken or not
        setMove(arr,entry,1);                       //Set move in array
        gameBoard();                                               //print gameboard again
        checkWinner();                                            //Check whether player one is winner or not.
    }

     //This Method is used to check that the move is valid or not.
    private  boolean validMoveCheck (enter[][] arr, int position) {
        //Enhanced Switch which return values in true or false.
        return switch (position) {
            case 1 -> (arr[0][0] == enter.Empty);
            case 2 -> (arr[0][1] == enter.Empty);
            case 3 -> (arr[0][2] == enter.Empty);
            case 4 -> (arr[1][0] == enter.Empty);
            case 5 -> (arr[1][1] == enter.Empty);
            case 6 -> (arr[1][2] == enter.Empty);
            case 7 -> (arr[2][0] == enter.Empty);
            case 8 -> (arr[2][1] == enter.Empty);
            case 9 -> (arr[2][2] == enter.Empty);
            default -> false;
        };
    }

    //This method is used to set move in array
    public void setMove(enter[][]arr, int position,int player){
        enter symbol = enter.Empty ;
        if(player == 1){ symbol = enter.X; }     //Player one is X
        if(player == 2){ symbol = enter.O; }   //Player 2 means Computer AI is O

        //This Enhanced switch is used to set move in array
        switch (position){
            case 1  -> arr[0][0]=symbol ;
            case 2 -> arr[0][1]= symbol;
            case 3 -> arr[0][2]=symbol;
            case 4 -> arr[1][0]= symbol;
            case 5 -> arr[1][1]=  symbol;
            case 6 -> arr[1][2]= symbol;
            case 7 -> arr[2][0]=symbol;
            case 8 -> arr[2][1]= symbol;
            case 9 -> arr[2][2]=symbol;
        }
    }

    //This method is used get move from computer using random function
    public  void computerMove(){
        Random cm = new Random();     //Create object of random
        int move;
        move = cm.nextInt(9)+1;  //Bound computer to select integer between 1-9
        boolean result= validMoveCheck( arr, move);   //Check validation of computer move
        //While loop to get move again and again if computer move is invalid
        while(!result)
        {  System.out.print("Invalid Move! This place Already taken Enter Again : ");
            move = cm.nextInt(9)+1;
            result = validMoveCheck(arr, move);  }
        System.out.println();
        System.out.println("Computer's Turn (O)");
        System.out.println("Move by Computer : "+move);
        setMove(arr,move,2);                  //Set move function is used to set computer move in an array.
        gameBoard();                             //To print game board with updated move.
        checkWinner();                          //This function is used to check weather the computer is wins or not
    }

    //This method is used to check indexes that if X match then player wins and vice versa
    public static enter playerHasWon(enter[][] arr) {
        //Check each row
        for(int i = 0; i < 3; i++) {
            if(arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][0] != enter.Empty) {
                return arr[i][0];
            }
        }
        //Check each column
        for(int j = 0; j < 3; j++) {
            if(arr[0][j] == arr[1][j] && arr[1][j] == arr[2][j] && arr[0][j] != enter.Empty) {
                return arr[0][j];
            }
        }
        //Check the diagonals
        if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] != enter.Empty) {
            return arr[0][0];
        }
        if(arr[2][0] == arr[1][1] && arr[1][1] ==  arr[0][2] && arr[2][0] != enter.Empty) {
            return arr[2][0];
        }
        //Otherwise, nobody has not won yet
        return enter.Empty;
    }

    //This method is used to print winner name and other details
    public void checkWinner(){
        if(playerHasWon(arr)==enter.X){
            System.out.println(this.player_1+" is a Winner");
            playercounter++;                            //This instance variable is used to store players wins
            askfromUser();
        }else if(playerHasWon(arr)==enter.O) {
            System.out.println(this.player_2+" is a Winner");
            compcounter++;                          //This instance variable is used to store Computer wins
            askfromUser();
        }else if(Tie(arr)){
            System.out.println("No one is winner because Game is Tie");
            tiecounter++;                                   //This instance variable is used to store ties
            askfromUser();
        }
    }

    //This method is used to find that the game is tie or not
    public boolean Tie(enter[][] arr) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[i][j] == enter.Empty) {
                    return false;
                }
            }
        }
        return true;
    }
    public void askfromUser(){
        System.out.print("Press 1 to Play Again , Press 2 to Restart or Press 3 to stop or terminate Game :  ");
        int en=in.nextInt();
        if(en == 1){ setEmpty();  System.out.println(); start();}
        if(en == 2){ setEmpty(); restart();}
        if(en == 3){  stop();}
    }
}