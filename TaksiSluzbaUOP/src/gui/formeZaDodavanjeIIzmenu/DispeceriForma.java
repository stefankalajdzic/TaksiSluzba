package gui.formeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pojo.Dispecer;
import util.RadSaDatotekama;
import enums.EPol;
import enums.ETelefonskaOdeljenja;

public class DispeceriForma extends JFrame {

	//zavrseno
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
	private JTextField txtkorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("Jmbg");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<EPol> cbPol = new JComboBox<EPol>(EPol.values());
	private JLabel lblBrTelefona = new JLabel("Broj telefona");
	private JTextField txtBrTelefona = new JTextField(20);
	private JLabel lblPlata = new  JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblBrTelefonskeLinije = new  JLabel("Br. tel. linije");
	private JTextField txtBrTelefonskeLinije = new JTextField(20);
	private JLabel lblBrojTelefonskogOdeljenja = new JLabel("Br. tel. odeljenja");
	private JComboBox<ETelefonskaOdeljenja> cbBrojTelefonskogOdeljenja = 
				new JComboBox<ETelefonskaOdeljenja>(ETelefonskaOdeljenja.values());
	
	
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Dispecer dispecer;
	
	public DispeceriForma(RadSaDatotekama rsd, Dispecer dispecer) {
		this.rsd = rsd;
		this.dispecer = dispecer;
		if(dispecer == null) {
			setTitle("Dodavanje dispecera");
		}else {
			setTitle("Izmena podataka - " + dispecer.getKorisnickoIme());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][]20[]");
		setLayout(layout);
		
//		if(dispecer != null) {
//			popuniPolja();
//		}
		
		add(lblKorisnickoIme);
		add(txtkorisnickoIme);
		add(lblLozinka);
		add(pfLozinka);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblAdresa);
		add(txtAdresa);
		add(lblPol);
		add(cbPol);
		add(lblBrTelefona);
		add(txtBrTelefona);
		add(lblPlata);
		add(txtPlata);
		add(lblBrTelefonskeLinije);
		add(txtBrTelefonskeLinije);
		add(lblBrojTelefonskogOdeljenja);
		add(cbBrojTelefonskogOdeljenja);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	
	private void initActions() {
		
	}
}
	