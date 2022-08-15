package com.tamvan.barcode.createbarcode.controllers;

import com.google.zxing.WriterException;
import com.tamvan.barcode.createbarcode.beans.QrCodeResponse;
import com.tamvan.barcode.createbarcode.services.BarcodeGenerator;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/barcode-generator")
@Tag(name = "barcode generator service", description = "Service to Generate Barcode")
@RequiredArgsConstructor
public class GeneratorController {

    private final BarcodeGenerator barcodeGenerator;

    @GetMapping(value = "/qr-code", produces = MediaType.IMAGE_PNG_VALUE)
    public HttpEntity generateQrCode(@RequestParam(value = "content", required = true)String content,
                                                           @RequestParam(value = "width", required = false, defaultValue = "200")Integer width,
                                                           @RequestParam(value = "height", required = false, defaultValue = "200")Integer height) throws WriterException, IOException {
        return new ResponseEntity<>(barcodeGenerator.generateQrBarcode(content, width, height), HttpStatus.OK);
    }

    @GetMapping(value = "/qr-code-with-response")
    public HttpEntity<QrCodeResponse> generateQrCodeWithObjects(@RequestParam(value = "content", required = true)String content,
                                                                @RequestParam(value = "width", required = false, defaultValue = "200")Integer width,
                                                                @RequestParam(value = "height", required = false, defaultValue = "200")Integer height) throws WriterException, IOException {
        QrCodeResponse response = new QrCodeResponse();
        response.setContent(content);
        response.setImage(barcodeGenerator.generateQrBarcode(content, width, height));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
