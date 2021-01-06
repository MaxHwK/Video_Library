package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produit;
import model.Commande;
import model.Client;

public class Videotheque extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 7394006427481956893L;
	private JComboBox<Object> choixFenBox;
	private JButton boutonAjout;
	private JButton boutonSuppr;
	private JTable tableCl, tableCo, tablePr;
	private JLabel lclient,lproduit,lcommande;

	public Videotheque() {
	
		this.setTitle("Projet POO / COO - Gestion d'une Videotheque - Devoloppe par DJERMOUNE Kemil & GIRON Maxence (Annee : 2019 / 2020)");
		this.setSize(1500, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		initListeners();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel panneau1 = new JPanel();

		Object[] choix = new Object[]{"Client","Commande","Produit"};
		choixFenBox = new JComboBox<>(choix);
				
		boutonAjout=new JButton("Ajouter");
		boutonSuppr=new JButton("Supprimer");
				
		JPanel pnlTab = new JPanel();
		pnlTab.setLayout(new GridLayout(1, 1));

		JPanel pnlClient = new JPanel();
		String[] titreCl = new String[] { "Identifiant", "Nom", "Prenom", "Fidele" };
		Object[][] tabCl1 = { { "C1", "GIRON", "Maxence", "Oui" } };
		DefaultTableModel tableauCl = new DefaultTableModel(tabCl1, titreCl);
		tableCl = new JTable(tableauCl);
		lclient = new JLabel("Liste des Clients");
		pnlClient.add(lclient);
		pnlClient.add(new JScrollPane(tableCl));
		pnlTab.add(pnlClient);

		JPanel pnlCommande = new JPanel();
		String[] titreCo = new String[] { "ID Client", "ID Produit", "Date Debut", "Date Fin", "Montant" };
		Object[][] tabCo = { { "C1", "D1", "13/06/2020", "15/06/2020", "4" } };
		DefaultTableModel tableauCo = new DefaultTableModel(tabCo, titreCo);
		tableCo = new JTable(tableauCo);
		lcommande = new JLabel("Liste des Emprunts");
		pnlCommande.add(lcommande);
		pnlCommande.add(new JScrollPane(tableCo));
		pnlTab.add(pnlCommande);

		JPanel pnlProduit = new JPanel();
		String[] titrePr = new String[] { "Identifiant", "Type", "Titre", "Tarif/Jour", "Nombre" };
		Object[][] tabPr1 = {{"D1","DVD", "Titanic", "2", "3"}};
		DefaultTableModel tableauPr = new DefaultTableModel(tabPr1,titrePr);
		tablePr = new JTable(tableauPr);
		lproduit = new JLabel("Liste des Produits");
		pnlProduit.add(lproduit);
		pnlProduit.add(new JScrollPane(tablePr));
		pnlTab.add(pnlProduit);

		panneau1.add(choixFenBox);
		panneau1.add(boutonAjout);
		panneau1.add(boutonSuppr);
		panneau1.setBackground(Color.DARK_GRAY);
				
		this.add(pnlTab, BorderLayout.NORTH);
		this.add(panneau1, BorderLayout.SOUTH);
		
		boutonAjout.addActionListener(this);
		boutonSuppr.addActionListener(this);		
	}
	
	public JButton getBoutonAjout() {
		return boutonAjout;
	}
	
	public JButton getBoutonSuppr() {
		return boutonSuppr;
	}

	private void initListeners() {
		 this.addWindowListener(new ExitListener());
    }

    public void exit() {
        int rep = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment d�j� nous quitter ?","Fermeture de l'application",JOptionPane.YES_NO_OPTION);
        System.out.println("rep :"+rep);
        if (rep == 0) {
            System.exit(0);
        }
    }

    public class ExitListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            exit();
        }
    }

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String choix = (String) choixFenBox.getSelectedItem();
		String strInfoCl, strInfoCo, strInfoPr;
		DefaultTableModel tabCl = (DefaultTableModel) tableCl.getModel();
		DefaultTableModel tabCo = (DefaultTableModel) tableCo.getModel();
		DefaultTableModel tabPr = (DefaultTableModel) tablePr.getModel();

		if(b == boutonAjout) {
			
			if(choix == "Client") {
				
				strInfoCl = JOptionPane.showInputDialog(this,"Saisir les informations en les separant par un espace\n Voici un exemple : C1 DJERMOUNE Kemil (Oui/Non)","Inscription Nouveau Client", JOptionPane.QUESTION_MESSAGE);
				String[] infoCl = strInfoCl.split(" ");
				tabCl.addRow(new Object[]{infoCl[0], infoCl[1], infoCl[2], infoCl[3]});
				UUID id = UUID.fromString(infoCl[0]);
				Client.AjouterClient(id, infoCl[1], infoCl[2]);
			}
			
			else if (choix == "Commande") {
				
				strInfoCo = JOptionPane.showInputDialog(this,"Saisir les informations en les separant par un espace\n Voici un exemple : C1 D1 13/06/2020 15/06/2020 4","Nouvelle Commande", JOptionPane.QUESTION_MESSAGE);
				String[] infoCo = strInfoCo.split(" ");
				tabCo.addRow(new Object[]{infoCo[0], infoCo[1], infoCo[2], infoCo[3], infoCo[4]});
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy ");
				Date d = null;
				
				try {
					d = sdf.parse(infoCo[0]);
				}
				
				catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				Date d1 = null;
				
				try {
					d1 = sdf.parse(infoCo[1]);
				} 
				
				catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				float montant=Float.parseFloat(infoCo[2]);
				Commande.AjouterEmprunt(d, d1, montant);
			}
			
			else if (choix == "Produit") {
				
				strInfoPr = JOptionPane.showInputDialog(this,"Saisir les informations en les separant par un espace\n Voici un exemple : D1 DVD Titanic 2 3","Creation Nouveau Produit", JOptionPane.QUESTION_MESSAGE);
				String[] infoPr = strInfoPr.split(" ");
				tabPr.addRow(new Object[] { infoPr[0], infoPr[1], infoPr[2], infoPr[3], infoPr[4]});
				int id=Integer.parseInt(infoPr[0]);
				float prix=Float.parseFloat(infoPr[2]);
				Object[] p = new Object[]{infoPr[1].toString(),prix};
				Produit.AjouterProduit(id, p);
			}
		}
		
		else if(b==boutonSuppr && (tableCl.getSelectedRow() != -1 || tableCo.getSelectedRow() != -1 || tablePr.getSelectedRow() != -1)) {
			
			int res = JOptionPane.showOptionDialog(this, "Voulez vous supprimer cette ligne ?","Supprimer la ligne ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Oui", "Non" }, JOptionPane.YES_OPTION);
			
			if(res == JOptionPane.YES_OPTION) {
				
				try {
				
				if(tableCl.getSelectedRow() != -1)
					tabCl.removeRow(tableCl.getSelectedRow());
					Client.SupprimerClient(null);

				if(tableCo.getSelectedRow() != -1)
					tabCo.removeRow(tableCo.getSelectedRow());
					Commande.SupprimerEmprunt(null);

				if(tablePr.getSelectedRow() != -1)
					tabPr.removeRow(tablePr.getSelectedRow());
					Produit.SupprimerProduit(null);
				
				JOptionPane.showMessageDialog(this, "Ligne supprimee", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				
				catch(NullPointerException e1) {
				}
			}
			
			else if(res == JOptionPane.NO_OPTION)
				JOptionPane.showMessageDialog(this, "Operation annulee", "Information",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}