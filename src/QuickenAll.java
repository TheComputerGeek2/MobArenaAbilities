import java.util.Set;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.MABoss;
import com.garbagemule.MobArena.waves.ability.Ability;
import com.garbagemule.MobArena.waves.ability.AbilityInfo;

@AbilityInfo(name = "Quicken All", aliases = { "quickenall" })
public class QuickenAll implements Ability {

    private final int SPEED_LEVEL = 3;

    private final int DURATION = 1200;

    @Override
    public void execute(Arena arena, MABoss boss) {
        Set<Player> players = arena.getPlayersInArena();
        Set<LivingEntity> monsters = arena.getMonsterManager().getMonsters();
        PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, DURATION, SPEED_LEVEL);

        for (Player p : players) {
            p.addPotionEffect(effect);
        }
        for (LivingEntity e : monsters) {
            e.addPotionEffect(effect);
        }

    }

}
