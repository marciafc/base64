package br.com.marcia.base64.tela;

import br.com.marcia.base64.utils.EncoderUtils;
import br.com.marcia.base64.utils.DecoderUtils;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static br.com.marcia.base64.utils.MimeTypeUtils.getMimeType;

public class TelaPrincipal extends JFrame {

    private JButton okButton;

    private JLabel mensagem1Label;
    private JLabel mensagem2Label;
    private JLabel mimeTypeLabel;

    public TelaPrincipal() {

        super("Base64 - Encode/Decode");

        try {

            incluirAbas();

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            setSize(600, 200);
            setVisible(true);
            setLocationRelativeTo(null);

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void incluirAbas() {

        JTabbedPane abas = new JTabbedPane();

        abas.addTab("Conversor", null, montarAbaArquivo());
        add(abas);

    }


    private JPanel montarAbaArquivo() {

        JPanel aba = new JPanel();

        TelaArquivo telaArquivo = new TelaArquivo();

        okButton = new JButton("OK");
        okButton.addActionListener(e -> {

            try {
                converter(telaArquivo.getNomeArquivoField().getText());
                telaArquivo.getNomeArquivoField().setText("");

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        aba.add(telaArquivo);
        aba.add(okButton);

        mensagem1Label = new JLabel("base64 para imagem/pdf: informe arquivo txt contendo o base64");
        mensagem2Label = new JLabel("imagem/pdf para base64: informe arquivo, será gerado txt contendo base64");
        mimeTypeLabel = new JLabel();

        aba.add(mensagem1Label);
        aba.add(mensagem2Label);
        aba.add(mimeTypeLabel);

        return aba;
    }

    private void converter(String nomeArquivo) throws IOException {

        if(FilenameUtils.getExtension(nomeArquivo).equals("txt")) {
            byte[] textoBytes = DecoderUtils.converterEmArquivo(nomeArquivo);

            mimeTypeLabel.setText(getMimeType(textoBytes));
            mimeTypeLabel.setForeground(Color.BLUE);

        } else {
            EncoderUtils.converterEmBase64(nomeArquivo);
        }
    }

}
