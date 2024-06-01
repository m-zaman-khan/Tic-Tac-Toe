import java.util.Scanner;

//Game Class
public class Game {
    //Instance Variables
    protected String player_1;
    protected String player_2;

    //Constructor
    public Game() {
        setPlayer_1(player_1);
        setPlayer_2(player_2);
    }

    //Set player one is used to get player name from user.
    public void setPlayer_1(String player_1) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of First Player : ");
        this.player_1 = in.nextLine();
    }
    //Set player two is used to set player 2 name as Computer AI
    public void setPlayer_2(String player_2) {
        this.player_2 ="Computer AI";
        System.out.println("Second Player of this game is : "+this.player_2);
    }


    public int start(){
        return 0;
    } //Create Start method in parent class
    public int stop(){
        return 0;
    } //Create Stop method in parent class
    public int restart(){ return 0; } //Create restart method in parent class

    @Override
    public String toString() {
        return "Game{" +
                "player_1='" + player_1 + '\'' +
                ", player_2='" + player_2 + '\'' +
                '}';
    }
}
