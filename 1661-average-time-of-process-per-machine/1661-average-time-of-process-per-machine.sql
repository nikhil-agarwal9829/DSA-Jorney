# Write your MySQL query statement below
select machine_id, ROUND(avg(timestamp-previous_time),3) as processing_time
from(
    SELECT machine_id,
       process_id,
       activity_type,
       timestamp,
       LAG(timestamp) OVER (
           PARTITION BY machine_id, process_id
           ORDER BY timestamp
       ) AS previous_time
    FROM Activity
)t
where activity_type='end'
group by machine_id
order by machine_id asc;