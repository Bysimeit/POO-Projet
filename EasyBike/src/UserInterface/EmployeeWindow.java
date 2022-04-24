package UserInterface;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmployeeWindow extends JFrame{
    private JMenuBar menuBar;
    private JMenu infrastructureMenu, dashboardMenu;
    private Container mainContent;

    public EmployeeWindow(){
        super("Employé");
        setBounds(100,100,450,450);

        //fermeture avec l'icone X
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //create menu
        menuBar = new JMenuBar();

        dashboardMenu = new JMenu("Tableau de bord");
        menuBar.add(dashboardMenu);

        infrastructureMenu = new JMenu("Infrastructure");
        menuBar.add(infrastructureMenu);

        infrastructureMenu.addMenuListener(new InfrastructureListener());
        dashboardMenu.addMenuListener(new DashboardListener());

        this.setJMenuBar(menuBar);


        //create content

        mainContent = this.getContentPane();
        mainContent.setLayout(new BorderLayout());
        mainContent.add(new DashboardPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    //click infrastructure menu
    public class InfrastructureListener implements MenuListener{

        @Override
        public void menuSelected(MenuEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new InfrastructurePanel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }

    //click dashboard menu
    public class DashboardListener implements MenuListener{

        @Override
        public void menuSelected(MenuEvent e) {
            mainContent.removeAll();
            mainContent.setLayout(new BorderLayout());
            mainContent.add(new DashboardPanel(), BorderLayout.CENTER);
            mainContent.repaint();
            setVisible(true);
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }
}
