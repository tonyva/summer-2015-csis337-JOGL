package lab2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;

public class Lab2B extends Frame implements GLEventListener{
	/**
	 * Data members
	 */
	private static final long serialVersionUID = 1L;
	final int FRAME_HEIGHT = 300, FRAME_WIDTH = 400;
	private GL gl;
	private GL2 gl2;
	private GLCanvas canvas;
	private final double ZPLUS = 10.0, ZMINUS = -10.0;


	public Lab2B() {
		super();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
        canvas = new GLCanvas(); //GLDrawableFactory.getFactory().createGLCanvas( glcapabilities );
        canvas.addGLEventListener( this );
        add( canvas );
		addWindowListener( // This will close the window when the "Close" icon is clicked
		    	new WindowAdapter(){
		    		public void windowClosing(WindowEvent we){
		    			remove( canvas );
		    			System.exit(NORMAL); 
		    		}
		        }
		    );

	}

	public static void main(String[] args) {
		System.out.println("Hello graphics world");
		Lab2B mainWindow = new Lab2B();
		mainWindow.setVisible(true);
	}

	public void display(GLAutoDrawable drawable) {
        gl  = drawable.getGL();
        gl2 = gl.getGL2();
		
        gl2.glLoadIdentity();
        gl2.glColor3f( 0.0f, 1.0f, 0.0f);
        gl2.glRectf( 150.0f, 200.0f, 200.0f, 150.0f );
        gl.glFlush( );
//        print_error();
	}

	public void dispose(GLAutoDrawable arg0) {
	}

	@Override
	public void init(GLAutoDrawable drawable) {
        gl  = drawable.getGL();
        gl2 = gl.getGL2();

        gl2.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // set background color
        gl2.glClearDepthf( 1.0f );
        gl2.glEnable( GL.GL_DEPTH_TEST);
        gl2.glDepthFunc( GL.GL_LEQUAL);
        
        gl2.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST );
        gl2.glShadeModel( GL2.GL_SMOOTH );
        
        gl2.glViewport(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();
        gl2.glOrtho( 0, FRAME_WIDTH, 0, FRAME_HEIGHT, -ZPLUS, -ZMINUS );		
	}

	public void reshape(GLAutoDrawable arg0, int x, int y, int width, int height) {
        if (height == 0) height = 1;

        System.out.println("height: " +height + " width: " + width );
        gl.glViewport(0, 0, width, height);
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();
        if (width <= height)
                gl2.glOrtho( 0.0, 300.0, 0.0, 300.0 *height/width, -ZPLUS, -ZMINUS);
        else
                gl2.glOrtho( 0.0, 300.0 *width/height, 0.0, 300.0, -ZPLUS, -ZMINUS);
        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();
	}
}
