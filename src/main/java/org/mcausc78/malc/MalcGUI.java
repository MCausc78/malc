package org.mcausc78.malc;

import org.mcausc78.malc.permissions.Mode;

import javax.swing.*;
import java.util.List;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MalcGUI {
    public static void main(String[] args) {
        boolean isConsoleMode = args.length==1?(args[0].equals("-console")?true:false):false;
        if(!isConsoleMode) {
            Mode mode = new Mode();
            JFrame frame = new JFrame("Chmod calculator");
            JMenuBar jmb = new JMenuBar();
            JMenu jm = new JMenu("Themes");
            List<JMenuItem> ljmi = new ArrayList<>();
            for (UIManager.LookAndFeelInfo lafi : UIManager.getInstalledLookAndFeels()) {
                JMenuItem jmi = new JMenuItem(lafi.getClassName());
                jmi.addActionListener((ev) -> {
                    try{
                        UIManager.setLookAndFeel(lafi.getClassName());
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                });
                jm.add(jmi);
            }
            jmb.add(jm);
            frame.setJMenuBar(jmb);
            /*
            **
            ** O = Owner permissions
            ** G = Group permissions
            ** U = All users permissions
            ** R - Readable
            ** W - Writeable
            ** X = Executable
            ** T = True
            ** F = False
            **
            ** +---O-G-U-+
            ** +-R-T-F-F-+
            ** +-W-T-F-F-+
            ** +-X-T-F-F-+
            ** +---------+
            **
            */
            JLabel label = new JLabel("chmod 700 myfile.txt");
            label.setBounds(16, 12, 256, 256);
            JLabel label2 = new JLabel("Owner  Group  Users");
            label2.setBounds(4, -72, 192, 192);
            JLabel labelr = new JLabel("R");
            labelr.setBounds(8, -48, 192, 192);
            JLabel labelw = new JLabel("W");
            labelw.setBounds(8, -32, 192, 192);
            JLabel labelx = new JLabel("X");
            labelx.setBounds(8, -16, 192, 192);

            JCheckBox orjcb = new JCheckBox("", true);
            JCheckBox owjcb = new JCheckBox("", true);
            JCheckBox oxjcb = new JCheckBox("", true);
            JCheckBox grjcb = new JCheckBox("", false);
            JCheckBox gwjcb = new JCheckBox("", false);
            JCheckBox gxjcb = new JCheckBox("", false);
            JCheckBox urjcb = new JCheckBox("", false);
            JCheckBox uwjcb = new JCheckBox("", false);
            JCheckBox uxjcb = new JCheckBox("", false);
            frame.setSize(256, 256);
            orjcb.setBounds(32, 32, 22, 22);
            owjcb.setBounds(32, 52, 22, 22);
            oxjcb.setBounds(32, 70, 22, 22);
            grjcb.setBounds(56, 32, 22, 22);
            gwjcb.setBounds(56, 52, 22, 22);
            gxjcb.setBounds(56, 70, 22, 22);
            urjcb.setBounds(80, 32, 22, 22);
            uwjcb.setBounds(80, 52, 22, 22);
            uxjcb.setBounds(80, 70, 22, 22);
            orjcb.addItemListener(ev -> {
                mode.getOwnerPermissions().setReadable(orjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            owjcb.addItemListener(ev -> {
                mode.getOwnerPermissions().setWriteable(owjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            oxjcb.addItemListener(ev -> {
                mode.getOwnerPermissions().setExecutable(oxjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            grjcb.addItemListener(ev -> {
                mode.getGroupPermissions().setReadable(grjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            gwjcb.addItemListener(ev -> {
                mode.getGroupPermissions().setWriteable(gwjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            gxjcb.addItemListener(ev -> {
                mode.getGroupPermissions().setExecutable(gxjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            urjcb.addItemListener(ev -> {
                mode.getUsersPermissions().setReadable(urjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            uwjcb.addItemListener(ev -> {
                mode.getUsersPermissions().setWriteable(uwjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            uxjcb.addItemListener(ev -> {
                mode.getUsersPermissions().setExecutable(uxjcb.isSelected());
                label.setText(new Calculator(mode).toString());
            });
            JCheckBox[] jcbs = {orjcb, owjcb, oxjcb, grjcb, gwjcb, gxjcb, urjcb, uwjcb, uxjcb};
            frame.getContentPane().add(label);
            frame.getContentPane().add(label2);
            frame.getContentPane().add(labelr);
            frame.getContentPane().add(labelw);
            frame.getContentPane().add(labelx);
            frame.getContentPane().add(orjcb);
            frame.getContentPane().add(owjcb);
            frame.getContentPane().add(oxjcb);
            frame.getContentPane().add(grjcb);
            frame.getContentPane().add(gwjcb);
            frame.getContentPane().add(gxjcb);
            frame.getContentPane().add(urjcb);
            frame.getContentPane().add(uwjcb);
            frame.getContentPane().add(uxjcb);
            frame.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {

                }

                @Override
                public void windowClosing(WindowEvent e) {
                    int a = JOptionPane.showConfirmDialog(frame, "Wanna exit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    switch (a) {
                        case JOptionPane.YES_OPTION:
                            frame.setVisible(false);
                            frame.dispose();
                            System.exit(0);
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                        case JOptionPane.CLOSED_OPTION:
                            break;
                        default:
                            System.out.printf("Invalid answer: %d", a);
                    }
                }

                @Override
                public void windowClosed(WindowEvent e) {

                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }
}
