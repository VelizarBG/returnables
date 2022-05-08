package velizarbg.returnables.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.function.CommandFunctionManager;
import velizarbg.returnables.Returnables;
import velizarbg.returnables.util.EntryInterface;
import velizarbg.returnables.mixins.CommandFunctionManagerAccessor;
import velizarbg.returnables.mixins.CommandFunctionManagerExecutionAccessor;

import java.util.Deque;

import static net.minecraft.server.command.CommandManager.literal;

public class ReturnCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(
			literal("return").requires(source -> source.hasPermissionLevel(2))
				.executes(context -> {
					try {
						Deque<CommandFunctionManager.Entry> queue = ((CommandFunctionManagerExecutionAccessor) (((CommandFunctionManagerAccessor) context.getSource().getServer().getCommandFunctionManager()).getExecution())).getQueue();
						int currentUid = Returnables.currentEntryUid;
						while (((EntryInterface) queue.getFirst()).getUid() == currentUid) {
							queue.removeFirst();
						}
						return 1;
					} catch (NullPointerException e) {
						return 0;
					}
				})
		);
	}
}
