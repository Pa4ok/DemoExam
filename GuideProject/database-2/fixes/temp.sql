CREATE TABLE IF NOT EXISTS temp (
	product_title VARCHAR(256) NOT NULL,
	material_title VARCHAR(256) NOT NULL,
	material_count INT NOT NULL
);

CREATE TABLE IF NOT EXISTS `ProductMaterial` (
  `ProductID` INT NOT NULL,
  `MaterialID` INT NOT NULL,
  `ProductCount` DOUBLE NULL,
  PRIMARY KEY (`ProductID`, `MaterialID`),
  CONSTRAINT `FK_ProductMaterial_Material`
    FOREIGN KEY (`MaterialID`)
    REFERENCES `Material` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductMaterial_Product`
    FOREIGN KEY (`ProductID`)
    REFERENCES `Product` (`ID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
	
INSERT INTO productmaterial(ProductID, MaterialID, ProductCount)
SELECT product.ID as ProductID, material.ID as MaterialID, temp.material_count as ProductCount
FROM temp
INNER JOIN product ON product.Title = temp.product_title
INNER JOIN material ON material.Title = temp.material_title
