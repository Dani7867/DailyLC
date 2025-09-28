select 
    t.request_at as Day,
    ROUND(SUM(
        CASE
            WHEN t.status IN ('cancelled_by_driver', 'cancelled_by_client') THEN 1
            ELSE 0
        END)/count(*)
    ,2) AS 'Cancellation Rate'
from trips t
join users c on c.users_id = t.client_id AND c.banned = 'No'
join users d on d.users_id = t.driver_id AND d.banned = 'No'
WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
group by t.request_at;