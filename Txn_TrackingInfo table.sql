create table Txn_TrackingInfo(
trackingId 	serial not null,
vechicleId 	int not null,
latitude 	float8 NOT NULL,
longitude 	float8 NOT NULL,
createdDate 	timestamp NOT NULL,
CONSTRAINT Txn_TrackingInfo_pkey PRIMARY KEY (trackingId),
FOREIGN KEY(vechicleId) REFERENCES Txn_VechicleInfo
)


