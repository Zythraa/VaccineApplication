import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.awt.event.*;
import java.util.Queue;
import java.util.Stack;

public class Complete extends JFrame implements ActionListener{

	private Container cont;
	private JList<String> list;
	private Queue<Citizen> qCenter1,qCenter2, qCenter3;
	private Stack<Citizen> stCenter1, stCenter2, stCenter3;
	private LinkedList<Citizen> completedList;
	private JButton btnBack;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public Complete(Stack<Citizen> stCenter1, Stack<Citizen> stCenter2, Stack<Citizen> stCenter3, Queue<Citizen> qCenter1, Queue<Citizen> qCenter2, Queue<Citizen> qCenter3, LinkedList<Citizen> completedList) {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().setBackground(new Color(240, 230, 140));
		setBackground(new Color(245, 222, 179));
		
		cont = getContentPane();
		cont.setLayout(null);

		this.completedList = completedList;

		this.stCenter1 = stCenter1;
		this.stCenter2 = stCenter2;
		this.stCenter3 = stCenter3;

		this.qCenter1 = qCenter1;
		this.qCenter2 = qCenter2;
		this.qCenter3 = qCenter3;

		String[] List= new String[completedList.size()];
		for (int i = 0; i < List.length; i++) {
			List[i] = completedList.get(i).getName();
		}
		
		list = new JList(List);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(5);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < completedList.size(); i++) {
					if(completedList.get(i).getName().equalsIgnoreCase(list.getSelectedValue()))
						JOptionPane.showMessageDialog(null, completedList.get(i), "Certificate", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		list.setBounds(26, 41, 132, 58);
		
		JLabel lblNewLabel = new JLabel("Complete vaccination.");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(124, 94, 324, 33);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		cont.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(105, 150, 343, 119);
		panel.add(new JScrollPane(list));
		cont.add(panel);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBackground(new Color(0, 128, 128));
		btnBack.setForeground(new Color(0, 0, 205));
		btnBack.setBounds(201, 354, 152, 33);
		btnBack.addActionListener(this);
		cont.add(btnBack);
		
		lblNewLabel_1 = new JLabel("Note: Please click the name for vaccine certificate.");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1.setBounds(105, 269, 436, 33);
		getContentPane().add(lblNewLabel_1);
		
		setBounds(100, 100, 573, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnBack){
			Vaccination frame = new Vaccination(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3, completedList);
			frame.setVisible(true);
			dispose();
		}
	}
}
