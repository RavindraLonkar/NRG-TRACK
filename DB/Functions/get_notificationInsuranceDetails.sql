-- Function: public.get_notificationinsurancedetails(integer)

-- DROP FUNCTION public.get_notificationinsurancedetails(integer);

CREATE OR REPLACE FUNCTION public.get_notificationinsurancedetails(IN inputuserid integer)
  RETURNS TABLE(notificationid integer, vechiclename character varying, vechiclenumber character varying, insurancename character varying, remainingdays integer, notificationcount integer, startdate timestamp without time zone, enddate timestamp without time zone) AS
$BODY$

BEGIN

    
Return Query   

	select 
	insurance.insuranceid as notificationid,
	vechicle.vechiclename ,
	vechicle.vechiclenumber,
	insurance.insurancename,
	DATE_PART('day', insurance.enddate - now())::integer as remainingdays,
	count(*) over ()::integer as notificationcount,
	insurance.startdate,
	insurance.enddate
	 from txn_insurance insurance
	inner join mst_vechicle vechicle
	inner join txn_user userdata
	on vechicle.userid= userdata.userid
	on insurance.vehicleid=vechicle.vehicleid
	where insurance.reminder>= DATE_PART('day', insurance.enddate - now())
	and userdata.userid=inputuserid;
         
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public.get_notificationinsurancedetails(integer)
  OWNER TO postgres;
