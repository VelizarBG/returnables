package velizarbg.returnables;

import net.fabricmc.api.ModInitializer;

public class Returnables implements ModInitializer {
	public static Integer nextUid = Integer.MIN_VALUE;
	public static int currentEntryUid;

	@Override
	public void onInitialize() {
	}

	public static void nextUid() {
		++nextUid;
	}
}
