
package view;

import controller.CarroController;
import model.Carro;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroCarro extends JPanel {

    private JLabel labelAno;
    private JLabel labelModelo;
    private JLabel labelCarros;

    private JTextField fieldAno;
    private JTextField fieldModelo;

    private JButton buttonCadastro;

    private JList<Carro> listaCarros;
    private DefaultListModel<Carro> modeloLista;
    private JScrollPane scrollLista;

    private CarroController controller;

    public TelaCadastroCarro() {
        this.controller = new CarroController();
        initComponents();
    }

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

        modeloLista = new DefaultListModel<>();
        listaCarros = new JList<>(modeloLista);

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

        this.setLayout(null);

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

            int ano;

            try {
                ano = Integer.parseInt(
                        fieldAno.getText().trim()
                );
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe um ano válido!"
                );
                return;
            }

            String modelo = fieldModelo.getText().trim();

            if (ano <= 0 || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o ano e o modelo corretamente!"
                );
                return;
            }

            controller.inserirCarro(ano, modelo);

            atualizarLista();

            JOptionPane.showMessageDialog(
                    this,
                    "Carro cadastrado com sucesso!"
            );

            fieldAno.setText("");
            fieldModelo.setText("");

            fieldAno.requestFocusInWindow();
        });

        atualizarLista();
    }
}
