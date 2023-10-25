import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GameProgress player1 = new GameProgress(100, 4, 2, 34.6);
        GameProgress player2 = new GameProgress(65, 34, 65, 23.12);
        GameProgress player3 = new GameProgress(23, 59, 78, 123.45);
        player1.saveGame("D://Games/savegames/player1.txt", player1);
        player2.saveGame("D://Games/savegames/player2.txt", player2);
        player3.saveGame("D://Games/savegames/player3.txt", player3);
        ArrayList<String> adressList = new ArrayList<>();
        adressList.add("D://Games/savegames/player1.txt");
        adressList.add("D://Games/savegames/player2.txt");
        adressList.add("D://Games/savegames/player3.txt");
        GameProgress.zipFiles("D://Games/savegames/zip_output.zip", adressList);

    }
}