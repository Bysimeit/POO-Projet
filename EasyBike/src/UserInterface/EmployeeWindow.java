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
    private JFrame loginWindow;
    private Register loginID;

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

        this.loginWindow = loginWindow;
        this.loginID = loginID;
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
        disconnectItem.addActionListener(new DisconnectListener());
        modifyItem.addActionListener(new ModifyListener());
        deleteItem.addActionListener(new DeleteListener());
        addItem.addActionListener(new AddListener());
        research1Item.addActionListener(new Research1Listener());
        research2Item.addActionListener(new Research2Listener());
        research3Item.addActionListener(new Research3Listener());

        this.setJMenuBar(menuBar);


        //create content
        mainContent = this.getContentPane();
        mainContent.setLayout(new BorderLayout());
        mainContent.add(dashboardPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    //events DashboardItem

    //click profileItem
    public class ProfileListener implements ActionListener {
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
    public class DisconnectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            loginWindow.setVisible(true);
        }
    }

    //events CRUDItem

    //click modifyItem
    public class ModifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new ResearchRepairPanel(mainContent, EmployeeWindow.this, false, loginID), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //click deleteItem
    public class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new ResearchRepairPanel(mainContent, EmployeeWindow.this, true, loginID), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //click addItem
    public class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new RepairSheetPanel(true, loginID, null, EmployeeWindow.this, mainContent), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //events ResearchItem

    //event research1Item
    public class Research1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new Research1Panel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //event research2Item
    public class Research2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new Research2Panel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

    //event research3Item
    public class Research3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new Research3Panel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }
    }

}
