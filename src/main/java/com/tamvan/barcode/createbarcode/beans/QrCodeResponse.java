package com.tamvan.barcode.createbarcode.beans;

import lombok.Data;

@Data
public class QrCodeResponse {
    private String content;
    private byte[] image;
}
