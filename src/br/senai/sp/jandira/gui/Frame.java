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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class Frame extends JFrame {

	String dias [] = {"domingo", "segunda", "terça", "quarta","quinta","sexta"};
	
	private JPanel contentPane;
	private JTextField textField_Matricula;
	private JTextField textField_Nome;
	private int posicao = 0;
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_Matricula = new JTextField();
		textField_Matricula.setBounds(92, 88, 114, 20);
		contentPane.add(textField_Matricula);
		textField_Matricula.setColumns(10);
		
		JLabel lblNewLabel_Matricula = new JLabel("Matricula:");
		lblNewLabel_Matricula.setBounds(20, 91, 62, 14);
		contentPane.add(lblNewLabel_Matricula);
		
		JLabel lblNewLabel_Nome = new JLabel("Nome:");
		lblNewLabel_Nome.setBounds(20, 128, 50, 14);
		contentPane.add(lblNewLabel_Nome);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(92, 119, 172, 20);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblNewLabel_Periodo = new JLabel("Periodo:");
		lblNewLabel_Periodo.setBounds(20, 178, 50, 14);
		contentPane.add(lblNewLabel_Periodo);
		
		JButton btnNewButton_SalvarAluno = new JButton("Salvar Aluno");
		btnNewButton_SalvarAluno.setBounds(20, 222, 186, 23);
		contentPane.add(btnNewButton_SalvarAluno);
		
		
		AlunoRepository turma =new AlunoRepository();
						
				
		btnNewButton_SalvarAluno.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno ();
				aluno.setMatricula(textField_Matricula.getText());
				aluno.setNome(textField_Nome.getName());
				
				turma.gravar(aluno, posicao);
				posicao++;
			}
		});
		
		
		
		JScrollPane scrollPane_ListaAluno = new JScrollPane();
		scrollPane_ListaAluno.setBounds(276, 72, 186, 208);
		contentPane.add(scrollPane_ListaAluno);
		
		JList list_ListaAluno = new JList();
		DefaultListModel<String> listaModel = new DefaultListModel<String>();
		scrollPane_ListaAluno.setViewportView(list_ListaAluno);
		
		
		JLabel lblNewLabel_CadastroAluno = new JLabel("Cadastro de Aluno");
		lblNewLabel_CadastroAluno.setBounds(175, 11, 134, 36);
		contentPane.add(lblNewLabel_CadastroAluno);
		
		
		JComboBox comboBox_Periodo = new JComboBox();
		DefaultComboBoxModel<String> modelPeriodo = new DefaultComboBoxModel<String>(dias); 
		
		for(Periodo p : Periodo.values()) {
			modelPeriodo.addElement(p.getDescricao());
		}
		
		comboBox_Periodo.setModel(modelPeriodo);
		comboBox_Periodo.setBounds(94, 172, 112, 26);
		contentPane.add(comboBox_Periodo);
		
		
		JLabel lblNewLabel_ListaAluno = new JLabel("Lista Aluno:");
		lblNewLabel_ListaAluno.setBounds(276, 59, 112, 14);
		contentPane.add(lblNewLabel_ListaAluno);
		
		contentPane.setVisible(true);
		
	
		
		
	}
}
