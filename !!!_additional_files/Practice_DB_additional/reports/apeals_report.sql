DROP TABLE IF EXISTS REPORT;
CREATE TEMP TABLE REPORT(
	"���� ���������" varchar(50),
	"���������� ���������" bigint,
	"mom turned off the internet" bigint,
	"low internet speed" bigint,
	"no internet speed" bigint,
	"no connection" bigint,
	"often changes in internet speed" bigint);
	
INSERT INTO REPORT
SELECT  generate_series(min(date('01.01.2018')), max(date('01.01.2021')), '1d')::date,
		NULL, NULL, NULL,
		NULL, NULL, NULL;

DROP TABLE IF EXISTS PRE_REPORT;
CREATE TEMP TABLE PRE_REPORT(
	"���� ���������" varchar(50),
	"���������� ���������" bigint,
	"mom turned off the internet" bigint,
	"low internet speed" bigint,
	"no internet speed" bigint,
	"no connection" bigint,
	"often changes in internet speed" bigint);
	
INSERT INTO PRE_REPORT
SELECT		appeal_date as "���� ���������",
			COUNT (appeals.id) as "���������� ���������",
			SUM (CASE appeals.id_problem WHEN 1 THEN 1 ELSE 0 END) AS "mom turned off the internet",
 	      	SUM (CASE appeals.id_problem WHEN 2 THEN 1 ELSE 0 END) AS "low internet speed",
  	   		SUM (CASE appeals.id_problem WHEN 3 THEN 1 ELSE 0 END) AS "no internet speed",
			SUM (CASE appeals.id_problem WHEN 4 THEN 1 ELSE 0 END) AS "no connection",
			SUM (CASE appeals.id_problem WHEN 5 THEN 1 ELSE 0 END) AS "often changes in internet speed"
		FROM appeals
		WHERE id_duty = '40'
		GROUP BY appeal_date;
		
UPDATE REPORT
	SET
	"���������� ���������" = (SELECT "���������� ���������" FROM PRE_REPORT WHERE REPORT."���� ���������" = PRE_REPORT."���� ���������"),
	"mom turned off the internet" = (SELECT "mom turned off the internet" FROM PRE_REPORT WHERE REPORT."���� ���������" = PRE_REPORT."���� ���������"),
	"low internet speed" = (SELECT "low internet speed" FROM PRE_REPORT WHERE REPORT."���� ���������" = PRE_REPORT."���� ���������"),
	"no internet speed" = (SELECT "no internet speed" FROM PRE_REPORT WHERE REPORT."���� ���������" = PRE_REPORT."���� ���������"),
	"no connection" = (SELECT "no connection" FROM PRE_REPORT WHERE REPORT."���� ���������" = PRE_REPORT."���� ���������"),
	"often changes in internet speed" = (SELECT "often changes in internet speed" FROM PRE_REPORT WHERE REPORT."���� ���������" = PRE_REPORT."���� ���������");

SELECT * FROM REPORT
UNION
SELECT	'�����:' as "���� ���������",
		COUNT (appeals.id) as "���������� ���������",
		SUM (CASE appeals.id_problem WHEN 1 THEN 1 ELSE 0 END) AS "mom turned off the internet",
        SUM (CASE appeals.id_problem WHEN 2 THEN 1 ELSE 0 END) AS "low internet speed",
        SUM (CASE appeals.id_problem WHEN 3 THEN 1 ELSE 0 END) AS "no internet speed",
		SUM (CASE appeals.id_problem WHEN 4 THEN 1 ELSE 0 END) AS "no connection",
		SUM (CASE appeals.id_problem WHEN 5 THEN 1 ELSE 0 END) AS "often changes in internet speed"
FROM appeals
WHERE id_duty = '40' and appeal_date > '01.01.2018' and appeal_date < '01.01.2021'
ORDER BY "���� ���������";



--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////--
--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////--
--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////--



SELECT	to_char(date_range.generate_series, 'YYYY.MM.DD') as "���� ���������",
		COUNT (appeals.id) as "���������� ���������",
		SUM (CASE appeals.id_problem WHEN 1 THEN 1 ELSE 0 END) AS "mom turned off the internet",
		SUM (CASE appeals.id_problem WHEN 2 THEN 1 ELSE 0 END) AS "low internet speed",
		SUM (CASE appeals.id_problem WHEN 3 THEN 1 ELSE 0 END) AS "no internet speed",
		SUM (CASE appeals.id_problem WHEN 4 THEN 1 ELSE 0 END) AS "no connection",
		SUM (CASE appeals.id_problem WHEN 5 THEN 1 ELSE 0 END) AS "often changes in internet speed"
FROM  (SELECT generate_series(min(date('01.01.2018')), max(date('01.01.2021')), '1d')::date) date_range
left join appeals on (date_range.generate_series = appeals.appeal_date and id_duty = '40')
WHERE generate_series between '01.01.2018' and '01.01.2021'
GROUP BY generate_series
UNION
SELECT	'�����:' as "���� ���������",
		COUNT (appeals.id) as "���������� ���������",
		SUM (CASE appeals.id_problem WHEN 1 THEN 1 ELSE 0 END) AS "mom turned off the internet",
		SUM (CASE appeals.id_problem WHEN 2 THEN 1 ELSE 0 END) AS "low internet speed",
		SUM (CASE appeals.id_problem WHEN 3 THEN 1 ELSE 0 END) AS "no internet speed",
		SUM (CASE appeals.id_problem WHEN 4 THEN 1 ELSE 0 END) AS "no connection",
		SUM (CASE appeals.id_problem WHEN 5 THEN 1 ELSE 0 END) AS "often changes in internet speed"
FROM appeals
WHERE id_duty = '40' and appeal_date between '01.01.2018' and '01.01.2021'
ORDER BY "���� ���������";