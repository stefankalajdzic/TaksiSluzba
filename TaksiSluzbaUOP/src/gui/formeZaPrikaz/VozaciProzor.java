package gui.formeZaPrikaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import pojo.Automobil;
import pojo.Dispecer;
import pojo.Vozac;
import util.RadSaDatotekama;

public class VozaciProzor extends JFrame {
	

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable vozaciTabela;
	
	private RadSaDatotekama rsd;
	
	public VozaciProzor(RadSaDatotekama rsd) {
		this.rsd = rsd;
		setTitle("Vozaci");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon removeIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(removeIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		mainToolbar.setFloatable(false);
		
		String[] zaglavlja = new String[] {"Id", "Korisnicko ime", "Lozinka", "Ime", "Prezime", "Jmbg", "Adresa", "Pol",
											"Broj telefona", "Plata", "Br clanske karte udruzenja", "Automobil"};
		Object[][] sadrzaj = new Object[rsd.sviNeobrisaniVozaci().size()][zaglavlja.length];
		
		for(int i=0; i< rsd.sviNeobrisaniVozaci().size(); i++) {
			Vozac vozac = rsd.sviNeobrisaniVozaci().get(i);
			Automobil automobil = rsd.sviNeobrisaniAutomobili().get(i);
			sadrzaj[i][0] = vozac.getId();
			sadrzaj[i][1] = vozac.getKorisnickoIme();
			sadrzaj[i][2] = vozac.getLozinka();
			sadrzaj[i][3] = vozac.getIme();
			sadrzaj[i][4] = vozac.getPrezime();
			sadrzaj[i][5] = vozac.getJmbg();
			sadrzaj[i][6] = vozac.getAdresa();
			sadrzaj[i][7] = vozac.getPol();
			sadrzaj[i][8] = vozac.getBrojTelefona();
			sadrzaj[i][9] = vozac.getPlata();
			sadrzaj[i][10] = vozac.getBrojClanskeKarteUdruzenjaTaksista();
			sadrzaj[i][11] = automobil == null ? "--" : vozac.getAutomobil().getId();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		vozaciTabela = new JTable(tableModel);
		
		vozaciTabela.setRowSelectionAllowed(true);
		vozaciTabela.setColumnSelectionAllowed(false);
		vozaciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vozaciTabela.setDefaultEditor(Object.class, null);
		vozaciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(vozaciTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
	}

}
