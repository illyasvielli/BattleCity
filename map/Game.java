import javax.swing.*;
import java.awt.Dimension;

public class Game{
	public static void main(String[] args){
		JFrame window = new JFrame("Platform");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GamePanel());
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

}