package velizarbg.returnables.mixins;

import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.function.CommandFunction;
import net.minecraft.server.function.CommandFunctionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import velizarbg.returnables.Returnables;

import java.util.Deque;

@Mixin(CommandFunction.FunctionElement.class)
public class CommandFunctionFunctionElementMixin {
	@Inject(method = "method_17914", at = @At(target = "Ljava/lang/Math;min(II)I", value = "INVOKE", shift = At.Shift.BY, by = 2))
	private static void beforeNewEntries(CommandFunctionManager.Tracer tracer, int i, int j, Deque<CommandFunctionManager.Entry> deque, ServerCommandSource serverCommandSource, CommandFunction f, CallbackInfo ci) {
		Returnables.nextUid();
	}
}
