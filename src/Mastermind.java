import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Mastermind extends Frame implements WindowListener {

	Panel vueClavier;
	Canvas vuePropositions;

	public Mastermind() {
		this.setTitle("Mastermind");
		this.setSize(300, 700);
		this.setLayout(new BorderLayout());
		this.addWindowListener(this);
		this.setVisible(true);
		
		/* Setup vueClavier */
		
		vueClavier = new Panel();
		vueClavier.setPreferredSize(new Dimension(0, 40));
		vueClavier.setBackground(Color.LIGHT_GRAY);

		// For vueClavier
		FlowLayout fl = new FlowLayout();	
		fl.preferredLayoutSize(vueClavier);
		vueClavier.setLayout(fl);

		// Adding buttons to the layout, at the bottom
		for (Color c : Modele.COULEURS) {
			Button b = new Button();
			b.setPreferredSize(new Dimension(30, 30));
			b.setBackground(c);
			vueClavier.add(b);
		}
		
		/********************/

		vuePropositions = new Canvas();

		this.add(vueClavier, BorderLayout.PAGE_END);
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");

		Modele modele = new Modele();

		new Mastermind();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}