package com.github.tryflle.fakenameenhanced.mixin;


import com.github.tryflle.fakenameenhanced.util.NameUtil;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FontRenderer.class)
class FontRendererMixin {

    @ModifyVariable(method = "renderStringAtPos", at = @At("HEAD"), argsOnly = true)
    private String modifyRenderStringAtPos(String text) {
        return NameUtil.INSTANCE.replaceString(text);
    }

    @ModifyVariable(method = "getStringWidth", at = @At("HEAD"), argsOnly = true)
    private String modifyGetStringWidth(String text) {
        return NameUtil.INSTANCE.replaceString(text);
    }
}