DROP TABLE `menu`;

CREATE TABLE menu (
	id BIGINT PRIMARY KEY AUTO_INCREMENT, 
	dish_Number INTEGER NOT NULL, 
	dish_Name VARCHAR(255), 
	vegan_Suitability VARCHAR(255), 
	dish_Price INTEGER
);