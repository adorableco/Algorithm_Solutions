select i.animal_id, i.animal_type, i.name
from animal_ins i join animal_outs o on i.animal_id = o.animal_id
where i.sex_upon_intake like 'I%' and o.sex_upon_outcome not like 'I%'
order by i.animal_id;