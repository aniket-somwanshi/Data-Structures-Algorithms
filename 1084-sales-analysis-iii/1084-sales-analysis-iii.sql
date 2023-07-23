select p.product_id, p.product_name 
from Product as p
inner join Sales as s
on p.product_id = s.product_id
group by p.product_id
HAVING MIN(s.sale_date) >= CAST('2019-01-01' AS DATE) AND
       MAX(s.sale_date) <= CAST('2019-03-31' AS DATE)