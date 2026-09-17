select s.firstName,s.lastName,r.city,r.state 
from Person s 
left join Address r
on s.personId=r.personId;



