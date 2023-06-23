
/**
 * # Chess Game(Doubt)
 * # A Chess Game Made In Java With The Use Of 2-D Array
 * 
 * !> After Inputting The Value As 4a-4b, The ChessBoard Is Not Updating(Not Swapping The Values)...
 * 
 * @author (Divyanshu Dhruv)
 * @version (0.1)
 */
import java.util.*;
public class Chess{
    String p1,p2;
    String posStart,posEnd,posStartRow,posStartColumn,posEndRow,posEndColumn;
    int row,column;

    boolean king; 
    String chessBoard1[][] = {
            {"R","P"," "," "," "," ","P","R"},
            {"K","P"," "," "," "," ","P","K"},
            {"B","P"," "," "," "," ","P","B"},
            {"K","P"," "," "," "," ","P","K"},
            {"Q","P"," "," "," "," ","P","Q"},
            {"B","P"," "," "," "," ","P","B"},
            {"K","P"," "," "," "," ","P","K"},
            {"R","P"," "," "," "," ","P","R"}
        };     

    Scanner sc;

    Chess(){
        p1 = p2 = posStart = posEnd = "";
        king = false;
        sc = new Scanner(System.in);
    }

    public void k(){
        String temp = chessBoard1[0][0]; // Refers To 1a
        chessBoard1[0][0] = chessBoard1[3][0]; // Swapping 4a => 1a
        chessBoard1[3][0] = temp; // Swapping 1a => 4a(TEMP)
    }

    void lookPiece(){
        if(chessBoard1[row][column].equals("K"))
            k(); //king      
        else
            System.out.println("Error");
    }

    void getValues(){
        if(posStart.equals("4a")){
            row= 3;
            column=0;                   
        }else
            System.out.println("Error");
    }

    void getPos(String n){
        posStart=n.substring(0,2);  
        posEnd=n.substring(3);
    }

    void spacer(){
        System.out.println();
        System.out.println();
    }

    void input(){
        Chess obj = new Chess();
        while (king != true){
            obj.spacer();

            System.out.println("+=====================+");
            System.out.print("Enter The Moves (P1)[TYPE => 4a-4b]: ");
            p1 = sc.next();
            System.out.print("Enter The Moves (P2)[TYPE ANYTHING]: ");
            p2 = sc.next();
            System.out.println("+=====================+");
            obj.spacer();

            obj.printChessBoard(); 

            obj.getPos(p1);
            obj.getValues();
            obj.lookPiece();
        }
    }

    void printChessBoard() {
        // Add Space Before The Letters
        System.out.print("   "); 

        // Print Letters
        for(char k ='a'; k<='h';k++){
            System.out.print("    "+k + " ");
        }

        // Print Space
        System.out.println();
        System.out.println();

        // Variable For Number
        int a =1;

        // Print Chess Board
        for (int i = 0; i < chessBoard1.length; i++) {
            // Margin
            System.out.println("    +-----------------------------------------------+");

            // Left Numbers
            System.out.print(a+"  ");

            // Chess Board
            for (int j = 0; j < chessBoard1[i].length; j++) {
                // Left Margin And Chess Board
                System.out.print(" |  " + chessBoard1[i][j] + " ");
            }

            // Right Margin
            System.out.print(" |   " + a);
            System.out.println();

            // Updating The Number
            a=a +1;
        }

        // Bottome Margin
        System.out.println("    +-----------------------------------------------+");
        System.out.println();

        // Space For Letters
        System.out.print("   ");

        // Print The Letters
        for(char k ='a'; k<='h';k++){
            System.out.print("    "+k + " ");
        }

        // Space
        System.out.println();
    }

    public static void main() throws InterruptedException {
        Chess obj = new Chess();
        // Creating A Chess Board And Filling It With Initial Values
        // String chessBoard[][] = {
        // {"R","P"," "," "," "," ","P","R"},
        // {"K","P"," "," "," "," ","P","K"},
        // {"B","P"," "," "," "," ","P","B"},
        // {"K","P"," "," "," "," ","P","K"},
        // {"Q","P"," "," "," "," ","P","Q"},
        // {"B","P"," "," "," "," ","P","B"},
        // {"K","P"," "," "," "," ","P","K"},
        // {"R","P"," "," "," "," ","P","R"}
        // };     
        obj.printChessBoard();
        obj.input();
    }
}

