package br.com.marcia.base64.tela;

import javax.swing.*;
import java.io.File;

public class TelaArquivo extends JPanel {

    private JLabel arquivoLabel;
    private JTextField nomeArquivoField;
    private JButton selecioneButton;
    private JFileChooser fileChooser;

    public TelaArquivo() {

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        arquivoLabel = new JLabel("Arquivo");
        nomeArquivoField = new JTextField(30);
        selecioneButton = new JButton("Selecione...");

        selecioneButton.addActionListener(evt -> setArquivoSelecionado());

        add(arquivoLabel);
        add(nomeArquivoField);
        add(selecioneButton);

    }

    public void setArquivoSelecionado() {

        try {
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int retorno = fileChooser.showSaveDialog(this);
            if(retorno == JFileChooser.APPROVE_OPTION) {
                nomeArquivoField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JTextField getNomeArquivoField() {
        return nomeArquivoField;
    }
}
