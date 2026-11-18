
package view;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    private JTabbedPane abas;

    public TelaPrincipal() {
        initComponents();
    }

    private void initComponents() {

        this.setTitle("Sistema de Cadastro");
        this.setSize(550, 500);
        this.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );
        this.setLocationRelativeTo(null);

        // Cria o componente de abas
        abas = new JTabbedPane();

        // Adiciona os formulários
        abas.addTab(
                "Cadastro de Pessoas",
                new TelaCadastroPessoa()
        );

        abas.addTab(
                "Cadastro de Carros",
                new TelaCadastroCarro()
        );

        this.add(abas);

        this.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal();
        });
    }
}
