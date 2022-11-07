import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;



public class Form extends JFrame implements ActionListener{

	private Container cont;
	private JTextField txtName, txtAge, txtState, txtIc, txt1stdose, txt2nddose, txtCertificate, txtTypeofvaccine;
	private JButton btnSubmit, btnBack;
	private String option;
    private LinkedList<Citizen> CitizenList; 
    private Citizen person;

	/**
	 * Create the frame.
	 */
	public Form(String option, LinkedList<Citizen> citizen, Citizen person) {
		super("Input Form");
		getContentPane().setBackground(new Color(255, 222, 173));
		getContentPane().setForeground(new Color(0, 128, 128));

		this.option = option;
        this.CitizenList = citizen;
        this.person = person;

		cont = getContentPane();
        cont.setLayout(null);
        
        JLabel lblName = new JLabel("Name :");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblName.setBounds(139, 52, 110, 38);
        cont.add(lblName);
        
        JLabel lblState = new JLabel("State :");
        lblState.setBounds(139, 141, 85, 30);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 20));
        cont.add(lblState);
        
        JLabel lblIc = new JLabel("IC :");
        lblIc.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblIc.setBounds(173, 101, 85, 30);
        cont.add(lblIc);
        
        JLabel lblAge = new JLabel("Age :");
        lblAge.setBounds(149, 190, 85, 30);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
        cont.add(lblAge);
        
        JLabel lblTypeofvaccine = new JLabel("Type of vaccine:");
        lblTypeofvaccine.setBounds(44, 245, 199, 38);
        lblTypeofvaccine.setFont(new Font("Tahoma", Font.BOLD, 20));
        cont.add(lblTypeofvaccine);
        
        JLabel lbl1stdose = new JLabel("1st dose status :");
        lbl1stdose.setBounds(43, 295, 181, 38);
		lbl1stdose.setFont(new Font("Tahoma", Font.BOLD, 20));
        cont.add(lbl1stdose);
        
        JLabel lbl2nddose = new JLabel("2nd dose status :");
        lbl2nddose.setBounds(32, 343, 239, 38);
		lbl2nddose.setFont(new Font("Tahoma", Font.BOLD, 20));
        cont.add(lbl2nddose);
        
        JLabel lblCertificate = new JLabel("Certificate :");
        lblCertificate.setBounds(87, 391, 199, 26);
		lblCertificate.setFont(new Font("Tahoma", Font.BOLD, 20));
        cont.add(lblCertificate);
        
        txtName = new JTextField();
        txtName.setBounds(287, 56, 276, 30);
        cont.add(txtName);
        txtName.setColumns(10);
        
        txtIc = new JTextField();
        txtIc.setColumns(10);
        txtIc.setBounds(287, 101, 276, 29);
        cont.add(txtIc);
        
        txtState = new JTextField();
        txtState.setColumns(10);
        txtState.setBounds(287, 144, 276, 26);
        cont.add(txtState);
        
        txtAge = new JTextField();
        txtAge.setColumns(10);
        txtAge.setBounds(287, 194, 276, 26);
        cont.add(txtAge);
        
        txtTypeofvaccine = new JTextField();
        txtTypeofvaccine.setColumns(10);
        txtTypeofvaccine.setBounds(287, 252, 276, 26);
        cont.add(txtTypeofvaccine);
        
        txt1stdose = new JTextField();
        txt1stdose.setColumns(10);
        txt1stdose.setBounds(287, 302, 276, 26);
        cont.add(txt1stdose);
        
        txt2nddose = new JTextField();
        txt2nddose.setColumns(10);
        txt2nddose.setBounds(287, 350, 276, 26);
        cont.add(txt2nddose);
        
        txtCertificate = new JTextField();
        txtCertificate.setColumns(10);
        txtCertificate.setBounds(287, 391, 276, 27);
        cont.add(txtCertificate);
        
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(656, 475, 85, 21);
		btnSubmit.addActionListener(this);
        cont.add(btnSubmit);
        
        btnBack = new JButton("BACK");
        btnBack.setBounds(561, 475, 85, 21);
        btnBack.addActionListener(this);
        cont.add(btnBack);

        if(option.equalsIgnoreCase("UPDATE")){ 
            txtName.setText(person.getName());
            txtIc.setText(person.getIc());
            txtIc.setEditable(false);
            txtState.setText(person.getState());
            txtAge.setText(person.getAge()+"");
            txt1stdose.setText(person.getStat1stDose());
            txt2nddose.setText(person.getStat2ndDose());
            txtCertificate.setText(person.getCertificate());
            txtTypeofvaccine.setText(person.getTypeofvaccine());
        }
        
		setBounds(200, 200, 450, 300);
        setSize(782,563);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnSubmit){

            JTextField field[] = {txtName, txtAge, txtState, txtIc, txtTypeofvaccine};
            boolean empty = false;
            for (int i = 0; i < field.length; i++) {
                if(field[i].getText().equalsIgnoreCase("")){
                    empty = true;
                    break;
                }
            }
            if(empty){
                JOptionPane.showMessageDialog(null, "Please dont leave input field empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(Integer.parseInt(txtAge.getText()) < 18){
                JOptionPane.showMessageDialog(null, "Age is not match", "Age", JOptionPane.ERROR_MESSAGE);
                return;
            }

			if(option.equalsIgnoreCase("ADD")){
                String dose1 = txt1stdose.getText().equalsIgnoreCase("") ? null : txt1stdose.getText();
                String dose2 = txt2nddose.getText().equalsIgnoreCase("") ? null : txt2nddose.getText();
                String Certificicate = txtCertificate.getText().equalsIgnoreCase("") ? null : txtCertificate.getText();

                Citizen citizen = new Citizen(txtName.getText(), txtIc.getText(), txtState.getText(), Integer.parseInt(txtAge.getText()), txtTypeofvaccine.getText(), dose1, dose2, Certificicate);
                
                CitizenList.add(citizen);

				TestCitizen frame = new TestCitizen(CitizenList);
				frame.setVisible(true);
				dispose();
			}
            else if(option.equalsIgnoreCase("UPDATE")){
                for (int i = 0; i < CitizenList.size(); i++) {
                    if(CitizenList.get(i).getIc() == person.getIc()){
                        CitizenList.set(i, person);
                    }
                }
                
				TestCitizen frame = new TestCitizen(CitizenList);
				frame.setVisible(true);
				dispose();
			}
		}
        else if(e.getSource() == btnBack){
            TestCitizen frame = new TestCitizen(CitizenList);
            frame.setVisible(true);
            dispose();
        }
	}
}