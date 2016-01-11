create or replace trigger tr_petit_num2
  before insert on t_petit
  for each row
begin
  select to_char(:new.date_input,'MM') || '/' || ((select nvl(max(to_number(substr(t2.num,4,100))),0) from t_petit t2 where
  to_char(:new.date_input,'MM.YYYY')=to_char(t2.date_input,'MM.YYYY') 
  and :new.source_id=t2.source_id and :new.present_id=t2.present_id
  )
  + 1)
   into :new.num from dual;
end tr_petit_num;
/
