package com.happyrespawnanchor.noblockedservers.mixin;

import net.minecraft.client.multiplayer.resolver.AddressCheck;
import net.minecraft.client.multiplayer.resolver.ResolvedServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerNameResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerNameResolver.class)
public abstract class ServerNameResolverMixin {
    @Redirect(method = "resolveAddress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/resolver/AddressCheck;isAllowed(Lnet/minecraft/client/multiplayer/resolver/ServerAddress;)Z"))
    private boolean redirectIsAllowed(AddressCheck addressCheck, ServerAddress address) {
        return true;
    }
    @Redirect(method = "resolveAddress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/resolver/AddressCheck;isAllowed(Lnet/minecraft/client/multiplayer/resolver/ResolvedServerAddress;)Z"))
    private boolean redirectIsAllowed(AddressCheck addressCheck, ResolvedServerAddress address) {
        return true;
    }

}
