package lab2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Lab2A extends Frame {
	/**
	 * Data members
	 */
	private static final long serialVersionUID = 1L;
	final int FRAME_HEIGHT = 300, FRAME_WIDTH = 400;

	public Lab2A() {
		super();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
        addWindowListener( // This will close the window when the "Close" icon is clicked
        		new WindowAdapter(){
        			public void windowClosing(WindowEvent we){ System.exit(NORMAL); }
        		}
        );
	}

	public static void main(String[] args) {
		System.out.println("Hello graphics world");
		Lab2A mainWindow = new Lab2A();
		mainWindow.setVisible(true);
	}
}
