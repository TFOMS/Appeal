prompt PL/SQL Developer import file
prompt Created on 2 ‘Â‚‡Î¸ 2015 „. by paa
set feedback off
set define off
prompt Creating T_HSP...
create table T_HSP
(
  HSP_ID NUMBER,
  HSP    VARCHAR2(110)
)
;

prompt Loading T_HSP...
insert into T_HSP (HSP_ID, HSP)
values (1, 'œŒÀ» À»Õ» ¿');
insert into T_HSP (HSP_ID, HSP)
values (2, '—“¿÷»ŒÕ¿–');
insert into T_HSP (HSP_ID, HSP)
values (0, null);
commit;
prompt 3 records loaded
set feedback on
set define on
prompt Done.
