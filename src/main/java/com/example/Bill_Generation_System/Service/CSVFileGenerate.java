package com.example.Bill_Generation_System.Service;

import com.example.Bill_Generation_System.Model.Product;
import com.example.Bill_Generation_System.Repository.ProductRepository;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CSVFileGenerate
{
    @Autowired
    private ProductRepository productRepository;

    public String generateCSV()
    {
        String CSVFilePath = "D:/Bill_Generation_System_Stock_Report_CSV_File/stock_report.csv";

        List<Product> productList = productRepository.findAll();

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSVFilePath)))
        {
            String[] ProductData = {"Product ID", "Product Name", "Product Price", "Product GST", "Product Stock"};
            writer.writeNext(ProductData);

            for (Product product : productList)
            {
                String[] productStock =
                {
                    String.valueOf(product.getProductId()),
                    product.getProductName(),
                    String.valueOf(product.getProductPrice()),
                    String.valueOf(product.getProductGst()),
                    String.valueOf(product.getProductStock())
                };
                writer.writeNext(productStock);
            }
            System.out.println("CSV file successfully generated at: " + CSVFilePath);
            return CSVFilePath;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}