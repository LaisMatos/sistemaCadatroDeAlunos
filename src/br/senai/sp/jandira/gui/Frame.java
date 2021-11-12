package br.senai.sp.jandira.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Matricula;
	private JTextField textField_Nome;
	private int posicao = 0;
	
	private Periodo obterPeriodo (int periodoSelecionado) {
		
		if (periodoSelecionado ==0) {
			return Periodo.MANHA;
		}else if (periodoSelecionado ==1) {
			return Periodo.TARDE;
		}else {
			return Periodo.NOITE;
		}
	}
	
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
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(20, 91, 62, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 128, 50, 14);
		contentPane.add(lblNome);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(92, 119, 172, 20);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setBounds(20, 178, 50, 14);
		contentPane.add(lblPeriodo);
		
		//JButton 
		JButton btnSalvarAluno = new JButton("Salvar Aluno");
		btnSalvarAluno.setBounds(20, 222, 186, 23);
		contentPane.add(btnSalvarAluno);
			
				
		JScrollPane scrollPaneAluno = new JScrollPane();
		scrollPaneAluno.setBounds(276, 72, 186, 208);
		contentPane.add(scrollPaneAluno);
		
		// JList		
		JList listaAluno = new JList();
		DefaultListModel<String> listaModel = new DefaultListModel<String>();
		listaAluno.setModel(listaModel);
		scrollPaneAluno.setViewportView(listaAluno);
				
		
		JLabel lblCadastroAluno = new JLabel("Cadastro de Aluno");
		lblCadastroAluno.setBounds(175, 11, 134, 36);
		contentPane.add(lblCadastroAluno);
		
		//JComboBox
		JComboBox comboPeriodo = new JComboBox();
		DefaultComboBoxModel<String> modelPeriodo = new DefaultComboBoxModel<String>(); 
		comboPeriodo.setModel(modelPeriodo);
		
		for(Periodo p : Periodo.values()) {
			modelPeriodo.addElement(p.getDescricao());
		}
				
		
		comboPeriodo.setBounds(94, 172, 112, 26);
		contentPane.add(comboPeriodo);
		
		
		JLabel lblListaAluno = new JLabel("Lista Aluno:");
		lblListaAluno.setBounds(276, 59, 112, 14);
		contentPane.add(lblListaAluno);
		
		
		AlunoRepository turma = new AlunoRepository(3);
		
		btnSalvarAluno.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					
				Aluno aluno = new Aluno ();
				aluno.setMatricula(textField_Matricula.getText());
				aluno.setNome(textField_Nome.getText());
				
				//Definir o horário que o aluno estuda
				aluno.setPeriodo(obterPeriodo(comboPeriodo.getSelectedIndex()));
				
				//grava aluno e posição na turma
				turma.gravar(aluno, posicao);
				
				//adicionar o nome do aluno ao model da lista
				listaModel.addElement(aluno.getNome());
				
				posicao++;
				
				if (posicao==turma.getTamanho()) {
					btnSalvarAluno.setEnabled(false);
					JOptionPane.showConfirmDialog(null,"A turma encheu!");
				}
				contentPane.setVisible(true);
			}
		});
		
			//achar o erro 
			listaAluno.addListSelectionListener(new ListSelectionListener()){
			
		
			public void valueChanged(ListSelectionEvent e) {
				
				Aluno aluno= turma.listarAluno(listaAluno.getSelectedIndex());
				textField_Matricula.setText(aluno.getMatricula());
				textField_Nome.setText(aluno.getNome());
				
				comboPeriodo.setSelectedIndex(aluno.getPeriodo().ordinal());
			}
		}
	
	}
}
