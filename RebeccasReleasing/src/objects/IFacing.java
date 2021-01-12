package objects;

public interface IFacing {

	public FACING getFacing();

	public void setFacing(FACING facing);

	public default boolean isHorizontal() {
		if (getFacing() == FACING.UP || getFacing() == FACING.DOWN)
			return true;
		else
			return false;
	}

	public enum FACING {
		UP, DOWN, LEFT, RIGHT;
	}
}
