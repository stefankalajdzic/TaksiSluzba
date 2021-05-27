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
import gui.formeZaDodavanjeIIzmenu.MusterijeForma;
import gui.formeZaDodavanjeIIzmenu.VozaciForma;
import main.Main;
import pojo.Automobil;
import pojo.Musterija;
import pojo.Vozac;
import util.RadSaDatotekama;

public class MusterijeProzor extends JFrame {
	

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable musterijeTabela;
	
	private RadSaDatotekama rsd;
	
	public MusterijeProzor(RadSaDatotekama rsd) {
		this.rsd = rsd;
		setTitle("Musterije");
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
											"Broj telefona"};
		Object[][] sadrzaj = new Object[rsd.sveNeobrisaneMusterije().size()][zaglavlja.length];
		
		for(int i=0; i< rsd.sveNeobrisaneMusterije().size(); i++) {
			Musterija musterija = rsd.sveNeobrisaneMusterije().get(i);
			sadrzaj[i][0] = musterija.getId();
			sadrzaj[i][1] = musterija.getKorisnickoIme();
			sadrzaj[i][2] = musterija.getLozinka();
			sadrzaj[i][3] = musterija.getIme();
			sadrzaj[i][4] = musterija.getPrezime();
			sadrzaj[i][5] = musterija.getJmbg();
			sadrzaj[i][6] = musterija.getAdresa();
			sadrzaj[i][7] = musterija.getPol();
			sadrzaj[i][8] = musterija.getBrojTelefona();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		musterijeTabela = new JTable(tableModel);
		
		musterijeTabela.setRowSelectionAllowed(true);
		musterijeTabela.setColumnSelectionAllowed(false);
		musterijeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterijeTabela.setDefaultEditor(Object.class, null);
		musterijeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(musterijeTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = musterijeTabela.getSelectedRow();
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
					String korisnickoIme = tableModel.getValueAt(red, 1).toString();
					Musterija musterija = rsd.NadjiMusterijuPoKorisnickomImenu(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete musteriju?", 
							korisnickoIme + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						musterija.setObrisan(true);
						//da je ovo vozac:
//						(for Voznja v : vozac.getNjegoveVoznje()){
//							v.setObrisan(true);
//						}
						tableModel.removeRow(red);
						rsd.snimiMusterije(Main.MUSTERIJE_FAJL);
					}
				}
				
			}
		}); 
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijeForma mf = new MusterijeForma(rsd, null);
				mf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = musterijeTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String korisnickoIme = tableModel.getValueAt(red, 1).toString();
						Musterija musterija = rsd.NadjiMusterijuPoKorisnickomImenu(korisnickoIme);
						if(musterija == null) {
							JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja musterije sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
						}else {
							MusterijeForma mf = new MusterijeForma(rsd, musterija);
							mf.setVisible(true);
						}
					}
				}
			});
		
	}

}
