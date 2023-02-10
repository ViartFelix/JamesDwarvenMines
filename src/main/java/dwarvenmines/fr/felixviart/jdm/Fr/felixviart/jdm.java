package dwarvenmines.fr.felixviart.jdm.Fr.felixviart;


import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.npc.skin.Skin;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import net.citizensnpcs.api.CitizensAPI;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public final class jdm extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //npc.createNPC("hello :)");

        /*
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC npc = registry.createNPC(EntityType.PLAYER, "npc test");
        World world= Bukkit.getWorlds().get(0);
        Location loc=new Location(world,-41,200,-120);
        String signature="C2lrhfmFNC0HSUhwwGD97CgdOEY5Psg1Z64+J4S/OR8TNX/lmYEtTTxlOeUJGv63aZUWtoTraAuFFxvP1jbbjoBRTsvTLPonGkdLo+eKCcSQH7dudUMErKC5GqgEWXDP1KK9cPYBO881MznM1sQGiFcPLp1kXfYC65hQcHxIDH75yu1MQuTuSS08fcmBRUnImtuxHgRKXoIpno6XI/ndQVg3Gjaray+IkgGLtmzE+uo1NxOLTVENMoDRGmpvLV4G9xkVlMbnNQtF70gOhfLLM7Dwyji5hKAOhCN5ZpM4iyoFQk7/SzySX/J15xfLiWzSJzMiBPXEXMvfzJjZtsKzXiFEM0+oZ/eaemHWr2/SxTAxYovzfiJCB5s6AJvG9+kqtBGb0RGl6HGIs8r3Rnxd6ge8FTgutbdLtmdz9Mvs54DSp95/rCvHF9qM9UZlImkrWz5A07YdOUqmEEsiXnpS/K5+pEt6GdSKS8pUQZn8kSUBT7iujzFnCECDdMakwDmLa8fa2yFpyDzOWcGjOaSWigj2zOpRFKnfKJg+pxshrfoZeLAdPS6qRx2GWcbg+ICA1mza24OfU2Nh0TV6444GZ44h8qey25Y/aSyAyh8GPTOr7pKqzQIfKvjaUN0piTs6sCTY5tcRn9zRWN2f7KbmaQ+V0elwqA1Q7XGL904zcj4=";
        String data="ewogICJ0aW1lc3RhbXAiIDogMTU5NzQyNDgzNzAyOCwKICAicHJvZmlsZUlkIiA6ICI2MTI4MTA4MjU5M2Q0OGQ2OWIzMmI3YjlkMzIxMGUxMiIsCiAgInByb2ZpbGVOYW1lIiA6ICJuaWNyb25pYzcyMTk2IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzQwZDMwZWJjYzkxMDI5YmRjM2MxOGI4N2ZhMzMzNTkzMjI5M2IwMGRlMjUxYjJkMTE3NWQyYzA4Y2JmNzcwNTUiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==";
        //SkinTrait skin=npc.getOrAddTrait(SkinTrait.class);
        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent("qzdqzzq",signature,data);
        //skin.setFetchDefaultSkin(false);
        //skin.setShouldUpdateSkins(true);
        npc.spawn(loc);

         */

        npc npc=new npc();
        try {
            npc.initNPCs();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
