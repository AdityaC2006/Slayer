
public class Poison {
	private int x_pos;
	private int y_pos;
	public Poison(int x_pos, int y_pos) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
	}
	public int get_x_pos() {
		return x_pos;
		
	}
	public int get_y_pos() {
		return y_pos;
	}
	public void set_x_pos(int x) {
		x_pos = x;
	}
	public void set_y_pos(int y) {
		y_pos = y;
	}

}
