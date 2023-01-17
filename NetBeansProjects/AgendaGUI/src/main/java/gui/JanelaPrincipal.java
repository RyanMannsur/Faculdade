package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import principalRyan.Agenda;


import principalRyan.Contato;

public class JanelaPrincipal extends JFrame 
						implements ActionListener{
	
	private JPanel panelTitulos;
	private JPanel panelTexto;
	private JPanel panelBotoes;
	private JPanel panelBanner;
	
	private JLabel banner;
	private JLabel lnome;
	private JLabel lendereco;
	private JLabel ltelefone;
	private JLabel lemail;
	
	private JTextField nome;
	private JTextField endereco;
	private JTextField telefone;
	private JTextField email;
	
	private JButton botaoLimpar;
	private JButton botaoInserir;
	private JButton botaoConsultar;
	private JButton botaoGravar;
	
	private Agenda agenda;
	private Contato contato;
	
	public JanelaPrincipal() {
		super("Agenda de contatos");
		instanciaComponentes();
		defineLayoutPanels();
		adicionaComponentes();
		registraHandler();
	}
	
	public void instanciaComponentes() {
		agenda = new Agenda();
		
		panelTitulos = new JPanel();
		panelTexto = new JPanel();
		panelBotoes = new JPanel();
		panelBanner = new JPanel();
		
		banner = new JLabel("Contatos");
		
		nome = new JTextField();
		endereco = new JTextField();
		telefone = new JTextField();
		email = new JTextField();	
		
		lnome = new JLabel("Nome :");
		lendereco = new JLabel("Endereço: ");
		ltelefone = new JLabel("Telefone: ");
		lemail = new JLabel("Email: ");
		
		botaoLimpar = new JButton(" Limpar ");
		botaoInserir = new JButton(" Inserir ");
		botaoConsultar = new JButton(" Consultar ");
		botaoGravar = new JButton(" Gravar ");
	}
	
	public void defineLayoutPanels() {
		setLayout(new BorderLayout());
		
		panelTitulos.setLayout(new GridLayout(4,2));
		panelTexto.setLayout(new GridLayout(4,2));
		panelBotoes.setLayout(new GridLayout(1,4));
		
		lnome.setHorizontalAlignment(SwingConstants.RIGHT);
		lendereco.setHorizontalAlignment(SwingConstants.RIGHT);
		ltelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lemail.setHorizontalAlignment(SwingConstants.RIGHT);

	}
	
	public void adicionaComponentes() {
		add(panelTitulos,BorderLayout.WEST);
		add(panelTexto,BorderLayout.CENTER);
		add(panelBotoes,BorderLayout.SOUTH);
		add(panelBanner,BorderLayout.NORTH);
		
		panelBanner.add(banner);
		
		panelTitulos.add(lnome);
		panelTitulos.add(lendereco);
		panelTitulos.add(ltelefone);
		panelTitulos.add(lemail);
		
		panelTexto.add(nome);
		panelTexto.add(endereco);
		panelTexto.add(telefone);
		panelTexto.add(email);
		
		panelBotoes.add(botaoLimpar);
		panelBotoes.add(botaoInserir);
		panelBotoes.add(botaoConsultar);
		panelBotoes.add(botaoGravar);
		
	}
	
	public void registraHandler() {
		botaoLimpar.addActionListener(this);
		botaoInserir.addActionListener(this);
		botaoConsultar.addActionListener(this);
		botaoGravar.addActionListener(this);
	}
	
	public static void main (String[] args) {
		JanelaPrincipal janela = new JanelaPrincipal();
		janela.setSize(450,180);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText().equals(" Inserir ")) {
			contato = new Contato(nome.getText(),endereco.getText(),telefone.getText(),email.getText());
			if(agenda.inserirContato(contato)) {
				JOptionPane.showMessageDialog(this, "Contato incluido com sucesso!", "Adição de Contatos", JOptionPane.INFORMATION_MESSAGE);
				limparTela();
			}
		}
		if (((JButton)e.getSource()).getText().equals(" Consultar ")) {
			Contato contato = agenda.pesquisar(nome.getText());
			nome.setText(contato.getNome());
			endereco.setText(contato.getEndereco());
			telefone.setText(contato.getTelefone());
			email.setText(contato.getEmail());
		}
		if (((JButton)e.getSource()).getText().equals(" Limpar ")) {
			limparTela();
		}
		if (((JButton)e.getSource()).getText().equals(" Gravar ")) {
                    agenda.gravar();
		}
	}
	
	public void limparTela() {
		nome.setText("");
		endereco.setText("");
		telefone.setText("");
		email.setText("");
	}

}
