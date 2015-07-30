import java.util.Set;

import org.bukkit.entity.LivingEntity;

import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.MABoss;
import com.garbagemule.MobArena.waves.ability.Ability;
import com.garbagemule.MobArena.waves.ability.AbilityInfo;

@AbilityInfo(name = "Heal Monsters", aliases = { "healmonsters" })
public class HealMonsters implements Ability {

    private final double MAX_HEALTH_RECOVERY = 20.0;

    @Override
    public void execute(Arena arena, MABoss boss) {
        Set<LivingEntity> monsters = arena.getMonsterManager().getMonsters();
        for (LivingEntity e : monsters) {
            heal(e);
        }
    }

    private void heal(LivingEntity e) {
        double currentHealth = e.getHealth();
        double newHealth = Math.min(e.getMaxHealth(), currentHealth + MAX_HEALTH_RECOVERY);
        e.setHealth(newHealth);
    }

}
