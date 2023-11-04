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
    public void saveGame(String address) {
        try {
            File files = new File(address);
        } catch (Exception e) {
            System.err.println(e);
        }
        try (
                FileOutputStream fos = new FileOutputStream(address);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println(e);
            ;
        }
    }

    public static void zipFiles(String address, List<String> adressList) throws FileNotFoundException {
        for (String arr : adressList) {
            try (ZipOutputStream zout = new ZipOutputStream(new
                    FileOutputStream(address));
                 FileInputStream fis = new FileInputStream(arr)) {
                ZipEntry entry = new ZipEntry(new File(fis.toString()).getName());
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
}
