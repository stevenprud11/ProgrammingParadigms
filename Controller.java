import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements ActionListener, MouseListener, KeyListener{
	//instance variables
	View view;
	Model model;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;

	//constructor
	Controller(Model m){
		model = m;
	}
	void setView(View v){
		view = v;
	}

	//mouse clicks
	public void mousePressed(MouseEvent e){
		model.setDestination(e.getX(), e.getY());
	}

	public void mouseReleased(MouseEvent e){ 
	}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseClicked(MouseEvent e){
	}
	public void actionPerformed(ActionEvent e){
		view.removeButton();
	}

	//clicks from keyboard
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
		}
	}
	//released keys
	public void keyReleased(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
		}
	}

	public void keyTyped(KeyEvent e){
	}
	//will move the turtle faster by 4 units rather than 1
	void update(){
		if(keyRight) model.turtle_x += Math.min(4, model.dest_x - model.turtle_x);
		if(keyLeft) model.turtle_x -= Math.min(4, model.dest_x - model.turtle_x);
		if(keyDown) model.turtle_y += Math.min(4, model.dest_y - model.turtle_y);
		if(keyUp) model.turtle_y -= Math.min(4, model.dest_y - model.turtle_x);
	}
}
