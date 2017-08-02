-- document typeID for upload docuement
insert into cfg_codeType (CodeTypeID,CodeType,CodeTypeDescription,CreatedBy,CreatedDate,LastModifiedBy,LastModifiedDate,isActive) 
select 1,'DocumentTypeID','DocumentTypeID',1,now(),1,now(),1
where NOT EXISTS(select * from cfg_codeType where codeTypeId = 1)

-- picture codevalue for docuement type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 101,1,'Picture','Picture', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 1 and CodeValueID=101)
----------------------------------------------------

-- FileTypeID for upload docuement
insert into cfg_codeType (CodeTypeID,CodeType,CodeTypeDescription,CreatedBy,CreatedDate,LastModifiedBy,LastModifiedDate,isActive) 
select 2,'FileTypeID','FileTypeID',1,now(),1,now(),1
where NOT EXISTS(select * from cfg_codeType where codeTypeId = 2)

-- jpg codevalue for FileTypeID type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 201,2,'JPG','JPG', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 2 and CodeValueID=201)
----------------------------------------------------


-- Salutation 
insert into cfg_codeType (CodeTypeID,CodeType,CodeTypeDescription,CreatedBy,CreatedDate,LastModifiedBy,LastModifiedDate,isActive) 
select 3,'Salutation','Salutation',1,now(),1,now(),1
where NOT EXISTS(select * from cfg_codeType where codeTypeId = 3)

-- Mr codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 301,3,'Mr','Mr', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 3 and CodeValueID=301)

-- Mrs codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 302,3,'Mrs','Mrs', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 3 and CodeValueID=302)

-- Dr codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 303,3,'Dr','Dr', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 3 and CodeValueID=303)

-- M/S codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 304,3,'M/S','M/S', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 3 and CodeValueID=304)

-- Master codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 305,3,'Master','Master', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 3 and CodeValueID=305)

--Miss codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 306,3,'Miss','Miss', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 3 and CodeValueID=306)

-- Prof codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 307,3,'Prof','Prof', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 3 and CodeValueID=307)
----------------------------------------------------


-- Gender 
insert into cfg_codeType (CodeTypeID,CodeType,CodeTypeDescription,CreatedBy,CreatedDate,LastModifiedBy,LastModifiedDate,isActive) 
select 4,'Gender','Gender',1,now(),1,now(),1
where NOT EXISTS(select * from cfg_codeType where codeTypeId = 4)

--male codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 401,4,'Male','Male', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 4 and CodeValueID=401)

-- female codevalue for Salutation type
insert into CFG_CodeValue(CodeValueID, CodeTypeId, CodeValue, CodeValueDescription, DisplaySeqNo, IsDefault, IsDisplay, IsActive, CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate)
select 402,4,'Female','Female', 1,0,1,1,1,now(),1,now()
where NOT EXISTS(select * from CFG_CodeValue where codeTypeId = 4 and CodeValueID=402)
--------------------------------------------
