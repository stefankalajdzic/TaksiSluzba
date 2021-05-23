package gui.formeZaPrikaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import pojo.Dispecer;
import util.RadSaDatotekama;

public class DispeceriProzor extends JFrame {

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable dispeceriTabela;
	
	private RadSaDatotekama rsd;
	
	public DispeceriProzor(RadSaDatotekama rsd) {
		this.rsd = rsd;
		setTitle("Dispeceri");
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
											"Broj telefona", "Plata", "Broj tel linije", "Telefonsko odjeljenje"};
		Object[][] sadrzaj = new Object[rsd.sviNeobrisaniDispeceri().size()][zaglavlja.length];
		
		for(int i=0; i< rsd.sviNeobrisaniDispeceri().size(); i++) {
			Dispecer dispecer = rsd.sviNeobrisaniDispeceri().get(i);
			sadrzaj[i][0] = dispecer.getId();
			sadrzaj[i][1] = dispecer.getKorisnickoIme();
			sadrzaj[i][2] = dispecer.getLozinka();
			sadrzaj[i][3] = dispecer.getIme();
			sadrzaj[i][4] = dispecer.getPrezime();
			sadrzaj[i][5] = dispecer.getJmbg();
			sadrzaj[i][6] = dispecer.getAdresa();
			sadrzaj[i][7] = dispecer.getPol();
			sadrzaj[i][8] = dispecer.getBrojTelefona();
			sadrzaj[i][9] = dispecer.getPlata();
			sadrzaj[i][10] = dispecer.getBrojTelefonskeLinije();
			sadrzaj[i][11] = dispecer.getTelefonskaOdeljenja();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		dispeceriTabela = new JTable(tableModel);
		
		dispeceriTabela.setRowSelectionAllowed(true);
		dispeceriTabela.setColumnSelectionAllowed(false);
		dispeceriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dispeceriTabela.setDefaultEditor(Object.class, null);
		dispeceriTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(dispeceriTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
	}
	
}