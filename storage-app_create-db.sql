-- tables
-- Table: item
CREATE TABLE item (
    ID bigserial  NOT NULL,
    Name varchar(255)  NOT NULL,
    Serial_Number int  NULL,
    Weight decimal(7,2)  NOT NULL,
    Colour varchar(25)  NOT NULL,
    Value int  NOT NULL,
    File_Name varchar(64)  NOT NULL,
    CONSTRAINT item_pk PRIMARY KEY (ID)
);

-- Table: storage
CREATE TABLE storage (
    ID bigserial  NOT NULL,
    Name varchar(50)  NOT NULL,
    Code int  NOT NULL,
    Storage_Type_ID int8  NOT NULL,
    User_ID int8  NOT NULL,
    storage_nest_ID int8  NOT NULL,
    CONSTRAINT id PRIMARY KEY (ID)
);

-- Table: storage_item
CREATE TABLE storage_item (
    ID bigserial  NOT NULL,
    Storage_ID int8  NOT NULL,
    Item_ID int8  NOT NULL,
    CONSTRAINT storage_item_pk PRIMARY KEY (ID)
);

-- Table: storage_nest
CREATE TABLE storage_nest (
    ID bigserial  NOT NULL,
    Storage_ID int8  NOT NULL,
    CONSTRAINT storage_nest_pk PRIMARY KEY (ID)
);

-- Table: storage_type
CREATE TABLE storage_type (
    ID bigserial  NOT NULL,
    Type varchar(1)  NOT NULL,
    TypeName varchar(50)  NOT NULL,
    CONSTRAINT storage_type_pk PRIMARY KEY (ID)
);

-- Table: users
CREATE TABLE users (
    ID bigserial  NOT NULL,
    Name varchar(50)  NOT NULL,
    Email varchar(255)  NOT NULL,
    Role varchar(40)  NOT NULL,
    Password varchar(255)  NOT NULL,
    Storage_Limit int  NULL,
    CONSTRAINT users_pk PRIMARY KEY (ID)
);

-- foreign keys
-- Reference: Storage_Storage_Type (table: storage)
ALTER TABLE storage ADD CONSTRAINT Storage_Storage_Type
    FOREIGN KEY (Storage_Type_ID)
    REFERENCES storage_type (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Storage_User (table: storage)
ALTER TABLE storage ADD CONSTRAINT Storage_User
    FOREIGN KEY (User_ID)
    REFERENCES users (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Storage_storage_nest (table: storage)
ALTER TABLE storage ADD CONSTRAINT Storage_storage_nest
    FOREIGN KEY (storage_nest_ID)
    REFERENCES storage_nest (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: storage_item_Item (table: storage_item)
ALTER TABLE storage_item ADD CONSTRAINT storage_item_Item
    FOREIGN KEY (Item_ID)
    REFERENCES item (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: storage_item_Storage (table: storage_item)
ALTER TABLE storage_item ADD CONSTRAINT storage_item_Storage
    FOREIGN KEY (Storage_ID)
    REFERENCES storage (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: storage_nest_Storage (table: storage_nest)
ALTER TABLE storage_nest ADD CONSTRAINT storage_nest_Storage
    FOREIGN KEY (Storage_ID)
    REFERENCES storage (ID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End.

