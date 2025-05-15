select d.id, d.email, d.first_name, d.last_name
from developers d
where exists (
    select 1
    from skillcodes
    where category ='Front End' and code & d.skill_code = code
)
order by d.id;