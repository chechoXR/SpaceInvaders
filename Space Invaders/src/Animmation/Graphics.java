package Animmation;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Graphics extends Application implements EventHandler<KeyEvent> {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void handle(KeyEvent event) {
		
	}

	public void bulletSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(
					"C:/Users/checho/Documents/Universidad/Semestre-IV/Paradigmas de programacion/Space Invaders/laser.wav")
							.getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();

		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		EnemyA a = new EnemyA();
		EnemyA a1 = new EnemyA();
		EnemyA a2 = new EnemyA();
		EnemyA a3 = new EnemyA();
		EnemyA a4 = new EnemyA();
		EnemyA a5 = new EnemyA();
		EnemyA a6 = new EnemyA();
		EnemyA a7 = new EnemyA();
		EnemyA a8 = new EnemyA();
		EnemyA a9 = new EnemyA();

		EnemyB b = new EnemyB();
		EnemyB b1 = new EnemyB();
		EnemyB b2 = new EnemyB();
		EnemyB b3 = new EnemyB();
		EnemyB b4 = new EnemyB();
		EnemyB b5 = new EnemyB();
		EnemyB b6 = new EnemyB();
		EnemyB b7 = new EnemyB();
		EnemyB b8 = new EnemyB();
		EnemyB b9 = new EnemyB();

		EnemyC c = new EnemyC();
		EnemyC c1 = new EnemyC();
		EnemyC c2 = new EnemyC();
		EnemyC c3 = new EnemyC();
		EnemyC c4 = new EnemyC();
		EnemyC c5 = new EnemyC();
		EnemyC c6 = new EnemyC();
		EnemyC c7 = new EnemyC();
		EnemyC c8 = new EnemyC();
		EnemyC c9 = new EnemyC();

		EnemyD d = new EnemyD();
		EnemyD d1 = new EnemyD();
		EnemyD d2 = new EnemyD();
		EnemyD d3 = new EnemyD();
		EnemyD d4 = new EnemyD();
		EnemyD d5 = new EnemyD();
		EnemyD d6 = new EnemyD();
		EnemyD d7 = new EnemyD();
		EnemyD d8 = new EnemyD();
		EnemyD d9 = new EnemyD();

		Pane p = new Pane();
		ImageView bottom = new ImageView(new Image("file:characters/Bottom/Base.png"));
		Text checho = new Text("CHECHO");
		Player player = new Player();

		// p.getChildren().add(a.getImage());
		// p.getChildren().add(a1.getImage());
		p.getChildren().addAll(a.getImage(), a1.getImage(), a2.getImage(), a3.getImage(), a4.getImage(), a5.getImage(),
				a6.getImage(), a7.getImage(), a8.getImage(), a9.getImage(), b.getImage(), b1.getImage(), b2.getImage(),
				b3.getImage(), b4.getImage(), b5.getImage(), b6.getImage(), b7.getImage(), b8.getImage(), b9.getImage(),
				c.getImage(), c1.getImage(), c2.getImage(), c3.getImage(), c4.getImage(), c5.getImage(), c6.getImage(),
				c7.getImage(), c8.getImage(), c9.getImage(), d.getImage(), d1.getImage(), d2.getImage(), d3.getImage(),
				d4.getImage(), d5.getImage(), d6.getImage(), d7.getImage(), d8.getImage(), d9.getImage(), bottom,
				player.getImage(), checho);
		// p.getChildren().add(a.getImage());
		// p.getChildren().add(a1.getImage());

		Scene sc = new Scene(p, 1350, 698);
		bottom.setLayoutY(698 - 65);
		// checho.setLayoutX(1350/2);
		// checho.setLayoutY(698-65);
		checho.setFill(Color.rgb(00, 255, 2));
		checho.setLayoutX(600);
		checho.setLayoutY(678);
		checho.setFont(Font.font(30));

		player.getImage().setLayoutX((sc.getWidth() / 2) - 50);
		player.getImage().setLayoutY(585);

		int time = 1000;
		int move = 190;

		// a
		a.getImage().setLayoutX(85);
		Path path = new Path();
		path.getElements().add(new MoveTo(38, 38));
		path.getElements().add(new LineTo(a.getImage().getLayoutX() + 85 + move, 38));
		PathTransition animationA = new PathTransition();
		animationA.setDuration(Duration.millis(time));
		animationA.setPath(path);
		animationA.setOrientation(OrientationType.NONE);
		animationA.setCycleCount(Integer.MAX_VALUE);
		animationA.setAutoReverse(true);
		animationA.setNode(a.getImage());

		// a1
		a1.getImage().setLayoutX(85 * 2);


		PathTransition animationA1 = new PathTransition();

		animationA1.setDuration(Duration.millis(time));
		animationA1.setPath(path);
		animationA1.setOrientation(OrientationType.NONE);
		animationA1.setCycleCount(Integer.MAX_VALUE);
		animationA1.setAutoReverse(true);
		animationA1.setNode(a1.getImage());

		// a2
		a2.getImage().setLayoutX(85 * 3);

		PathTransition animationA2 = new PathTransition();

		animationA2.setDuration(Duration.millis(time));
		animationA2.setPath(path);
		animationA2.setOrientation(OrientationType.NONE);
		animationA2.setCycleCount(Integer.MAX_VALUE);
		animationA2.setAutoReverse(true);
		animationA2.setNode(a2.getImage());

		// a3
		a3.getImage().setLayoutX(85 * 4);

		PathTransition animationA3 = new PathTransition();

		animationA3.setDuration(Duration.millis(time));
		animationA3.setPath(path);
		animationA3.setOrientation(OrientationType.NONE);
		animationA3.setCycleCount(Integer.MAX_VALUE);
		animationA3.setAutoReverse(true);
		animationA3.setNode(a3.getImage());

		// a4
		a4.getImage().setLayoutX(85 * 5);

		PathTransition animationA4 = new PathTransition();

		animationA4.setDuration(Duration.millis(time));
		animationA4.setPath(path);
		animationA4.setOrientation(OrientationType.NONE);
		animationA4.setCycleCount(Integer.MAX_VALUE);
		animationA4.setAutoReverse(true);
		animationA4.setNode(a4.getImage());

		// a5
		a5.getImage().setLayoutX(85 * 6);

		PathTransition animationA5 = new PathTransition();

		animationA5.setDuration(Duration.millis(time));
		animationA5.setPath(path);
		animationA5.setOrientation(OrientationType.NONE);
		animationA5.setCycleCount(Integer.MAX_VALUE);
		animationA5.setAutoReverse(true);
		animationA5.setNode(a5.getImage());

		// a6
		a6.getImage().setLayoutX(85 * 7);
		PathTransition animationA6 = new PathTransition();
		animationA6.setDuration(Duration.millis(time));
		animationA6.setPath(path);
		animationA6.setOrientation(OrientationType.NONE);
		animationA6.setCycleCount(Integer.MAX_VALUE);
		animationA6.setAutoReverse(true);
		animationA6.setNode(a6.getImage());

		// a7
		a7.getImage().setLayoutX(85 * 8);

		PathTransition animationA7 = new PathTransition();

		animationA7.setDuration(Duration.millis(time));
		animationA7.setPath(path);
		animationA7.setOrientation(OrientationType.NONE);
		animationA7.setCycleCount(Integer.MAX_VALUE);
		animationA7.setAutoReverse(true);
		animationA7.setNode(a7.getImage());

		// a8
		a8.getImage().setLayoutX(85 * 9);

		PathTransition animationA8 = new PathTransition();

		animationA8.setDuration(Duration.millis(time));
		animationA8.setPath(path);
		animationA8.setOrientation(OrientationType.NONE);
		animationA8.setCycleCount(Integer.MAX_VALUE);
		animationA8.setAutoReverse(true);
		animationA8.setNode(a8.getImage());

		// a9
		a9.getImage().setLayoutX(85 * 10);

		PathTransition animationA9 = new PathTransition();

		animationA9.setDuration(Duration.millis(time));
		animationA9.setPath(path);
		animationA9.setOrientation(OrientationType.NONE);
		animationA9.setCycleCount(Integer.MAX_VALUE);
		animationA9.setAutoReverse(true);
		animationA9.setNode(a9.getImage());

		// ________________________________________________________________

		// b
		b.getImage().setLayoutX(85);
		b.getImage().setLayoutY(85);
		Path pathB = new Path();
		pathB.getElements().add(new MoveTo(38, 38));
		pathB.getElements().add(new LineTo(b.getImage().getLayoutX() + 85 + move, 38));
		PathTransition animationB = new PathTransition();
		animationB.setDuration(Duration.millis(time));
		animationB.setPath(pathB);
		animationB.setOrientation(OrientationType.NONE);
		animationB.setCycleCount(Integer.MAX_VALUE);
		animationB.setAutoReverse(true);
		animationB.setNode(b.getImage());

		// b1
		b1.getImage().setLayoutX(85 * 2);
		b1.getImage().setLayoutY(85);
		PathTransition animationB1 = new PathTransition();
		animationB1.setDuration(Duration.millis(time));
		animationB1.setPath(pathB);
		animationB1.setOrientation(OrientationType.NONE);
		animationB1.setCycleCount(Integer.MAX_VALUE);
		animationB1.setAutoReverse(true);
		animationB1.setNode(b1.getImage());

		// b2
		b2.getImage().setLayoutX(85 * 3);
		b2.getImage().setLayoutY(85);
		PathTransition animationB2 = new PathTransition();
		animationB2.setDuration(Duration.millis(time));
		animationB2.setPath(pathB);
		animationB2.setOrientation(OrientationType.NONE);
		animationB2.setCycleCount(Integer.MAX_VALUE);
		animationB2.setAutoReverse(true);
		animationB2.setNode(b2.getImage());

		// b3
		b3.getImage().setLayoutX(85 * 4);
		b3.getImage().setLayoutY(85);
		PathTransition animationB3 = new PathTransition();
		animationB3.setDuration(Duration.millis(time));
		animationB3.setPath(pathB);
		animationB3.setOrientation(OrientationType.NONE);
		animationB3.setCycleCount(Integer.MAX_VALUE);
		animationB3.setAutoReverse(true);
		animationB3.setNode(b3.getImage());

		// b4
		b4.getImage().setLayoutX(85 * 5);
		b4.getImage().setLayoutY(85);
		PathTransition animationB4 = new PathTransition();
		animationB4.setDuration(Duration.millis(time));
		animationB4.setPath(pathB);
		animationB4.setOrientation(OrientationType.NONE);
		animationB4.setCycleCount(Integer.MAX_VALUE);
		animationB4.setAutoReverse(true);
		animationB4.setNode(b4.getImage());

		// b5
		b5.getImage().setLayoutX(85 * 6);
		b5.getImage().setLayoutY(85);
		PathTransition animationB5 = new PathTransition();
		animationB5.setDuration(Duration.millis(time));
		animationB5.setPath(pathB);
		animationB5.setOrientation(OrientationType.NONE);
		animationB5.setCycleCount(Integer.MAX_VALUE);
		animationB5.setAutoReverse(true);
		animationB5.setNode(b5.getImage());

		// b6
		b6.getImage().setLayoutX(85 * 7);
		b6.getImage().setLayoutY(85);
		PathTransition animationB6 = new PathTransition();
		animationB6.setDuration(Duration.millis(time));
		animationB6.setPath(pathB);
		animationB6.setOrientation(OrientationType.NONE);
		animationB6.setCycleCount(Integer.MAX_VALUE);
		animationB6.setAutoReverse(true);
		animationB6.setNode(b6.getImage());

		// b7
		b7.getImage().setLayoutX(85 * 8);
		b7.getImage().setLayoutY(85);
		PathTransition animationB7 = new PathTransition();
		animationB7.setDuration(Duration.millis(time));
		animationB7.setPath(pathB);
		animationB7.setOrientation(OrientationType.NONE);
		animationB7.setCycleCount(Integer.MAX_VALUE);
		animationB7.setAutoReverse(true);
		animationB7.setNode(b7.getImage());

		// b8
		b8.getImage().setLayoutX(85 * 9);
		b8.getImage().setLayoutY(85);
		PathTransition animationB8 = new PathTransition();
		animationB8.setDuration(Duration.millis(time));
		animationB8.setPath(pathB);
		animationB8.setOrientation(OrientationType.NONE);
		animationB8.setCycleCount(Integer.MAX_VALUE);
		animationB8.setAutoReverse(true);
		animationB8.setNode(b8.getImage());

		// b9
		b9.getImage().setLayoutX(85 * 10);
		b9.getImage().setLayoutY(85);
		PathTransition animationB9 = new PathTransition();
		animationB9.setDuration(Duration.millis(time));
		animationB9.setPath(pathB);
		animationB9.setOrientation(OrientationType.NONE);
		animationB9.setCycleCount(Integer.MAX_VALUE);
		animationB9.setAutoReverse(true);
		animationB9.setNode(b9.getImage());

		// ________________________________________________________________

		// c
		c.getImage().setLayoutX(85);
		c.getImage().setLayoutY(85*2);
		Path pathC = new Path();
		pathC.getElements().add(new MoveTo(38, 38));
		pathC.getElements().add(new LineTo(c.getImage().getLayoutX() + 85 + move, 38));
		PathTransition animationC = new PathTransition();
		animationC.setDuration(Duration.millis(time));
		animationC.setPath(pathC);
		animationC.setOrientation(OrientationType.NONE);
		animationC.setCycleCount(Integer.MAX_VALUE);
		animationC.setAutoReverse(true);
		animationC.setNode(c.getImage());

		// c1
		c1.getImage().setLayoutX(85 * 2);
		c1.getImage().setLayoutY(85*2);
		PathTransition animationC1 = new PathTransition();
		animationC1.setDuration(Duration.millis(time));
		animationC1.setPath(pathC);
		animationC1.setOrientation(OrientationType.NONE);
		animationC1.setCycleCount(Integer.MAX_VALUE);
		animationC1.setAutoReverse(true);
		animationC1.setNode(c1.getImage());

		// c2
		c2.getImage().setLayoutX(85 * 3);
		c2.getImage().setLayoutY(85*2);
		PathTransition animationC2 = new PathTransition();
		animationC2.setDuration(Duration.millis(time));
		animationC2.setPath(pathC);
		animationC2.setOrientation(OrientationType.NONE);
		animationC2.setCycleCount(Integer.MAX_VALUE);
		animationC2.setAutoReverse(true);
		animationC2.setNode(c2.getImage());

		// c3
		c3.getImage().setLayoutX(85 * 4);
		c3.getImage().setLayoutY(85*2);
		PathTransition animationC3 = new PathTransition();
		animationC3.setDuration(Duration.millis(time));
		animationC3.setPath(pathC);
		animationC3.setOrientation(OrientationType.NONE);
		animationC3.setCycleCount(Integer.MAX_VALUE);
		animationC3.setAutoReverse(true);
		animationC3.setNode(c3.getImage());

		// c4
		c4.getImage().setLayoutX(85 * 5);
		c4.getImage().setLayoutY(85*2);
		PathTransition animationC4 = new PathTransition();
		animationC4.setDuration(Duration.millis(time));
		animationC4.setPath(pathC);
		animationC4.setOrientation(OrientationType.NONE);
		animationC4.setCycleCount(Integer.MAX_VALUE);
		animationC4.setAutoReverse(true);
		animationC4.setNode(c4.getImage());

		// c5
		c5.getImage().setLayoutX(85 * 6);
		c5.getImage().setLayoutY(85*2);
		PathTransition animationC5 = new PathTransition();
		animationC5.setDuration(Duration.millis(time));
		animationC5.setPath(pathC);
		animationC5.setOrientation(OrientationType.NONE);
		animationC5.setCycleCount(Integer.MAX_VALUE);
		animationC5.setAutoReverse(true);
		animationC5.setNode(c5.getImage());

		// c6
		c6.getImage().setLayoutX(85 * 7);
		c6.getImage().setLayoutY(85*2);
		PathTransition animationC6 = new PathTransition();
		animationC6.setDuration(Duration.millis(time));
		animationC6.setPath(pathC);
		animationC6.setOrientation(OrientationType.NONE);
		animationC6.setCycleCount(Integer.MAX_VALUE);
		animationC6.setAutoReverse(true);
		animationC6.setNode(c6.getImage());

		// c7
		c7.getImage().setLayoutX(85 * 8);
		c7.getImage().setLayoutY(85*2);
		PathTransition animationC7 = new PathTransition();
		animationC7.setDuration(Duration.millis(time));
		animationC7.setPath(pathC);
		animationC7.setOrientation(OrientationType.NONE);
		animationC7.setCycleCount(Integer.MAX_VALUE);
		animationC7.setAutoReverse(true);
		animationC7.setNode(c7.getImage());

		// c8
		c8.getImage().setLayoutX(85 * 9);
		c8.getImage().setLayoutY(85*2);
		PathTransition animationC8 = new PathTransition();
		animationC8.setDuration(Duration.millis(time));
		animationC8.setPath(pathC);
		animationC8.setOrientation(OrientationType.NONE);
		animationC8.setCycleCount(Integer.MAX_VALUE);
		animationC8.setAutoReverse(true);
		animationC8.setNode(c8.getImage());

		// c9
		c9.getImage().setLayoutX(85 * 10);
		c9.getImage().setLayoutY(85*2);
		PathTransition animationC9 = new PathTransition();
		animationC9.setDuration(Duration.millis(time));
		animationC9.setPath(pathC);
		animationC9.setOrientation(OrientationType.NONE);
		animationC9.setCycleCount(Integer.MAX_VALUE);
		animationC9.setAutoReverse(true);
		animationC9.setNode(c9.getImage());

		
		
		
		
		// d
		d.getImage().setLayoutX(85);
		d.getImage().setLayoutY(85*3);
		Path pathD = new Path();
		pathD.getElements().add(new MoveTo(38, 38));
		pathD.getElements().add(new LineTo(d.getImage().getLayoutX() + 85 + move, 38));
		PathTransition animationD = new PathTransition();
		animationD.setDuration(Duration.millis(time));
		animationD.setPath(pathD);
		animationD.setOrientation(OrientationType.NONE);
		animationD.setCycleCount(Integer.MAX_VALUE);
		animationD.setAutoReverse(true);
		animationD.setNode(d.getImage());

		// d1
		d1.getImage().setLayoutX(85 * 2);
		d1.getImage().setLayoutY(85*3);
		PathTransition animationD1 = new PathTransition();
		animationD1.setDuration(Duration.millis(time));
		animationD1.setPath(pathD);
		animationD1.setOrientation(OrientationType.NONE);
		animationD1.setCycleCount(Integer.MAX_VALUE);
		animationD1.setAutoReverse(true);
		animationD1.setNode(d1.getImage());

		// d2
		d2.getImage().setLayoutX(85 * 3);
		d2.getImage().setLayoutY(85*3);
		PathTransition animationD2 = new PathTransition();
		animationD2.setDuration(Duration.millis(time));
		animationD2.setPath(pathD);
		animationD2.setOrientation(OrientationType.NONE);
		animationD2.setCycleCount(Integer.MAX_VALUE);
		animationD2.setAutoReverse(true);
		animationD2.setNode(d2.getImage());

		// d3
		d3.getImage().setLayoutX(85 * 4);
		d3.getImage().setLayoutY(85*3);
		PathTransition animationD3 = new PathTransition();
		animationD3.setDuration(Duration.millis(time));
		animationD3.setPath(pathD);
		animationD3.setOrientation(OrientationType.NONE);
		animationD3.setCycleCount(Integer.MAX_VALUE);
		animationD3.setAutoReverse(true);
		animationD3.setNode(d3.getImage());

		// d4
		d4.getImage().setLayoutX(85 * 5);
		d4.getImage().setLayoutY(85*3);
		PathTransition animationD4 = new PathTransition();
		animationD4.setDuration(Duration.millis(time));
		animationD4.setPath(pathD);
		animationD4.setOrientation(OrientationType.NONE);
		animationD4.setCycleCount(Integer.MAX_VALUE);
		animationD4.setAutoReverse(true);
		animationD4.setNode(d4.getImage());

		// d5
		d5.getImage().setLayoutX(85 * 6);
		d5.getImage().setLayoutY(85*3);
		PathTransition animationD5 = new PathTransition();
		animationD5.setDuration(Duration.millis(time));
		animationD5.setPath(pathD);
		animationD5.setOrientation(OrientationType.NONE);
		animationD5.setCycleCount(Integer.MAX_VALUE);
		animationD5.setAutoReverse(true);
		animationD5.setNode(d5.getImage());

		// d6
		d6.getImage().setLayoutX(85 * 7);
		d6.getImage().setLayoutY(85*3);
		PathTransition animationD6 = new PathTransition();
		animationD6.setDuration(Duration.millis(time));
		animationD6.setPath(pathD);
		animationD6.setOrientation(OrientationType.NONE);
		animationD6.setCycleCount(Integer.MAX_VALUE);
		animationD6.setAutoReverse(true);
		animationD6.setNode(d6.getImage());

		// d7
		d7.getImage().setLayoutX(85 * 8);
		d7.getImage().setLayoutY(85*3);
		PathTransition animationD7 = new PathTransition();
		animationD7.setDuration(Duration.millis(time));
		animationD7.setPath(pathD);
		animationD7.setOrientation(OrientationType.NONE);
		animationD7.setCycleCount(Integer.MAX_VALUE);
		animationD7.setAutoReverse(true);
		animationD7.setNode(d7.getImage());

		// d8
		d8.getImage().setLayoutX(85 * 9);
		d8.getImage().setLayoutY(85*3);
		PathTransition animationD8 = new PathTransition();
		animationD8.setDuration(Duration.millis(time));
		animationD8.setPath(pathD);
		animationD8.setOrientation(OrientationType.NONE);
		animationD8.setCycleCount(Integer.MAX_VALUE);
		animationD8.setAutoReverse(true);
		animationD8.setNode(d8.getImage());

		// d9
		d9.getImage().setLayoutX(85 * 10);
		d9.getImage().setLayoutY(85*3);
		PathTransition animationD9 = new PathTransition();
		animationD9.setDuration(Duration.millis(time));
		animationD9.setPath(pathD);
		animationD9.setOrientation(OrientationType.NONE);
		animationD9.setCycleCount(Integer.MAX_VALUE);
		animationD9.setAutoReverse(true);
		animationD9.setNode(d9.getImage());
		
		
		
		
		
		
		animationA.play();
		animationA1.play();
		animationA2.play();
		animationA3.play();
		animationA4.play();
		animationA5.play();
		animationA6.play();
		animationA7.play();
		animationA8.play();
		animationA9.play();

		animationB.play();
		animationB1.play();
		animationB2.play();
		animationB3.play();
		animationB4.play();
		animationB5.play();
		animationB6.play();
		animationB7.play();
		animationB8.play();
		animationB9.play();

		
		animationC.play();
		animationC1.play();
		animationC2.play();
		animationC3.play();
		animationC4.play();
		animationC5.play();
		animationC6.play();
		animationC7.play();
		animationC8.play();
		animationC9.play();
		
		
		animationD.play();
		animationD1.play();
		animationD2.play();
		animationD3.play();
		animationD4.play();
		animationD5.play();
		animationD6.play();
		animationD7.play();
		animationD8.play();
		animationD9.play();
		
		
		player.getImage().setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.SPACE) {

				bulletSound();
				// p.getChildren().add(player.getFire());
				ImageView bullet = new ImageView(new Image("file:characters/Bullet/Bullet.png"));
				bullet.setLayoutX(player.getImage().getLayoutX());
				bullet.setLayoutY(player.getImage().getLayoutY() - 50);
				p.getChildren().add(bullet);

				Path pathP = new Path();
				pathP.getElements().add(new MoveTo(bullet.getX() + 25, bullet.getY()));
				pathP.getElements().add(new LineTo(bullet.getX() + 25, -600));
				PathTransition animationP = new PathTransition();
				animationP.setDuration(Duration.millis(500));
				animationP.setPath(pathP);
				animationP.setOrientation(OrientationType.NONE);
				animationP.setCycleCount(1);
				animationP.setAutoReverse(false);
				animationP.setNode(bullet);

				animationP.play();

			}

			if (e.getCode() == KeyCode.RIGHT && player.getImage().getLayoutX() < sc.getWidth() - 55) {
				player.getImage().setLayoutX(player.getImage().getLayoutX() + 8);
			}

			if (e.getCode() == KeyCode.LEFT && player.getImage().getLayoutX() > 0)
				player.getImage().setLayoutX(player.getImage().getLayoutX() - 8);

		});

		sc.setFill(Color.BLACK);

		primaryStage.setScene(sc);
		primaryStage.show();
		primaryStage.setTitle("Space Invaders!                                                                                                                                                                                                                                      By: Checho");
		player.getImage().requestFocus();
	}

}

class EnemyA {

	private int life;
	private final ImageView skin = new ImageView(new Image("file:characters/Enemies/A.png"));

	public EnemyA() {

		this.life = 3;

	}

	public void onHitEvent() {
		this.life--;
	}

	public int getLife() {
		return this.life;
	}

	public ImageView getImage() {
		if (this.life>0)
			return this.skin;
		else
			return null;
	}
}

class EnemyB {

	private int life;
	private final ImageView skin = new ImageView(new Image("file:characters/Enemies/B.png"));

	public EnemyB() {

		this.life = 3;

	}
//_________
	public void onHitEvent() {
		this.life--;
	}

	public int getLife() {
		return this.life;
	}

	public ImageView getImage() {
		if (this.life>0)
			return this.skin;
		else
			return null;
	}
}

class EnemyC {

	private int life;
	private final ImageView skin = new ImageView(new Image("file:characters/Enemies/C.png"));

	public EnemyC() {

		this.life = 3;

	}

	public void onHitEvent() {
		this.life--;
	}

	public int getLife() {
		return this.life;
	}

	public ImageView getImage() {
		if (this.life>0)
			return this.skin;
		else
			return null;
	}
}

class EnemyD {

	private int life;
	private final ImageView skin = new ImageView(new Image("file:characters/Enemies/D.png"));

	public EnemyD() {

		this.life = 3;

	}

	public void onHitEvent() {
		this.life--;
	}

	public int getLife() {
		return this.life;
	}

	public ImageView getImage() {
		if (this.life>0)
			return this.skin;
		else
			return null;
	}
}

class Player {

	private int life;
	private final ImageView skin = new ImageView(new Image("file:characters/Player/Player.png"));
	private ImageView bullet = new ImageView(new Image("file:characters/Bullet/Bullet.png"));

	public Player() {

		this.life = 5;

	}

	public void onHitEvent() {
		this.life--;
	}

	public void fire() {

		bullet.setX(skin.getLayoutX());
		bullet.setY(skin.getLayoutY());

		System.out.println(bullet.getX());
		System.out.println(bullet.getY());
		// path.getElements().add(new LineTo(a.getImage().getLayoutX()+85+move,38));
		Path path = new Path();
		path.getElements().add(new MoveTo(this.getImage().getLayoutX() + 85, 38));
		path.getElements().add(new LineTo(this.getImage().getLayoutX() + 85, 38));
		PathTransition animationA = new PathTransition();
		animationA.setDuration(Duration.millis(1000));
		animationA.setPath(path);
		animationA.setOrientation(OrientationType.NONE);
		animationA.setCycleCount(1);
		animationA.setAutoReverse(false);
		animationA.setNode(bullet);

		animationA.play();

		System.out.println(bullet.getX());
		System.out.println(bullet.getY());
	}

	public ImageView getFire() {

		return this.bullet;

	}

	public int getLife() {
		return this.life;
	}

	public ImageView getImage() {
		return this.skin;
	}

}