import java.util.Set;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;

import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.MABoss;
import com.garbagemule.MobArena.waves.ability.Ability;
import com.garbagemule.MobArena.waves.ability.AbilityInfo;

@AbilityInfo(name = "Sudo Shoot Arrow", aliases = { "sudoarrow" })
public class SudoShootArrow implements Ability {

    @Override
    public void execute(Arena arena, MABoss boss) {
        Set<LivingEntity> monsters = arena.getMonsterManager().getMonsters();
        for (LivingEntity m : monsters) {
            m.launchProjectile(Arrow.class);
        }
    }
}
