
package view;

import controller.PessoaController;
import model.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroPessoa extends JPanel {

    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelPessoas;

    private JTextField fieldNome;
    private JTextField fieldEmail;

    private JButton buttonCadastro;

    private JList<Pessoa> listaPessoas;
    private DefaultListModel<Pessoa> modeloLista;
    private JScrollPane scrollLista;

    private PessoaController controller;

    public TelaCadastroPessoa() {
        this.controller = new PessoaController();
        initComponents();
    }

    private void atualizarLista() {

        List<Pessoa> pessoas = controller.getPessoas();

        modeloLista.clear();

        for (Pessoa pessoa : pessoas) {
            modeloLista.addElement(pessoa);
        }
    }

    public void initComponents() {

        labelNome = new JLabel("Nome:");
        labelEmail = new JLabel("E-mail:");
        labelPessoas = new JLabel("Pessoas cadastradas:");

        fieldNome = new JTextField();
        fieldEmail = new JTextField();

        buttonCadastro = new JButton("Cadastrar");

        modeloLista = new DefaultListModel<>();
        listaPessoas = new JList<>(modeloLista);

        listaPessoas.setCellRenderer(
                new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(
                            JList<?> list,
                            Object value,
                            int index,
                            boolean isSelected,
                            boolean cellHasFocus) {

                        super.getListCellRendererComponent(
                                list,
                                value,
                                index,
                                isSelected,
                                cellHasFocus
                        );

                        if (value instanceof Pessoa) {
                            Pessoa pessoa = (Pessoa) value;

                            setText(
                                    pessoa.getNome()
                                            + " - "
                                            + pessoa.getEmail()
                            );
                        }

                        return this;
                    }
                }
        );

        scrollLista = new JScrollPane(listaPessoas);

        this.setLayout(null);

        labelNome.setBounds(30, 30, 70, 25);
        this.add(labelNome);

        fieldNome.setBounds(100, 30, 340, 25);
        this.add(fieldNome);

        labelEmail.setBounds(30, 70, 70, 25);
        this.add(labelEmail);

        fieldEmail.setBounds(100, 70, 340, 25);
        this.add(fieldEmail);

        buttonCadastro.setBounds(100, 110, 120, 30);
        this.add(buttonCadastro);

        labelPessoas.setBounds(30, 160, 200, 25);
        this.add(labelPessoas);

        scrollLista.setBounds(30, 190, 410, 180);
        this.add(scrollLista);

        buttonCadastro.addActionListener(e -> {

            String nome = fieldNome.getText().trim();
            String email = fieldEmail.getText().trim();

            if (nome.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o nome e o e-mail!"
                );
                return;
            }

            controller.cadastrarPessoa(nome, email);

            atualizarLista();

            JOptionPane.showMessageDialog(
                    this,
                    "Pessoa cadastrada com sucesso!"
            );

            fieldNome.setText("");
            fieldEmail.setText("");

            fieldNome.requestFocusInWindow();
        });

        atualizarLista();
    }
}
