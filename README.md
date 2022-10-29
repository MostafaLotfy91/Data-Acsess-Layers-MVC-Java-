# Data-Acsess-Layers-MVC-Java-
some Modules of a big projects built in (MVC) 

## Stock Market consists of the following tables 
### -Users(User_id , fullname ,user_name , password , email)
### -Product (product_id , product name , product_price , product_quantity)
### -Product Country (seq_id , product_id_fk,country_name , product module ,qntity )

product_id_fk is a forign key of the product country 

as we konw the MVC consists of three parts the first is module 

# i generate a module to a stock market with functions like 
## -Insert 
## -Update 
## -Delete 
## -Select 
### and a Data Base manager in class DBmanager responsiple for generate the connection and close it 
also generate a 3 classes as entities (product , user , producct country ) contain all properties and getter & setter methods .
