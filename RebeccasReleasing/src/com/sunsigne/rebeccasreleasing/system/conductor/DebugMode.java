package com.sunsigne.rebeccasreleasing.system.conductor;

import com.sunsigne.rebeccasreleasing.system.util.Cycloid;

public class DebugMode {

	private final Cycloid<Boolean> hitboxMode = new Cycloid<>(false, true);
	private final Cycloid<Boolean> wallPassMode = new Cycloid<>(false, true);
	private final Cycloid<Boolean> multiToolMode = new Cycloid<>(true, false, true);

	public Cycloid<Boolean> getHitboxMode() {
		return hitboxMode;
	}

	public Cycloid<Boolean> getWallPassMode() {
		return wallPassMode;
	}

	public Cycloid<Boolean> getMultiToolMode() {
		return multiToolMode;
	}
}
