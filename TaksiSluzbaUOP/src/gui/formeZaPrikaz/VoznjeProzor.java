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
import pojo.Musterija;
import pojo.Vozac;
import pojo.Voznja;
import util.RadSaDatotekama;

public class VoznjeProzor extends JFrame {
	

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable voznjeTabela;
	
	private RadSaDatotekama rsd;
	
	public VoznjeProzor(RadSaDatotekama rsd) {
		this.rsd = rsd;
		setTitle("Voznje");
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
		
		String[] zaglavlja = new String[] {"Id", "Datum", "Vreme porudzbine", "Polazak", "Odrediste",
								"Musterija", "Vozac", "Broj predjenih km", "Trajanje voznje", "Status"};
		Object[][] sadrzaj = new Object[rsd.sveNeobrisaneVoznje().size()][zaglavlja.length];
		
		for(int i=0; i< rsd.sveNeobrisaneVoznje().size(); i++) {
			Voznja voznja = rsd.sveNeobrisaneVoznje().get(i);
			Musterija musterija = rsd.sveNeobrisaneMusterije().get(i);
			Vozac vozac = rsd.sviNeobrisaniVozaci().get(i);
			sadrzaj[i][0] = voznja.getId();
			sadrzaj[i][1] = voznja.getDatum();
			sadrzaj[i][2] = voznja.getVremePorudzbine();
			sadrzaj[i][3] = voznja.getAdresaPolaska();
			sadrzaj[i][4] = voznja.getAdresaDestinacije();
			sadrzaj[i][5] = musterija == null ? "--" : musterija.getId();
			sadrzaj[i][6] = vozac == null ? "--" : vozac.getId();
			sadrzaj[i][7] = voznja.getBrojPredjenihKilometara();
			sadrzaj[i][8] = voznja.getTrajanjeVoznje();
			sadrzaj[i][9] = voznja.getStatus();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		voznjeTabela = new JTable(tableModel);
		
		voznjeTabela.setRowSelectionAllowed(true);
		voznjeTabela.setColumnSelectionAllowed(false);
		voznjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		voznjeTabela.setDefaultEditor(Object.class, null);
		voznjeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(voznjeTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
	}

}
