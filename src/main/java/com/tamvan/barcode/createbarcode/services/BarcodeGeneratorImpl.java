package com.tamvan.barcode.createbarcode.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class BarcodeGeneratorImpl implements BarcodeGenerator {

    @Override
    public byte[] generateQrBarcode(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter barcodeWriter = new  QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        byte[] imageByte = toByteArray(MatrixToImageWriter.toBufferedImage(bitMatrix));
        return imageByte;
    }

    private static byte[] toByteArray(BufferedImage bi)
            throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", baos);
        byte[] bytes = baos.toByteArray();
        return bytes;

    }
}
