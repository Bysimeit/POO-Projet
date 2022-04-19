import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfaceConnexionWindows extends JFrame {
    private InterfaceConnexionButtons buttonsArea;
    private InterfaceConnexionMain mainArea;
    private InterfaceConnexionTitle titleArea;
    private InterfaceConnexionPanel panel;
    private Container mainContent;

    public InterfaceConnexionWindows(){
        super("Connexion");
        setBounds(100,100,500,500);

        //fermeture avec l'icone X
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //panel = new InterfaceConnexionPanel();
        buttonsArea = new InterfaceConnexionButtons();
        mainArea = new InterfaceConnexionMain();
        titleArea = new InterfaceConnexionTitle();

        mainContent = this.getContentPane();
        mainContent.setLayout(new BorderLayout());

        mainContent.add(mainArea, BorderLayout.CENTER);
        mainContent.add(buttonsArea,BorderLayout.SOUTH);
        mainContent.add(titleArea,BorderLayout.NORTH);

        setVisible(true);
    }

}
