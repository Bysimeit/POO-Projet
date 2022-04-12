import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfaceConnexionWindows extends JFrame {
    private InterfaceConnexionContent content;
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

        content = new InterfaceConnexionContent();


        mainContent = this.getContentPane();
        mainContent.setLayout(new BorderLayout());

        mainContent.add(content, BorderLayout.CENTER);

        setVisible(true);
    }

}
