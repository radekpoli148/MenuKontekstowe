package menukontekstowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuKontekstowe extends JFrame{

    public MenuKontekstowe()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Pasek menu");
        this.setBounds(300, 320, 400, 200);
        
        final JPopupMenu menuKontekstowe = new JPopupMenu();
        menuKontekstowe.add(new JMenuItem(new AbstractAction("Zamknij"){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));
        menuKontekstowe.add(new JMenuItem("Kopiuj"));
        menuKontekstowe.add(new JMenuItem("Wklej"));
        
        this.getContentPane().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("klik");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released");
                
                if(e.getClickCount() == 3 && e.getButton() == MouseEvent.BUTTON1 && e.isShiftDown())
                    JOptionPane.showMessageDialog(rootPane, "Sporo tych kliknięć");
                
                if(e.isPopupTrigger())
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("wszedłem");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("odszedłem");
            }
        });
        this.getContentPane().add(test, BorderLayout.SOUTH);
        test.addMouseListener(new MouseAdapter(){
        @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released");
                
                if(e.getClickCount() == 3 && e.getButton() == MouseEvent.BUTTON1 && e.isShiftDown())
                    JOptionPane.showMessageDialog(rootPane, "Sporo tych kliknięć");
                
                if(e.isPopupTrigger())
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
                
            }
        });
        
        this.setDefaultCloseOperation(3);
    }
    
    private JButton test = new JButton("test");
    
    
    public static void main(String[] args) {
        new MenuKontekstowe().setVisible(true);
    }
    
}
