package net.twilightdelight.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class KnightmetalknifeHitProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.hurt(DamageSource.GENERIC, entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0);
	}
}
