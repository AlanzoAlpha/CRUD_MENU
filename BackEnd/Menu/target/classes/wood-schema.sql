DROP TABLE `wood`;

create table wood (
	id bigint not null auto_increment, 
	age integer not null, 
	artificial boolean not null, 
	colour varchar(255), 
	coniferous boolean not null, 
	name varchar(255), 
	soft boolean not null, 
	weight integer not null, primary key (id)
);