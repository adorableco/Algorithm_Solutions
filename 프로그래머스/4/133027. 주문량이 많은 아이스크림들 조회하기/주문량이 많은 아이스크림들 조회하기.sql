select distinct j.flavor
from july j join first_half f on j.flavor = f.flavor
group by j.flavor 
order by sum(j.total_order) + f.total_order desc
limit 3;