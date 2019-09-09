import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author checho
 *
 */

public  abstract class SpaceInvaders extends Application implements EventHandler<KeyEvent>   {

	/**
	 * True if is a bullet on the board, false otherwise.
	 *
	 */
	private boolean isBullet=false;



	/**
	 * Image of the player
	 */
	private	Image Player = new Image("file:characters/Player/Player.png");
	private ImageView showPlayer = new ImageView(Player);



	/**
	 * Image of the enemy "A"
	 */
	private	Image A = new Image("file:characters/Enemies/A.png");



	/**
	 * Image of the enemy "B"
	 */

	private	Image B = new Image("file:characters/Enemies/B.png");




	/**
	 * Image of the enemy "C"
	 */
	private	Image C = new Image("file:characters/Enemies/C.png");



	/**
	 * Image of the enemy "D"
	 */
	private	Image D = new Image("file:characters/Enemies/D.png");



	/**
	 * Image of the bullet
	 */
	private Image Bullet = new Image("file:characters/Bullet/Bullet.png");


	private Pane p = new Pane(showPlayer);


	/**
	 * Images of the shields
	 */
	private	Image S1 = new Image("file:characters/Shield/s1.png");
	private	Image S2 = new Image("file:characters/Shield/s2.png");
	private	Image S3 = new Image("file:characters/Shield/s3.png");
	private	Image S4 = new Image("file:characters/Shield/s4.png");

	/**
	 * Image of the bottom of the screen
	 */
	private	Image base = new Image("file:characters/Bottom/Base.png");

	/**
	 * Image of Game Over
	 */
	private Image go = new Image("file:characters/GameOver/gameover.png");



	Scene s = new Scene(p,1350,698);



	private int lifes=3;
	private int score=0;
	private static int level=1;

	//_______________________________________________________________


	/*
	private static char [][] world= {
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','1','3','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','2','4','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','1','3','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','2','4','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','P','K'},
			{'A','B','C','D','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','1','3','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','2','4','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','1','3','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','2','4','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'A','B','C','D','.','.','.','.','.','1','3','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','2','4','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'},
			{'.','.','.','.','.','.','.','.','.','.','.','.','.','K'}
	};
	 */
	
	
	private static char [][] world= new char[27][14];

	public static void main(String[] args) throws IOException {

		loadLevel(level);

		System.out.println(world.length);
		System.out.println(world[0].length);
		System.out.println(Arrays.deepToString(world));



		//		Application.launch(args);


	}
	
	/**
	 * loads the level
	 * @param n
	 * @throws IOException
	 */
	private static void loadLevel(int n) throws IOException
	{	String path="C:/Users/checho/Documents/Universidad/Semestre-IV/Paradigmas de programacion/Space Invaders/levels/Level"+n+".txt";
	File file= new File(path);
	BufferedReader br = new BufferedReader(new FileReader(file));

	for (int i = 0; i < world.length; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine(),",");
		for (int j = 0; j < world[0].length; j++) {
			world[i][j]=st.nextToken().charAt(0);


		}
	}

	br.close();
	}


	/**
	 * Returns the player position on the world
	 * @return an array of 2 positions withs the position.
	 */
	public abstract int[] Player(); 


	/**
	 * Returns a copy of the world
	 * @return 
	 */
	public static char[][] getWorld(){
		return world;
	}

	/**
	 * Returns an array of 2 positions with the bullet position if there is one in the world, if there
	 *  is not a bullet returns -1 in both positions. 
	 * 	
	 */
	public static int[] Bullet() 
	{
		int[] b = new int[2];
		b[0]=b[1]=-1;
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				if(world[i][j]=='f')
				{
					b[0]=i;
					b[1]=j;
				}
			}
		}
		return b;
	}




	@Override
	public void handle(KeyEvent k) {
		if(this.lifes>0)
		{
			int p[]=Player();

			
			if(k.getCode()==KeyCode.RIGHT && p[0]<(world.length-1) )

			{	System.out.println("Right");
			world[p[0]][p[1]]='.';
			world[p[0]+1][p[1]]='P';

			}

			if(k.getCode()==KeyCode.LEFT && p[0]>(0))
			{	
				System.out.println("Left");
				world[p[0]][p[1]]='.';
				world[p[0]-1][p[1]]='P';

			}





			if(k.getCode()==KeyCode.SPACE   )
			{	
				if(!isBullet)
				{
					bulletSound();
					System.out.println("Fire!");

					world[p[0]][p[1]-1]='f';

					isBullet=true;
				}




			}

			if(k.getCode()==KeyCode.A &&this.lifes>0)
				this.lifes--;

			if(k.getCode()==KeyCode.S)
				this.lifes++;

			if(k.getCode()==KeyCode.UP && p[1]>(11))
			{	
				System.out.println("Up");
				world[p[0]][p[1]]='.';
				world[p[0]][p[1]-1]='P';

			}

			if(k.getCode()==KeyCode.DOWN && p[1]<(world[0].length-2))
			{
				System.out.println("Down");
				world[p[0]][p[1]]='.';
				world[p[0]][p[1]+1]='P';

			}

			reload();

		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {



		reload();
		s.setFill(Color.BLACK);

		s.setOnKeyPressed(this);


		primaryStage.setScene(s);
		primaryStage.setTitle("Space Invaders!                                                                                                                                                                                                                                      By: Checho");
		primaryStage.centerOnScreen();
		primaryStage.show();





	}




	/**
	 * Updates the view of the world 
	 */
	private void reload()
	{
		if(this.lifes>0 && !endLevel()) { 

			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='P')
					{	

						showPlayer.setLayoutX(i*50);
						showPlayer.setLayoutY(j*50);
					}
				}

			}


			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='A')
					{	
						ImageView showA = new ImageView(A);

						showA.setLayoutX(i*50);
						showA.setLayoutY(j*100);
						p.getChildren().add(showA);
					}

				}

			}

			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='B')
					{	
						ImageView showB = new ImageView(B);

						showB.setLayoutX(i*50);
						showB.setLayoutY(j*100);
						p.getChildren().add(showB);
					}

				}

			}

			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='C')
					{	
						ImageView showC = new ImageView(C);
						showC.setLayoutX(i*50);
						showC.setLayoutY(j*100);
						p.getChildren().add(showC);
					}

				}

			}

			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='D')
					{	
						ImageView showD = new ImageView(D);
						showD.setLayoutX(i*50);
						showD.setLayoutY(j*100);
						p.getChildren().add(showD);
					}

				}

			}


			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='f')
					{	
						ImageView showFire = new ImageView(Bullet);
						showFire.setLayoutX(i*50);
						showFire.setLayoutY(j*50);
						p.getChildren().add(showFire);
					}

				}

			}


			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='1')
					{	
						ImageView S1 = new ImageView(this.S1);
						S1.setLayoutX(i*50);
						S1.setLayoutY(j*50);
						p.getChildren().add(S1);
					}

				}

			}

			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='2')
					{	
						ImageView S2 = new ImageView(this.S2);
						S2.setLayoutX(i*50);
						S2.setLayoutY(j*50);
						p.getChildren().add(S2);
					}

				}

			}



			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='3')
					{	
						ImageView S3 = new ImageView(this.S3);
						S3.setLayoutX(i*50);
						S3.setLayoutY(j*50);
						p.getChildren().add(S3);
					}

				}

			}



			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[0].length; j++) {

					if(world[i][j]=='4')
					{	
						ImageView S4 = new ImageView(this.S4);
						S4.setLayoutX(i*50);
						S4.setLayoutY(j*50);
						p.getChildren().add(S4);
					}

				}

			}




		}
		else {
			if(!endLevel()) {
				ImageView gameOver = new ImageView(go);
				gameOver.setLayoutX(300);
				gameOver.setLayoutY(240);
				p.getChildren().add(gameOver);
			}
			else 
			{	
				
				level++;
				if(level<5)
					try {
						loadLevel(level);
					} catch (IOException e) {
						e.printStackTrace();
					}
				else
				{
					// Here code for final view (credits(?))
				}
				
			}

		}

		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {

				if(world[i][j]=='K')
				{	
					ImageView b = new ImageView(this.base);
					b.setLayoutX(i*50);
					b.setLayoutY(j*50);
					p.getChildren().add(b);
				}

			}

		}

		Text lifes=new Text("Lifes: "+ this.lifes);
		lifes.setFill(Color.rgb(00, 255, 2));

		p.getChildren().add(lifes);
		lifes.setLayoutX(10);
		lifes.setLayoutY(688);
		lifes.setFont(Font.font(30));

		Text Score = new Text("Score: "+this.score);
		Score.setFill(Color.rgb(00, 255, 2));
		p.getChildren().add(Score);
		Score.setLayoutX(1150);
		Score.setLayoutY(688);
		Score.setFont(Font.font(30));

		
		Text level=new Text("Level: "+SpaceInvaders.level);
		level.setFill(Color.rgb(00, 255, 2));
		p.getChildren().add(level);
		level.setLayoutX(250);
		level.setLayoutY(688);
		level.setFont(Font.font(30));
		
		
		
		Text checho=new Text("¡CHECHO!");
		checho.setFill(Color.rgb(00, 255, 2));
		p.getChildren().add(checho);
		checho.setLayoutX(550);
		checho.setLayoutY(688);
		checho.setFont(Font.font(30));

		
		
		
	}








	/**
	 * Increments the score of the player, according to the enemy that is hit by a bullet
	 * @param e
	 */
	public abstract void enemyKilled(char e);
	
	
	/**
	 * Decrements the lives when the player is hit by a bullet
	 */
	public abstract void playerKilled();
	
	

	/**
	 * Returns the number of enemies remaining on the world
	 * @return
	 */
	public abstract int enemiesAlive() ;

	/**
	 * Returns true if there is at least an enemy in the world
	 * @return
	 */
	public abstract boolean stillEnemies();

	
	
	
	/**
	 * 
	 * @return true if there is not a enemy and the player has at least 1 life.
	 */
	public abstract boolean endLevel();


	
	


	/**
	 * Bullet sound
	 */
	public void bulletSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Users/checho/Documents/Universidad/Semestre-IV/Paradigmas de programacion/Space Invaders/laser.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();

		}
	}



	public  int getLifes()
	{	
		int l=this.lifes;
		return  l;
	}
	
	
	public  void setLifes(int l)
	{	
		this.lifes+=l;
	}
	
	public  int getScore()
	{	
		int s=this.score;
		return  s;
	}
	
	public  void setScore(int s)
	{	
		this.score+=s;
	}
	//_______________________________________________________________

}
