package org.oakbricks.nmbs.mixin;

import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.passive.SheepEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EvokerEntity.class)
public class EvokerEntityMixin {
	@Shadow private SheepEntity wololoTarget;

	@Overwrite
	public void setWololoTarget(@Nullable SheepEntity sheep) {
		this.wololoTarget = null;
	}
}
