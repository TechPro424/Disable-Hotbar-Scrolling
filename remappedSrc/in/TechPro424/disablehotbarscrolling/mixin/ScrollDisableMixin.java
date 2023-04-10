package in.techpro424.disablehotbarscrolling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerInventory;

@Mixin(PlayerInventory.class)
public abstract class ScrollDisableMixin {

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/entity/player/PlayerInventory;scrollInHotbar(D)V", cancellable = true)
    private void disableScrolling(double scrollAmount, CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

}
