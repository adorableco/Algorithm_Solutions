-- 코드를 입력하세요
SELECT o.animal_id, o.name
from animal_outs o
where not exists (
    select 1
    from animal_ins
    where animal_id = o.animal_id
)
order by o.animal_id;