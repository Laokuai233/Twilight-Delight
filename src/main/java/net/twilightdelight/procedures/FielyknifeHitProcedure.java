package net.twilightdelight.procedures;

import net.minecraft.world.entity.Entity;

public class FielyknifeHitProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(15);
	}
}
