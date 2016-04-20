<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<sec:authentication var="principal" property="principal" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery-1.6.1.min.js" />"></script>
	
	
	<c:url var="findTypesURL" value="/types" />
	<c:url var="findCausesURL" value="/causes" />
	<c:url var="findRectifs1URL" value="/rectifs1" />
	<c:url var="findRectifs2URL" value="/rectifs2" />
	<c:url var="findRectifs3URL" value="/rectifs3" />
	<c:url var="findRectifs4URL" value="/rectifs4" />
	
	<script>
	
	function cancelback() {
		parent.history.back();
		};

	
	function numberone() {
		console.log('@@ '+$('#sel').val());
		if($('#sel').val() != '0'){
			
			$('#addpetit').prop('disabled', false);
		}
		else{
			$('#addpetit').prop('disabled', true);
			}
		
	 }	

		
	$(document).ready(
			
		function() {
			$.getJSON('${findTypesURL}', {
				ajax : 'true'
			}, function(data) {
				var html = '<option value="0"></option>';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
				}
				html += '</option>';

				$('#type').html(html);
			});
		}
	)
		
	</script>
	<script type="text/javascript">
	$(document).ready(function() { 
		$('#type').change(
				function() {
					$.getJSON('${findCausesURL}', {
						typeName : $(this).val(),
						ajax : 'true'
					}, function(data) {
						var html = '<option value="0"></option>';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
						}
						html += '</option>';
	
						$('#cause').html(html);
					});
				});
	});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cause").change(onSelectChange);
		});
	
		function onSelectChange() {
			var selected = $("#cause option:selected");		
			var output = "";
			if(selected.val() != 0){
				output = selected.text();
			}
			$("#output").html(output);
		}
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() { 
		$('#cause').change(
			function() {
				$.getJSON('${findRectifs1URL}', {
					causeName : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="0"></option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
					}
					html += '</option>';

					$('#rectif1').html(html);
				});
			});
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#rectif1").change(onSelectChange);
		});
	
		function onSelectChange() {
			var selected = $("#rectif1 option:selected");		
			var output = "";
			if(selected.val() != 0){
				output = selected.text();
			}
			$("#output").html(output);
		}
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() { 
		$('#rectif1').change(
			function() {
				$.getJSON('${findRectifs2URL}', {
					rectif1Name : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="0"></option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
					}
					html += '</option>';

					$('#rectif2').html(html);
				});
			});
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#rectif2").change(onSelectChange);
		});
	
		function onSelectChange() {
			var selected = $("#rectif2 option:selected");		
			var output = "";
			if(selected.val() != 0){
				output = selected.text();
			}
			$("#output").html(output);
		}
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() { 
		$('#rectif2').change(
			function() {
				$.getJSON('${findRectifs3URL}', {
					rectif2Name : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="0"></option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
					}
					html += '</option>';

					$('#rectif3').html(html);
				});
			});
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#rectif3").change(onSelectChange);
		});
	
		function onSelectChange() {
			var selected = $("#rectif3 option:selected");		
			var output = "";
			if(selected.val() != 0){
				output = selected.text();
			}
			$("#output").html(output);
		}
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() { 
		$('#rectif3').change(
			function() {
				$.getJSON('${findRectifs4URL}', {
					rectif3Name : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="0"></option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
					}
					html += '</option>';

					$('#rectif4').html(html);
				});
			});
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#rectif4").change(onSelectChange);
		});
	
		function onSelectChange() {
			var selected = $("#rectif4 option:selected");		
			var output = "";
			if(selected.val() != 0){
				output = selected.text();
			}
			$("#output").html(output);
		}
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(".hide").hide();
			$(".btn-slide").click(function(){
		        $(".hide").slideToggle("slow");
		        $(this).toggleClass("active");
		    });
		});
	</script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
	
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<c:url value="/resources/jquery/ui/1.11.2/themes/smoothness/jquery-ui.css"/>">
	<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/bliking.css"/>" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>" type="text/css"/>
	<script src="<c:url value="/resources/jquery/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/jquery/ui/1.11.2/jquery-ui.js"/>"></script>
	<script>
		$(function() {
			$( "#dateInput" ).datepicker({dateFormat:'dd.mm.yy'});
		});
	</script>
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
<c:if test="${petit.id eq null}">
<h3><spring:message code="label.petits" /></h3>
</c:if>
<c:if test="${petit.id ne null}">
<h3><spring:message code="label.nepetits" /></h3>
</c:if>

<form:form method="post" action="add" commandName="petit" name='petit_form'>
<form:errors path="*" cssClass="errorblock" element="div" />
	<table>
		<tr>
			<form:hidden path="id" name='id'/>
			<form:hidden path="num"/>
			
			
				
			<c:if test="${petit.id eq null}">
				<td>
					<form:label path="dateInput"><spring:message code="label.dateInput" /></form:label>
				</td>
				<td>
					<form:input class="css-input" id="dateInput" path="dateInput"/>
				</td>
				
				<form:hidden path="blockger2016.state" value="${1}" />
				
				<sec:authorize access="hasRole('ROLE_TFOMS')">
					<form:hidden path="blockger2016.regsource_id" value="${1}" />
					<form:hidden path="blockger2016.regname" value="${principal.username}" />
				</sec:authorize>
				
				
				
			</c:if>
		
				
			<c:if test="${petit.id ne null}">
				<form:hidden id="dateInput" path="dateInput"/>
				<spring:message code="label.id" />&nbsp<c:out value="${petit.num}" />&nbsp&nbsp&nbsp&nbsp<spring:message code="label.dateInput" />&nbsp<c:out value="${petit.dateInput}" />
				<c:set var="statec2" value="${petit.blockger2016.state}"/>
					<c:if test="${(statec2 == 3)}">
						&nbsp<spring:message code="label.dateand" />&nbsp<c:out value="${petit.blockger2016.date_end}" />
					</c:if>				
				
				
				<form:hidden path="blockger2016.idblockger2016"/>
				<form:hidden path="blockger2016.state" value="${2}" />
				<form:hidden path="blockger2016.regsource_id"/>
				<form:hidden path="blockger2016.regname"/>
				
				<!-- Если пользователь проваливается в форму редактирования  при state =3 (завершен)
				то передаем тот же самый date_end по новой и в базе срабатывает триггер иначе в базу добавить пустая date_end-->
				<input type="hidden" name="fil" value="${petit.blockger2016.date_end}"/>
				
				
			</c:if>
			
			<!-- <td><form:label path="dateBegin"><spring:message code="label.dateBegin" /></form:label></td>
			<td><form:input class="css-input" path="dateBegin" /></td>
			
			<td><form:label path="dateEnd"><spring:message code="label.dateEnd" /></form:label></td>
			<td><form:input class="css-input" path="dateEnd" /></td>-->
		</tr>
		<tr>	
			<td><form:label path="sourceId"><spring:message code="label.source" /></form:label></td>
			<td><form:select path="sourceId">
				<form:options items="${sourceList}"/>
			</form:select></td>
			
			<td><form:label path="conectId"><spring:message code="label.conect" /></form:label></td>
			<td><form:select path="conectId">
				<form:option value="0" label="" />
    			<form:options items="${conectList}"/>
			</form:select></td>

			<!--<td><form:label path="intermedId"><spring:message code="label.intermed" /></form:label></td>
			<td><form:select path="intermedId">
    			<form:options items="${intermedList}"/>
			</form:select></td>-->
		</tr>
		<tr>			
			<td><form:label path="presentId"><spring:message code="label.present" /></form:label></td>
			<td><form:select path="presentId">
    			<form:options items="${presentList}"/>
			</form:select></td>
			
			<td><form:label path="letterNum"><spring:message code="label.letterNum" /></form:label></td>
			<td><form:input class="css-input" path="letterNum" /></td>
			
			<td><form:label path="letterDate"><spring:message code="label.letterDate" /></form:label></td>
			<td><form:input class="css-input" path="letterDate" /></td>
		</tr>
	</table>
	<br>
	<table>			
		<tr>
			<td><form:label path="surname"><spring:message code="label.surname" /></form:label></td>
			<td><form:input class="css-input" path="surname" /></td>

			<td><form:label path="name"><spring:message code="label.name" /></form:label></td>
			<td><form:input class="css-input" path="name" /></td>

			<td><form:label path="patrony"><spring:message code="label.patrony" /></form:label></td>
			<td><form:input class="css-input" path="patrony" /></td>
		</tr>
		<tr>
			<td><form:label path="policy"><spring:message code="label.policy" /></form:label></td>
			<td><form:input class="css-input" path="policy" /></td>

			<td><form:label path="tel"><spring:message code="label.tel" /></form:label></td>
			<td><form:input class="css-input" path="tel" /></td>

			<td><form:label path="adress"><spring:message code="label.adress" /></form:label></td>
			<td><form:input class="css-input" path="adress" /></td>
		</tr>
	</table>
	<br>
	<table>			
		<tr>
			<td><form:label path="terId"><spring:message code="label.ter" /></form:label></td>
			<td><form:select path="terId">
				<form:option value="54" label="54 Новосибирскaя область" />
    			<form:options items="${terList}"/>
			</form:select></td>
	
			<td><form:label path="terAnswerId"><spring:message code="label.terAnswer" /></form:label></td>
			<td><form:select path="terAnswerId">
				<form:option value="54" label="54 Новосибирскaя область" />				
    			<form:options items="${terList}"/>
			</form:select></td>
		</tr>
	</table>
	<table>	
		<tr>
			<td><form:label path="typeId"><spring:message code="label.type" /></form:label></td>
			<td><span id="typeWarning" style="color:#ff8000">!
				<span style="font-size:8">${petit.type.typeName}</span>
			</span>
			<form:select id="type" path="typeId"
			onchange="document.getElementById('typeWarning').hidden = true;"
			></form:select>
			</td>
		</tr>
		<tr>			
			<td><form:label path="causeId"><spring:message code="label.cause" /></form:label></td>
			<td><span id="causeWarning" style="color:#ff8000">!
				<span style="font-size:8">${petit.cause.causeName}</span>
			</span><form:select id="cause" path="causeId"
			onchange="document.getElementById('causeWarning').hidden = true;"
			></form:select></td>
		</tr>
		<tr>			
			<td><form:label path="rectif1Id"><spring:message code="label.rectif1" /></form:label></td>
			<td><span id="rectif1Warning" style="color:#ff8000">!
				<span style="font-size:8">${petit.rectif1.rectif1Name}</span>
			</span><form:select id="rectif1" path="rectif1Id"
			onchange="document.getElementById('rectif1Warning').hidden = true;"
			></form:select></td>
		</tr>
	</table>
	<div class='hide'>
	<table>			
		<tr>	
			<td><form:label path="rectif2Id"><spring:message code="label.rectif2" /></form:label></td>
			<td>
				<span id="rectif2Warning" style="color:#ff8000;font-size:8">${petit.rectif2.rectif2Name}</span>
			<form:select id="rectif2" path="rectif2Id"
			onchange="document.getElementById('rectif2Warning').hidden = true;"
			>
			</form:select></td>
		</tr>
		<tr>	
			<td><form:label path="rectif3Id"><spring:message code="label.rectif3" /></form:label></td>
			<td>
				<span id="rectif3Warning" style="color:#ff8000;font-size:8">${petit.rectif3.rectif3Name}</span>
			<form:select id="rectif3" path="rectif3Id"
			onchange="document.getElementById('rectif3Warning').hidden = true;"
			>
			</form:select></td>
		</tr>
		<tr>	
			<td><form:label path="rectif4Id"><spring:message code="label.rectif4" /></form:label></td>
			<td>
				<span id="rectif4Warning" style="color:#ff8000;font-size:8">${petit.rectif4.rectif4Name}</span>
			<form:select id="rectif4" path="rectif4Id"
			onchange="document.getElementById('rectif4Warning').hidden = true;"
			>
			</form:select></td>
		</tr>
	</table>
	</div>
	<div class='hide'>
	<table>
		<tr>
			<td><form:label path="last1"><spring:message code="label.last1" /></form:label></td>
			<td><form:input class="css-input" path="last1" /></td>
	
			<td><form:label path="last2"><spring:message code="label.last2" /></form:label></td>
			<td><form:input class="css-input" path="last2" /></td>
			
			<td><form:label path="hspId"><spring:message code="label.hsp" /></form:label></td>
			<td><form:select path="hspId">
				<form:option value="0" label="" />
    			<form:options items="${hspList}"/>
			</form:select></td>
						
		</tr>
	</table>
	</div>
	<div class='hide'>
	<table>		
		<tr>
			<td><form:label path="moId"><spring:message code="label.mo" /></form:label></td>
			<td><form:select path="moId">
				<form:option value="0" label="" />
    			<form:options items="${moList}"/>
			</form:select></td>
			
			<td><form:label path="insurId"><spring:message code="label.insur" /></form:label></td>
			<td><form:select path="insurId">
				<form:option value="0" label="" />
    			<form:options items="${insurList}"/>
			</form:select></td>
			
			<!--<td><form:label path="placeId"><spring:message code="label.place" /></form:label></td>
			<td><form:select path="placeId">
    			<form:options items="${placeList}"/>
			</form:select></td>-->
		</tr>
	</table>
	</div>
	<div class='hide'>
	<table>
		<tr>
			<td><form:label path="validId"><spring:message code="label.valid" /></form:label></td>
			<td><form:select path="validId">
				<form:option value="0" label="" />
    			<form:options items="${validList}"/>
			</form:select></td>
	
			<td><form:label path="compens"><spring:message code="label.compens" /></form:label></td>
			<td><form:input class="css-input" path="compens" /></td>
	
			<td><form:label path="satisf"><spring:message code="label.satisf" /></form:label></td>
			<td><form:input class="css-input" path="satisf" /></td>
	
			<td><form:label path="compensSource"><spring:message code="label.compensSource" /></form:label></td>
			<td><form:input class="css-input" path="compensSource" /></td>
	
			<td><form:label path="compensCode"><spring:message code="label.compensCode" /></form:label></td>
			<td><form:input class="css-input" path="compensCode" /></td>
	
			<td><form:label path="compensSum"><spring:message code="label.compensSum" /></form:label></td>
			<td><form:input class="css-input" path="compensSum" /></td>
		</tr>
	</table>
	</div>
	<div class='hide'>
	<table>		
<!-- 	<tr>
			<td><form:label path="propos"><spring:message code="label.propos" /></form:label></td>
			<td><form:textarea rows="2" cols="100" value="0" path="propos" /></td>
		</tr>
-->		
		<tr>
			<td><form:label path="causeNote"><spring:message code="label.causeNote" /></form:label></td>
			<td><form:textarea rows="2" cols="100" value="0" path="causeNote" /></td>
		</tr>
	</table>
	</div>
	<table>
		<tr>
			<td>
				<input class='btn-slide' type="button" value="<spring:message code="label.more"/>"/>
			</td>
		</tr>
		<tr>	
			<td>
				<c:if test="${petit.id ne null}">
					<input name="cancel_button" onclick="cancelback()" type="button" value="<spring:message code="label.cancelpetit"/>"/>
					<input name="submit" type="submit" value="<spring:message code="label.editpetit"/>" 
						onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
					/>
					
					<c:set var="gu" value="${petit.blockger2016.state}"/>
					<c:if test="${(gu < 3)}">	
						<input name="submit" type="submit" value="<spring:message code="label.endpetit"/>" 
							onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
						/>
					</c:if>	
				</c:if>
				
				<c:if test="${petit.id eq null}">
				<form:select id="sel" path="sourceId" onclick="numberone()">
					<form:option label="Назначить"  value="0" />
					<form:options items="${listassign}"/>
				</form:select>
				
					<input type="submit" id="addpetit" name="submit" value="<spring:message code="label.addpetit"/>" disabled="disabled" 
						onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
					/>
					
					<input name="submit" type="submit" value="<spring:message code="label.endpetit"/>" 
						onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
					/>
				</c:if>
			</td>
		</tr>
	</table>

</form:form>


<hr>
<c:if test="${petit.id eq null}">
<section> <!--for demo wrap-->
<div  class="tbl-header">
<table class="tabmy" cellpadding="0" cellspacing="0" border="0">
  <thead>
  <tr>
			<th><spring:message code="label.id" /></th>      
		    <th><spring:message code="label.dateInput" /></th>
		    <!-- <th><spring:message code="label.dateBegin" /></th>
		    <th><spring:message code="label.dateEnd" /></th>-->         
		    <th><spring:message code="label.source" /></th>
		    <th><spring:message code="label.present" /></th>
		    <th><spring:message code="label.letterNum" /></th>
		    <th><spring:message code="label.mo" /></th>
		    <!--<th><spring:message code="label.letterDate" /></th>
		    <th><spring:message code="label.conect" /></th>
		    <th><spring:message code="label.intermed" /></th>-->
		    <th><spring:message code="label.type" /></th>
		    <th><spring:message code="label.surname" /></th>
		    <th><spring:message code="label.name" /></th>
		    <!--<th><spring:message code="label.patrony" /></th>
		    <th><spring:message code="label.policy" /></th>
		    <th><spring:message code="label.tel" /></th>
		    <th><spring:message code="label.adress" /></th> -->
		    <th><spring:message code="label.ter" /></th>
		    <!--<th><spring:message code="label.terAnswer" /></th>
		    <th><spring:message code="label.last1" /></th>
		    <th><spring:message code="label.last2" /></th>
		    <th><spring:message code="label.hsp" /></th>
		    <th><spring:message code="label.insur" /></th>
		    <th><spring:message code="label.place" /></th>-->
		    <th><spring:message code="label.cause" /></th>
		    <th><spring:message code="label.rectif1" /></th>
		    <!--<th><spring:message code="label.rectif2" /></th>
		    <th><spring:message code="label.rectif3" /></th>
		    <th><spring:message code="label.rectif4" /></th>-->
		    <th><spring:message code="label.valid" /></th>
		    <!-- <th><spring:message code="label.compens" /></th>-->
		    <th><spring:message code="label.satisf" /></th>
		    <!-- <th><spring:message code="label.compensSource" /></th>
		    <th><spring:message code="label.compensCode" /></th>
		    <th><spring:message code="label.compensSum" /></th>
		    <th><spring:message code="label.propos" /></th>-->
		    <th><spring:message code="label.username" /></th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
    </tr>
      
  </thead>
</table>
</div>
<div  class="tbl-content">
<table class="tabmy" cellpadding="0" cellspacing="0" border="0">
  <tbody>
  <c:forEach items="${petitList}" var="petit">
  <c:set var="statecl" value="${petit.blockger2016.state}"/>
		<c:if test="${(statecl == 1)}">
	  		<c:set value="someclass blink" var="cssClass"></c:set>
		</c:if>
		<c:if test="${(statecl == 2)}">
	  		<c:set value="someclass2" var="cssClass"></c:set>
		</c:if> 
		<c:if test="${(statecl != 1 && statecl != 2 )}">
	  		<c:set value="someclass3" var="cssClass"></c:set>
		</c:if> 
    <tr class="${cssClass}">
      			<!--<td>${petit.id}</td>-->
				<td>${petit.num}</td>      
			    <td>${petit.dateInput}</td>         
			    <!-- <td>${petit.dateBegin}</td>
			    <td>${petit.dateEnd}</td>-->
			    <td>${petit.source.sourceName}</td>
			    <td>${petit.present.presentName}</td>
			    <td>${petit.letterNum}</td>
			    <td>${petit.mo.moName}</td>
			    <!--<td>${petit.letterDate}</td>
			    <td>${petit.conect.conectName}</td>
			    <td>${petit.intermedId}</td>-->
			    <td>${petit.type.typeName}</td>
			    <td>${petit.surname}</td>
			    <td>${petit.name}</td>
			    <!--<td>${petit.patrony}</td>
			    <td>${petit.policy}</td>
			    <td>${petit.tel}</td>
			    <td>${petit.adress}</td> -->
			    <td>${petit.ter.terName}</td>
			    <!--<td>${petit.terAnswer.terName}</td>
			    <td>${petit.last1}</td>
			    <td>${petit.last2}</td>
			    <td>${petit.hspId}</td>
			    <td>${petit.insurId}</td>	
			    <td>${petit.placeId}</td>-->
			    <td>${petit.cause.causeName}</td>
			    <td>${petit.rectif1.rectif1Name}</td>
			    <!--<td>${petit.rectif2.rectif2Name}</td>
			    <td>${petit.rectif3.rectif3Name}</td>
			    <td>${petit.rectif4.rectif4Name}</td>-->
			    <td>${petit.valid.validName}</td>
			    <!-- <td>${petit.compens}</td>-->
			    <td>${petit.satisf}</td>
			    <!-- <td>${petit.compensSource}</td>
			    <td>${petit.compensCode}</td>
			    <td>${petit.compensSum}</td>
			    <td>${petit.propos}</td>-->
			    <td>${petit.username}</td>
				<td><a id="iddel" href="delete/${petit.id}" title="Удалить"><i class="fa fa-trash-o fa-3x"></i></a></td>
				<td><a id="iddel" href="refresh/${petit.id}" title="Редактировать"><i class="fa fa-pencil-square-o  fa-3x" aria-hidden="true"></i></a></td>

			    
			    
    </tr>
  </c:forEach>  
  </tbody>
</table>
</div>
</section>
</c:if>
</body>
</html>