public class Shield {
	private int x_pos;
	private int y_pos;
    public Shield(){}
	public Shield(int x_pos, int y_pos) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
	}
	public int get_y_sh() {
		return y_pos;
	}
	public int get_x_sh() {
		return x_pos;
	}
	public void set_x_pos(int x) {
		x_pos = x;
	}
	public void set_pos(int x, int y) {
		x_pos = x;
		y_pos = y;
	}
	public void set_y_pos(int y) {
		y_pos = y;
	}
    public Shield get(int i) {
        return null;
    }
    
}
