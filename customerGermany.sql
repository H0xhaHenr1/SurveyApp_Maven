SELECT c.customerNumber, c.customerName, o.orderNumber, od.productCode, od.quantityOrdered, od.priceEach, od.orderLineNumber
FROM customers c
JOIN orders o ON c.customerNumber = o.customerNumber
JOIN orderdetails od ON o.orderNumber = od.orderNumber
WHERE c.country = 'Germany';
