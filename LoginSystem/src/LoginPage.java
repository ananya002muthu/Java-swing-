import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LoginPage implements ActionListener{
	
	JFrame frame=new JFrame();
    JButton loginButton	= new JButton("Login");
    JButton resetButton	= new JButton("Reset");
    JTextField userIDfield= new JTextField ();
    JPasswordField userPasswordfield= new JPasswordField ();
    JLabel userIDLabel=new JLabel("userID:");
    JLabel userPasswordLabel=new JLabel("password:");
    JLabel messageLabel=new JLabel();

	HashMap<String,String> logininfo =new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginforOriginal){
		
		logininfo=loginforOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDfield.setBounds(125, 100, 200, 25);
		userPasswordfield.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDfield);
		frame.add(userPasswordfield);
		frame.add(loginButton);
		frame.add(resetButton);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== resetButton) {
			userIDfield.setText("");
			userPasswordfield.setText("");
		}
		
		if(e.getSource()== loginButton) {
			
			String userID=userIDfield.getText();
			String password=String.valueOf(userPasswordfield.getPassword());
			
		   	if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)){
					
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login Successsful");
					frame.dispose();
					WelcomPage welcomepage= new WelcomPage(userID);
				}
				else
				{
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}
			}
		   	else {

				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
		   	}
		}
		
		
	}

}
