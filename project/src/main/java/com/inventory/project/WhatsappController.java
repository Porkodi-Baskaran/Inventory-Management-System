package com.example.InventoryMangement.Contoller;



import com.example.InventoryMangement.WhatsappService.WhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.io.File;

@RestController
@RequestMapping("/api/notify")
public class WhatsappController {

    @Autowired
    private WhatsappService whatsappService;

    /**
     POST http://localhost:8080/api/notify/whatsapp/invoice?to=+919876543210&fileName=invoice123.pdf
     */
    @PostMapping("/whatsapp/invoice")
    public ResponseEntity<String> sendInvoiceOnWhatsApp(
            @RequestParam String to,       // WhatsApp number, e.g., +919876543210
            @RequestParam String fileName  // File name of invoice PDF
    ) {
        try {

            File pdfFile = new File("https://a1b2c3d4.ngrok.io/invoices" + fileName);

            if (!pdfFile.exists()) {
                return ResponseEntity.badRequest().body(" PDF file not found: " + pdfFile.getAbsolutePath());
            }

            whatsappService.sendInvoicePdf(to, pdfFile);
            return ResponseEntity.ok("✅ WhatsApp invoice sent successfully to " + to);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body(" Failed to send WhatsApp message: " + e.getMessage());
        }
    }
}

