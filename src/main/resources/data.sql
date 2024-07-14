CREATE TABLE IF NOT EXISTS `category_table` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `cname` VARCHAR(255) NOT NULL,
    `creation_date` DATE NOT NULL,
    `total_order` INT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `order_table` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `product` VARCHAR(255) NOT NULL,
    `quantity` INT NOT NULL,
    `price` DOUBLE NOT NULL,
    `category_id` BIGINT,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`category_id`) REFERENCES `category_table`(`id`)
);
