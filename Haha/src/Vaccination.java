import java.awt.*;
import javax.swing.*;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.*;

public class Vaccination extends JFrame implements ActionListener{

	private Container cont;
	private JButton btn1stdose, btn2nddose, btnComplete, btnBack;
	private Queue<Citizen> qCenter1,qCenter2, qCenter3;
	private Stack<Citizen> stCenter1, stCenter2, stCenter3;
	private LinkedList<Citizen> completedList;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public Vaccination(Stack<Citizen> stCenter1, Stack<Citizen> stCenter2, Stack<Citizen> stCenter3, Queue<Citizen> qCenter1, Queue<Citizen> qCenter2, Queue<Citizen> qCenter3, LinkedList<Citizen> completedList) {
		super("Vaccination");
		getContentPane().setBackground(new Color(255, 228, 181));
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 10));

		this.completedList = completedList;

		this.stCenter1 = stCenter1;
		this.stCenter2 = stCenter2;
		this.stCenter3 = stCenter3;

		this.qCenter1 = qCenter1;
		this.qCenter2 = qCenter2;
		this.qCenter3 = qCenter3;

		cont = getContentPane();
        cont.setLayout(null);
        
        btn1stdose = new JButton("1st Dose");
        btn1stdose.setBackground(new Color(102, 205, 170));
        btn1stdose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn1stdose.setBounds(183, 168, 188, 40);
		btn1stdose.addActionListener(this);
		cont.add(btn1stdose);
        
        btn2nddose = new JButton("2nd Dose");
        btn2nddose.setBackground(new Color(102, 205, 170));
        btn2nddose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn2nddose.setBounds(183, 229, 188, 40);
		btn2nddose.addActionListener(this);
		cont.add(btn2nddose);
        
        btnComplete = new JButton("Completed");
        btnComplete.setForeground(new Color(248, 248, 255));
        btnComplete.setBackground(new Color(0, 0, 205));
        btnComplete.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnComplete.setBounds(349, 306, 195, 40);
		btnComplete.addActionListener(this);
		cont.add(btnComplete);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(32, 306, 188, 40);
		btnBack.addActionListener(this);
		cont.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Continue?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 62, 319, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		cont.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Note: Please continue with 1st dose.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(127, 125, 340, 31);
		getContentPane().add(lblNewLabel_1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 418);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btn1stdose){
			Vaccine frame = new Vaccine(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList, "1stdose");
			frame.setVisible(true);
			dispose();
		}
		else if(e.getSource() == btn2nddose){
			Vaccine frame = new Vaccine(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList, "2nddose");
			frame.setVisible(true);
			dispose();
		}

		else if(e.getSource() == btnComplete){
			Complete frame = new Complete(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList);
			frame.setVisible(true);
			dispose();
		}

		else if(e.getSource() == btnBack){
			LinkedList<Citizen> CitizenList = new LinkedList<>();
			while(!stCenter1.isEmpty()){
				CitizenList.add(stCenter1.pop());
			}while(!stCenter2.isEmpty()){
				CitizenList.add(stCenter2.pop());
			}while(!stCenter3.isEmpty()){
				CitizenList.add(stCenter3.pop());
			}while(!qCenter1.isEmpty()){
				CitizenList.add(qCenter1.remove());
			}while(!qCenter2.isEmpty()){
				CitizenList.add(qCenter2.remove());
			}while(!qCenter3.isEmpty()){
				CitizenList.add(qCenter3.remove());
			}while(!completedList.isEmpty()){
				CitizenList.add(completedList.pop());
			}
			
			TestCitizen frame = new TestCitizen(CitizenList);
			frame.setVisible(true);
			dispose();
		}
	}
}