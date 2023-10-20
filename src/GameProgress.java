import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String address, GameProgress gameProgress) {
        try {
            File files = new File("D://Games/savegames/players.txt");
        } catch (Exception e) {
            System.err.println(e);
        }
        try (
                FileOutputStream fos = new FileOutputStream("players.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (IOException e) {
            System.err.println(e);;
        }
    }
    public void zipFiles(String address, GameProgress gameProgress) throws FileNotFoundException {
        try (ZipOutputStream zout = new ZipOutputStream(new
                FileOutputStream("zip_output.zip"));
             FileInputStream fis = new FileInputStream("players.txt")) {
            ZipEntry entry = new ZipEntry("packed_notes.txt");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
