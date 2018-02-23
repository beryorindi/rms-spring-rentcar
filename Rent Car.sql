CREATE TABLE IF NOT EXISTS `user_detail` (
  `user_detail_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `id_card_number` varchar(25),
  `address` varchar(150),
  `phone_number` varchar(15),

  PRIMARY KEY (`user_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `cars` (
  `car_id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `type` varchar(50) NOT NULL,
  `transmition` varchar(2) NOT NULL,
  `seat` int(3) NOT NULL,
	`year` int(4) NOT NULL,

  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
  `stock` int(2) NOT NULL,
  `price` int(20) NOT NULL,
    `available` int(3),

  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_by` varchar(50) NOT NULL,
  `order_date` int(20) NOT NULL,
  `update_on` date NOT NULL,
    `update_by` date NOT NULL

  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `order_detail` (
  `order_detail_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int(20) NOT NULL,
  `update_on` date,
    `update_by` date

  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cars` (`brand`, `model`, `type`, `transmition`, `seat`, `year`) VALUES
	('Toyota', 'Avanza', '1.5 Veloz', 'MT', 7, 2015),
	('Toyota', 'Avanza', '1.2 G', 'AT', 7, 2015),
    ('Toyota', 'Innova', '2.5 V', 'MT', 7, 2015); 
    


INSERT INTO `product` (`stock`, `name`, `price`, `available`) VALUES
	(1,"Avanza New", 350000, 1),(2, "Avanza Old", 300000, 2),(2, "Innova New", 400000, 2); 
    
INSERT INTO `user_detail`(`name`,`last_name`,`id_card_number`,`address`,`phone_number`) VALUES ('admin','123','45697451201','Tebet Jakarta','084574812154'),('admin','super','45123004548','Kuningan Jakarta','08310004578'),('user','000','37884512001','Kalibata Jakarta','0811154786') ;

CREATE TABLE IF NOT EXISTS `vehicle` (
  `vehicle_id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `type` varchar(50) NOT NULL,
  `transmition` varchar(2) NOT NULL,
  `seat` int(3),
    `year` int(4),
    `color` varchar(50),
    `license_plate` varchar(10),

  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `vehicle` (`brand`, `model`, `type`, `transmition`, `seat`, `year`,`color`,`license_plate`) VALUES
	('Toyota', 'Avanza', '1.5 Veloz', 'MT', 7, 2015,'grey','B1245XYZ'),
	('Toyota', 'Avanza', '1.2 G', 'AT', 7, 2015, 'grey','B1246ABC'),
    ('Toyota', 'Innova', '2.5 V', 'MT', 7, 2015, 'grey','B2475XYZ'); 