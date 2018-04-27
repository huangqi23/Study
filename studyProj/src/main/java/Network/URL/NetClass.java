package Network.URL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class NetClass extends Authenticator{
    private JDialog passwordDialog;
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton okbutton = new JButton("ok");
    private JButton cancelbutton = new JButton("Cancel");
    private JLabel mainlabel = new JLabel("hello");

    public NetClass() {
        this("" ,new JFrame());
    }
    public NetClass(String s ) {
        this(s, new JFrame());
    }

    public NetClass(JFrame jFrame) {
        this("",jFrame);
    }

    public NetClass(String username, JFrame jFrame) {
        this.passwordDialog = new JDialog(jFrame,true);
        Container pane = passwordDialog.getContentPane();
        pane.setLayout(new GridLayout(4,1));
        JLabel userlabel = new JLabel("username:");
        JLabel passwordlabel = new JLabel("password");
        pane.add(mainlabel);

        JPanel p2 = new JPanel();
        p2.add(userlabel);
        p2.add(usernameField);
        usernameField.setText(username);
        pane.add(p2);

        JPanel p3 = new JPanel();
        p3.add(passwordlabel);
        p3.add(passwordField);
        pane.add(p3);

        JPanel p4 = new JPanel();
        p4.add(okbutton);
        p4.add(cancelbutton);
        pane.add(p4);
        passwordDialog.pack();
    }
    private void show(){
        String prompt = this.getRequestingPrompt();
        passwordDialog.pack();
        passwordDialog.setVisible(true);
    }

    PasswordAuthentication response = null;

    class okresponse implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            char[] password = passwordField.getPassword();
            String username = usernameField.getText();
            response = new PasswordAuthentication(username, password);
        }

    }

    class cancelresponse implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    public PasswordAuthentication getResponse() {
        this.show();
        return this.response;
    }

    public void frameshow(){
        this.show();
    }

}
