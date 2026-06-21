package com.udla;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gestiona clientes y sus pedidos.
 * Provee funcionalidad para agregar clientes, agregar pedidos,
 * procesar pedidos y generar reportes.
 */
public class CustomerManager {

  private static final Logger logger = Logger.getLogger(CustomerManager.class.getName());

  private List<String> customerList = new ArrayList<>();
  private List<String> orderList = new ArrayList<>();

  /**
   * Agrega un cliente a la lista de clientes.
   * Valida que el nombre del cliente no sea nulo o vacío.
   *
   * @param customerName el nombre del cliente a agregar
   * @throws IllegalArgumentException si customerName es nulo o vacío
   */
  public void addCustomer(String customerName) {
    if (customerName == null || customerName.trim().isEmpty()) {
      throw new IllegalArgumentException("Customer name cannot be null or empty");
    }
    customerList.add(customerName);
    if (logger.isLoggable(Level.INFO)) {
      logger.info("Added customer: " + customerName);
    }
  }

  /**
   * Agrega un pedido a la lista de pedidos.
   * Valida que el nombre del pedido no sea nulo o vacío.
   *
   * @param orderName el nombre del pedido a agregar
   * @throws IllegalArgumentException si orderName es nulo o vacío
   */
  public void addOrder(String orderName) {
    if (orderName == null || orderName.trim().isEmpty()) {
      throw new IllegalArgumentException("Order name cannot be null or empty");
    }
    orderList.add(orderName);
    if (logger.isLoggable(Level.INFO)) {
      logger.info("Order added: " + orderName);
    }
  }

  /**
   * Procesa todos los pedidos de un cliente específico.
   * Valida que el nombre del cliente no sea nulo o vacío.
   *
   * @param customerName el nombre del cliente cuyos pedidos serán procesados
   * @throws IllegalArgumentException si customerName es nulo o vacío
   */
  public void processOrders(String customerName) {
    if (customerName == null || customerName.trim().isEmpty()) {
      throw new IllegalArgumentException("Customer name cannot be null or empty");
    }
    if (logger.isLoggable(Level.INFO)) {
      logger.info("Processing orders for: " + customerName);
    }
    for (String order : orderList) {
      if (logger.isLoggable(Level.INFO)) {
        logger.info("Processing order: " + order);
      }
    }
  }

  /**
   * Genera un reporte resumen de todos los clientes y pedidos.
   * Delega la impresión a los métodos printCustomerReport y printOrderReport.
   */
  public void generateReport() {
    printCustomerReport();
    printOrderReport();
  }

  /**
   * Imprime el reporte de clientes en el logger.
   */
  private void printCustomerReport() {
    if (logger.isLoggable(Level.INFO)) {
      logger.info("Customer Report");
    }
    for (String customer : customerList) {
      if (logger.isLoggable(Level.INFO)) {
        logger.info("Customer: " + customer);
      }
    }
  }

  /**
   * Imprime el reporte de pedidos en el logger.
   */
  private void printOrderReport() {
    if (logger.isLoggable(Level.INFO)) {
      logger.info("Order Report");
    }
    for (String order : orderList) {
      if (logger.isLoggable(Level.INFO)) {
        logger.info("Order: " + order);
      }
    }
  }

  /**
   * Método principal para demostrar la funcionalidad de CustomerManager.
   * Crea una instancia del gestor y realiza operaciones de ejemplo.
   *
   * @param args argumentos de línea de comandos (no utilizados)
   */
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