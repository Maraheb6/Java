import java.util.Arrays;
import java.util.Collections;
import java.util.*;





public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[][] gameBord = {
                {' ', '|', ' ', '|', ' '},
                {'-','+','-','+','-'},
                {' ', '|', ' ', '|', ' '},
                {'-','+','-','+','-'},
                {' ', '|', ' ', '|', ' '}
        };

        printGB(gameBord);
        //updateGB(1,1,gameBord);
        boolean gameOver=false;
        boolean playAgine=true;
        while (playAgine){
            while (!gameOver){
                playerMove(gameBord);
                gameOver=winer(gameBord);
                if(gameOver){
                    break;
                }
                computerMove(gameBord);
                gameOver=winer(gameBord);
                if(gameOver){
                    break;
                }
            }
            System.out.println("Would You Like to Play Agine? (1:Yes  2:No)");
            int choice= s.nextInt();
            if(choice==1){
                playAgine=true;
                emptyGB(gameBord);
                gameOver=false;
                printGB(gameBord);
            }
            else if(choice==2){
                playAgine=false;
                System.out.println("Good Bye");
            }
            else System.out.println("Invalid Choice");
        }



    }

    public static void printGB(char[][] gameBord) {

        for (char i = 0; i < gameBord.length; i++) {
            for (char j = 0; j < gameBord[i].length; j++) {
                System.out.print(gameBord[i][j]);
            }
            System.out.println();
        }
    }

    public static void updateGB(int player, int place, char[][] gameBord) {
        char xo;

        if (player == 1)
            xo = 'X';
        else
            xo = 'O';


        if (place == 1) {
            gameBord[0][0] = xo;
            printGB(gameBord);
        } else if (place == 2) {
            gameBord[0][2] = xo;
            printGB(gameBord);
        } else if (place == 3) {
            gameBord[0][4] = xo;
            printGB(gameBord);
        } else if (place == 4) {
            gameBord[2][0] = xo;
            printGB(gameBord);
        } else if (place == 5) {
            gameBord[2][2] = xo;
            printGB(gameBord);
        } else if (place == 6) {
            gameBord[2][4] = xo;
            printGB(gameBord);
        } else if (place == 7) {
            gameBord[4][0] = xo;
            printGB(gameBord);
        } else if (place == 8) {
            gameBord[4][2] = xo;
            printGB(gameBord);
        } else if (place == 9) {
            gameBord[4][4] = xo;
            printGB(gameBord);
        }


    }

    public static boolean isValid(int move, char[][] gameBord) {
        if (move == 1) {
            if (gameBord[0][0] == ' ')
                return true;
            else
                return false;}

        else if (move == 2) {
            if (gameBord[0][2] == ' ')
                return true;
            else
                return false;}

        else if (move == 3) {
            if (gameBord[0][4] == ' ')
                return true;
            else
                return false;}

        else if (move == 4) {
            if (gameBord[2][0] == ' ')
                return true;
            else
                return false;}

        else if (move == 5) {
            if (gameBord[2][2] == ' ')
                return true;
            else
                return false;}

        else if (move == 6) {
            if (gameBord[2][4] == ' ')
                return true;
            else
                return false;}

        else if (move == 7) {
            if (gameBord[4][0] == ' ')
                return true;
            else
                return false;}

        else if (move == 8) {
            if (gameBord[4][2] == ' ')
                return true;
            else
                return false;}
        else if (move == 9) {
            if (gameBord[4][4] == ' ')
                return true;
            else
                return false;}

        else {
                return false;}
    }

    public static void playerMove(char[][]gameBord){
        int player=1;
        Scanner s=new Scanner(System.in);
        System.out.println("Where Would you like to play? (1-9)");
        int move=s.nextInt();

        boolean result=isValid(move,gameBord);
        while (!result){
            System.out.println("is not a valid move");
            System.out.println("Where Would you like to play? (1-9)");
             move=s.nextInt();

            result=isValid(move,gameBord);}
            updateGB(player,move,gameBord);


    }



    public static void computerMove(char[][]gamrBord){
        int player=2;

        Random random=new Random();
        random.setSeed(123456789);
        int move=random.nextInt();

        boolean result=isValid(move,gamrBord);

        while (!result){
            move=random.nextInt();
            result=isValid(move,gamrBord);
        }
        System.out.println("Computer Chose:" +move);
        updateGB(player,move,gamrBord);
    }



    public static boolean winer(char[][]gameBord){

        if(gameBord[0][0]=='X'&& gameBord[0][2]=='X'&& gameBord[0][4]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[0][0]=='O'&& gameBord[0][2]=='O'&& gameBord[0][4]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        if(gameBord[0][0]=='X'&& gameBord[2][0]=='X'&& gameBord[4][0]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[0][0]=='O'&& gameBord[2][0]=='O'&& gameBord[4][0]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        if(gameBord[0][0]=='X'&& gameBord[2][2]=='X'&& gameBord[4][4]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[0][0]=='O'&& gameBord[2][2]=='O'&& gameBord[4][4]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        if(gameBord[2][0]=='X'&& gameBord[2][2]=='X'&& gameBord[2][4]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[2][0]=='O'&& gameBord[2][2]=='O'&& gameBord[2][4]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        if(gameBord[0][4]=='X'&& gameBord[2][4]=='X'&& gameBord[4][4]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[0][4]=='O'&& gameBord[2][4]=='O'&& gameBord[4][4]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        if(gameBord[4][0]=='X'&& gameBord[4][2]=='X'&& gameBord[4][4]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[4][0]=='O'&& gameBord[4][2]=='O'&& gameBord[4][4]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        if(gameBord[0][4]=='X'&& gameBord[2][2]=='X'&& gameBord[4][0]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[0][4]=='O'&& gameBord[2][2]=='O'&& gameBord[4][0]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        if(gameBord[0][2]=='X'&& gameBord[2][2]=='X'&& gameBord[4][2]=='X')
        {
            System.out.println("Congratulations, You are The Winer!!");
            return true;
        }
        if(gameBord[0][2]=='O'&& gameBord[2][2]=='O'&& gameBord[4][2]=='O')
        {
            System.out.println("Computer Wins");
            return true;
        }
        return false;
    }
    public static void emptyGB(char[][]gameBord){
        gameBord[0][0]=' ';
        gameBord[0][2]=' ';
        gameBord[0][4]=' ';
        gameBord[2][0]=' ';
        gameBord[2][2]=' ';
        gameBord[2][4]=' ';
        gameBord[4][0]=' ';
        gameBord[4][2]=' ';
        gameBord[4][4]=' ';
    }

}















