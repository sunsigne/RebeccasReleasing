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
		LEFT(0), RIGHT(1), UP(2), DOWN(3);

		private int num;

		FACING(int num) {

			this.num = num;
		}

		public int getNum() {
			return num;
		}
	}

}
