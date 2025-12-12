-- Write your PostgreSQL query statement below
select machine_id ,
Round(sum( case when activity_type ='end' then timestamp 
 else -timestamp end) :: NUMERIC(20,3) /
(count(distinct process_id)),3) as processing_time
from activity
group by machine_id
