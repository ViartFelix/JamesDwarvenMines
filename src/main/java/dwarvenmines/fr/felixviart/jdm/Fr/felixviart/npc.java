package dwarvenmines.fr.felixviart.jdm.Fr.felixviart;

import com.google.gson.JsonObject;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class npc {
    private World world=Bukkit.getWorlds().get(0);
    private MySQL DB_NPC=new MySQL();
    //static ResultSet allNPCs;
    private ArrayList allNPC=null;
    public void initNPCs() throws SQLException, IOException, ClassNotFoundException {
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dwarven_mines","root","");
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM npcs"
        )) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Location loc=new Location(world,rs.getDouble("X"),rs.getDouble("Y"),rs.getDouble("Z"),rs.getFloat("yaw"),0);
                setNPCSkin(
                        rs.getString("name"),
                        loc,
                        rs.getString("signature"),
                        rs.getString("value"),
                        rs.getDouble("yaw")
                );
            }

            rs.close();
        } catch (Exception ex) {
            System.out.println("------------------ERROR-----------------");
            System.out.println("Stacktrace: " + ex);
            System.out.println("----------------------------------------");
        }
    }

    public void setNPCSkin(String name, Location location, String signature, String data, Double yaw) {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC npc = registry.createNPC(EntityType.PLAYER, name);
        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent(name+"'s skin",signature,data);
        npc.spawn(location);
    }
}