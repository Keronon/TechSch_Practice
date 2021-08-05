CREATE TABLE "contracts" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL UNIQUE,
	"id_client" int4 NOT NULL,
	"preparation_date" DATE NOT NULL,
	"start_date" DATE NOT NULL,
	"id_status" int4 NOT NULL,
	"end_date" DATE,
	CONSTRAINT "contracts_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "contract_statuses" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "contract_statuses_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "clients" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	"id_technical_information" int4 NOT NULL,
	"id_city" int4 NOT NULL,
	"adress" char(250) NOT NULL,
	"contact_information" TEXT NOT NULL,
	CONSTRAINT "clients_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "technical_infomation" (
	"id" serial NOT NULL,
	"dr/sr" char(250) NOT NULL,
	"id_server" int4 NOT NULL,
	"port/sap" int4 NOT NULL,
	"speed(mb/s)" int4 NOT NULL,
	"ip" inet NOT NULL,
	"scheme" char(250) NOT NULL,
	"pm" char(250) NOT NULL,
	CONSTRAINT "technical_infomation_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "client_cities" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "client_cities_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "appeals" (
	"id" serial NOT NULL,
	"appeal_date" DATE NOT NULL,
	"id_duty" int4 NOT NULL,
	"id_problem" int4 NOT NULL,
	"id_client" int4 NOT NULL,
	"problem_analysis" TEXT NOT NULL,
	"decision_date" DATE NOT NULL,
	"decision" TEXT NOT NULL,
	"culprit" char(250) NOT NULL,
	"downtime" char(100) NOT NULL,
	"check_out" bool NOT NULL,
	"decision_success" bool NOT NULL,
	CONSTRAINT "appeals_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "problems" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "problems_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "users" (
	"id" serial NOT NULL,
	"last_name" char(100) NOT NULL,
	"first_name" char(100) NOT NULL,
	"login" char(100) NOT NULL UNIQUE,
	"password" char(50) NOT NULL,
	"organization" char(100) NOT NULL,
	"contact_information" char(100) NOT NULL,
	"id_role" int4 NOT NULL,
	"id_status" int4 NOT NULL,
	CONSTRAINT "users_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "statuses" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "statuses_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "roles" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "roles_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "financial_operations" (
	"id" serial NOT NULL,
	"id_bill" int4 NOT NULL,
	"id_transaction_type" int4 NOT NULL,
	"sum" int4 NOT NULL,
	"operation_date" DATE NOT NULL,
	"id_user" int4 NOT NULL,
	"id_contract_part" int4 NOT NULL,
	"cancellation_date" DATE NOT NULL,
	"id_cancellation_user" int4 NOT NULL,
	"comment" TEXT,
	CONSTRAINT "financial_operations_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "transaction_types" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "transaction_types_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "bills" (
	"id" serial NOT NULL,
	"id_client" int4 NOT NULL,
	"balance" money NOT NULL,
	CONSTRAINT "bills_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "contract_parts" (
	"id" serial NOT NULL,
	"id_contract" int4 NOT NULL,
	"id_tariff" int4 NOT NULL,
	CONSTRAINT "contract_parts_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "services" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "services_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "withdrawal_types" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	CONSTRAINT "withdrawal_types_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "tariffs" (
	"id" serial NOT NULL,
	"name" char(250) NOT NULL,
	"id_service" int4 NOT NULL,
	"id_withdrawal_type" int4 NOT NULL,
	"cost" money NOT NULL,
	CONSTRAINT "tariffs_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "contract_changes" (
	"id_contract" int4 NOT NULL,
	"name" char(250) NOT NULL UNIQUE,
	"id_client" int4 NOT NULL,
	"preparation_date" DATE NOT NULL,
	"start_date" DATE NOT NULL,
	"id_status" int4 NOT NULL,
	"end_date" DATE,
	"id" serial NOT NULL,
	"id_user" int4 NOT NULL,
	"date_change" DATE NOT NULL,
	"comment" TEXT,
	CONSTRAINT "contract_changes_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "client_changes" (
	"id_client" int4 NOT NULL,
	"name" char(250) NOT NULL,
	"id_technical_information" int4 NOT NULL,
	"id_city" int4 NOT NULL,
	"adress" char(250) NOT NULL,
	"contact_information" TEXT NOT NULL,
	"id" serial NOT NULL,
	"id_user" int4 NOT NULL,
	"date_change" DATE NOT NULL,
	"comment" TEXT,
	CONSTRAINT "client_changes_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_changes" (
	"id_user_change" int4 NOT NULL,
	"last_name" char(100) NOT NULL,
	"first_name" char(100) NOT NULL,
	"login" char(100) NOT NULL UNIQUE,
	"organization" char(100) NOT NULL,
	"contact_information" char(100) NOT NULL,
	"id_role" int4 NOT NULL,
	"id_status" int4 NOT NULL,
	"id" serial NOT NULL,
	"id_user" int4 NOT NULL,
	"date_change" DATE NOT NULL,
	"comment" TEXT,
	CONSTRAINT "user_changes_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "contracts" ADD CONSTRAINT "contracts_fk0" FOREIGN KEY ("id_client") REFERENCES "clients"("id");
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_fk1" FOREIGN KEY ("id_status") REFERENCES "contract_statuses"("id");


ALTER TABLE "clients" ADD CONSTRAINT "clients_fk0" FOREIGN KEY ("id_technical_information") REFERENCES "technical_infomation"("id");
ALTER TABLE "clients" ADD CONSTRAINT "clients_fk1" FOREIGN KEY ("id_city") REFERENCES "client_cities"("id");



ALTER TABLE "appeals" ADD CONSTRAINT "appeals_fk0" FOREIGN KEY ("id_duty") REFERENCES "users"("id");
ALTER TABLE "appeals" ADD CONSTRAINT "appeals_fk1" FOREIGN KEY ("id_problem") REFERENCES "problems"("id");
ALTER TABLE "appeals" ADD CONSTRAINT "appeals_fk2" FOREIGN KEY ("id_client") REFERENCES "clients"("id");


ALTER TABLE "users" ADD CONSTRAINT "users_fk0" FOREIGN KEY ("id_role") REFERENCES "roles"("id");
ALTER TABLE "users" ADD CONSTRAINT "users_fk1" FOREIGN KEY ("id_status") REFERENCES "statuses"("id");



ALTER TABLE "financial_operations" ADD CONSTRAINT "financial_operations_fk0" FOREIGN KEY ("id_bill") REFERENCES "bills"("id");
ALTER TABLE "financial_operations" ADD CONSTRAINT "financial_operations_fk1" FOREIGN KEY ("id_transaction_type") REFERENCES "transaction_types"("id");
ALTER TABLE "financial_operations" ADD CONSTRAINT "financial_operations_fk2" FOREIGN KEY ("id_user") REFERENCES "users"("id");
ALTER TABLE "financial_operations" ADD CONSTRAINT "financial_operations_fk3" FOREIGN KEY ("id_contract_part") REFERENCES "contract_parts"("id");
ALTER TABLE "financial_operations" ADD CONSTRAINT "financial_operations_fk4" FOREIGN KEY ("id_cancellation_user") REFERENCES "users"("id");


ALTER TABLE "bills" ADD CONSTRAINT "bills_fk0" FOREIGN KEY ("id_client") REFERENCES "clients"("id");

ALTER TABLE "contract_parts" ADD CONSTRAINT "contract_parts_fk0" FOREIGN KEY ("id_contract") REFERENCES "contracts"("id");
ALTER TABLE "contract_parts" ADD CONSTRAINT "contract_parts_fk1" FOREIGN KEY ("id_tariff") REFERENCES "tariffs"("id");



ALTER TABLE "tariffs" ADD CONSTRAINT "tariffs_fk0" FOREIGN KEY ("id_service") REFERENCES "services"("id");
ALTER TABLE "tariffs" ADD CONSTRAINT "tariffs_fk1" FOREIGN KEY ("id_withdrawal_type") REFERENCES "withdrawal_types"("id");

ALTER TABLE "contract_changes" ADD CONSTRAINT "contract_changes_fk0" FOREIGN KEY ("id_contract") REFERENCES "contracts"("id");
ALTER TABLE "contract_changes" ADD CONSTRAINT "contract_changes_fk1" FOREIGN KEY ("id_client") REFERENCES "clients"("id");
ALTER TABLE "contract_changes" ADD CONSTRAINT "contract_changes_fk2" FOREIGN KEY ("id_status") REFERENCES "contract_statuses"("id");
ALTER TABLE "contract_changes" ADD CONSTRAINT "contract_changes_fk3" FOREIGN KEY ("id_user") REFERENCES "users"("id");

ALTER TABLE "client_changes" ADD CONSTRAINT "client_changes_fk0" FOREIGN KEY ("id_client") REFERENCES "clients"("id");
ALTER TABLE "client_changes" ADD CONSTRAINT "client_changes_fk1" FOREIGN KEY ("id_technical_information") REFERENCES "technical_infomation"("id");
ALTER TABLE "client_changes" ADD CONSTRAINT "client_changes_fk2" FOREIGN KEY ("id_city") REFERENCES "client_cities"("id");
ALTER TABLE "client_changes" ADD CONSTRAINT "client_changes_fk3" FOREIGN KEY ("id_user") REFERENCES "users"("id");

ALTER TABLE "user_changes" ADD CONSTRAINT "user_changes_fk0" FOREIGN KEY ("id_user_change") REFERENCES "users"("id");
ALTER TABLE "user_changes" ADD CONSTRAINT "user_changes_fk1" FOREIGN KEY ("id_role") REFERENCES "roles"("id");
ALTER TABLE "user_changes" ADD CONSTRAINT "user_changes_fk2" FOREIGN KEY ("id_status") REFERENCES "statuses"("id");
ALTER TABLE "user_changes" ADD CONSTRAINT "user_changes_fk3" FOREIGN KEY ("id_user") REFERENCES "users"("id");

