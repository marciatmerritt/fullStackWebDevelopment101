-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.address
(

    CONSTRAINT address_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.customers
(

    CONSTRAINT customers_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.inventory
(

    CONSTRAINT inventory_pkey PRIMARY KEY (id),
    CONSTRAINT "Unique Rows" UNIQUE (store_id, item_id)
);

CREATE TABLE IF NOT EXISTS public.items
(

    CONSTRAINT items_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.payment_types
(

    CONSTRAINT payment_types_pkey PRIMARY KEY (id),
    CONSTRAINT payment_type UNIQUE (payment_method)
);

CREATE TABLE IF NOT EXISTS public.purchase_items
(

    CONSTRAINT purchase_items_pkey PRIMARY KEY (id),
    CONSTRAINT purchase_items_purchase_id_item_id_key UNIQUE (purchase_id, item_id)
);

CREATE TABLE IF NOT EXISTS public.purchases
(

    CONSTRAINT purchases_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.stores
(

    CONSTRAINT stores_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.customers
    ADD CONSTRAINT customers_store_id_fkey FOREIGN KEY (store_id)
    REFERENCES public.stores (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.inventory
    ADD CONSTRAINT inventory_item_id_fkey FOREIGN KEY (item_id)
    REFERENCES public.items (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.inventory
    ADD CONSTRAINT inventory_store_id_fkey FOREIGN KEY (store_id)
    REFERENCES public.stores (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.purchase_items
    ADD CONSTRAINT purchase_items_item_id_fkey FOREIGN KEY (item_id)
    REFERENCES public.items (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.purchase_items
    ADD CONSTRAINT purchase_items_purchase_id_fkey FOREIGN KEY (purchase_id)
    REFERENCES public.purchases (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.purchases
    ADD CONSTRAINT purchases_customer_id_fkey FOREIGN KEY (customer_id)
    REFERENCES public.customers (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.purchases
    ADD CONSTRAINT purchases_payement_type_id_fkey FOREIGN KEY (payment_type_id)
    REFERENCES public.payment_types (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.purchases
    ADD CONSTRAINT purchases_store_id_fkey FOREIGN KEY (store_id)
    REFERENCES public.stores (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.stores
    ADD CONSTRAINT stores_address_fkey FOREIGN KEY (address_id)
    REFERENCES public.address (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;