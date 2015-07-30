import java.util.Collection;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;

import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.MABoss;
import com.garbagemule.MobArena.waves.ability.Ability;
import com.garbagemule.MobArena.waves.ability.AbilityInfo;
import com.garbagemule.MobArena.waves.ability.AbilityUtils;

@AbilityInfo(name = "Copy Target Buffs", aliases = { "copytargetbuffs" })
public class CopyTargetBuffs implements Ability {

    @Override
    public void execute(Arena arena, MABoss boss) {
        LivingEntity target = AbilityUtils.getTarget(arena, boss.getEntity(), false);
        if (target == null) {
            return;
        }

        Collection<PotionEffect> targetEffects = target.getActivePotionEffects();
        boss.getEntity().addPotionEffects(targetEffects);
    }

}
