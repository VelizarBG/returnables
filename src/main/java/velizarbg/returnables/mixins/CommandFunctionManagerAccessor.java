package velizarbg.returnables.mixins;

import net.minecraft.server.function.CommandFunctionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CommandFunctionManager.class)
public interface CommandFunctionManagerAccessor {
	@Accessor
	CommandFunctionManager.Execution getExecution();
}
