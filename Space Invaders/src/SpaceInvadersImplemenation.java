import java.io.IOException;


public class SpaceInvadersImplemenation extends SpaceInvaders {

	
	public static void main(String[] args) throws IOException {
		SpaceInvaders.main(args);
		SpaceInvaders.launch();
	
		
	}
	
	
	
	
	char[][] world = getWorld();
	
	@Override
	public  int[] Player() 
	{
		int[] p = new int[2];
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				if(world[i][j]=='P')
				{
					p[0]=i;
					p[1]=j;
				}
			}
		}
		return p;
	}
	
	
	//_____________________________________________________________
	
	/**
	 * Increments the score of the player, according to the enemy that is hit by a bullet
	 * @param e
	 */
	@Override
	public void enemyKilled(char e)
	{
		if (e=='A') 
			setScore(18);

		if (e=='B') 
			setScore(15);
		
		if (e=='C') 
			setScore(12);
		
		if (e=='D') 
			setScore(10);
	}

	/**
	 * Decrements the lives when the player is hit by a bullet
	 */
	@Override
	public void playerKilled() {

		setLifes(-1);
	}

	/**
	 * Returns the number of enemies remaining on the world
	 * @return
	 */
	@Override
	public int enemiesAlive() {
		int enemies=0;
		for (int i = 0; i < world.length; i++) 
			for (int j = 0; j < world[0].length; j++) 
				if(world[i][j]=='A' || world[i][j]=='B' || world[i][j]=='C' || world[i][j]=='D')
					enemies++;

		return enemies;			
	}


	/**
	 * Returns true if there is at least an enemy in the world
	 * @return
	 */
	@Override
	public boolean stillEnemies(){
		return enemiesAlive()>0;
	}

	/**
	 * 
	 * @return true if there is not a enemy and the player has at least 1 life.
	 */
	@Override
	public boolean endLevel() {

		return !(stillEnemies()) && getLifes()>0;

	}




	
	



	//_____________________________________________________________
	
	
}
