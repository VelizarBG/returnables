package velizarbg.returnables.mixins;

import net.minecraft.server.function.CommandFunctionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Deque;

@Mixin(CommandFunctionManager.Execution.class)
public interface CommandFunctionManagerExecutionAccessor {
	@Accessor
	Deque<CommandFunctionManager.Entry> getQueue();
}
