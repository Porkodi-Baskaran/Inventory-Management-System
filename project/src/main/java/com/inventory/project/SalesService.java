package com.example.InventoryMangement.Service;

import com.example.InventoryMangement.Entity.Customer;
import com.example.InventoryMangement.Entity.Invoice;

import com.example.InventoryMangement.Entity.InvoiceItem;
import com.example.InventoryMangement.PDFGenrator.PdfGeneratorService;
import com.example.InventoryMangement.Repo.CustomerRepo;
import com.example.InventoryMangement.Repo.InvoiceRepo;
import com.example.InventoryMangement.Repo.ProductRepo;


import com.example.InventoryMangement.WhatsappService.WhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SalesService {
@Autowired
    private final InvoiceRepo invoiceRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final PdfGeneratorService pdfGeneratorService;
    private final WhatsappService whatsappService;


    @Value("${inventory.low-stock.threshold:5}")
    private int lowStockThreshold;

    @Value("${admin.whatsapp.number:}")
    private String adminNumber;

    public SalesService(InvoiceRepo invoiceRepo, CustomerRepo customerRepo, ProductRepo productRepo, PdfGeneratorService pdfGeneratorService, WhatsappService whatsappService) {
        this.invoiceRepo = invoiceRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.pdfGeneratorService = pdfGeneratorService;
        this.whatsappService = whatsappService;
    }


    public Invoice createSale(Invoice invoice) {
        if (invoice.getCustomer() != null && invoice.getCustomer().getId() != null) {
            var existing = customerRepo.findById(Math.toIntExact(invoice.getCustomer().getId()))
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            invoice.setCustomer(existing);
        }

        // 🔸 Basic invoice setup
        invoice.setInvoiceNo("INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        invoice.setDate(new Date());
        invoice.setStatus("UNPAID");

        // 🔸 Calculate total
        double grandTotal = 0;
        for (InvoiceItem item : invoice.getItems()) {
            double lineTotal = (item.getQty() * item.getPrice()) * (1 - item.getDiscount() / 100);
            item.setTotal(lineTotal);
            item.setInvoice(invoice);
            grandTotal += lineTotal;

            // 🧠 Check stock level (optional if you track inventory)
          /*  if (item.getProduct() != null && item.getProduct().getStock() <= lowStockThreshold) {
                String alertMsg = String.format(
                        "⚠️ Low Stock Alert!\nProduct: %s\nRemaining Stock: %d\nPlease reorder soon.",
                        item.getProduct().getName(),
                        item.getProduct().getStock()
                );
                whatsappService.sendTextMessage(adminNumber, alertMsg);
            }*/
        }

            invoice.setTotal(grandTotal);
            invoice.setReceived(0);

            // 💾 Save to DB
            var savedInvoice = invoiceRepo.save(invoice);

            // 🧾 Generate PDF
            String pdfPath = pdfGeneratorService.generateInvoicePdf(savedInvoice);
            File pdfFile = new File(pdfPath);

            // 💬 Send WhatsApp invoice (optional)
            if (savedInvoice.getCustomer() != null && savedInvoice.getCustomer().getPhone() != null) {
                whatsappService.sendInvoicePdf(savedInvoice.getCustomer().getPhone(), pdfFile);
            }

            return savedInvoice;
        }


    private void updateStatus(Invoice inv) {
        if (inv.getReceived() >= inv.getTotal()) inv.setStatus("PAID");
        else if (inv.getReceived() > 0) inv.setStatus("PARTIAL");
        else inv.setStatus("UNPAID");
    }


    public List<Invoice> getAllSales() {
        return invoiceRepo.findAll();
    }

    public Invoice getInvoice(Long id) {
        return invoiceRepo.findById(Math.toIntExact(id)).orElseThrow();
    }

    public Customer saveCustomer(Customer c) {
        return customerRepo.save(c);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}

