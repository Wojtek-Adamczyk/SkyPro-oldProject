import java.io.*;

public class State
{
    public static final String FILE_PATH_PLAYER = "Saved games\\saved.player";
    public static final String FILE_PATH_WORLD = "Saved games\\saved.world";

    public static void savePlayer(Player player)
    {
        try
        {
            FileOutputStream fileSave = new FileOutputStream(FILE_PATH_PLAYER);
            ObjectOutputStream save = new ObjectOutputStream(fileSave);
            save.writeObject(player);
            save.close();
            fileSave.close();
            System.out.println("Game saved SUCCESSFULLY");
            System.out.println();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT SAVED");
            System.out.println();
        }
    }

    public static void saveWorld(World world)
    {
        try
        {
            FileOutputStream fileSave = new FileOutputStream(FILE_PATH_WORLD);
            ObjectOutputStream save = new ObjectOutputStream(fileSave);
            save.writeObject(world);
            save.close();
            fileSave.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public static Player loadPlayer()
    {
        try
        {
            FileInputStream fileLoad = new FileInputStream(FILE_PATH_PLAYER);
            ObjectInputStream load = new ObjectInputStream(fileLoad);
            Player player = (Player) load.readObject();
            load.close();
            fileLoad.close();
            System.out.println("Game loaded SUCCESSFULLY");
            System.out.println();
            return player;

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT LOADED");
            System.out.println();
            return null;
        }
    }

    public static World loadWorld()
    {
        try
        {
            FileInputStream fileLoad = new FileInputStream(FILE_PATH_WORLD);
            ObjectInputStream load = new ObjectInputStream(fileLoad);
            World world = (World) load.readObject();
            load.close();
            fileLoad.close();
            return world;
        }
        catch (IOException | ClassNotFoundException e) {e.printStackTrace(); return null;}
    }
}