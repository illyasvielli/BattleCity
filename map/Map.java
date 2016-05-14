import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

import java.awt.Image;
public class Map{
	private int x;
	private int y;
	private int tileSize;
	private int[][] map;
	private int mapWidth;
	private int mapHeight;

	//private BufferedImage tileset;
	//private Tile[][] tiles;
	private boolean blocked;
	Image img;

	public Map(String s, int tileSize){
		this.tileSize = tileSize;
		try{
			BufferedReader br = new BufferedReader(new FileReader(s));	/*makes a buffered reader to read file testmap*/
			mapWidth = Integer.parseInt(br.readLine());	//first line is map's width
			mapHeight = Integer.parseInt(br.readLine());	//2nd line is map's height

			map = new int[mapHeight][mapWidth];	/*2d array with rows = mapHeight col = mapWidth*/

			//String delimiters = " ";
			for(int row = 0; row<mapHeight; row++){	/*while there are sting rows in file*/
				String line = br.readLine();	/*stores line*/
				String[] tokens = line.split(" "); /*stores into array tokens int separated by delimeter " "*/
				
				for(int col = 0; col<mapWidth; col++)
					map[row][col] = Integer.parseInt(tokens[col]); /*sets col to the int in tokens array*/
			}
		}catch(Exception e){}
	}
	/*public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}		
	public int getTileSize(){
		return tileSize;
	}
	/*public boolean isBlocked(int row,int col){
		int rc = map[row][col];
		int r = rc/tiles[0].length;
		int c = rc%tiles[0].length;
		return tiles[r][c].isBlocked();
	} */

	public void update(){}
	
	public void draw(Graphics2D g){
		for(int row = 0; row<mapHeight; row++){	/*checks every cell in 2d array and prints specific image for each condition*/
			for(int col = 0; col<mapWidth; col++){
				int rc = map[row][col];
				if (rc == 0){
					try {
						img = ImageIO.read(new File("resizedBrick.png"));
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
					this.blocked = true;
					g.drawImage(img, col*tileSize,row*tileSize,null); 
					
				}
				if (rc == 1){
					g.setColor(Color.BLACK); //free space / black tiles
					this.blocked = false;
					g.fillRect(x + col * tileSize, y + row * tileSize, tileSize, tileSize);					
				}
				if (rc == 2){
					try {
						img = ImageIO.read(new File("resizedMetal.png"));
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
					this.blocked = true;
					g.drawImage(img, col*tileSize,row*tileSize,null);
				}
				if (rc == 3){
					try {
						img = ImageIO.read(new File("resizedWater.png"));
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
					this.blocked = true;
					g.drawImage(img, col*tileSize,row*tileSize,null); 
				} 
				if (rc == 4){
					g.setColor(Color.DARK_GRAY); //border / dark gray tiles
					this.blocked = true;
					g.fillRect(x + col * tileSize, y + row * tileSize, tileSize, tileSize);										
				}	
			}
		}
	}
}






