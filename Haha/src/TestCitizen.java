import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.StringTokenizer;

public class TestCitizen extends JFrame implements ActionListener{

	private Container cont;
	private JButton btnAdd, btnRemove, btnUpdate, btnContinue;
	private JLabel lblLoader;
	private LinkedList<Citizen> CitizenList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		LinkedList<Citizen> citizenlist = new LinkedList<>();
		try {
            BufferedReader br = new BufferedReader(new FileReader("Citizen.txt"));
            Citizen citizen;

            String line = br.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                String name = st.hasMoreTokens() ? st.nextToken() : null;
                String ic = st.hasMoreTokens() ? st.nextToken() : null;
                String state = st.hasMoreTokens() ? st.nextToken() : null;
                int age = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                String typeofvaccine = st.hasMoreTokens() ? st.nextToken() : null;
                String stat1stDose = st.hasMoreTokens() ? st.nextToken() : null;
                String stat2ndDose = st.hasMoreTokens() ? st.nextToken() : null;
                String certificate = st.hasMoreTokens() ? st.nextToken() : null;
				
                citizen = new Citizen(name, ic, state, age, typeofvaccine, stat1stDose, stat2ndDose, certificate);
                citizenlist.add(citizen);

                line = br.readLine();
            }

            br.close();
        } catch (EOFException ex) {
			System.out.println("End of file error");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("Wrong input!!!");
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		TestCitizen frame = new TestCitizen(citizenlist);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public TestCitizen(LinkedList<Citizen> CitizenList) {
		super("Citizen");
		getContentPane().setBackground(new Color(255, 218, 185));

		this.CitizenList = CitizenList;

		cont = getContentPane();
        cont.setLayout(null);
        
        lblLoader = new JLabel(CitizenList.size()+" Citizen have loaded");
        lblLoader.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblLoader.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoader.setBounds(245, 152, 295, 31);
        cont.add(lblLoader);
        
        btnAdd = new JButton("Add");
        btnAdd.setForeground(new Color(0, 0, 0));
        btnAdd.setBackground(new Color(224, 255, 255));
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdd.setBounds(124, 231, 152, 46);
		btnAdd.addActionListener(this);
        cont.add(btnAdd);
        
        btnRemove = new JButton("Remove");
        btnRemove.setBackground(new Color(224, 255, 255));
        btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRemove.setBounds(329, 231, 140, 46);
		btnRemove.addActionListener(this);
        cont.add(btnRemove);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(224, 255, 255));
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnUpdate.setBounds(541, 231, 140, 40);
		btnUpdate.addActionListener(this);
        cont.add(btnUpdate);
        
        btnContinue = new JButton("Continue");
        btnContinue.setForeground(new Color(248, 248, 255));
        btnContinue.setBackground(new Color(0, 0, 128));
        btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnContinue.setBounds(329, 317, 140, 46);
		btnContinue.addActionListener(this);
        cont.add(btnContinue);
        
        JLabel lblNewLabel = new JLabel("VACCINATION STATUS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(263, 46, 308, 40);
        getContentPane().add(lblNewLabel);

		setBounds(200, 200, 450, 300);
        setSize(794,451);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			Form frame = new Form("ADD", CitizenList, new Citizen());
			frame.setVisible(true);
			dispose();
			return;
		}
		else if(e.getSource() == btnContinue){
			Stack<Citizen> stCenter1, stCenter2, stCenter3;
			Queue<Citizen> qCenter1, qCenter2, qCenter3;
			
			stCenter1 = new Stack<>();
			stCenter2 = new Stack<>();
			stCenter3 = new Stack<>();
			
			qCenter1 = new LinkedList<>();
			qCenter2 = new LinkedList<>();
			qCenter3 = new LinkedList<>();

			System.out.println(CitizenList.getLast());
			LinkedList<Citizen> completedList =  new LinkedList<>();
			
			int size = CitizenList.size();
			for (int i = 0; i < size; i++) {
				Citizen person = CitizenList.removeLast();
				if(person.getAge() >= 18 & person.getAge() <= 30){
					if(person.getStat2ndDose() != null){
						completedList.add(person);
						continue;
					}
					else if(person.getStat1stDose() != null){
						qCenter1.add(person);
						continue;
					}
					else{
						stCenter1.add(person);
						continue;
					}
				}
				else if(person.getAge() >= 31 & person.getAge() <=49){
					if(person.getStat2ndDose() != null){
						completedList.add(person);
						continue;
					}
					else if(person.getStat1stDose() != null){
						qCenter2.add(person);
						continue;
					}
					else{
						stCenter2.add(person);
						continue;
					}
				}
				else if(person.getAge() >= 50){
					if(person.getStat2ndDose() != null){
						completedList.add(person);
						continue;
					}
					else if(person.getStat1stDose() != null){
						qCenter3.add(person);
						continue;
					}
					else{
						stCenter3.add(person);
						continue;
					}
				}
			}

			Vaccination frame = new Vaccination(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3,completedList);
			frame.setVisible(true);
			dispose();
			return;
		}

		String ic = JOptionPane.showInputDialog(null, "Insert IC", "IC", JOptionPane.QUESTION_MESSAGE);
		int Person_num = -1;
		for (int i = 0; i < CitizenList.size(); i++) {
			if(CitizenList.get(i).getIc().equalsIgnoreCase(ic)) {
				Person_num = i;
				break;
			}
		}
		if(ic == null)
			return;

		if(Person_num == -1){
			JOptionPane.showMessageDialog(null, "Citizen with " + ic + " not existed","Not Found", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(e.getSource() == btnRemove){
			int reply = JOptionPane.showConfirmDialog(null, CitizenList.get(Person_num), "Are you sure to delete this citizen", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				CitizenList.remove(Person_num);
			}
		}
		else if (e.getSource() == btnUpdate) {
			Form frame = new Form("UPDATE", CitizenList, CitizenList.get(Person_num));
			frame.setVisible(true);
			dispose();
		}
	}
}

