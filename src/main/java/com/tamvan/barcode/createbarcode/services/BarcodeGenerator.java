package com.tamvan.barcode.createbarcode.services;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface BarcodeGenerator  {

    byte[] generateQrBarcode(String text, int width, int height) throws WriterException, IOException;

}
