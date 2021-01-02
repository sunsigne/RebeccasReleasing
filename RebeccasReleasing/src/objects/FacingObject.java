package objects;

import objects.world.storing.Looting;

public abstract class FacingObject extends GameObject implements Looting {

	protected boolean horizontal;
	protected boolean facingLeft;
	protected boolean updatableFacing;

	public FacingObject(int x, int y, boolean facingLeft, boolean horizontal, OBJECTID id) {
		super(x, y, id);
		this.facingLeft = facingLeft;
		this.horizontal = horizontal;
	}

	public FacingObject(int x, int y, OBJECTID id) {
		super(x, y, id);
	}

	// state

	public void setFacingLeft(boolean reflection) {
		this.facingLeft = reflection;
	}

	public boolean isFacingLeft() {
		return facingLeft;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setUpdatableFacing(boolean updatableFacing) {
		this.updatableFacing = updatableFacing;
	}

	public boolean isUpdatableFacing() {
		return updatableFacing;
	}

}
