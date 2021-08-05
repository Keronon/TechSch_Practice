	select to_char(start_date, 'YYYY.MM.DD') as "start_date", count(distinct id) from
		(select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=1))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=2))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=3))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=4))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=5))) main
	group by start_date
	union all
	select 'Итого:' as "start_date", count(distinct id) from
		(select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=1))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=2))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=3))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=4))
		union all
		select start_date, id from contracts where id in
				(select distinct id_contract from contract_parts where id_tariff in
					(select id from tariffs WHERE id_service=5))) main
	order by start_date

--------///////////////////////////////////////////////////////////////////////////////////////////////////////////--------
--------///////////////////////////////////////////////////////////////////////////////////////////////////////////--------
--------/////////////////////////////////////////////Рабочий способ////////////////////////////////////////////////--------
--------///////////////////////////////////////////////////////////////////////////////////////////////////////////--------
--------///////////////////////////////////////////////////////////////////////////////////////////////////////////--------

select to_char(c.start_date, 'YYYY.MM.DD') as "Дата", count(distinct c.id) as "Кол-во контрактов",
SUM (CASE t.id_service WHEN 1 THEN 1 ELSE 0 END) as "phone lines",
SUM (CASE t.id_service WHEN 2 THEN 1 ELSE 0 END) AS "vpn l2",
SUM (CASE t.id_service WHEN 3 THEN 1 ELSE 0 END) AS "vpn l3",
SUM (CASE t.id_service WHEN 4 THEN 1 ELSE 0 END) AS "sip",
SUM (CASE t.id_service WHEN 5 THEN 1 ELSE 0 END) AS "internet"
from contracts c inner join contract_parts cp on c.id = cp.id_contract
inner join tariffs t on t.id = cp.id_tariff
group by "Дата"
union
select 'Итого:' as "Дата", count(distinct c.id) as "Кол-во контрактов",
SUM (CASE t.id_service WHEN 1 THEN 1 ELSE 0 END) as "phone lines",
SUM (CASE t.id_service WHEN 2 THEN 1 ELSE 0 END) AS "vpn l2",
SUM (CASE t.id_service WHEN 3 THEN 1 ELSE 0 END) AS "vpn l3",
SUM (CASE t.id_service WHEN 4 THEN 1 ELSE 0 END) AS "sip",
SUM (CASE t.id_service WHEN 5 THEN 1 ELSE 0 END) AS "internet"
from contracts c inner join contract_parts cp on c.id = cp.id_contract
inner join tariffs t on t.id = cp.id_tariff
order by "Дата"