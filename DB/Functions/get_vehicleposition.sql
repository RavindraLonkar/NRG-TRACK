-- Function: public.get_vehicleposition(integer)

-- DROP FUNCTION public.get_vehicleposition(integer);

CREATE OR REPLACE FUNCTION public.get_vehicleposition(IN inputuserid integer)
  RETURNS TABLE(vehiclepositionid integer, vehiclenumber character varying, vehiclename character varying, latitude character varying, longitude character varying) AS
$BODY$

BEGIN
  
     

Return Query   
select   trackerposition.vehiclepositionid,trackerposition.vehicleNumber as vehicleNumber,trackerposition.vehicleName as vehicleName,trackerposition.latitude as latitude,trackerposition.longitude as longitude from
(
		select 
		ROW_NUMBER () OVER (
		 PARTITION BY tracker.trackerid
		 ORDER BY
		 trackdata.createddate desc
		 )
		 ,trackdata.trackerid as vehiclepositionid
		,vehicle.vechiclenumber as vehicleNumber
		,vehicle.vechiclename as vehicleName
		,trackdata.latitude as latitude
		,trackdata.longitude as longitude
		from txn_trackingdata trackdata
		inner join mst_tracker tracker on 
		trackdata.trackerid=tracker.trackerid
		inner join mst_vechicle vehicle 
		on vehicle.vehicleid=tracker.vehicleid
		where vehicle.userid=inputuserid and vehicle.isactive=1
		)trackerposition
		where row_number=1;
      

   
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public.get_vehicleposition(integer)
  OWNER TO postgres;
