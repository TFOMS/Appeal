prompt PL/SQL Developer import file
prompt Created on 5 Март 2015 г. by paa
set feedback off
set define off
prompt Creating T_PETIT_HISTORY...
create table T_PETIT_HISTORY
(
  ID             NUMBER,
  DATE_INPUT     DATE,
  SOURCE_ID      NUMBER,
  PRESENT_ID     NUMBER,
  CONECT_ID      NUMBER,
  INTERMED       NUMBER,
  TYPE_ID        NUMBER,
  NAME           VARCHAR2(30),
  SURNAME        VARCHAR2(30),
  PATRONY        VARCHAR2(30),
  POLICY         VARCHAR2(30),
  TEL            VARCHAR2(20),
  ADRESS         VARCHAR2(50),
  TER_ID         NUMBER,
  TER_ANSWER_ID  NUMBER,
  LAST1          NUMBER,
  LAST2          NUMBER,
  MO_ID          NUMBER,
  INSUR_ID       NUMBER,
  PLACE          NUMBER,
  USERNAME       VARCHAR2(50),
  CAUSE_ID       NUMBER,
  RECTIF1_ID     NUMBER,
  RECTIF2_ID     NUMBER,
  RECTIF3_ID     NUMBER,
  RECTIF4_ID     NUMBER,
  VALID_ID       NUMBER,
  COMPENS        VARCHAR2(30),
  SATISF         VARCHAR2(30),
  COMPENS_SOURCE VARCHAR2(30),
  COMPENS_CODE   VARCHAR2(30),
  COMPENS_SUM    VARCHAR2(30),
  PROPOS         VARCHAR2(1000),
  LETTER_NUM     VARCHAR2(30),
  LETTER_DATE    VARCHAR2(30),
  DATE_BEGIN     DATE,
  DATE_END       DATE,
  CAUSE_NOTE     VARCHAR2(200),
  HSP_ID         NUMBER(10),
  NUM            VARCHAR2(8),
  DATE_LOG       DATE,
  ACTION         VARCHAR2(20)
)
;
alter table T_PETIT_HISTORY
  add constraint PETITHISTID unique (ID);

prompt Loading T_PETIT_HISTORY...
prompt Table is empty
set feedback on
set define on
prompt Done.
