SELECT DISTINCT p.productCode, p.productName, p.productLine, p.buyPrice
FROM orders o
JOIN orderdetails od ON o.orderNumber = od.orderNumber
JOIN products p ON od.productCode = p.productCode
WHERE o.orderDate BETWEEN '2004-12-01' AND '2004-12-31';
