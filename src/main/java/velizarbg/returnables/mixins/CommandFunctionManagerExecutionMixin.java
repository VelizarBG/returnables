package velizarbg.returnables.mixins;

import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.function.CommandFunction;
import net.minecraft.server.function.CommandFunctionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import velizarbg.returnables.Returnables;
import velizarbg.returnables.util.EntryInterface;

@Mixin(CommandFunctionManager.Execution.class)
public class CommandFunctionManagerExecutionMixin {
	@Inject(method = "run", at = @At(target = "Lnet/minecraft/server/function/CommandFunction;getElements()[Lnet/minecraft/server/function/CommandFunction$Element;", value = "INVOKE", shift = At.Shift.AFTER))
	private void beforeNewEntries(CommandFunction function, ServerCommandSource source, CallbackInfoReturnable<Integer> cir) {
		Returnables.nextUid();
	}

	@ModifyVariable(method = "run", at = @At(target = "Ljava/util/Deque;removeFirst()Ljava/lang/Object;", value = "INVOKE", shift = At.Shift.BY, by = 3), index = 6)
	private CommandFunctionManager.Entry storeCurrentEntryUid(CommandFunctionManager.Entry currentEntry) {
		Returnables.currentEntryUid = ((EntryInterface) currentEntry).getUid();
		return currentEntry;
	}
}
