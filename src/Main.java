import javax.swing.JFrame;
import view.SlogoGUI;
import model.SlogoModel;


public class Main {
	
	public static final String TITLE = "SLOGO";
	
	/**
	 *  Start of the program.
	 */
	public static void main (String[] args){
		// create model and view. Load the model onto the view
		SlogoModel model = new SlogoModel();
		SlogoGUI view = new SlogoGUI(model);
		// Pop up the frame and fill it with content of the GUI
		JFrame frame = new JFrame(TITLE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(view);
		frame.setVisible(true);
	}
}
