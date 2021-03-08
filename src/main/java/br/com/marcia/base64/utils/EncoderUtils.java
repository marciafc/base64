package br.com.marcia.base64.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static br.com.marcia.base64.utils.ArquivoUtils.*;

public class EncoderUtils {

    public static byte[] converterEmBase64(String caminhoArquivo) throws IOException {

        byte[] conteudoArquivo = FileUtils.readFileToByteArray(new File(caminhoArquivo));

        byte[] encoder = Base64
                .getEncoder()
                .encode(conteudoArquivo);

        String caminhoNovoArquivo = caminhoArquivo.substring(0, caminhoArquivo.lastIndexOf("."));
        escrever(caminhoNovoArquivo.concat(".txt"), encoder);

        return encoder;

    }

}
