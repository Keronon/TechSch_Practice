UPDATE public.bills
	SET balance=
	(
		(select sum(public.financial_operations.sum) from public.financial_operations
	 	where public.financial_operations.id_transaction_type=2 and public.financial_operations.id_bill=public.bills.id)
		-
		(select sum(public.financial_operations.sum) from public.financial_operations
	 	where public.financial_operations.id_transaction_type=1 and public.financial_operations.id_bill=public.bills.id)
	)
	WHERE id>0;

///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

UPDATE public.bills b
	SET balance=
		(
		select sum
			(case
				when f_o.id_transaction_type=2 then f_o.sum
				when f_o.id_transaction_type=1 then f_o.sum*(-1)
			 end)
		from public.financial_operations f_o where f_o.id_bill=b.id
		)
	WHERE id>0;