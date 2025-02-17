SELECT customerNumber, COUNT(*) AS order_count
FROM orders
GROUP BY customerNumber
HAVING order_count = (
    SELECT COUNT(*) AS max_orders
    FROM orders
    GROUP BY customerNumber
    ORDER BY max_orders DESC
    LIMIT 1
)
ORDER BY order_count DESC;