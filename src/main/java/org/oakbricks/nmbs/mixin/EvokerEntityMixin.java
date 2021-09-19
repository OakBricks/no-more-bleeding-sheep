package org.oakbricks.nmbs.mixin;

import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.raid.RaiderEntity;
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

	@Overwrite
	public final @Nullable SheepEntity getWololoTarget() {
		return null;
	}
}

@Mixin(EvokerEntity.WololoGoal.class)
class WololoGoalMixin {
	@Overwrite
	public boolean canStart() {
		return false;
	}
	@Overwrite
	public boolean shouldContinue() {
		return false;
	}
	@Overwrite
	public void castSpell() {}
	@Overwrite
	public SpellcastingIllagerEntity.Spell getSpell() {
		return SpellcastingIllagerEntity.Spell.NONE;
	}
}
@Mixin(EvokerEntity.LookAtTargetOrWololoTarget.class)
class LookAtTargetOrWololoTargetMixin {
	@Overwrite
	public void tick() {
		if (((EvokerEntity) (Object) this).getTarget() != null) {
			((EvokerEntity) (Object) this).getLookControl().lookAt(((EvokerEntity) (Object) this).getTarget(), (float)((EvokerEntity) (Object) this).getBodyYawSpeed(), (float)((EvokerEntity) (Object) this).getLookPitchSpeed());
		}
	}
}