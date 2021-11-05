package br.senai.sp.jandira.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import br.senai.sp.jandira.model.Periodo;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Matricula;
	private JTextField textField_Nome;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_Matricula = new JTextField();
		textField_Matricula.setBounds(76, 88, 114, 20);
		contentPane.add(textField_Matricula);
		textField_Matricula.setColumns(10);
		
		JLabel lblNewLabel_Matricula = new JLabel("Matricula");
		lblNewLabel_Matricula.setBounds(20, 91, 50, 14);
		contentPane.add(lblNewLabel_Matricula);
		
		JLabel lblNewLabel_Nome = new JLabel("Nome:");
		lblNewLabel_Nome.setBounds(20, 128, 50, 14);
		contentPane.add(lblNewLabel_Nome);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(76, 125, 172, 20);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblNewLabel_Periodo = new JLabel("Periodo");
		lblNewLabel_Periodo.setBounds(20, 178, 50, 14);
		contentPane.add(lblNewLabel_Periodo);
		
		JButton btnNewButton_SalvarAluno = new JButton("Salvar Aluno");
		btnNewButton_SalvarAluno.setBounds(20, 222, 186, 23);
		contentPane.add(btnNewButton_SalvarAluno);
		
		JScrollPane scrollPane_ListaAluno = new JScrollPane();
		scrollPane_ListaAluno.setBounds(276, 72, 186, 208);
		contentPane.add(scrollPane_ListaAluno);
		
		JList list_ListaAluno = new JList();
		scrollPane_ListaAluno.setViewportView(list_ListaAluno);
		
		JLabel lblNewLabel_CadastroAluno = new JLabel("Cadastro de Aluno");
		lblNewLabel_CadastroAluno.setBounds(175, 11, 102, 36);
		contentPane.add(lblNewLabel_CadastroAluno);
		
		JComboBox comboBox_Periodo = new JComboBox();
		comboBox_Periodo.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboBox_Periodo.setBounds(76, 172, 112, 26);
		contentPane.add(comboBox_Periodo);
		
		JLabel lblNewLabel_ListaAluno = new JLabel("Lista Aluno");
		lblNewLabel_ListaAluno.setBounds(276, 59, 112, 14);
		contentPane.add(lblNewLabel_ListaAluno);
		
		contentPane.setVisible(true);
		
	
		
		
	}
}
