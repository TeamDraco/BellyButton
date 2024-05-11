package teamdraco.bellybutton.common.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

// todo - add an advancement to explain this effect a bit, 'Survive having itchy without taking off your armor'
public class ItchyEffect extends MobEffect {

    public ItchyEffect(MobEffectCategory typeIn, int color) {
        super(typeIn, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        float f = entity.getArmorCoverPercentage();

        if (entity.getHealth() > 1.0F) {
            entity.hurt(DamageSource.MAGIC, f * 4.0F);
        }
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }
}
