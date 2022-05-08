package velizarbg.returnables.mixins;

import net.minecraft.server.function.CommandFunctionManager;
import org.spongepowered.asm.mixin.Mixin;
import velizarbg.returnables.Returnables;
import velizarbg.returnables.util.EntryInterface;

@Mixin(CommandFunctionManager.Entry.class)
public class CommandFunctionManagerEntryMixin implements EntryInterface {
	private final Integer uid = Returnables.nextUid;

	@Override
	public int getUid() {
		return this.uid;
	}
}
