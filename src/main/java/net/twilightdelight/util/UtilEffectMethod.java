package net.twilightdelight.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Goulixiaoji
 */
public class UtilEffectMethod {

    public static List<Entity> getEntitiesInRange(double size, LivingEntity entityInRange){
        final Vec3 position = new Vec3(entityInRange.getX(), entityInRange.getY(), entityInRange.getZ());

        return entityInRange.getLevel().getEntitiesOfClass(net.minecraft.world.entity.Entity.class, new AABB(position, position).inflate(size), e -> true)
                .stream().sorted(Comparator.comparingDouble(entcnd -> entcnd.distanceToSqr(position)))
                .collect(Collectors.toList());
    }


    public static void setEntityEffectByCommand(Entity entity, String command) {
        // Why Entity don't have addEffect()

        if (!entity.level.isClientSide && entity.getServer() != null){
            entity.getServer().getCommands().performCommand(
                    entity.createCommandSourceStack().withSuppressedOutput().withPermission(4),
                    command
            );
    }
    }

}
