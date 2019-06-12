
import javax.swing.JFrame;

public class FrameDemo{
	public static void main(String[] args){
		JFrame frame = new JFrame("Frame Demo");  //starts up the process of making a frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends the program when closed 
		frame.setSize(400, 400); //decides the measurements

        Shapes r = new Shapes();
        frame.add(r);
        
		frame.setVisible(true); //makes the frame box appear
    }
}
