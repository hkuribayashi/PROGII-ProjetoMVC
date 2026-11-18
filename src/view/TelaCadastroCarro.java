
package view;

import controller.CarroController;
import model.Carro;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroCarro extends JFrame {

    private JLabel labelAno;
    private JLabel labelModelo;
    private JLabel labelCarros;

    private JTextField fieldAno;
    private JTextField fieldModelo;

    private JButton buttonCadastro;

    // Lista de objetos Carro
    private JList<Carro> listaCarros;
    private DefaultListModel<Carro> modeloLista;
    private JScrollPane scrollLista;

    // Controller
    private CarroController controller;

    public TelaCadastroCarro() {
        this.controller = new CarroController();
        initComponents();
    }

    // Consulta os Carros cadastrados via Controller
    private void atualizarLista() {

        List<Carro> carros = controller.getCarros();

        modeloLista.clear();

        for (Carro carro : carros) {
            modeloLista.addElement(carro);
        }
    }

    public void initComponents() {

        labelAno = new JLabel("Ano:");
        labelModelo = new JLabel("Modelo:");
        labelCarros = new JLabel("Carros cadastrados:");

        fieldAno = new JTextField();
        fieldModelo = new JTextField();

        buttonCadastro = new JButton("Cadastrar");

        // Inicialização da lista de pessoas
        modeloLista = new DefaultListModel<>();
        listaCarros = new JList<>(modeloLista);

        // Define como cada Pessoa será exibida na lista
        listaCarros.setCellRenderer(
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

                        if (value instanceof Carro) {
                            Carro carro = (Carro) value;

                            setText(
                                    carro.getAno()
                                            + " - "
                                            + carro.getModelo()
                            );
                        }

                        return this;
                    }
                }
        );

        scrollLista = new JScrollPane(listaCarros);

        this.setTitle("Cadastrar Carro");
        this.setSize(500, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE
        );

        this.getContentPane().setLayout(null);

        labelAno.setBounds(30, 30, 70, 25);
        this.add(labelAno);

        fieldAno.setBounds(100, 30, 340, 25);
        this.add(fieldAno);

        labelModelo.setBounds(30, 70, 70, 25);
        this.add(labelModelo);

        fieldModelo.setBounds(100, 70, 340, 25);
        this.add(fieldModelo);

        buttonCadastro.setBounds(100, 110, 120, 30);
        this.add(buttonCadastro);

        labelCarros.setBounds(30, 160, 200, 25);
        this.add(labelCarros);

        scrollLista.setBounds(30, 190, 410, 180);
        this.add(scrollLista);

        buttonCadastro.addActionListener(e -> {

            Integer ano = Integer.parseInt( fieldAno.getText().trim() );
            String modelo = fieldModelo.getText().trim();

            if (ano <= 0 || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o ano e o modelo corretamente!"
                );
                return;
            }

            // Cadastro via Controller
            controller.inserirCarro(ano, modelo);

            // Atualiza a lista via Controller
            atualizarLista();

            JOptionPane.showMessageDialog(
                    this,
                    "Carro cadastrado com sucesso!"
            );

            // Limpa os campos
            fieldAno.setText("");
            fieldModelo.setText("");

            // Retorna o foco ao campo nome
            fieldAno.requestFocusInWindow();
        });

        // Carrega os carros já cadastrados
        atualizarLista();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
