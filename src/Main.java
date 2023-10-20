import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GameProgress player1 = new GameProgress(100, 4, 2, 34.6);
        GameProgress player2 = new GameProgress(65, 34, 65, 23.12);
        GameProgress player3 = new GameProgress(23, 59, 78, 123.45);
        player1.saveGame("D://Games/savegames/players.txt", player1);
        player2.saveGame("D://Games/savegames/players.txt", player2);
        player3.saveGame("D://Games/savegames/players.txt", player3);
        player1.zipFiles("D://Games/savegames/players.txt", player1);
        player2.zipFiles("D://Games/savegames/players.txt", player2);
        player3.zipFiles("D://Games/savegames/players.txt",player3);

    }
}