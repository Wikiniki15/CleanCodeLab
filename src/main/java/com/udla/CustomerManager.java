package com.udla;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Manages customers and their orders.
 */
public class CustomerManager {

    private static final Logger logger = Logger.getLogger(CustomerManager.class.getName());

    private List<String> customerList = new ArrayList<>();
    private List<String> orderList = new ArrayList<>();

    public void addCustomer(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        customerList.add(customerName);
        logger.info("Added customer: " + customerName);
    }

    public void addOrder(String orderName) {
        if (orderName == null || orderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Order name cannot be null or empty");
        }
        orderList.add(orderName);
        logger.info("Order added: " + orderName);
    }

    public void processOrders(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        logger.info("Processing orders for: " + customerName);
        for (String order : orderList) {
            logger.info("Processing order: " + order);
        }
    }

    public void generateReport() {
        printCustomerReport();
        printOrderReport();
    }

    private void printCustomerReport() {
        logger.info("Customer Report");
        for (String customer : customerList) {
            logger.info("Customer: " + customer);
        }
    }


    private void printOrderReport() {
        logger.info("Order Report");
        for (String order : orderList) {
            logger.info("Order: " + order);
        }
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        manager.addCustomer("John Doe");
        manager.addCustomer("Jane Smith");
        manager.addOrder("Order1");
        manager.addOrder("Order2");
        manager.processOrders("John Doe");
        manager.generateReport();
    }
}