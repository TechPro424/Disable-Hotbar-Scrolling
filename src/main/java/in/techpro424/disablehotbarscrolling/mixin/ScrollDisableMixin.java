package in.techpro424.disablehotbarscrolling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MouseHandler;

@Mixin(MouseHandler.class)
public abstract class ScrollDisableMixin {

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;setSelectedSlot(I)V"), method = "onScroll(JDD)V", cancellable = true)
    private void disableScrolling(long window, double horizontal, double vertical, CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

}
