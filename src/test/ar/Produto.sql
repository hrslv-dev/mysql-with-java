CREATE TABLE Produtos ( 
    id INT PRIMARY KEY AUTO_INCREMENT, 
    nome VARCHAR(100) NOT NULL, 
    valor DECIMAL(10,2) NOT NULL
)

ALTER TABLE Produtos MODIFY COLUMN id INT NOT NULL;



-- ALER TABLE Produtos -> auto_increment e NOT null

SELECT * FROM Produtos; 