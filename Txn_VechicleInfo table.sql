create table Txn_VechicleInfo(
vechicleId      	serial not null,
userId int      	not null,
vechicleName    	varchar(100) NULL,
CreatedBy      		int,
CreatedDate       	timestamp,
LastModifiedBy 		int,
LastModifiedDate	timestamp,
CONSTRAINT Txn_VechicleInfo_pkey PRIMARY KEY (vechicleId),
FOREIGN KEY(userId) REFERENCES Txn_User
)
