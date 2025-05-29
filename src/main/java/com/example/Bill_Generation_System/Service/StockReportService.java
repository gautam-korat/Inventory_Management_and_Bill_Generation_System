package com.example.Bill_Generation_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockReportService
{
    @Autowired
    private CSVFileGenerate csvFileGenerate;

    @Autowired
    private WhatsAppService whatsAppService;

    @Autowired
    private EmailService emailService;

    public String sendStockReportMessageTOWhatsApp(String phoneNumber)
    {
        String CSVFilePath = csvFileGenerate.generateCSV();

        String message = "Your stock report is ready. Please find the attached CSV file.";
        whatsAppService.sendWhatsAppMessage(phoneNumber, message);

        return CSVFilePath;
    }
}