select animal_id, name
from animal_ins
where (name like '%el%' or name like '%EL%' or name like '%eL%' or name like '%El%') and animal_type = 'Dog'
order by name;