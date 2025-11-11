package com.example.InventoryMangement.WhatsappService;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
@Service
public class WhatsappService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.whatsapp.from}")
    private String fromNumber;

    public void sendInvoicePdf(String toNumber, File pdfFile) {
        Twilio.init(accountSid, authToken);


        String pdfUrl = "https://tantalizing-carmella-coquettishly.ngrok-free.dev/invoices" + pdfFile.getName();

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:" + toNumber),
                        new com.twilio.type.PhoneNumber(fromNumber),
                        "🧾 Your invoice is ready!\nPlease find the attached PDF below."
                )
                .setMediaUrl(java.util.List.of(java.net.URI.create(pdfUrl)))
                .create();


    }
}
