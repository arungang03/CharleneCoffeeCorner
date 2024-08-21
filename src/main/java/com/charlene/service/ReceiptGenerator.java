package com.charlene.service;

import com.charlene.model.Order;
import com.charlene.utils.Formatter;

public class ReceiptGenerator {
    public String generate(Order order) {
        Formatter formatter = new Formatter();
        StringBuilder receipt = new StringBuilder();

        // Append formatted items
        order.getItems().stream()
                .map(formatter::formatItem)
                .forEach(formattedItem -> receipt.append(formattedItem).append("\n"));

        // Append formatted extras
        order.getAllExtras().stream()
                .map(formatter::formatExtra)
                .forEach(formattedExtra -> receipt.append(formattedExtra).append("\n"));

        receipt.append("Total: ").append(formatter.formatPrice(order.getTotalPrice()));
        return receipt.toString();
    }
}
