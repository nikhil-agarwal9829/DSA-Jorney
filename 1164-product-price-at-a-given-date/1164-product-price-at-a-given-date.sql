SELECT p.product_id,
       COALESCE(p.new_price, 10) AS price
FROM Products p
JOIN (
    SELECT product_id, MAX(change_date) AS max_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
) x
ON p.product_id = x.product_id
AND p.change_date = x.max_date

UNION

SELECT product_id, 10 AS price
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16';