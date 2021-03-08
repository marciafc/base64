package br.com.marcia.base64;

import br.com.marcia.base64.utils.DecoderUtils;
import br.com.marcia.base64.utils.EncoderUtils;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class Base64Test {

    @Test
    public void quandoDecodarArquivoBase64QueEhJpgEntaoRetornarArquivoJpg() throws IOException {

        String caminhoRaiz = "src/test/resources/dog/";

        // dog.txt => dog.jpg
        File arquivoBase64 = new File(caminhoRaiz.concat("dog.txt"));
        DecoderUtils.converterEmArquivo(arquivoBase64.getAbsolutePath());

        // dog.jpg => dog_copia.txt
        File arquivoJpg = new File(caminhoRaiz.concat("dog.jpg"));
        EncoderUtils.converterEmBase64(arquivoJpg.getAbsolutePath());

        // dog_copia.txt => dog_copia.jpg
        File arquivoBase64CompararAposConversao = new File(caminhoRaiz.concat("dog_copia.txt"));
        DecoderUtils.converterEmArquivo(arquivoBase64CompararAposConversao.getAbsolutePath());

        // Comparar se o conteúdo dos arquivos de base64 inicial e final são iguais
        assertTrue(FileUtils.contentEquals(arquivoBase64, arquivoBase64CompararAposConversao));

        // Comparar se o conteúdo dos arquivos JPG inicial e final são iguais
        assertTrue(FileUtils.contentEquals(arquivoJpg, new File(caminhoRaiz.concat("dog_copia.jpg"))));

    }

    @Test
    public void quandoDecodarArquivoBase64QueEhPngEntaoRetornarArquivoPng() throws IOException {

        String caminhoRaiz = "src/test/resources/dog_cat/";

        // dog_cat.txt => dog_cat.png
        File arquivoBase64 = new File(caminhoRaiz.concat("dog_cat.txt"));
        DecoderUtils.converterEmArquivo(arquivoBase64.getAbsolutePath());

        // dog_cat.png => dog_cat_copia.txt
        File arquivoPng = new File(caminhoRaiz.concat("dog_cat.png"));
        EncoderUtils.converterEmBase64(arquivoPng.getAbsolutePath());

        // dog_cat_copia.txt => dog_cat_copia.png
        File arquivoBase64CompararAposConversao = new File(caminhoRaiz.concat("dog_cat_copia.txt"));
        DecoderUtils.converterEmArquivo(arquivoBase64CompararAposConversao.getAbsolutePath());

        // Comparar se o conteúdo dos arquivos de base64 inicial e final são iguais
        assertTrue(FileUtils.contentEquals(arquivoBase64, arquivoBase64CompararAposConversao));

        // Comparar se o conteúdo dos arquivos PNG inicial e final são iguais
        assertTrue(FileUtils.contentEquals(arquivoPng, new File(caminhoRaiz.concat("dog_cat_copia.png"))));

    }

    @Test
    public void quandoDecodarArquivoBase64QueEhPdfEntaoRetornarArquivoPdf() throws IOException {

        String caminhoRaiz = "src/test/resources/pdf/";

        // Teste.txt => Teste.pdf
        File arquivoBase64 = new File(caminhoRaiz.concat("Teste.txt"));
        DecoderUtils.converterEmArquivo(arquivoBase64.getAbsolutePath());

        // Teste.pdf => Teste_copia.txt
        File arquivoPdf = new File(caminhoRaiz.concat("Teste.pdf"));
        EncoderUtils.converterEmBase64(arquivoPdf.getAbsolutePath());

        // Teste_copia.txt => Teste_copia.pdf
        File arquivoBase64CompararAposConversao = new File(caminhoRaiz.concat("Teste_copia.txt"));
        DecoderUtils.converterEmArquivo(arquivoBase64CompararAposConversao.getAbsolutePath());

        // Comparar se o conteúdo dos arquivos de base64 inicial e final são iguais
        assertTrue(FileUtils.contentEquals(arquivoBase64, arquivoBase64CompararAposConversao));

        // Comparar se o conteúdo dos arquivos PDF inicial e final são iguais
        assertTrue(FileUtils.contentEquals(arquivoPdf, new File(caminhoRaiz.concat("Teste_copia.pdf"))));

    }


   @AfterEach
    public void cleanUp() {

        String caminhoRaiz = "src/test/resources/";

        try {
            Files.deleteIfExists(Paths.get(caminhoRaiz, "dog", "dog.jpg"));
            Files.deleteIfExists(Paths.get(caminhoRaiz, "dog", "dog_copia.jpg"));
            Files.deleteIfExists(Paths.get(caminhoRaiz,"dog", "dog_copia.txt" ));

            Files.deleteIfExists(Paths.get(caminhoRaiz, "dog_cat", "dog_cat.png"));
            Files.deleteIfExists(Paths.get(caminhoRaiz, "dog_cat", "dog_cat_copia.png"));
            Files.deleteIfExists(Paths.get(caminhoRaiz,"dog_cat", "dog_cat_copia.txt" ));

            Files.deleteIfExists(Paths.get(caminhoRaiz, "pdf", "Teste.pdf"));
            Files.deleteIfExists(Paths.get(caminhoRaiz, "pdf", "Teste_copia.pdf"));
            Files.deleteIfExists(Paths.get(caminhoRaiz,"pdf", "Teste_copia.txt" ));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
