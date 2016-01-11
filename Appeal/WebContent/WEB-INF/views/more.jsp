<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
	
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>" type="text/css"/>
		
</head>
<body>

<div id = top-menu>

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
<a href="<c:url value="/index" />">
	<spring:message code="label.index" />
</a>
<a href="<c:url value="/searching" />">
	<spring:message code="label.searching" />
</a>
<a href="<c:url value="/reporting" />">
	<spring:message code="label.report" />
</a>
</div>
<div id = main-menu>
<h2><spring:message code="label.title" /></h2>
</div>
<div id = main>
<h3><spring:message code="label.more" /></h3>
<table class="data">
	<tr><td><spring:message code="label.id"/></td><td>${petit.num}</td></tr>
	<tr><td><spring:message code="label.dateInput"/></td><td>${petit.dateInput}</td></tr>
	<tr><td><spring:message code="label.dateBegin"/></td><td>${petit.dateBegin}</td></tr>
	<tr><td><spring:message code="label.dateEnd"/></td><td>${petit.dateEnd}</td></tr>
	<tr><td><spring:message code="label.source"/></td><td>${petit.source.sourceName}</td></tr>
	<tr><td><spring:message code="label.present"/></td><td>${petit.present.presentName}</td></tr>
	<tr><td><spring:message code="label.letterNum"/></td><td>${petit.letterNum}</td></tr>
	<tr><td><spring:message code="label.letterDate"/></td><td>${petit.letterDate}</td></tr>
	<tr><td><spring:message code="label.conect"/></td><td>${petit.conect.conectName}</td></tr>
	<tr><td><spring:message code="label.intermed"/></td><td>${petit.intermedId}</td></tr>
	<tr><td><spring:message code="label.type"/></td><td>${petit.type.typeName}</td></tr>
	<tr><td><spring:message code="label.surname"/></td><td>${petit.surname}</td></tr>
	<tr><td><spring:message code="label.name"/></td><td>${petit.name}</td></tr>
	<tr><td><spring:message code="label.patrony"/></td><td>${petit.patrony}</td></tr>
	<tr><td><spring:message code="label.policy"/></td><td>${petit.policy}</td></tr>
	<tr><td><spring:message code="label.tel"/></td><td>${petit.tel}</td></tr>
	<tr><td><spring:message code="label.adress"/></td><td>${petit.adress}</td></tr>
	<tr><td><spring:message code="label.ter"/></td><td>${petit.ter.terName}</td></tr>
	<tr><td><spring:message code="label.terAnswer"/></td><td>${petit.terAnswer.terName}</td></tr>
	<tr><td><spring:message code="label.last1"/></td><td>${petit.last1}</td></tr>
	<tr><td><spring:message code="label.last2"/></td><td>${petit.last2}</td></tr>
	<tr><td><spring:message code="label.mo"/></td><td>${petit.mo.moName}</td></tr>
	<tr><td><spring:message code="label.hsp"/></td><td>${petit.hsp.hspName}</td></tr>
	<tr><td><spring:message code="label.insur"/></td><td>${petit.insur.insurName}</td>	</tr>
	<tr><td><spring:message code="label.place"/></td><td>${petit.placeId}</td></tr>
	<tr><td><spring:message code="label.cause"/></td><td>${petit.cause.causeName}</td></tr>
	<tr><td><spring:message code="label.rectif1"/></td><td>${petit.rectif1.rectif1Name}</td></tr>
	<tr><td><spring:message code="label.rectif2"/></td><td>${petit.rectif2.rectif2Name}</td></tr>
	<tr><td><spring:message code="label.rectif3"/></td><td>${petit.rectif3.rectif3Name}</td></tr>
	<tr><td><spring:message code="label.rectif4"/></td><td>${petit.rectif4.rectif4Name}</td></tr>
	<tr><td><spring:message code="label.valid"/></td><td>${petit.valid.validName}</td></tr>
	<tr><td><spring:message code="label.compens"/></td><td>${petit.compens}</td></tr>
	<tr><td><spring:message code="label.satisf"/></td><td>${petit.satisf}</td></tr>
	<tr><td><spring:message code="label.compensSource"/></td><td>${petit.compensSource}</td></tr>
	<tr><td><spring:message code="label.compensCode"/></td><td>${petit.compensCode}</td></tr>
	<tr><td><spring:message code="label.compensSum"/></td><td>${petit.compensSum}</td></tr>
	<tr><td><spring:message code="label.propos"/></td><td>${petit.propos}</td></tr>
	<tr><td><spring:message code="label.username"/></td><td>${petit.username}</td></tr>
	<tr><td><spring:message code="label.causeNote"/></td><td>${petit.causeNote}</td></tr>
	<tr></tr>
	<tr><td><a href="refresh/${petit.id}"><spring:message code="label.correct" /></a></td></tr>
</table>
</div>
</body>
</html>