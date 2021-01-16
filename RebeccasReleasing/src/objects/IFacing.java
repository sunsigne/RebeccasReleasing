package objects;

public interface IFacing {

	public FACING getFacing();

	public void setFacing(FACING facing);

	public default boolean isHorizontal() {
		return isHorizontal(getFacing());
	}

	public default boolean isHorizontal(FACING facing) {
		if (facing == FACING.UP || facing == FACING.DOWN)
			return true;
		else
			return false;
	}

	public enum FACING {
		UP, DOWN, LEFT, RIGHT;
	}
}
