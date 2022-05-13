
public class Arena {
	private char[][] arr2DCharacter;
	public static int xSize;
	public static int ySize;
	private int currentRound;
	public Arena(int x, int y) {
		xSize = x-1;
		ySize = y-1;
		arr2DCharacter = new char[y][x];
	}
	public char[][] get_arr2DCharacter() {
		return arr2DCharacter;
	}
	public int get_currentRound() {
		return currentRound;
	}
	public void incrementRound() {
		currentRound++;
	}
	public void updateArena(Game s) {
		for (int i = 0; i < arr2DCharacter.length; i++) {
			for (int j = 0; j < arr2DCharacter[0].length; j++) {
				if (j == s.getPlayer().get_x_pos() && i == s.getPlayer().get_y_pos()) {
					arr2DCharacter[i][j] = '@';
				}
				else if (s.getNumVampsAt(j, i) == 1) {
					arr2DCharacter[i][j] = 'V';
				}
				else if (s.getNumVampsAt(j, i) > 1) {
					arr2DCharacter[i][j] = (s.getNumVampsAt(j, i) + "").charAt(0);
				}
				else if (s.isPoisonAt(j, i) == true) {
					arr2DCharacter[i][j] = 'X';
				}
				else if (s.isShieldAt(j, i) == true) {
					arr2DCharacter[i][j] = 'S';
				}
				else {
					arr2DCharacter[i][j] = '.';
				}
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
