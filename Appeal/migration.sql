INSERT INTO T_PETIT(ID, ADRESS, CAUSE, COMPENS, COMPENS_CODE, COMPENS_SOURCE, COMPENS_SUM, CONECT_ID, DATE_INPUT, INSUR, INTERMED, LAST1, LAST2, MO, NAME, PATRONY, PLACE, POLICY, PRESENT_ID, PROPOS, RECTIF1, RECTIF2, RECTIF3, RECTIF4, SATISF, SOURCE_ID, SURNAME, TEL, TER_ANSWER_ID, TER_ID, TYPE_ID, USERNAME, VALID_ID, CAUSE_ID, LETTER_DATE, LETTER_NUM, RECTIF1_ID, RECTIF2_ID, RECTIF3_ID, RECTIF4_ID) 
select p.id, p.adress, pa.cause, pa.compens, pa.COMPENS_CODE, pa.COMPENS_SOURCE, pa.COMPENS_SUM, 
p.CONECT, p.DATE_INPUT,p.INSUR,p.INTERMED,p.LAST1,p.LAST2,p.MO,p.NAME,p.PATRONY,p.PLACE,p.POLICY,
p.PRESENT, null, null,null,null,null, pa.SATISF,p.sOURCE,p.SURNAME, p.TEL,p.TER_ANSWER,
p.TER, p.tYPE,p.USERNAME, pa.VALID,pa.CAUSE, null,null,pa.RECTIF1,pa.reCTIF2,pa.RECTIF3,
pa.RECTIF4
from PETIT p, PETIT_APPEAL pa
where p.id=pa.id;
INSERT INTO T_PETIT(ID, ADRESS, CAUSE, COMPENS, COMPENS_CODE, COMPENS_SOURCE, COMPENS_SUM, CONECT_ID, DATE_INPUT, INSUR, INTERMED, LAST1, LAST2, MO, NAME, PATRONY, PLACE, POLICY, PRESENT_ID, PROPOS, RECTIF1, RECTIF2, RECTIF3, RECTIF4, SATISF, SOURCE_ID, SURNAME, TEL, TER_ANSWER_ID, TER_ID, TYPE_ID, USERNAME, VALID_ID, CAUSE_ID, LETTER_DATE, LETTER_NUM, RECTIF1_ID, RECTIF2_ID, RECTIF3_ID, RECTIF4_ID) 
select p.id, p.adress, null,null,null,null,null, 
p.CONECT, p.DATE_INPUT,p.INSUR,p.INTERMED,p.LAST1,p.LAST2,p.MO,p.NAME,p.PATRONY,p.PLACE,p.POLICY,
p.PRESENT, null, null,null,null,null, null,p.sOURCE,p.SURNAME, p.TEL,p.TER_ANSWER,
p.TER, p.tYPE,p.USERNAME, null,pc.CAUSE, null,null,pc.RECTIF1,null,null,null
from PETIT p, PETIT_CONSULT pc
where p.id=pc.id;

UPDATE T_RECTIF3 SET RECTIF3 = upper(rectif3);

UPDATE T_PETIT t 
SET rectif4_id = 
(select tr4.rectif4_id
from  PETIT_TYPE_RECTIF4 pr4, T_RECTIF4 tr4
where t.type_id=pr4.type and t.cause_id=pr4.cause 
	and t.rectif1_id=pr4.rectif1 and t.rectif2_id=pr4.rectif2 and t.rectif3_id=pr4.rectif3 
	and t.rectif4_id=pr4.id and pr4.rectif4 = tr4.rectif4);

UPDATE T_PETIT t 
SET rectif3_id = 
(select tr3.rectif3_id
from  PETIT_TYPE_RECTIF3 pr3, T_RECTIF3 tr3
where t.type_id=pr3.type and t.cause_id=pr3.cause 
	and t.rectif1_id=pr3.rectif1 and t.rectif2_id=pr3.rectif2
	and t.rectif3_id=pr3.id and pr3.rectif3 = tr3.rectif3 limit 1);

UPDATE T_PETIT t 
SET rectif2_id = 
(select tr2.rectif2_id
from  PETIT_TYPE_RECTIF2 pr2, T_RECTIF2 tr2
where t.type_id=pr2.type and t.cause_id=pr2.cause 
	and t.rectif1_id=pr2.rectif1 
	and t.rectif2_id=pr2.id and pr2.rectif2 = tr2.rectif2 limit 1);

UPDATE T_PETIT t 
SET rectif1_id = 
(select tr1.rectif1_id
from  PETIT_TYPE_RECTIF1 pr1, T_RECTIF1 tr1
where t.type_id=pr1.type and t.cause_id=pr1.cause 
	and t.rectif1_id=pr1.id and pr1.rectif1 = tr1.rectif1 limit 1);

UPDATE T_PETIT t 
SET cause_id = 
(select tc.cause_id
from  PETIT_TYPE_CAUSE pc, T_CAUSE tc
where t.type_id=pc.type 
	and t.cause_id=pc.id 
	and pc.cause = tc.cause limit 1);

update T_PETIT set last1 = 0 where last1 is null;
update T_PETIT set last2 = 0 where last2 is null;
update T_PETIT set rectif1_id = 0 where rectif1_id is null;
update T_PETIT set rectif2_id = 0 where rectif2_id is null;
update T_PETIT set rectif3_id = 0 where rectif3_id is null;
update T_PETIT set rectif4_id = 0 where rectif4_id is null;
update T_PETIT set valid_id = 0 where valid_id is null;
