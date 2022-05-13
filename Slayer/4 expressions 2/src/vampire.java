public class vampire {
	private boolean isAlive;
	private int x_pos;
	private int y_pos;
	public vampire(int x, int y) {
		x_pos = x;
		y_pos = y;
		isAlive = true;
	}
	public void set_x_pos(int x_pos) {
		this.x_pos = x_pos;
	}
	public void set_y_pos(int y_pos) {
		this.y_pos = y_pos;
	}
	public int get_x_pos() {
		return x_pos;
	}
	public int get_y_pos() {
		return y_pos;
	}
	public void kill() {
		isAlive = false;	
	}
	public boolean check_isAlive() {
		return isAlive;	
	}
	public void moveVampire(player p) {
		int direction = (int) (Math.random()*4);
		int prevXpos = x_pos;
		int prevYpos = y_pos;
		if (direction == 0) {
			y_pos--;
		}
		if (direction == 1) {
			y_pos++;
		}
		if (direction == 2 ) {
			x_pos--;
		}
		if (direction == 3) {
			x_pos++;
		}
		if (p.get_x_pos() == x_pos) {
			set_x_pos(prevXpos);
		}
		if (p.get_y_pos() == y_pos) {
			set_y_pos(prevYpos);
		}
		int xMaxOutOfBounds = Arena.xSize - 1;
		int yMaxOutOfBounds = Arena.ySize - 1;
		int xMinOutOfBounds = 0;
		int yMinOutOfBounds = 0;
		if (x_pos > xMaxOutOfBounds) {
			set_x_pos(xMaxOutOfBounds);
		}
		if (x_pos < xMinOutOfBounds) {
			set_x_pos(0);
		}
		if (y_pos > yMaxOutOfBounds) {
			set_y_pos(yMaxOutOfBounds);
		}
		if (y_pos < yMinOutOfBounds) {
			set_y_pos(0);
		}
	}
	
	public static void main(String[] args) {
		vampire vampire1 = new vampire(10, 12);
	}

}
