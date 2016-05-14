import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Thread thread;
	private boolean running;

	private BufferedImage image;
	private Graphics2D g;

//	private int FPS = 30;
//	private int targetTime = 1000/FPS;

	public Map map; 

	public GamePanel(){
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);	
		requestFocus();
	}
	public void addNotify(){
		super.addNotify();
		if(thread == null){	/*if no threads yet, creates new thread and starts it's running process*/
			thread = new Thread(this);
			thread.start();
		}
	}
	public void run(){

		init();	
		//update();
		render();		
		draw();
/*		long startTime;
		long urdTime;
		long waitTime;
		while(running){

			startTime = System.nanoTime();
			update();
			render();
			draw();

			urdTime = (System.nanoTime()-startTime)/1000000;
			waitTime = targetTime - urdTime;
			try{
				Thread.sleep(waitTime);
			}catch(Exception e){

			}
		} */
	}
	public void init(){
		//running = true;
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB); /*sets image with size WIDTH x HEIGHT and accepts RGB type image*/
		g = (Graphics2D)image.getGraphics();	
		map = new Map("testmap.txt",40);	/*initializes map from file testmap.txt and tile size 40*/
		//map.loadTiles("brick.png");
	}

	private void update(){
		map.update();
	}
	private void render(){
		/*g.setColor(Color.BLACK);
		g.fillRect(0,0,WIDTH,HEIGHT); */
		map.draw(g);
	}
	private void draw(){
		Graphics g2 = getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose(); 
	}
	

}