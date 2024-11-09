package com.restonic4.serverdaw.mixin;

import com.mojang.authlib.GameProfile;
import com.restonic4.serverdaw.ServerDaw;
import net.minecraft.client.User;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(User.class)
public class UserMixin {
    @Inject(method = "getGameProfile", at = @At("HEAD"), cancellable = true)
    private void getGameProfile(CallbackInfoReturnable<GameProfile> cir) {
        User current = (User) (Object) this;

        cir.setReturnValue(new GameProfile(current.getProfileId(), ServerDaw.getName()));
        cir.cancel();
    }

    @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
    private void getName(CallbackInfoReturnable<String> cir) {
        User current = (User) (Object) this;

        cir.setReturnValue(ServerDaw.getName());
        cir.cancel();
    }
}
