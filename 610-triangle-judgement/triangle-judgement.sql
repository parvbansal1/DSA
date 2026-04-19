# Write your MySQL query statement below
select x,y,z,
case 
    when(x + y <= z || y + z <= x || z + x <= y) then 'No'
    else 'Yes'
end as triangle
from triangle