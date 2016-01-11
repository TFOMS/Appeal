package res;

import java.util.LinkedHashMap;
import java.util.Map;

import domain.CauseL;
import domain.Rectif1L;
import domain.Rectif2L;
import domain.Rectif3L;
import domain.TypeL;

public class FieldsDepends {
	
	public Map<Integer, TypeL> types = new LinkedHashMap<Integer, TypeL>();
	public Map<Integer, CauseL> causes = new LinkedHashMap<Integer, CauseL>();
	public Map<Integer, Rectif1L> rectifs1 = new LinkedHashMap<Integer, Rectif1L>();
	public Map<Integer, Rectif2L> rectifs2 = new LinkedHashMap<Integer, Rectif2L>();
	public Map<Integer, Rectif3L> rectifs3 = new LinkedHashMap<Integer, Rectif3L>();
	
	public FieldsDepends() {
	
		TypeL type = new TypeL("Жалоба", 1);
		type.addCause("3 ОБЕСПЕЧЕНИЕ ПОЛИСАМИ ОМС", 1)
				.addCause("4 ВЫБОР МО В СФЕРЕ ОМС", 2)
				.addCause("5 ВЫБОР ВРАЧА", 3)
				.addCause("6 ВЫБОР ИЛИ ЗАМЕНА СМО", 4)
				.addCause("7 ОРГАНИЗАЦИЯ РАБОТЫ МО", 5)
				.addCause("8 САНИТАРНО-ГИГИЕНИЧЕСКОЕ СОСТОЯНИЕ МО", 6)
				.addCause("9 МАТЕРИАЛЬНО-ТЕХНИЧЕСКОЕ ОБЕСПЕЧЕНИЕ МО", 7)
				.addCause("10 ЭТИКА И ДЕОНТОЛОГИЯ МЕДИЦИНСКИХ РАБОТНИКОВ", 8)
				.addCause("11 КМП", 9)
				.addCause("12 ЛЕКАРСТВЕННОЕ ОБЕСПЕЧЕНИЕ ПРИ ОКАЗАНИИ МЕДИЦИНСКОЙ ПОМОЩИ", 10)
				.addCause("13 ОТКАЗ В МЕДИЦИНСКОЙ ПОМОЩИ ПО ПРОГРАММАМ ОМС", 11)
				.addCause("14 НЕИСПОЛНЕНИЕ СМО ОБЯЗАННОСТЕЙ ПО ДОГОВОРУ", 12)
				.addCause("15 ВЗИМАНИЕ ДЕНЕЖНЫХ СРЕДСТВ ЗА МЕДИЦИНСКУЮ ПОМОЩЬ ПО ПРОГРАММАМ ОМС", 13)
				.addCause("16 НЕПРАВОМЕРНОЕ РАСПРОСТРАНЕНИЕ ПЕРСОНАЛЬНЫХ ДАННЫХ", 14)
				.addCause("17 ПРОЧИЕ ПРИЧИНЫ", 15);
		this.types.put(type.getId(), type);
		type = new TypeL("Заявление", 2);
		type.addCause("3.1 О ВЫДЕЛЕНИИ СРЕДСТВ ДЛЯ ОПЛАТЫ МЕД ПОМОЩИ В РАМКАХ ТЕРРИТОРИАЛЬНОЙ ПРОГРАММЫ ГОСУДАРСТВЕННЫХ ГАРАНТИЙ ОКАЗАНИЯ БЕСПЛАТНОЙ МЕДИЦИНСКОЙ ПОМОЩИ", 16)
				.addCause("3.2 ВЫБОРЕ И ЗАМЕНЕ СМО", 17)
				.addCause("3.3 ХОДАТАЙСТВА О РЕГИСТРАЦИИ В КАЧЕСТВЕ ЗАСТРАХОВАННОГО ЛИЦА", 18)
				.addCause("3.4 ХОДАТАЙСТВА ОБ ИДЕНТИФИКАЦИИ В КАЧЕСТВЕ ЗАСТРАХОВАННОГО ЛИЦА", 19)
				.addCause("3.5 О ВЫДАЧЕ ДУБЛИКАТА (ПЕРЕОФОРМЛЕНИИ) ПОЛИСА ОМС", 20)
				.addCause("3.6 ДРУГИЕ", 21);
		this.types.put(type.getId(), type);
		type = new TypeL("Консультация", 3);
		type.addCause("4.1 ОБ ОБЕСПЕЧЕНИИ ПОЛИСАМИ ОМС", 22)
				.addCause("4.2 О ВЫБОРЕ МО В СФЕРЕ ОМС", 23)
				.addCause("4.3 О ВЫБОРЕ ВРАЧА", 24)
				.addCause("4.4 О ВЫБОРЕ ИЛИ ЗАМЕНЕ СМО", 25)
				.addCause("4.5 ОБ ОРГАНИЗАЦИИ РАБОТЫ МО", 26)
				.addCause("4.6 О САНИТАРНО-ГИГИЕНИЧЕСКОМ СОСТОЯНИИ МО", 27)
				.addCause("4.7 ОБ ЭТИКЕ И ДЕОНТОЛОГИИ МЕДИЦИНСКИХ РАБОТНИКОВ", 28)
				.addCause("4.8 О КМП", 29)
				.addCause("4.9 О ЛЕКАРСТВЕННОМ ОБЕСПЕЧЕНИИ ПРИ ОКАЗАНИИ МЕДИЦИНСКОЙ ПОМОЩИ", 30)
				.addCause("4.10 ОБ ОТКАЗЕ В ОКАЗАНИИ МЕДИЦИНСКОЙ ПОМОЩИ ПО ПРОГРАММАМ ОМС", 31)
				.addCause("4.11 О ПОЛУЧЕНИИ МЕДИЦИНСКОЙ ПОМОЩИ ПО БАЗОВОЙ ПРОГРАММЕ ОМС ВНЕ ТЕРРИТОРИИ СТРАХОВАНИЯ", 32)
				.addCause("4.12 О ВЗИМАНИИ ДЕНЕЖНЫХ СРЕДСТВ ЗА МЕДИЦИНСКУЮ ПОМОЩЬ ПО ПРОГРАММАМ ОМC", 33)
				.addCause("4.12. 1 О ВИДАХ, КАЧЕСТВЕ И УСЛОВИЯХ ПРЕДОСТАВЛЕНИЯ МЕДИЦИНСКОЙ ПОМОЩИ ПО ПРОГРАММАМ ОМС", 36)				
				.addCause("4.13 О ПЛАТНЫХ МЕДИЦИНСКИХ УСЛУГАХ, ОКАЗЫВАЕМЫХ В МО", 34)
				.addCause("4.14 ДРУГИЕ", 35)
				;
		this.types.put(type.getId(), type);
		type = new TypeL("Предложение", 4);
		this.types.put(type.getId(), type);
		
		CauseL cause = new CauseL("3 ОБЕСПЕЧЕНИЕ ПОЛИСАМИ ОМС", 1);
		cause
				.addRectif1("ОТКАЗ В ВЫДАЧЕ ПОЛИСА ОМС", 1)
				.addRectif1("НЕСВОЕВРЕМЕННОСТЬ ВЫДАЧИ ПОЛИСА ОМС(СРОКИ ВЫДАЧИ НАРУШЕНЫ)", 2)
				.addRectif1("ДРУГОЕ", 3);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("4 ВЫБОР МО В СФЕРЕ ОМС", 2);
		cause
				.addRectif1("4.1 НА ТЕРРИТОРИИ СТРАХОВАНИЯ", 5)
				.addRectif1("4.2 ВНЕ ТЕРРИТОРИИ СТРАХОВАНИЯ", 4);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("5 ВЫБОР ВРАЧА", 3);
		cause
				.addRectif1("ОТКАЗ В ВЫБОРЕ ВРАЧА", 6)
				.addRectif1("ДРУГОЕ (С УТОЧНЕНИЕМ)", 7);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("6 ВЫБОР ИЛИ ЗАМЕНА СМО", 4);
		cause
				.addRectif1("6.1 ПО ПОСТОЯННОМУ МЕСТУ ЖИТЕЛЬСТВА", 8)
				.addRectif1("6.2 ВНЕ ПОСТОЯННОГО МЕСТА ЖИТЕЛЬСТВА", 9)
				.addRectif1("6.3 БЕЗ РЕГИСТРАЦИИ НА ТЕРРИТОРИИ РФ", 10);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("7 ОРГАНИЗАЦИЯ РАБОТЫ МО", 5);
		cause
				.addRectif1("СТАЦИОНАР", 11)
				.addRectif1("ПОЛИКЛИНИКА", 12);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("11 КМП", 9);
		cause
				.addRectif1("АКУШЕР-ГИНЕКОЛОГ", 13)
				.addRectif1("АЛЛЕРГОЛОГ", 14)
				.addRectif1("АНЕСТЕЗИОЛОГ-РЕАНИМАТОЛОГ", 15)
				.addRectif1("ВРАЧ ОБЩЕЙ ВРАЧЕБНОЙ ПРАКТИКИ", 16)
				.addRectif1("ГАСТРОЭНТЕРОЛОГ", 17)
				.addRectif1("ГЕМАТОЛОГ", 18)
				.addRectif1("ГЕНЕТИК", 19)
				.addRectif1("ДЕРМАТОВЕНЕРОЛОГ", 20)
				.addRectif1("ДЕТСКИЙ КАРДИОЛОГ", 21)
				.addRectif1("ДЕТСКИЙ ОНКОЛОГ", 22)
				.addRectif1("ДЕТСКИЙ СТОМАТОЛОГ", 23)
				.addRectif1("ДЕТСКИЙ УРОЛОГ-АНДРОЛОГ", 24)
				.addRectif1("ДЕТСКИЙ ХИРУРГ", 25)
				.addRectif1("ДЕТСКИЙ ЭНДОКРИНОЛОГ", 26)
				.addRectif1("ДИАБЕТОЛОГ", 27)
				.addRectif1("ИНФЕКЦИОНИСТ", 28)
				.addRectif1("КАРДИОЛОГ", 29)
				.addRectif1("НЕВРОЛОГ", 30)
				.addRectif1("НЕЙРОХИРУРГ", 31)
				.addRectif1("НЕОНАТОЛОГ", 32)
				.addRectif1("НЕФРОЛОГ", 33)
				.addRectif1("ОНКОЛОГ", 34)
				.addRectif1("ОТОРИНОЛАРИНГОЛОГ", 35)
				.addRectif1("ОФТАЛЬМОЛОГ", 36)
				.addRectif1("ПЕДИАТР", 37)
				.addRectif1("ПУЛЬМОНОЛОГ", 38)
				.addRectif1("РЕВМАТОЛОГ", 39)
				.addRectif1("СЕРДЕЧНО-СОСУДИСТЫЙ ХИРУРГ", 40)
				.addRectif1("СТОМАТОЛОГ", 41)
				.addRectif1("СУРДОЛОГ-ОТОЛАРИНГОЛОГ", 42)
				.addRectif1("ТЕРАПЕВТ", 43)
				.addRectif1("ТОКСИКОЛОГ", 44)
				.addRectif1("ТОРАКАЛЬНЫЙ ХИРУРГ", 45)
				.addRectif1("ТРАВМАТОЛОГ-ОРТОПЕД", 46)
				.addRectif1("УРОЛОГ", 47)
				.addRectif1("ХИРУРГ", 48)
				.addRectif1("ЧЕЛЮСТНО-ЛИЦЕВОЙ ХИРУРГ", 49)
				.addRectif1("ЭНДОКРИНОЛОГ", 50)
				.addRectif1("ВРАЧ СМП", 70)
				.addRectif1("ВРАЧ УЛЬТРАЗВУКОВОЙ ДИАГНОСТИКИ", 71)
				.addRectif1("РЕНТГЕНОЛОГ", 72);
		
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("12 ЛЕКАРСТВЕННОЕ ОБЕСПЕЧЕНИЕ ПРИ ОКАЗАНИИ МЕДИЦИНСКОЙ ПОМОЩИ", 10);
		cause
				.addRectif1("СТАЦИОНАРНОЙ МЕДИЦИНСКОЙ ПОМОЩИ", 51)
				.addRectif1("СТАЦИОНАРОЗАМЕЩАЮЩЕЙ МЕДИЦИНСКОЙ ПОМОЩИ", 52)
				.addRectif1("АМБУЛАТОРНО-ПОЛИКЛИНИЧЕСКОЙ МЕДИЦИНСКОЙ ПОМОЩИ", 53)
				.addRectif1("СКОРОЙ МЕДИЦИНСКОЙ ПОМОЩИ", 54);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("13 ОТКАЗ В МЕДИЦИНСКОЙ ПОМОЩИ ПО ПРОГРАММАМ ОМС", 11);
		cause
				.addRectif1("13.1 НА ТЕРРИТОРИИ СТРАХОВАНИЯ", 55)
				.addRectif1("13.2 ВНЕ ТЕРРИТОРИИ СТРАХОВАНИЯ", 56);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("15 ВЗИМАНИЕ ДЕНЕЖНЫХ СРЕДСТВ ЗА МЕДИЦИНСКУЮ ПОМОЩЬ ПО ПРОГРАММАМ ОМС", 13);
		cause
				.addRectif1("НА ТЕРРИТОРИИ СТРАХОВАНИЯ (15.1)", 58)
				.addRectif1("ВНЕ ТЕРРИТОРИИ СТРАХОВАНИЯ (15.2)", 59);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("17 ПРОЧИЕ ПРИЧИНЫ", 15);
		cause
				.addRectif1("В ТОМ ЧИСЛЕ ПО ВОПРОСАМ, НЕ ОТНОСЯЩИМСЯ К СФЕРЕ ОМС", 60);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("3.2 ВЫБОРЕ И ЗАМЕНЕ СМО", 17);
		cause
				.addRectif1("3.2.1 О ВЫБОРЕ СМО", 61)
				.addRectif1("3.2.2 О ЗАМЕНЕ СМО", 62);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("3.5 О ВЫДАЧЕ ДУБЛИКАТА (ПЕРЕОФОРМЛЕНИИ) ПОЛИСА ОМС", 20);
		cause
				.addRectif1("3.5.1 О ПЕРЕОФОРМЛЕНИИ ПОЛИСА", 63)
				.addRectif1("3.5.2 О ВЫДАЧЕ ДУБЛИКАТА ПОЛИСА", 64);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("3.6 ДРУГИЕ", 21);
		cause
				.addRectif1("3.6.1 НЕ ОТНОСЯЩИМСЯ К СФЕРЕ ОМС", 65);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("4.1 ОБ ОБЕСПЕЧЕНИИ ПОЛИСАМИ ОМС", 22);
		cause
				.addRectif1("4.1.1 ОБ ОБЕСПЕЧЕНИИ ПОЛИСАМИ ОМС ИНОСТРАННЫХ ГРАЖДАН, БЕЖЕНЦЕВ", 66)
				.addRectif1("ГРАЖДАН РФ", 67);
		this.causes.put(cause.getId(), cause);
		cause = new CauseL("4.12 О ВЗИМАНИИ ДЕНЕЖНЫХ СРЕДСТВ ЗА МЕДИЦИНСКУЮ ПОМОЩЬ ПО ПРОГРАММАМ ОМC", 33);
		cause
				.addRectif1("-", 69);
		this.causes.put(cause.getId(), cause);

		Rectif1L rectif1 = new Rectif1L("ОТКАЗ В ВЫДАЧЕ ПОЛИСА ОМС", 1);
		addRectif2Smo(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("НЕСВОЕВРЕМЕННОСТЬ ВЫДАЧИ ПОЛИСА ОМС(СРОКИ ВЫДАЧИ НАРУШЕНЫ)", 2);
		addRectif2Smo(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДРУГОЕ", 3);
		rectif1
			.addRectif2("-", 4);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ВНЕ ТЕРРИТОРИИ СТРАХОВАНИЯ", 4);
		addRectif2Denied(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("НА ТЕРРИТОРИИ СТРАХОВАНИЯ", 5);
		addRectif2Denied(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ПОЛИКЛИНИКА", 12);
		rectif1
			.addRectif2("Наличие больших очередей в регистратуру", 7)
			.addRectif2("Наличие больших очередей к врачам", 8)
			.addRectif2("Длительное ожидание дня приема врача-терапевта", 9)
			.addRectif2("Длительное ожидание дня приема врачей-специалистов", 10)
			.addRectif2("Отказ в выдаче направления в другую МО при отсутствии необходимого врача-специалиста", 11)
			.addRectif2("Длительное ожидание дня проведения диагностических, инструментальных и лабораторных исследований", 12)
			.addRectif2("Отказ в выдаче направления в другую МО при отсутствии возможности проведения необходимых диагностических, инструментальных и лабораторных исследований", 13)
			.addRectif2("Не удовлетворяет график работы МО", 14)
			.addRectif2("Невнимательность медицинского персонала", 15)
			.addRectif2("Другое", 16);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("СТАЦИОНАР", 11);
		rectif1
			.addRectif2("Отказ в организации проведения консультации врача специалиста", 17)
			.addRectif2("Отказ в организации проведения диагностических, инструментальных и лабораторных исследований", 18)
			.addRectif2("Длительное ожидание дня плановой госпитализации", 19)
			.addRectif2("Длительное ожидание оформления документов в приемном покое при госпитализации", 20)
			.addRectif2("Невнимательность медицинского персонала", 21)
			.addRectif2("Другое", 22);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("13.1 НА ТЕРРИТОРИИ СТРАХОВАНИЯ", 55);
		addRectif2Pay(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("13.2 ВНЕ ТЕРРИТОРИИ СТРАХОВАНИЯ", 56);
		addRectif2Pay(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("НА ТЕРРИТОРИИ СТРАХОВАНИЯ (15.1)", 58);
		addRectif2Hospital(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ВНЕ ТЕРРИТОРИИ СТРАХОВАНИЯ (15.2)", 59);
		addRectif2Hospital(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("АКУШЕР-ГИНЕКОЛОГ", 13);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("АЛЛЕРГОЛОГ", 14);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("АНЕСТЕЗИОЛОГ-РЕАНИМАТОЛОГ", 15);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ВРАЧ ОБЩЕЙ ВРАЧЕБНОЙ ПРАКТИКИ", 16);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ГАСТРОЭНТЕРОЛОГ", 17);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ГЕМАТОЛОГ", 18);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ГЕНЕТИК", 19);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДЕРМАТОВЕНЕРОЛОГ", 20);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДЕТСКИЙ КАРДИОЛОГ", 21);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДЕТСКИЙ ОНКОЛОГ", 22);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДЕТСКИЙ СТОМАТОЛОГ", 23);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДЕТСКИЙ УРОЛОГ-АНДРОЛОГ", 24);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДЕТСКИЙ ХИРУРГ", 25);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДЕТСКИЙ ЭНДОКРИНОЛОГ", 26);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ДИАБЕТОЛОГ", 27);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ИНФЕКЦИОНИСТ", 28);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("КАРДИОЛОГ", 29);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("НЕВРОЛОГ", 30);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("НЕЙРОХИРУРГ", 31);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("НЕОНАТОЛОГ", 32);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("НЕФРОЛОГ", 33);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ОНКОЛОГ", 34);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ОТОРИНОЛАРИНГОЛОГ", 35);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ОФТАЛЬМОЛОГ", 36);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ПЕДИАТР", 37);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ПУЛЬМОНОЛОГ", 38);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("РЕВМАТОЛОГ", 39);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("СЕРДЕЧНО-СОСУДИСТЫЙ ХИРУРГ", 40);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("СТОМАТОЛОГ", 41);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("СУРДОЛОГ-ОТОЛАРИНГОЛОГ", 42);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ТЕРАПЕВТ", 43);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ТОКСИКОЛОГ", 44);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ТОРАКАЛЬНЫЙ ХИРУРГ", 45);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ТРАВМАТОЛОГ-ОРТОПЕД", 46);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("УРОЛОГ", 47);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ХИРУРГ", 48);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ЧЕЛЮСТНО-ЛИЦЕВОЙ ХИРУРГ", 49);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ЭНДОКРИНОЛОГ", 50);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ВРАЧ СМП", 70);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("ВРАЧ УЛЬТРАЗВУКОВОЙ ДИАГНОСТИКИ", 71);
		addRectif2Act(rectif1);
		this.rectifs1.put(rectif1.getId(), rectif1);
		rectif1 = new Rectif1L("РЕНТГЕНОЛОГ", 72);
		addRectif2Act(rectif1);
		
		Rectif2L rectif2 = new Rectif2L("Наличие больших очередей в регистратуру", 7);
		rectif2
			.addRectif3("10-20 минут", 1)
			.addRectif3("20-30 минут", 2)
			.addRectif3("Более 30 минут", 3);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Наличие больших очередей к врачам", 8);
		rectif2
			.addRectif3("15-30 минут", 4)
			.addRectif3("30 минут – 1 час", 5)
			.addRectif3("Более 1 часа", 6);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Длительное ожидание дня приема врача-терапевта", 9);
		rectif2
			.addRectif3("3-5 дней", 7)
			.addRectif3("5-7 дней", 8)
			.addRectif3("Более 7 дней", 9);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Длительное ожидание дня приема врачей-специалистов", 10);
		rectif2
			.addRectif3("7-10 дней", 10)
			.addRectif3("10-14 дней", 11)
			.addRectif3("Более 14 дней", 12);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Отказ в выдаче направления в другую МО при отсутствии необходимого врача-специалиста", 11);
		addRectif3Doctor(rectif2);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Длительное ожидание дня проведения диагностических, инструментальных и лабораторных исследований", 12);
		rectif2
			.addRectif3("14-15 дней", 51)
			.addRectif3("15-20 дней", 52)
			.addRectif3("Более 20 дней", 53);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Отказ в выдаче направления в другую МО при отсутствии возможности проведения необходимых диагностических, инструментальных и лабораторных исследований", 13);
		rectif2
			.addRectif3("УЗИ", 54)
			.addRectif3("Рентгенография", 55)
			.addRectif3("ЭКГ", 56)
			.addRectif3("Эндоскопическое исследование", 57)
			.addRectif3("Клинико-лабораторные исследования", 58)
			.addRectif3("Другое", 59);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Не удовлетворяет график работы МО", 14);
		rectif2
			.addRectif3("Прием врачей специалистов", 60)
			.addRectif3("Прием терапевта, педиатра", 61)
			.addRectif3("Проведение диагностических исследований", 62);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Отказ в организации проведения консультации врача специалиста", 17);
		addRectif3Doctor(rectif2);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Отказ в организации проведения диагностических, инструментальных и лабораторных исследований", 18);
		rectif2
			.addRectif3("УЗИ", 63)
			.addRectif3("Рентгенография", 64)
			.addRectif3("ЭКГ", 65)
			.addRectif3("КТ", 66)
			.addRectif3("МРТ", 67)
			.addRectif3("Клинико-лабораторные исследования", 68)
			.addRectif3("Другое", 69);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Длительное ожидание дня плановой госпитализации", 19);
		rectif2
			.addRectif3("Дневной стационар", 70)
			.addRectif3("Стационар", 71);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Длительное ожидание оформления документов в приемном покое при госпитализации", 20);
		rectif2
			.addRectif3("Плановая медицинская помощь", 72)
			.addRectif3("Неотложная, Экстренная медицинская помощь", 73);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Требование оплаты за медицинскую помощь", 24);
		rectif2
			.addRectif3("Поликлиника", 74)
			.addRectif3("Стационар", 75);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("ПОЛИКЛИНИКА", 26);
		rectif2
			.addRectif3("За медицинскую помощь Обезболивание", 76)
			.addRectif3("За медицинскую помощь Консультацию врача специалиста", 77)
			.addRectif3("За медицинскую помощь Физиолечение", 78)
			.addRectif3("За медицинскую помощь другое", 79)
			.addRectif3("За лабораторные исследования Общеклинические исследования", 80)
			.addRectif3("За лабораторные исследования Биохимические исследования", 81)
			.addRectif3("За лабораторные исследования Гормональные исследования", 82)
			.addRectif3("За лабораторные исследования Другое", 83)
			.addRectif3("На оплату функциональных и инструментальных исследований УЗИ", 84)
			.addRectif3("На оплату функциональных и инструментальных исследований ЭКГ", 85)
			.addRectif3("На оплату функциональных и инструментальных исследований Рентгенография", 86)
			.addRectif3("На оплату функциональных и инструментальных исследований КТ", 87)
			.addRectif3("На оплату функциональных и инструментальных исследований МРТ", 88)
			.addRectif3("На оплату функциональных и инструментальных исследований Другое", 89)
			.addRectif3("За расходные материалы при проведении лечебно-диагностических мероприятий", 90);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("СТАЦИОНАР", 27);
		rectif2
			.addRectif3("За медицинскую помощь Оперативное лечение", 91)
			.addRectif3("За медицинскую помощь Обезболивание", 92)
			.addRectif3("За медицинскую помощь Консультацию врача специалиста", 93)
			.addRectif3("За медицинскую помощь Физиолечение", 94)
			.addRectif3("За медицинскую помощь Другое", 95)
			.addRectif3("За лабораторные исследования Общеклинические исследования", 96)
			.addRectif3("За лабораторные исследования Биохомические исследования", 97)
			.addRectif3("За лабораторные исследования Гормональные исследования", 98)
			.addRectif3("За лабораторные исследования Другое", 99)
			.addRectif3("На оплату функциональных и инструментальных исследований УЗИ", 100)
			.addRectif3("На оплату функциональных и инструментальных исследований ЭКГ", 101)
			.addRectif3("На оплату функциональных и инструментальных исследований Рентгенография", 102)
			.addRectif3("На оплату функциональных и инструментальных исследований Эндоскопические исследования", 103)
			.addRectif3("На оплату функциональных и инструментальных исследований КТ", 104)
			.addRectif3("На оплату функциональных и инструментальных исследований МРТ", 105)
			.addRectif3("На оплату функциональных и инструментальных исследований Другое", 106)
			.addRectif3("На приобретение лекарственных средств в период стационарного лечения", 107)
			.addRectif3("На приобретение расходных материалов в период стационарного лечения", 108)
			.addRectif3("За всю оказанную медицинскую помощь", 109);		
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Невыполнение, несвоевременное или ненадлежащее выполнение (без объективных причин) необходимых пациенту диагностических и (или) лечебных мероприятий, оперативных вмешательств в соответствии с порядком оказания медицинской помощи и (или) стандартами медицинской помощи:", 29);
		rectif2
			.addRectif3("не повлиявшее на состояние здоровья застрахованного лица", 110)
			.addRectif3("приведших к удлинению сроков лечения сверх установленных (за исключением случаев отказа застрахованного лица, оформленного в установленном порядке)", 111)
			.addRectif3("приведших к ухудшению состояния здоровья застрахованного лица, либо создавшее риск прогрессирования имеющегося заболевания, либо создавшее риск возникновения нового заболевания (за исключением случаев отказа застрахованного лица от лечения, оформленного в установленном порядке)", 112)
			.addRectif3("приведших к инвалидизации (за исключением случаев отказа застрахованного лица от лечения, оформленного в установленном порядке)", 113)
			.addRectif3("приведших к летальному исходу (за исключением случаев отказа застрахованного лица от лечения, оформленного в установленном порядке)", 114);
		this.rectifs2.put(rectif2.getId(), rectif2);
		rectif2 = new Rectif2L("Выполнение непоказанных, неоправданных с клинической точки зрения и не регламентированных стандартами медицинской помощи мероприятий:", 30);
		rectif2
			.addRectif3("приведших к удлинению сроков лечения, удорожанию стоимости лечения при отсутствии отрицательных последствий для состояния здоровья застрахованного лица", 115)
			.addRectif3("приведших к ухудшению состояния здоровья застрахованного лица, либо создавшее риск прогрессирования имеющегося заболевания, либо создавшее риск возникновения нового заболевания (за исключением случаев отказа застрахованного лица от лечения, оформленного в установленном порядке)", 116);
		this.rectifs2.put(rectif2.getId(), rectif2);

		Rectif3L rectif3 = new Rectif3L("7-10 дней", 10);
		addRectif4Doctor(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("10-14 дней", 11);
		addRectif4Doctor(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("Более 14 дней", 12);
		addRectif4Doctor(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("14-15 дней", 51);
		addRectif4Service(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("15-20 дней", 52);
		addRectif4Service(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("Более 20 дней", 53);
		addRectif4Service(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("Дневной стационар", 70);
		rectif3
			.addRectif4("20-30 дней", 57)
			.addRectif4("30-45 дней", 58)
			.addRectif4("Более 45 дней", 59);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("Стационар", 71);
		rectif3
			.addRectif4("1-2 месяца", 60)
			.addRectif4("2-3 месяца", 61)
			.addRectif4("Более 3 месяцев", 62);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("Поликлиника", 74);
		rectif3
			.addRectif4("За медицинскую помощь Обезболивание", 63)
			.addRectif4("За медицинскую помощь Консультацию врача-специалиста", 64)
			.addRectif4("За медицинскую помощь Физиолечение", 65)
			.addRectif4("За медицинскую помощь Другое", 66)
			.addRectif4("За клинико-лабораторные исследования Общеклинические исследования", 67)
			.addRectif4("За клинико-лабораторные исследования Биохимические исследования", 68)
			.addRectif4("За клинико-лабораторные исследования Гормональные исследования", 69)
			.addRectif4("За клинико-лабораторные исследования Другое", 70)
			.addRectif4("За функциональные и инструментальные исследования УЗИ", 71)
			.addRectif4("За функциональные и инструментальные исследования ЭКГ", 72)
			.addRectif4("За функциональные и инструментальные исследования Рентгенография", 73)
			.addRectif4("За функциональные и инструментальные исследования КТ", 74)
			.addRectif4("За функциональные и инструментальные исследования МРТ", 75)
			.addRectif4("За функциональные и инструментальные исследования Другое", 76)
			.addRectif4("За расходные материалы при проведении лечебно-диагностических мероприятий", 77);			
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("Стационар", 75);
		rectif3
			.addRectif4("За медицинскую помощь Оперативное лечение", 78)
			.addRectif4("За медицинскую помощь Обезболивание", 79)
			.addRectif4("За медицинскую помощь Консультацию врача специалиста", 80)
			.addRectif4("За медицинскую помощь Физиолечения", 81)
			.addRectif4("За медицинскую помощь Другое", 82)
			.addRectif4("За лабораторные исследования Общеклинические исследования", 83)
			.addRectif4("За лабораторные исследования Биохимические исследования", 84)
			.addRectif4("За лабораторные исследования Гормональные исследования", 85)
			.addRectif4("За лабораторные исследования Другое", 86)
			.addRectif4("За функциональные и инструментальные исследования УЗИ", 87)
			.addRectif4("За функциональные и инструментальные исследования ЭКГ", 88)
			.addRectif4("За функциональные и инструментальные исследования Рентгенография", 89)
			.addRectif4("За функциональные и инструментальные исследования КТ", 90)
			.addRectif4("За функциональные и инструментальные исследования МРТ", 91)
			.addRectif4("За функциональные и инструментальные исследования Другое", 92)
			.addRectif4("За лекарственные средства в период стационарного лечения", 93)
			.addRectif4("За расходные материалы в период стационарного лечения", 94)
			.addRectif4("За всю оказанную медицинскую помощь", 95);			
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Обезболивание", 76);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Консультацию врача специалиста", 77);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Физиолечение", 78);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь другое", 79);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Общеклинические исследования", 80);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Биохимические исследования", 81);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Гормональные исследования", 82);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Другое", 83);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований УЗИ", 84);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований ЭКГ", 85);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований Рентгенография", 86);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований КТ", 87);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований МРТ", 88);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований Другое", 89);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За расходные материалы при проведении лечебно-диагностических мероприятий", 90);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Оперативное лечение", 91);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Обезболивание", 92);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Консультацию врача специалиста", 93);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Физиолечение", 94);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За медицинскую помощь Другое", 95);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Общеклинические исследования", 96);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Биохомические исследования", 97);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Гормональные исследования", 98);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За лабораторные исследования Другое", 99);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований УЗИ", 100);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований ЭКГ", 101);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований Рентгенография", 102);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований Эндоскопические исследования", 103);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований КТ", 104);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований МРТ", 105);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На оплату функциональных и инструментальных исследований Другое", 106);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На приобретение лекарственных средств в период стационарного лечения", 107);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("На приобретение расходных материалов в период стационарного лечения", 108);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
		rectif3 = new Rectif3L("За всю оказанную медицинскую помощь", 109);
		addRectif4Pay(rectif3);
		this.rectifs3.put(rectif3.getId(), rectif3);
	}

	private void addRectif4Pay(Rectif3L rectif3) {
		rectif3
			.addRectif4("Заключен договор ДМС", 96)
			.addRectif4("Заплатил в кассу МО", 97)
			.addRectif4("Заплатил лично медицинском работнику", 98)
			.addRectif4("Другое", 99);
	}

	private void addRectif4Service(Rectif3L rectif3) {
		rectif3
			.addRectif4("УЗИ", 51)
			.addRectif4("Рентгенография", 52)
			.addRectif4("ЭКГ", 53)
			.addRectif4("Эндоскопическое исследование", 54)
			.addRectif4("Клинико-лабораторные исследования", 55)
			.addRectif4("Другое", 56);
	}

	private void addRectif4Doctor(Rectif3L rectif3) {
		rectif3
			.addRectif4("АКУШЕР-ГИНЕКОЛОГ", 13)
			.addRectif4("АЛЛЕРГОЛОГ", 14)
			.addRectif4("АНЕСТЕЗИОЛОГ-РЕАНИМАТОЛОГ", 15)
			.addRectif4("ВРАЧ ОБЩЕЙ ВРАЧЕБНОЙ ПРАКТИКИ", 16)
			.addRectif4("ГАСТРОЭНТЕРОЛОГ", 17)
			.addRectif4("ГЕМАТОЛОГ", 18)
			.addRectif4("ГЕНЕТИК", 19)
			.addRectif4("ДЕРМАТОВЕНЕРОЛОГ", 20)
			.addRectif4("ДЕТСКИЙ КАРДИОЛОГ", 21)
			.addRectif4("ДЕТСКИЙ ОНКОЛОГ", 22)
			.addRectif4("ДЕТСКИЙ СТОМАТОЛОГ", 23)
			.addRectif4("ДЕТСКИЙ УРОЛОГ-АНДРОЛОГ", 24)
			.addRectif4("ДЕТСКИЙ ХИРУРГ", 25)
			.addRectif4("ДЕТСКИЙ ЭНДОКРИНОЛОГ", 26)
			.addRectif4("ДИАБЕТОЛОГ", 27)
			.addRectif4("ИНФЕКЦИОНИСТ", 28)
			.addRectif4("КАРДИОЛОГ", 29)
			.addRectif4("НЕВРОЛОГ", 30)
			.addRectif4("НЕЙРОХИРУРГ", 31)
			.addRectif4("НЕОНАТОЛОГ", 32)
			.addRectif4("НЕФРОЛОГ", 33)
			.addRectif4("ОНКОЛОГ", 34)
			.addRectif4("ОТОРИНОЛАРИНГОЛОГ", 35)
			.addRectif4("ОФТАЛЬМОЛОГ", 36)
			.addRectif4("ПЕДИАТР", 37)
			.addRectif4("ПУЛЬМОНОЛОГ", 38)
			.addRectif4("РЕВМАТОЛОГ", 39)
			.addRectif4("СЕРДЕЧНО-СОСУДИСТЫЙ ХИРУРГ", 40)
			.addRectif4("СТОМАТОЛОГ", 41)
			.addRectif4("СУРДОЛОГ-ОТОЛАРИНГОЛОГ", 42)
			.addRectif4("ТЕРАПЕВТ", 43)
			.addRectif4("ТОКСИКОЛОГ", 44)
			.addRectif4("ТОРАКАЛЬНЫЙ ХИРУРГ", 45)
			.addRectif4("ТРАВМАТОЛОГ-ОРТОПЕД", 46)
			.addRectif4("УРОЛОГ", 47)
			.addRectif4("ХИРУРГ", 48)
			.addRectif4("ЧЕЛЮСТНО-ЛИЦЕВОЙ ХИРУРГ", 49)
			.addRectif4("ЭНДОКРИНОЛОГ", 50)
			.addRectif4("ВРАЧ СМП", 100)
			.addRectif4("ВРАЧ УЛЬТРАЗВУКОВОЙ ДИАГНОСТИКИ", 101)
			.addRectif4("РЕНТГЕНОЛОГ", 102);

	}

	private void addRectif3Doctor(Rectif2L rectif2) {
		rectif2
			.addRectif3("АКУШЕР-ГИНЕКОЛОГ", 13)
			.addRectif3("АЛЛЕРГОЛОГ", 14)
			.addRectif3("АНЕСТЕЗИОЛОГ-РЕАНИМАТОЛОГ", 15)
			.addRectif3("ВРАЧ ОБЩЕЙ ВРАЧЕБНОЙ ПРАКТИКИ", 16)
			.addRectif3("ГАСТРОЭНТЕРОЛОГ", 17)
			.addRectif3("ГЕМАТОЛОГ", 18)
			.addRectif3("ГЕНЕТИК", 19)
			.addRectif3("ДЕРМАТОВЕНЕРОЛОГ", 20)
			.addRectif3("ДЕТСКИЙ КАРДИОЛОГ", 21)
			.addRectif3("ДЕТСКИЙ ОНКОЛОГ", 22)
			.addRectif3("ДЕТСКИЙ СТОМАТОЛОГ", 23)
			.addRectif3("ДЕТСКИЙ УРОЛОГ-АНДРОЛОГ", 24)
			.addRectif3("ДЕТСКИЙ ХИРУРГ", 25)
			.addRectif3("ДЕТСКИЙ ЭНДОКРИНОЛОГ", 26)
			.addRectif3("ДИАБЕТОЛОГ", 27)
			.addRectif3("ИНФЕКЦИОНИСТ", 28)
			.addRectif3("КАРДИОЛОГ", 29)
			.addRectif3("НЕВРОЛОГ", 30)
			.addRectif3("НЕЙРОХИРУРГ", 31)
			.addRectif3("НЕОНАТОЛОГ", 32)
			.addRectif3("НЕФРОЛОГ", 33)
			.addRectif3("ОНКОЛОГ", 34)
			.addRectif3("ОТОРИНОЛАРИНГОЛОГ", 35)
			.addRectif3("ОФТАЛЬМОЛОГ", 36)
			.addRectif3("ПЕДИАТР", 37)
			.addRectif3("ПУЛЬМОНОЛОГ", 38)
			.addRectif3("РЕВМАТОЛОГ", 39)
			.addRectif3("СЕРДЕЧНО-СОСУДИСТЫЙ ХИРУРГ", 40)
			.addRectif3("СТОМАТОЛОГ", 41)
			.addRectif3("СУРДОЛОГ-ОТОЛАРИНГОЛОГ", 42)
			.addRectif3("ТЕРАПЕВТ", 43)
			.addRectif3("ТОКСИКОЛОГ", 44)
			.addRectif3("ТОРАКАЛЬНЫЙ ХИРУРГ", 45)
			.addRectif3("ТРАВМАТОЛОГ-ОРТОПЕД", 46)
			.addRectif3("УРОЛОГ", 47)
			.addRectif3("ХИРУРГ", 48)
			.addRectif3("ЧЕЛЮСТНО-ЛИЦЕВОЙ ХИРУРГ", 49)
			.addRectif3("ЭНДОКРИНОЛОГ", 50)
			.addRectif3("ВРАЧ СМП", 117)
			.addRectif3("ВРАЧ УЛЬТРАЗВУКОВОЙ ДИАГНОСТИКИ", 118)
			.addRectif3("РЕНТГЕНОЛОГ", 119);
	}

	private void addRectif2Act(Rectif1L rectif1) {
		rectif1
			.addRectif2("Доказанные в установленном порядке случаи нарушения врачебной этики и деонтологии работниками медицинской организации (устанавливаются по обращениям застрахованных лиц)", 28)
			.addRectif2("Невыполнение, несвоевременное или ненадлежащее выполнение (без объективных причин) необходимых пациенту диагностических и (или) лечебных мероприятий, оперативных вмешательств в соответствии с порядком оказания медицинской помощи и (или) стандартами медицинской помощи:", 29)
			.addRectif2("Выполнение непоказанных, неоправданных с клинической точки зрения и не регламентированных стандартами медицинской помощи мероприятий:", 30)
			.addRectif2("Преждевременное с клинической точки зрения прекращение проведения лечебных мероприятий при отсутствии клинического эффекта (кроме оформленных в установленном порядке случаев отказа от лечения)", 31)
			.addRectif2("Повторное обоснованное обращение застрахованного лица за медицинской помощью по поводу того же заболевания в течение 30 дней со дня завершения амбулаторного лечения и 90 дней со дня завершения лечения в стационаре вследствие отсутствия положительной динамики в состоянии здоровья, подтвержденное проведенной целевой или плановой экспертизой (за исключением случаев этапного лечения, хронических заболеваний и случаев не связанных с действиями (бездействиями) медицинских работников).", 32)
			.addRectif2("Нарушение по вине медицинской организации преемственности в лечении (в том числе несвоевременный перевод пациента в медицинскую организацию более высокого уровня), приведшее к удлинению сроков лечения и (или) ухудшению состояния здоровья застрахованного лица", 33)
			.addRectif2("Госпитализация застрахованного лица без медицинских показаний (необоснованная госпитализация), медицинская помощь которому могла быть предоставлена в установленном объеме в амбулаторно-поликлинических условиях, в условиях дневного стационара.", 34)
			.addRectif2("Госпитализация застрахованного лица, медицинская помощь которому должна быть оказана в стационаре другого профиля (непрофильная госпитализация), кроме случаев госпитализации по неотложным показаниям", 35)
			.addRectif2("Необоснованное удлинение сроков лечения по вине медицинской организации, а также увеличение количества медицинских услуг, посещений, койко-дней, не связанное с проведением диагностических, лечебных мероприятий, оперативных вмешательств в рамках стандартов медицинской помощи", 36)
			.addRectif2("Повторное посещение врача одной и той же специальности в один день при оказании амбулаторной медицинской помощи, за исключением повторного посещения для определения показаний к госпитализации, операции, консультациям в других медицинских организациях.", 37)
			.addRectif2("Действие или бездействие медицинского персонала, обусловившее развитие нового заболевания застрахованного лица (развитие ятрогенного заболевания)", 38)
			.addRectif2("Необоснованное назначение лекарственной терапии; одновременное назначение лекарственных средств – синонимов, аналогов или антагонистов по фармакологическому действию и т.п., связанное с риском для здоровья пациента и/или приводящее к удорожанию лечения", 39)
			.addRectif2("Невыполнение по вине медицинской организации обязательного патологоанатомического вскрытия в соответствии с действующим законодательством.", 40)
			.addRectif2("Наличие расхождений клинического и патологоанатомического диагнозов 2-3 категории", 41);
	}

	private void addRectif2Hospital(Rectif1L rectif1) {
		rectif1
			.addRectif2("ПОЛИКЛИНИКА", 26)
			.addRectif2("СТАЦИОНАР", 27);
	}

	private void addRectif2Pay(Rectif1L rectif1) {
		rectif1
			.addRectif2("Недействительность полиса ОМС", 23)
			.addRectif2("Требование оплаты за медицинскую помощь", 24)
			.addRectif2("Другое", 25);
	}

	private void addRectif2Denied(Rectif1L rectif1) {
		rectif1
			.addRectif2("ОТКАЗ", 5)
			.addRectif2("ДРУГОЕ", 6);
	}

	private void addRectif2Smo(Rectif1L rectif1) {
		rectif1
			.addRectif2("ООО СМО «СИМАЗ-МЕД»", 1)
			.addRectif2("ФИЛИАЛ «НОВОСИБИРСК-МЕДИЦИНА» ОАО «РОСНО-МС»", 2)
			.addRectif2("ФИЛИАЛ ОАО «СК «ИНГОССТРАХ-М» В Г. НОВОСИБИРСК", 3);
	}
	
}
