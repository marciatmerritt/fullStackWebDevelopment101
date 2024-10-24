/*
1. List of all store names and addresses in ABC order
*/
   SELECT s.name            	  AS "Store"
		 ,a.street
		  || ' ' ||
		  COALESCE(a.street2,'')  AS "Street Address"
		 ,a.city           		  AS "City"
		 ,a.state          		  AS "State"
		 ,a.zip            		  AS "Zip"
     FROM stores s
		  INNER JOIN address a
				  ON s.address_id  = a.id
 ORDER BY s.name;
/* 
2. Total sales per store by store name
*/
  SELECT s.name 					AS "Store"
		,SUM(pi.quantity * i.price) AS "Total Sales"
    FROM stores s
		 INNER JOIN purchases p
		 		 ON s.id = p.store_id
		 INNER JOIN purchase_items pi
		 		 ON p.id = pi.purchase_id
		 INNER JOIN items i
	    		 ON pi.item_id = i.id
GROUP BY s.name
ORDER BY s.name;
/*
3. List of customers by Store name
*/
   SELECT s.name 	  AS "Store"
		 ,c.first_name 
		  || ' ' || 
		  c.last_name AS "Member Name"
     FROM stores s
	 	  INNER JOIN customers c
    			  ON s.id = c.store_id
 ORDER BY s.name
 		 ,c.last_name;
/*
4. List of inventory for a specific store
*/
   SELECT s.name   		AS "Store"
		 ,it.name    	AS "Item"
		 ,inv.quantity  AS "Quantity"
		 ,it.price   	AS "Price per unit"
		 ,it.notes   	AS "Notes"	
     FROM stores s
		        INNER JOIN inventory inv
		  		  		ON s.id = inv.store_id
		  		INNER JOIN items it
		  				ON it.id = inv.item_id
    WHERE s.id = (SELECT id 
					FROM stores 
				   WHERE name LIKE 'Administaff%')
 ORDER BY inv.id;
/*
5. List of Total Sales grouped by month for specific store
*/
  SELECT TO_CHAR(p.purchase_date, 'MONTH') 			AS "Purchase Month"
        ,CAST(SUM(pi.quantity * it.price) AS MONEY) AS "Total Sales"
    FROM stores s
		 INNER JOIN purchases p
		 		 ON s.id = p.store_id
		 INNER JOIN purchase_items pi
		 		 ON p.id = pi.purchase_id
		 INNER JOIN items it
		 		 ON it.id = pi.item_id
   WHERE s.id = (SELECT id
                   FROM stores
                  WHERE name LIKE 'Administaff%') 
GROUP BY p.purchase_date
ORDER BY TO_CHAR(p.purchase_date, 'MM'); 
/*
6. List of purchases by payment method for a specific store
*/
  SELECT s.name        		AS "Store",
         pay.payment_method AS "Payment Type",
         COUNT(pay.id)      AS "Total Purchases by Payment Type"
    FROM stores s
         INNER JOIN purchases p
		 		 ON s.id = p.store_id
		 INNER JOIN payment_types pay
		 		 ON pay.id = p.payment_type_id
   WHERE s.id = (SELECT id 
		 	       FROM stores 
				  WHERE name LIKE 'Benchmark Electronics%') 
GROUP BY pay.id, s.name
ORDER BY pay.payment_method;
/*
7. List of low inventory items by store
*/
   SELECT s.name  	   AS "Store"
		 ,it.name      AS "Item"
		 ,inv.quantity AS "Quantity"	
     FROM stores s
		  INNER JOIN inventory inv
		  		  ON s.id  = inv.store_id
		  INNER JOIN items it
		    	  ON it.id = inv.item_id
    WHERE inv.quantity < 10
	  AND s.id  = inv.store_id
	  AND it.id = inv.item_id
 ORDER BY s.name
 		 ,it.name;
/*
8. purchase history for a specific customer across all stores
*/
  SELECT c.first_name
         || ' ' ||
         c.last_name        AS "Member Name"
        ,p.purchase_date    AS "Purchase Date"
        ,it.name         	AS "Item purchased"
        ,pi.quantity        AS "Quantity purchased"
        ,pay.payment_method AS "Name of payment type used"
    FROM customers c
		 INNER JOIN purchases p
		 		 ON c.id     = p.customer_id
         INNER JOIN purchase_items pi
		 		 ON p.id   	 = pi.purchase_id
         INNER JOIN payment_types pay
		 		 ON pay.id 	 = p.payment_type_id
         INNER JOIN items it
		 		 ON it.id  	 = pi.item_id
   WHERE c.id = (SELECT id
                   FROM customers
                  WHERE last_name  = 'Poggi'
                    AND first_name = 'Alfred')
ORDER BY p.purchase_date DESC;
/*
9. Update all of past purchases that used Apple pay to show as Credit.
*/
UPDATE purchases
   SET payment_type_id = (SELECT id
                            FROM payment_types
                           WHERE payment_method = 'credit')
 WHERE payment_type_id = (SELECT id
                            FROM payment_types
                           WHERE payment_method = 'apple pay');
/*
10. Remove Apple pay from payment_types table
*/
DELETE 
  FROM payment_types
 WHERE payment_method = 'apple pay';
/*
11. Add new item to the items table
*/
INSERT INTO items
           (name
           ,price
           ,notes)
	VALUES ('Frosted Flakes'
           ,5
           ,'They''re Grate!');
/*
12.Add 50 new Frosted Flakes items to every store's inventory with an a in the store name. 
*/
 INSERT INTO inventory
			(store_id
			,item_id
			,quantity)
	  SELECT stores.id
			,(SELECT id
			    FROM items
			   WHERE name  = 'Frosted Flakes'
			     AND price = 5)
			,50
	 FROM stores
	 WHERE name LIKE '%a%';
/*
13. Update notes on items table
*/
UPDATE items
   SET notes = 'They''re Gr-r-reat!'
 WHERE name  = 'Frosted Flakes'
   AND notes = 'They''re Grate!'
