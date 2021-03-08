package br.com.marcia.base64.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static br.com.marcia.base64.utils.ArquivoUtils.*;
import static br.com.marcia.base64.utils.MimeTypeUtils.getMimeType;

public class DecoderUtils {

    public static byte[] converterEmArquivo(String caminhoArquivo) throws IOException {

        String b64 = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));

        byte[] decoder = Base64
                .getDecoder()
                .decode(b64);

        escrever(alterarExtensaoArquivoConformeMimeType(caminhoArquivo, getMimeType(decoder)), decoder);

        return decoder;
    }

}
