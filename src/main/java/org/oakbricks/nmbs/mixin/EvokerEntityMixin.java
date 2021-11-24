package org.oakbricks.nmbs.mixin;

import net.minecraft.entity.mob.EvokerEntity;
import org.oakbricks.nmbs.SimpleConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EvokerEntity.WololoGoal.class)
public class EvokerEntityMixin {
	public boolean DISABLE_WOLOLO_GOAL = SimpleConfig.of("no-more-bleeding-sheep").request().getOrDefault("disableWololoGoalFromStarting", true);
	@Inject(at = @At("HEAD"), method = "canStart()Z", cancellable = true)
	public void canStart(CallbackInfoReturnable<Boolean> cir) {
		if (DISABLE_WOLOLO_GOAL) {
			cir.setReturnValue(false);
		}
	}
}