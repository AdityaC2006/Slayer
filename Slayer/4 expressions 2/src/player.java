import java.math.*;
public class player {
	private int numOfLives;
	private int x_pos;
	private int y_pos;
	public boolean stat;
	public boolean parStat;
	public int x;
	public int y;
	public player(int n, int x, int y) {
		numOfLives = n;
		x_pos = x;
		y_pos = y;
	}
	//parry
	public void parry1(){
        parStat = true;
        x= (int)(Math.random()*4);
	    y= (int)(Math.random()*4);
		System.out.println("Parry Initiated...");
	}
	public boolean parry2(){
		if(parStat==true){
		if(x == y){
			parStat=false;
			return true;
		}
	 }
	 parStat=false;
	 return false;
	}
	public boolean check(){
		return parStat;
	}
	//shield functionality
	public boolean get_Sh(){
		return stat;
	}
	public void set_sh(boolean st) {
		stat = st;
	}
	//life
	public void setNumLives(int numOfLives) {
		this.numOfLives = numOfLives;
	}
	//positions
	public void set_x_pos(int x_pos) {
		this.x_pos = x_pos;
	}
	public void set_y_pos (int y_pos) {
		this.y_pos = y_pos;
	}
	public int getNumLives() {
		return numOfLives;
	}
	public int get_x_pos() {
		return x_pos;
	}
	public int get_y_pos() {
		return y_pos;
	}
    //movement
	public void move(int m) {
		int maxX = Arena.xSize;
		int maxY = Arena.ySize;
		if (m == 0 && y_pos != 0) { //north
			y_pos--;
		}
		if (m == 1 && y_pos < maxY) { //south
			y_pos++;
		}
		if (m == 2 && x_pos < maxX) { //east
			x_pos++;
		}
		if (m == 3 && x_pos != 0) { //west
			x_pos--;
		}
		
	}
	public static void main(String[] args) {
	}
}
