import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	private player slayer;
	private vampire[] arrVamp;
	private int aliveVampires;
	private Arena arena;
	private ArrayList<Poison> objects;
	private Shield shield;
	public Game(int Sizex, int Sizey, int numOfVampires) {
		arrVamp = new vampire[numOfVampires];
		aliveVampires = numOfVampires;
		slayer = new player(10, (int) (Math.random()*Sizex), (int) (Math.random()*Sizey));
		arena = new Arena(Sizex, Sizey);
		objects = new ArrayList<Poison>();
		shield = new Shield();
		populateArena();
	}

	public void Spawn(){
		shield = new Shield(3,3);
		System.out.println("Shield spawned in");
	}
	public void populateArena() {
		for (int i = 0; i < arrVamp.length; i++) {
			shield = new Shield(3,3);
	     	shield = new Shield(5,5);
			arrVamp[i] = new vampire((int) (Math.random()*arena.xSize), (int) (Math.random()*arena.ySize));
			while (arrVamp[i].get_x_pos() == slayer.get_x_pos() && arrVamp[i].get_y_pos() == slayer.get_y_pos()) {
				arrVamp[i] = new vampire((int) (Math.random()*arena.xSize), (int) (Math.random()*arena.ySize));
			}
		}
		
	}
	public void playerMove() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter w, a, s, d to move, x to drop poison,p to parry: ");
		String line = input.nextLine();
		if (line.toLowerCase().contains("w")) {
			slayer.move(0);
		}
		else if (line.toLowerCase().contains("break")){
			System.out.println("Breaking");
			System.exit (1);
		}
		else if (line.toLowerCase().contains("p")){
			slayer.parry1();	
		}
		else if (line.toLowerCase().contains("b")) {
			Spawn();
			//Shield spawner
			}
		else if (line.toLowerCase().contains("s")) {
			slayer.move(1);
		}
		else if (line.toLowerCase().contains("d")) {
			slayer.move(2);
		}
		else if (line.toLowerCase().contains("a")) {
			slayer.move(3);
		}
		else {
			Poison p = new Poison(slayer.get_x_pos(), slayer.get_y_pos());
			objects.add(p);
		}
	}
	public int getNumVampsAt(int xPos, int yPos) {
		int numOfVampiresAtPos = 0;
		for (int i = 0; i < arrVamp.length; i++) {
			if (arrVamp[i].get_x_pos() == xPos && arrVamp[i].get_y_pos() == yPos && arrVamp[i].check_isAlive()) {
				numOfVampiresAtPos++;
			}
		}
		return numOfVampiresAtPos;
		
	}
	public boolean isPoisonAt(int xPos, int yPos) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).get_x_pos() == xPos && objects.get(i).get_y_pos() == yPos) {
				return true;
			}
		}
		return false;
	}
	public boolean isShieldAt(int xPos, int yPos) {
			if (shield.get_x_sh() == xPos && shield.get_y_sh() == yPos) {
				return true;
			}
		return false;
	}
	public void removePoisonAt(int xPos, int yPos) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).get_x_pos() == xPos && objects.get(i).get_y_pos() == yPos) {
				objects.remove(i);
			}
		}
	}
	public player getPlayer() {
		return slayer;
		
	}
	public void display() {
		arena.updateArena(this);
			System.out.println("-------");
		for (int i = 0; i < arena.get_arr2DCharacter().length; i++) {
			for (int j = 0; j < arena.get_arr2DCharacter()[0].length; j++) {
				System.out.print(arena.get_arr2DCharacter()[i][j]);
			}
			System.out.println();
		}
		System.out.println("Number of Lives: " + slayer.getNumLives());
		System.out.println("Current Round:" + arena.get_currentRound());
		System.out.println("Number of Alive Vampires: " + aliveVampires);
	}
	public void playGame() {
		display();
		while(true) {
			if (slayer.getNumLives() == 0 || aliveVampires == 0) {
				break;
			}
			playerMove();
			System.out.println(arrVamp.length);
			for (int i = 0; i < arrVamp.length; i++) {
				if (arrVamp[i].check_isAlive() == true) {
						arrVamp[i].moveVampire(slayer);
					if (isPoisonAt(arrVamp[i].get_x_pos(), arrVamp[i].get_y_pos())&&(slayer.get_Sh()==false)) {
						arrVamp[i].kill();
						removePoisonAt(arrVamp[i].get_x_pos(), arrVamp[i].get_y_pos());
						aliveVampires--;
						continue;
					}
					if (slayer.get_x_pos() == arrVamp[i].get_x_pos() && slayer.get_y_pos() == arrVamp[i].get_y_pos()) {
						System.out.println("You lose");
						break;
					}
				}

			}
			if(slayer.get_x_pos()==shield.get_x_sh()&&slayer.get_y_pos()==shield.get_y_sh()){
				slayer.set_sh(true);
				System.out.println("Shielded!");
			}

			int x = slayer.get_x_pos();
			int y = slayer.get_y_pos();
			int vampLocation = 0;
			vampLocation += getNumVampsAt(x + 1, y);
			vampLocation += getNumVampsAt(x - 1, y);
			vampLocation += getNumVampsAt(x, y + 1);
			vampLocation += getNumVampsAt(x, y - 1);
			if(slayer.check()==true){
               if(slayer.parry2()==true && vampLocation>0){
                for(int go=0;go<arrVamp.length;go++){
                    if(((arrVamp[x].get_x_pos()==x+1)&&(arrVamp[x].get_y_pos()==y))||((arrVamp[x].get_x_pos()==x-1)&&(arrVamp[x].get_y_pos()==y))||((arrVamp[x].get_x_pos()==x)&&(arrVamp[x].get_y_pos()==y+1))||((arrVamp[x].get_x_pos()==x+1)&&(arrVamp[x].get_y_pos()==y-1))){
						arrVamp[x].kill();
					}
				}
				System.out.println("Succesful Parry!");
			   }
			   else{
				slayer.setNumLives(slayer.getNumLives() - vampLocation);
				if(vampLocation>0){
					System.out.println("Parry failed...");
			   }
			}
		}
			else if (slayer.get_Sh()==true && vampLocation>0){
               slayer.set_sh(false);
			   System.out.println("Shielded attack! Your shield has broken!");
			}
			else{slayer.setNumLives(slayer.getNumLives() - vampLocation);
				if(vampLocation>0){
					System.out.println("Should have dodge rolled...");
				}
			}	
			arena.incrementRound();
			display();
		}
	}
	public static void main(String[] args) {
		Game play = new Game(10, 10, 10);
		play.playGame();
	}
}
