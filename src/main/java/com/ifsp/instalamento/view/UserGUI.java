package com.ifsp.instalamento.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ifsp.instalamento.estrutura.util.VariaveisProjeto;
import com.ifsp.instalamento.model.models.User;
import com.ifsp.instalamento.model.service.UserService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserGUI extends JFrame{
private static final long serialVersionUID = -6617720784946875271L;
	
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JRadioButton rdbtnAtivo;
	private JRadioButton rdbtnAdmin;
	private JButton btnSair;
	private JLabel lblNewLabel;
	private JTextField textFieldCodigo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UserGUI(){
		setTitle("Cadastro de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		
		passwordFieldSenha = new JPasswordField();
		
		rdbtnAtivo = new JRadioButton("Ativo");
		
		rdbtnAdmin = new JRadioButton("Admin");
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirUsuario();
			}
		});
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
			}
	
		});
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharUsuario();
			}
		});
		
		lblNewLabel = new JLabel("Código:");
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarUsuario();
			}

			
		});
		textFieldCodigo.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(157)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblSenha)
						.addComponent(lblEmail)
						.addComponent(lblNome))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnIncluir)
							.addGap(18)
							.addComponent(btnAlterar)
							.addGap(18)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnSair))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnAtivo)
							.addGap(36)
							.addComponent(rdbtnAdmin))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(passwordFieldSenha)
							.addComponent(textFieldEmail)
							.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSenha)
						.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAtivo)
						.addComponent(rdbtnAdmin))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void excluirUsuario() {
		User user = pegarDadosUser();
		
		UserService userService = new UserService();
		
		userService.delete(user);
		
	}

	protected void incluirUsuario() {
		
		User usuario = pegarDadosUser();

		UserService userService = new UserService();
		
		userService.save(usuario);
	}
	
	protected void alterarUsuario() {
		User usuario = pegarDadosUser();
	    
	    UserService userService = new UserService();
		
	    userService.update(usuario);
	}

	private void fecharUsuario() {
		dispose();
	}
	
	private void buscarUsuario() {
		User user = new User();
		
		if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
			textFieldCodigo.requestFocus();
			return;
		}
		
		Integer id = Integer.valueOf(textFieldCodigo.getText());

		UserService usuarioService = new UserService();
		
		user = usuarioService.findById(id);
		
		textFieldNome.setText(user.getUsername());
		textFieldEmail.setText(user.getEmail());
		passwordFieldSenha.setText(user.getPassword());
		
	}

	@SuppressWarnings("deprecation")
	public User pegarDadosUser() {
		
		User user = new User();
		if (!"".equals(textFieldCodigo.getText())){
			user.setId( Integer.valueOf(textFieldCodigo.getText()));
		}
		
		user.setUsername(textFieldNome.getText());
		user.setEmail(textFieldEmail.getText());
		user.setPassword(passwordFieldSenha.getText());
		
		
		return user;
	}
}
