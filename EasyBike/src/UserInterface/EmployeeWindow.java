package UserInterface;

import Model.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmployeeWindow extends JFrame{
    private JMenuBar menuBar;
    private JMenu CRUDMenu, dashboardMenu, researchMenu;
    private JMenuItem profileItem, disconnectItem, modifyItem, deleteItem, addItem, research1Item, research2Item, research3Item;
    private Container mainContent;
    private DashboardPanel dashboardPanel;
    private ResearchRepairPanel researchRepairPanel;

    public EmployeeWindow(JFrame loginWindow, Register loginID){
        super("Employé");
        setBounds(100,100,450,450);

        //close with X logo
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        dashboardPanel = new DashboardPanel(this, loginWindow, loginID);

        //create menu
        menuBar = new JMenuBar();

        dashboardMenu = new JMenu("Tableau de bord");
        menuBar.add(dashboardMenu);

        CRUDMenu = new JMenu("CRUD");
        menuBar.add(CRUDMenu);

        researchMenu = new JMenu("Recherches");
        menuBar.add(researchMenu);

        profileItem = new JMenuItem("Profil");
        dashboardMenu.add(profileItem);

        disconnectItem = new JMenuItem("Se déconnecter");
        dashboardMenu.add(disconnectItem);

        modifyItem = new JMenuItem("Modifier");
        CRUDMenu.add(modifyItem);

        deleteItem = new JMenuItem("Supprimer");
        CRUDMenu.add(deleteItem);

        addItem = new JMenuItem("Ajouter");
        CRUDMenu.add(addItem);

        research1Item = new JMenuItem("Recherche 1");
        researchMenu.add(research1Item);

        research2Item = new JMenuItem("Recherche 2");
        researchMenu.add(research2Item);

        research3Item = new JMenuItem("Recherche 3");
        researchMenu.add(research3Item);

        //create events JMenuItems
        profileItem.addActionListener(new ProfileListener());
        modifyItem.addActionListener(new ModifyListener());
        deleteItem.addActionListener(new DeleteListener());
        addItem.addActionListener(new AddListener());

        this.setJMenuBar(menuBar);


        //create content
        mainContent = this.getContentPane();
        mainContent.setLayout(new BorderLayout());
        mainContent.add(dashboardPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    //events DashboardItem

    //click profileItem
    public class ProfileListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(dashboardPanel, BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //click disconnectItem
    public class DisconnectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //employeeWindow.setVisible(false);
            //loginWindow.setVisible(true);
        }
    }

    //events CRUDItem

    //click modifyItem
    public class ModifyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new ResearchRepairPanel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //click deleteItem
    public class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new ResearchRepairPanel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //click addItem
    public class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new RepairSheetPanel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //events ResearchItem

    //event research1Item
    //event research2Item
    //event research3Item


}
