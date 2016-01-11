create or replace trigger tr_petit_num
  before insert on t_petit
  for each row
begin
  select to_char(:new.date_input,'MM') || '/' || ((select nvl(max(to_number(substr(t2.num,4,100))),0) from t_petit t2 where
  to_char(:new.date_input,'MM')=to_char(t2.date_input,'MM') and to_char(:new.date_input,'YYYY')=to_char(t2.date_input,'YYYY')
  )
  + 1)
   into :new.num from dual;
end tr_petit_num;
/
