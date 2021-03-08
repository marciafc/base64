package br.com.marcia.base64.utils;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static br.com.marcia.base64.utils.MimeTypeUtils.*;

public class ArquivoUtils {

    public static void escrever(String caminhoArquivo, byte[] bytes) {

        try (FileOutputStream fos = new FileOutputStream(ajustarNomeArquivoCasoJaExista(caminhoArquivo))) {
            fos.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String alterarExtensaoArquivoConformeMimeType(String caminhoArquivo, String mimeTypeArquivo) {

        String caminhoNovoArquivo = caminhoArquivo.substring(0, caminhoArquivo.lastIndexOf("."));

        switch(mimeTypeArquivo) {
            case MIME_TYPE_IMAGE_JPEG:
                return caminhoNovoArquivo + ".jpg";
            case MIME_TYPE_IMAGE_PNG:
                return caminhoNovoArquivo + ".png";
            case MIME_TYPE_APPLICATION_PDF:
                return caminhoNovoArquivo + ".pdf";
        }

        return null;
    }

    /**
     * Inclui sufixo "_copia", caso o arquivo já exista.
     * @return
     */
    private static String ajustarNomeArquivoCasoJaExista(String caminhoArquivo) {

        if(Files.exists(Paths.get(caminhoArquivo))) {

            int posicaoUltimoPonto = caminhoArquivo.lastIndexOf(".");
            String extensaoArquivo = caminhoArquivo.substring(posicaoUltimoPonto);
            return caminhoArquivo.substring(0, posicaoUltimoPonto) + "_copia" + extensaoArquivo;
        }

        return caminhoArquivo;
    }

}
