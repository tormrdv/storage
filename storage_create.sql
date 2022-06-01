-- tables
-- Table: Item
CREATE TABLE Item (
    ID int  NOT NULL,
    Name varchar(255)  NOT NULL,
    Serial_Number int  NULL,
    Weight decimal(7,2)  NOT NULL,
    Colour varchar(25)  NOT NULL,
    Value int  NOT NULL,
    File_Name varchar(64)  NOT NULL,
    Storage_ID int  NOT NULL,
    CONSTRAINT Item_pk PRIMARY KEY (ID)
);

-- Table: Role
CREATE TABLE Role (
    ID int  NOT NULL,
    Name varchar(20)  NOT NULL,
    CONSTRAINT Role_pk PRIMARY KEY (ID)
);

-- Table: Storage
CREATE TABLE Storage (
    ID int  NOT NULL,
    Name varchar(50)  NOT NULL,
    Storage_Type_ID int  NOT NULL,
    Storage_ID int  NULL,
    Code int  NOT NULL,
    User_ID int  NOT NULL,
    CONSTRAINT id PRIMARY KEY (ID)
);

-- Table: Storage_Type
CREATE TABLE Storage_Type (
    ID int  NOT NULL,
    Type varchar(1)  NOT NULL,
    TypeName varchar(50)  NOT NULL,
    CONSTRAINT Storage_Type_pk PRIMARY KEY (ID)
);

-- Table: User
CREATE TABLE "User" (
    ID int  NOT NULL,
    Name varchar(50)  NOT NULL,
    Email varchar(255)  NOT NULL,
    User_Role_ID int  NOT NULL,
    Password varchar(255)  NOT NULL,
    IsAdmin boolean  NOT NULL DEFAULT FALSE,
    Business_Client_Owner_ID int  NULL,
    Storage_Limit int  NULL,
    CONSTRAINT User_pk PRIMARY KEY (ID)
);

-- Table: User_Role
CREATE TABLE User_Role (
    ID int NOT NULL,
    Role_ID int  NOT NULL,
    User_ID int  NOT NULL
);

-- foreign keys
-- Reference: Item_Storage (table: Item)
ALTER TABLE Item ADD CONSTRAINT Item_Storage
    FOREIGN KEY (Storage_ID)
    REFERENCES Storage (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Storage_Storage (table: Storage)
ALTER TABLE Storage ADD CONSTRAINT Storage_Storage
    FOREIGN KEY (Storage_ID)
    REFERENCES Storage (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Storage_Storage_Type (table: Storage)
ALTER TABLE Storage ADD CONSTRAINT Storage_Storage_Type
    FOREIGN KEY (Storage_Type_ID)
    REFERENCES Storage_Type (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Storage_User (table: Storage)
ALTER TABLE Storage ADD CONSTRAINT Storage_User
    FOREIGN KEY (User_ID)
    REFERENCES "User" (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_Role_Role (table: User_Role)
ALTER TABLE User_Role ADD CONSTRAINT User_Role_Role
    FOREIGN KEY (Role_ID)
    REFERENCES Role (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_Role_User (table: User_Role)
ALTER TABLE User_Role ADD CONSTRAINT User_Role_User
    FOREIGN KEY (User_ID)
    REFERENCES "User" (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_User (table: User)
ALTER TABLE "User" ADD CONSTRAINT User_User
    FOREIGN KEY (Business_Client_Owner_ID)
    REFERENCES "User" (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End.

