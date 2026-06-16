package com.github.tryflle.fakenameenhanced.mixin;

import com.github.tryflle.fakenameenhanced.util.NameUtil;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;

import net.minecraft.network.chat.contents.PlainTextContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PlainTextContents.LiteralContents.class)
public abstract class LiteralContentsMixin {

    @Shadow public abstract String text();

    @Inject(method = "visit(Lnet/minecraft/network/chat/FormattedText$ContentConsumer;)Ljava/util/Optional;", at = @At("HEAD"), cancellable = true)
    private <T> void onVisit(FormattedText.ContentConsumer<T> visitor, CallbackInfoReturnable<Optional<T>> cir) {
        String replaced = NameUtil.INSTANCE.replaceString(this.text());
        cir.setReturnValue(visitor.accept(replaced));
    }

    @Inject(method = "visit(Lnet/minecraft/network/chat/FormattedText$StyledContentConsumer;Lnet/minecraft/network/chat/Style;)Ljava/util/Optional;", at = @At("HEAD"), cancellable = true)
    private <T> void onVisitStyled(FormattedText.StyledContentConsumer<T> visitor, Style style, CallbackInfoReturnable<Optional<T>> cir) {
        String replaced = NameUtil.INSTANCE.replaceString(this.text());
        cir.setReturnValue(visitor.accept(style, replaced));
    }
}
