
package demo.billingsoftware;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Timer;

public class StarttPanel extends javax.swing.JFrame 
{
   
    Timer timer=new Timer(10,new ActionListener() 
        {
           
            int i=1;
            
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(i==100)
                {
                timer.stop();
               new  LoginPanel().setVisible(true); 
                    setVisible(false);
            
               
                }
            jProgressBar5.setValue(i);
            i++;
            
            }
        });
    
    public StarttPanel() 
    {
        initComponents();
        timer.start();
       
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar5 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, 354));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel1.setText("Billing");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 146, 124, 43));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel3.setText("Software");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 195, -1, 36));

        jProgressBar5.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar5.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(jProgressBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 700, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar5;
    // End of variables declaration//GEN-END:variables
}
