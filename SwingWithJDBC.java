import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class SwingWithJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MyFram mf= new MyFram();
         mf.setVisible(true);
         mf.setTitle("Student");
         mf.setSize(400,400);
         mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mf.setLocation(200,200);
	}

}


class MyFram extends JFrame implements ActionListener{
	JLabel nameLabel, branchLabel, rollLabel;
	JTextField nameField, branchField,rollField;
	JButton submit;
	MyFram()
	{
		nameLabel= new JLabel("NAME");
		branchLabel= new JLabel("BRANCH");
		rollLabel= new JLabel("ROLL NO");
		
		nameField= new JTextField(10);
		branchField= new JTextField(10);
		rollField= new JTextField(10);
		submit= new JButton("SUBMIT");
		setLayout(null);
		add(nameLabel);
		nameLabel.setBounds(50,40,60,50);
		add(nameField);
		nameField.setBounds(150,40,100,35);
		add(rollLabel);
		rollLabel.setBounds(50,100,60,50);
		add(rollField);
		rollField.setBounds(150,100,100,35);
		add(branchLabel);
		branchLabel.setBounds(50,150,60,50);
		add(branchField);
		branchField.setBounds(150,150,100,35);
		add(submit);
		submit.setBounds(100,200,100,30);
		submit.addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submit)
		{
		    try
		    {
		    		Class.forName("com.mysql.cj.jdbc.Driver");
		    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest\",\"root\",\"password");
		    		PreparedStatement stat=con.prepareStatement("insert into student values(?,?,?)");
		    		String name=nameField.getText();
		    		String branch=branchField.getText();
		    		String roll=rollField.getText();
		    		int rol=Integer.parseInt(roll);
		    		stat.setInt(1, rol);
		    		stat.setString(2,name);
		    		stat.setString(3, branch);
		    		int i=stat.executeUpdate();
		    		JOptionPane.showMessageDialog(this,"Data Saved Successfully");
		    		rollField.setText("");
		    		nameField.setText("");
		    		branchField.setText("");
		    		
		    }
		    catch(ClassNotFoundException ex)
		    {
		    	JOptionPane.showMessageDialog(this, "Class not found");
		    	
		    }
		    catch(SQLException ed)
			{
				JOptionPane.showMessageDialog(this,"DataBase Error");	
			}

		}
	}
}
