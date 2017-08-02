create table CFG_CodeType(
CodeTypeID      	serial not null,
CodeType             	varchar(255) not null,    
CodeTypeDescription   	varchar(255) null,
CreatedBy      		int null,
CreatedDate       	timestamp,
LastModifiedBy 		int,
LastModifiedDate	timestamp,
isactive                int not null,
CONSTRAINT cfg_codetype_pkey PRIMARY KEY (CodeTypeID)
)

create table CFG_CodeValue(
CodeValueID           serial NOT NULL,
CodeTypeID      	  int not null,
CodeValue             varchar(255) not null,    
CodeValueDescription  varchar(1024) null,
DisplaySeqNo          int not null,
ParentCodeValueID     int null,
mapped_value1         varchar(255) null,
mapped_value2         varchar(255) null,
mapped_value3         varchar(255) null,
IsDefault             int not null,
IsDisplay             int not null,
IsActive              int not null,
CreatedBy      		  int null,
CreatedDate       	  timestamp,
LastModifiedBy 		  int,
LastModifiedDate	  timestamp,
CONSTRAINT CFG_CodeValue_pkey PRIMARY KEY (CodeValueID),
FOREIGN KEY(CodeTypeID) REFERENCES CFG_CodeType 
)


CREATE TABLE TXN_Document(
	DocumentID serial NOT NULL,
	DocumentTypeID int NOT NULL,
	DocumentText varchar(4000) NULL,
	DocumentName varchar(1000) NULL,
	DocumentStorageLocationID int NOT NULL,
	FileName varchar(1000) NULL,
	FileStoragePathURI varchar(255) NULL,
	FileTypeID int NULL,
	FileSizeKB int NULL,
	IsDownloadModule bit NULL,
	DownloadModuleID int NULL,
	DownloadDescription varchar(4000) NULL,
	UserID  int not null,
    CreatedBy int NULL,
	CreatedDate timestamp NULL,
	LastModifiedBy int NULL,
	LastModifiedDate timestamp NULL,
	IsActive bit NOT NULL,
CONSTRAINT TXN_Document_pkey PRIMARY KEY (DocumentID) ,    
FOREIGN KEY(userid) REFERENCES txn_user(userid),
FOREIGN KEY(DocumentTypeID) REFERENCES CFG_CodeValue(CodeValueID),
FOREIGN KEY(FileTypeID) REFERENCES CFG_CodeValue(CodeValueID)    
)
