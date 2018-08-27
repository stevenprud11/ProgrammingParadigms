import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	//instance variables
	Model model;
	Controller controller;
	View view;

	//constructor
	public Game(){
		model = new Model();
		controller = new Controller(model);
		view = new View(controller, model);
		this.setTitle("Turtle attack!!!");
		this.setSize(500, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addMouseListener(controller);
		this.addKeyListener(controller);
	}
	public void run(){
		while(true)
		{
			controller.update();
			model.update();
			view.repaint(); // Indirectly calls View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen

			// Go to sleep for 50 miliseconds
			try{
				Thread.sleep(50);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			System.out.println("hi"); // remove this line
		}
	}
	//main function
	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}
}
