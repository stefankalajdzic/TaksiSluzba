package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import gui.formeZaDodavanjeIIzmenu.VozaciForma;
import gui.formeZaDodavanjeIIzmenu.VoznjeForma;
import main.Main;
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
			Musterija musterija = voznja.getMusterija();
			Vozac vozac = voznja.getVozac();
			sadrzaj[i][0] = voznja.getId();
			sadrzaj[i][1] = voznja.getDatum();
			sadrzaj[i][2] = voznja.getVremePorudzbine();
			sadrzaj[i][3] = voznja.getAdresaPolaska();
			sadrzaj[i][4] = voznja.getAdresaDestinacije();
			sadrzaj[i][5] = musterija == null ? "--" : musterija;
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
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = voznjeTabela.getSelectedRow();
				//za voznju iz perspektive dispecera, pored dugmeta za brisanje itd. bice i dugme za dodelu voznje vozacu(samo ako voznja ima status kreirana):
				// int idVoznje = tableModel.getValueAt(red, 0).toString();
				// Voznja voznjica = rsd.NadjiVoznju(Integer.parseInt(idVoznje));
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} //(za voznju)if(voznjica.getStatus == EStatus.Kreirana){
				//kada je taj uslov ispunjen trebalo bi da iskoci prozor na kom ce samo biti dropbox u kom ce se izlistati svi vozaci(rsd.getVozaci)
				//kad se odabere vozac (okBtn.listener)
				//voznjica.setStatus(cekaOdobrenje)
				//voznjica.setVozac(dropbox.izabraniItem)
				//voznjica.getVozac.getNjegoveVoznje.add(voznjica)
				
			//} 
				else {
					String adresapolaska = tableModel.getValueAt(red, 3).toString();
					Voznja voznja = rsd.pronadjiVoznju(adresapolaska);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete voznju?", 
							adresapolaska + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						voznja.setObrisan(true);
						//da je ovo vozac:
//						(for Voznja v : vozac.getNjegoveVoznje()){
//							v.setObrisan(true);
//						}
						tableModel.removeRow(red);
						rsd.snimiVoznje(Main.VOZNJE_FAJL);
					}
				}
				
			}
				
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VoznjeForma voznjef = new VoznjeForma(rsd, null);
				voznjef.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = voznjeTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String adresapolaska = tableModel.getValueAt(red, 3).toString();
						Voznja voznja = rsd.pronadjiVoznju(adresapolaska);
						if(voznja == null) {
							JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja dispecera sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
						}else {
							VoznjeForma voznjef = new VoznjeForma(rsd, voznja);
							voznjef.setVisible(true);
						}
					}
				}
			});
		
	}

}
