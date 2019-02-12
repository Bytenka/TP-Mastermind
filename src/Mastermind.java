import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Mastermind extends Frame implements WindowListener {
	
	public Mastermind() {
		this.setTitle("Mastermind");
		this.setSize(1280, 720);
		this.addWindowListener(this);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Modele modele = new Modele();
		
		new Mastermind();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {	}

	@Override
	public void windowClosed(WindowEvent arg0) { }

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) { }

	@Override
	public void windowDeiconified(WindowEvent arg0) { }

	@Override
	public void windowIconified(WindowEvent arg0) {	}

	@Override
	public void windowOpened(WindowEvent arg0) { }
	
	
}