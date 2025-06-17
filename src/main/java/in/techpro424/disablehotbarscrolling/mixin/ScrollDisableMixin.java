package in.techpro424.disablehotbarscrolling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Mouse;

@Mixin(Mouse.class)
public abstract class ScrollDisableMixin {

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;setSelectedSlot(I)V"), method = "Lnet/minecraft/client/Mouse;onMouseScroll(JDD)V", cancellable = true)
    private void disableScrolling(long window, double horizontal, double vertical, CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

}
