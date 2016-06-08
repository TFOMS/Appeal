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
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
	
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/logosheader.css" />
	<link rel="stylesheet" href="<c:url value="/resources/jquery/ui/1.11.2/themes/smoothness/jquery-ui.css"/>">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome-4.6.1/css/font-awesome.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/bliking.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/style2.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/newform.css"/>" type="text/css"/>
	<script src="<c:url value="/resources/jquery/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/jquery/ui/1.11.2/jquery-ui.js"/>"></script>
	
	
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
		if($('#sel').val() != '0'){
			
			$('#addpetit').prop('disabled', false);
		}
		else{
			$('#addpetit').prop('disabled', true);
			}
		
	 }	

	function refreshp() {
		location.reload();
	 }	
	function refreshnightcall() {
		location.href='refnc';
	 }	

	function downcall() {
		location.href='nightcallfile';
	 }	

	function changepresentId() {
		if($("#presentId" ).val() !=1){
			$('#inboundLetter').fadeIn();
			$('#addpetit').fadeOut();
			$('#sel').fadeOut();
		}else{
			$('#inboundLetter').fadeOut();
			$('#addpetit').fadeIn();
			$('#sel').fadeIn();
			
		}
		
	 }
		
	$(document).ready(function() {
		
			if($("#presentId" ).val() !=1){
				$('#inboundLetter').fadeIn();
				$('#addpetit').fadeOut();
				$('#sel').fadeOut();
			}else{
				$('#inboundLetter').fadeOut();
				$('#addpetit').fadeIn();
				$('#sel').fadeIn();
			}
		
			var user = '${principal.username}';
			if(user != 'ernso' && user != 'call5001' && user != 'call5002' && user != 'call5003'
				&& user != 'callnight5001'
				&& user != 'callnight5002'
				&& user != 'callnight5003'){
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

			if(user =='callnight5001' || user =='callnight5002' || user =='callnight5003')
			{
				if(location.href.indexOf("index")>=0)
				{
					$('#draggable').hide();
					$('#main').addClass('forrefresh');
					console.log('test ');
				}
				
			}
	});
		
	</script>
	<script type="text/javascript">
	$(document).ready(function() { 
		// добовляем стиль css если адрес сайта содердит refresh 
		if(window.location.href.indexOf("refresh") > -1) {
				$('#main').addClass('forrefresh');
		    }

		
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

			$(".hide2").hide();
			$(".btn-slide2").click(function(){
		        $(".hide2").slideToggle("slow");
		        $(this).toggleClass("active");
		    });
		});
	</script>
	
	<script>
		$(function() {
			$( "#dateInput" ).datepicker({dateFormat:'dd.mm.yy'});
			$( "#dateInput" ).datepicker( "setDate", new Date());
		});
		$(function() {
			$( "#datebetween" ).datepicker({dateFormat:'dd.mm.yy'});
		});
		$(function() {
			$( "#date_med_doc" ).datepicker({dateFormat:'dd.mm.yy'});
		});
		$(function() {
			$( "#date_passOmer" ).datepicker({dateFormat:'dd.mm.yy'});
		});
		$(function() {
			$( "#date_receive" ).datepicker({dateFormat:'dd.mm.yy'});
		});
		$(function() {
			$( "#date_response" ).datepicker({dateFormat:'dd.mm.yy'});
		});
		
	</script>
	<script>
		//setTimeout ("$('body').animate({opacity: 1}, 3000 );", 10);
		$(document).ready(function() 
		{	
		setInterval(function () {
		
		setTimeout ("$('#tf').removeClass('tfoms').addClass('tfoms2');", 1000);//+4
		setTimeout ("$('#tf').removeClass('tfoms2').addClass('tfoms');", 8000);
		
		setTimeout ("$('#simaz').removeClass('sim').addClass('sim2');", 12000);
		setTimeout ("$('#simaz').removeClass('sim2').addClass('sim');", 19000);
		
		setTimeout ("$('#rosno').removeClass('ro').addClass('ro2');", 23000);
		setTimeout ("$('#rosno').removeClass('ro2').addClass('ro');", 30000);
		
		setTimeout ("$('#ingos').removeClass('in').addClass('in2');", 34000);
		setTimeout ("$('#ingos').removeClass('in2').addClass('in');", 41000);
            
        }, 45000);
		
		
		});

		 $(function() {
			    $( "#draggable" ).draggable();
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
<div style="float:right; margin-right:15px; font-weight: bold;">
	<i class="fa fa-user" aria-hidden="true"></i> Пользователь: <c:out value="${principal.username}"/>
</div>

</div>
<div id ="main-menu">
<div style="float:left; padding: 10px;">
<i style="margin-left:10px;" class="fa fa-heartbeat fa-2x " aria-hidden="true"></i>
<i style="margin-left:5px;" class="fa fa-phone-square fa-2x" aria-hidden="true"></i>
<i style="margin-left:5px;" class="fa fa-headphones fa-2x" aria-hidden="true"></i>
<h2 style="display: -webkit-inline-box;display: -moz-inline-box;display: -o-inline-box; margin-left:10px;"><spring:message code="label.title" /></h2>
</div>


<div style="float:right; margin-right: 75px;">
		<img src="${pageContext.request.contextPath}/resources/images/tf.png"  id="tf" class="tfoms">
        <img src="${pageContext.request.contextPath}/resources/images/simaz.png" id="simaz" class="sim">
		<img src="${pageContext.request.contextPath}/resources/images/rosno.png" id="rosno" class="ro">
		<img src="${pageContext.request.contextPath}/resources/images/ingos.png" id="ingos" class="in">
		</div>
</div>


<div id ="main">
<!-- <div id="draggable" class="ui-widget-content">
  <p>Drag me around</p>
</div> -->
 <c:if test="${petit.id ne null}">
  			<c:set value="foreditbackgr" var="cssforedit"></c:set>
</c:if>
<c:if test="${petit.id eq null}">
  			<c:set value="register " var="cssforedit"></c:set>
</c:if>


<form:form method="post" action="add" commandName="petit" name='petit_form' class="${cssforedit}" id="draggable">

	<form:errors path="*" cssClass="errorblock" element="div" />
	<form:hidden path="id" name='id'/>
	<form:hidden path="blockger2016.filecall"/>
	<form:hidden path="num"/>

<h1>
	<c:if test="${petit.id eq null}">
		<spring:message code="label.petits" />
	</c:if>
	<c:if test="${petit.id ne null}">
		<spring:message code="label.nepetits" />
	</c:if>
</h1>
<fieldset class="row1">
	<legend>Данные обращения</legend>
	  <p>
	  	<c:if test="${petit.id eq null}">
	      <form:label style="font-weight: bold;" path="dateInput"><spring:message code="label.dateInput" /></form:label>
	      <form:input id="dateInput" path="dateInput"/>
	   	</c:if>
	   	<c:if test="${petit.id ne null}">
			<spring:message code="label.id" />&nbsp<c:out value="${petit.num}" />&nbsp&nbsp&nbsp&nbsp
			<spring:message code="label.dateInput" />&nbsp<c:out value="${petit.dateInput}" />
			<form:hidden id="tupin" path="dateInput" value="${petit.dateInput}"/>
	   	</c:if>
	   	
	 	<form:label path="sourceId"><spring:message code="label.source" /></form:label>
	    <form:select path="sourceId">
			<form:options items="${sourceList}"/>
		</form:select>
	  </p>
	  <p>
		<form:label path="conectId"><spring:message code="label.conect" /></form:label>
		<form:select path="conectId">
			<form:option value="0" label="" />
		<form:options items="${conectList}"/>
		</form:select>  
		
		<form:label path="presentId"><spring:message code="label.present" /></form:label>
		<form:select id="presentId" onclick='changepresentId()' path="presentId">
	 		<form:options items="${presentList}"/>
		</form:select>
	  </p>
<sec:authorize access="hasAnyRole('ROLE_TFOMS','DEVELOPER','ROLE_SMO','ROLE_ADMIN')">	  
	  <p>
	  	<form:label path="letterNum"><spring:message code="label.letterNum" /></form:label>
		<form:input path="letterNum" />
				
		<form:label path="letterDate"><spring:message code="label.letterDate" /></form:label>
		<form:input path="letterDate" />
	  </p>
</sec:authorize>	  
</fieldset>
<fieldset class="row2">
	<legend>Персональные данные</legend>
	<p>
		<form:label style="font-weight: bold;" path="surname"><spring:message code="label.surname" /></form:label>
		<form:input class="css-input" path="surname" />

		<form:label style="font-weight: bold;" path="name"><spring:message code="label.name" /></form:label>
		<form:input  path="name"/>

		<form:label style="font-weight: bold;"  path="patrony"><spring:message code="label.patrony" /></form:label>
		<form:input class="css-input" path="patrony" />
	</p>
	<p>
		<form:label  style="font-weight: bold;" path="policy"><spring:message code="label.policy" /></form:label>
		<form:input  path="policy" />

		<form:label  style="font-weight: bold;" path="tel"><spring:message code="label.tel" /></form:label>
		<form:input  path="tel" />

		<form:label  style="font-weight: bold;" path="adress"><spring:message code="label.adress" /></form:label>
		<form:input  path="adress" />	
	</p>
	<p>
		<form:label path="terId"><spring:message code="label.ter" /></form:label>
		<form:select path="terId">
			<form:option value="0" label="" />
   			<form:options items="${terList}"/>
		</form:select>
	
		<form:label path="terAnswerId"><spring:message code="label.terAnswer" /></form:label>
		<form:select path="terAnswerId">
				<form:option value="54" label="54 Новосибирскaя область" />				
    			<form:options items="${terList}"/>
		</form:select>
	</p>
</fieldset>  
<fieldset class="row777">
	<legend>Тип и причина обращения</legend>
	<p>
	<sec:authorize access="hasAnyRole('ROLE_TFOMS','ROLE_SMO','ROLE_ADMIN')">
				<form:label path="typeId"><spring:message code="label.type" /></form:label>
				<span id="typeWarning" style="color:#ff8000">!
					<span style="font-size:8">${petit.type.typeName}</span>
				</span>
			<form:select id="type" path="typeId" onchange="document.getElementById('typeWarning').hidden = true;"></form:select>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ER')">
				<form:label path="typeId"><spring:message code="label.type" /></form:label>
				<span id="typeWarning" style="color:#ff8000">!
					<span style="font-size:8">${petit.type.typeName}</span>
				</span>
			<form:select id="type" path="typeId" onchange="document.getElementById('typeWarning').hidden = true;">
			<form:option value="0" label=""/>
			<form:option value="3" label="Консультация" />
			</form:select>
	</sec:authorize>		
	</p>
	<p>
			<form:label path="causeId"><spring:message code="label.cause" /></form:label>
				<span id="causeWarning" style="color:#ff8000">!
					<span style="font-size:8">${petit.cause.causeName}</span>
				</span>
			<form:select id="cause" path="causeId" onchange="document.getElementById('causeWarning').hidden = true;"></form:select>	
	</p>
	<p>			
			<form:label path="rectif1Id"><spring:message code="label.rectif1" /></form:label>
				<span id="rectif1Warning" style="color:#ff8000">!
					<span style="font-size:8">${petit.rectif1.rectif1Name}</span>
				</span>
			<form:select id="rectif1" path="rectif1Id" onchange="document.getElementById('rectif1Warning').hidden = true;"></form:select>
	</p>
</fieldset>
<sec:authorize access="hasAnyRole('ROLE_TFOMS','DEVELOPER','ROLE_SMO','ROLE_ADMIN')">
<fieldset class="row777">
                <legend>Подробнее</legend>
                <div class="hide">
                <p>
                	
						<form:label path="rectif2Id"><spring:message code="label.rectif2" /></form:label>
						<span id="rectif2Warning" style="color:#ff8000;font-size:8">${petit.rectif2.rectif2Name}</span>
						<form:select id="rectif2" path="rectif2Id" onchange="document.getElementById('rectif2Warning').hidden = true;"></form:select>
						
						<form:label path="rectif3Id"><spring:message code="label.rectif3" /></form:label>
						<span id="rectif3Warning" style="color:#ff8000;font-size:8">${petit.rectif3.rectif3Name}</span>
						<form:select id="rectif3" path="rectif3Id" onchange="document.getElementById('rectif3Warning').hidden = true;"></form:select>

						<form:label path="rectif4Id"><spring:message code="label.rectif4" /></form:label>
						<span id="rectif4Warning" style="color:#ff8000;font-size:8">${petit.rectif4.rectif4Name}</span>
						<form:select id="rectif4" path="rectif4Id" onchange="document.getElementById('rectif4Warning').hidden = true;" ></form:select>
                	
                </p>
                <p>
							
					<form:label path="hspId"><spring:message code="label.hsp" /></form:label>
					<form:select path="hspId">
						<form:option value="0" label="" />
		    			<form:options items="${hspList}"/>
					</form:select>
                </p>
                <p>
					<form:label path="moId"><spring:message code="label.mo" /></form:label>
					<form:select path="moId">
						<form:option value="0" label="" />
    					<form:options items="${moList}"/>
					</form:select>
			
					<form:label path="insurId"><spring:message code="label.insur" /></form:label>
					<form:select path="insurId">
						<form:option value="0" label="" />
    					<form:options items="${insurList}"/>
					</form:select>
                </p>
                <p>
					<form:label path="validId"><spring:message code="label.valid" /></form:label>
					<form:select path="validId">
						<form:option value="0" label="" />
    					<form:options items="${validList}"/>
					</form:select>
	
					<form:label path="compens"><spring:message code="label.compens" /></form:label>
					<form:input class="css-input" path="compens" />
	
					<form:label path="satisf"><spring:message code="label.satisf" /></form:label>
					<form:input class="css-input" path="satisf" />
	
					<form:label path="compensSource"><spring:message code="label.compensSource" /></form:label>
					<form:input class="css-input" path="compensSource" placeholder="СМО МО или ТФОМС"/>
	
					<form:label path="compensCode"><spring:message code="label.compensCode" /></form:label>
					<form:input class="css-input" path="compensCode" placeholder="Код дефекта"/>
	
					<form:label path="compensSum"><spring:message code="label.compensSum" /></form:label>
					<form:input class="css-input" path="compensSum" />
                </p>
                <p>
					<form:label style="width: 144px;" path="causeNote"><spring:message code="label.causeNote" /></form:label>
					<form:textarea rows="2" cols="100" value="0" path="causeNote" />
                </p>
                </div>
                <p>
                	<input class='btn-slide' type="button" value="<spring:message code="label.more"/>"/>
                </p><br>
</sec:authorize>                
                <div class="hide2">
					<p>
					<div style="float:left;">
						<div class="blockoutletter">
							<form:label style="float:none;" path="bloutboindletter2016.date_between">Дата промежуточного ответа</form:label><br>
		      				<form:input style="float:none;" id="datebetween" path="bloutboindletter2016.date_between"/>
	      				</div>
	      				<div class="blockoutletter">
							<form:label style="float:none;" path="bloutboindletter2016.date_querymedDoc">Дата запроса мед.документации</form:label><br>
		      				<form:input style="float:none;" id="date_med_doc" path="bloutboindletter2016.date_querymedDoc"/>
	      				</div>
	      			</div>	
					</p>                
	      			<p>
	      				<form:label path="bloutboindletter2016.date_passmedDoc">Дата передачи мед.документации в ОМЭР</form:label>
	      				<form:input id="date_passOmer" path="bloutboindletter2016.date_passmedDoc"/>
	      				
	      				<form:label path="bloutboindletter2016.date_obtainAkt">Дата получения Актов МЭ</form:label>
	      				<form:input id="date_receive" path="bloutboindletter2016.date_obtainAkt"/>
	      			</p>
	      			<p>	
	      				<form:label path="bloutboindletter2016.date_response">Дата окончательного ответа</form:label>
	      				<form:input id="date_response" path="bloutboindletter2016.date_response"/>
	      				
	      				<form:label path="bloutboindletter2016.numOutLetter">Номер письма</form:label>
	      				<form:input path="bloutboindletter2016.numOutLetter"/>
	      				
	      				<form:label path="bloutboindletter2016.responsible">Отвественный</form:label>
	      				<form:select path="bloutboindletter2016.responsible">
	      					<form:option value="" label="" />
							<form:option value="mityanina" label="mityanina" />
							<form:option value="smyvin" label="smyvin" />
							<form:option value="eremina" label="eremina" />
							<form:option value="hamitov" label="hamitov" />
						</form:select>
                	</p>
                	<p>
                	</p>
                </div>
                <p>
                	<input id="inboundLetter" class='btn-slide2' type="button" value="Исходящее письмо"/>
                </p>
</fieldset>

<fieldset class="row777">
                <legend>Выберите действие</legend>
                <p>
                	<c:if test="${petit.id ne null}">
                		<sec:authorize access="hasRole('ROLE_NIGHT')">
							<form:select  id="sel" path="username" onclick="numberone()">
								<form:option label="Назначить"  value="0" />
								<form:options items="${listassign}"/>
							</form:select>
							<input name="cancel_button" onclick="cancelback()" type="button" value="<spring:message code="label.cancelpetit"/>"/>
							
							<input type="submit"  id="addpetit" name="submit" value="Назначить" disabled="disabled" 
								onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
							/>
						
							<input name="submit"  type="submit" value="<spring:message code="label.endpetit"/>" 
								onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
							/>
							
							<a  href="../nightcallfile/${petit.id}" class="blink" style=" float: right; background: none;" title="Прослушать">Прослушать</a>
						</sec:authorize>
						
                		<sec:authorize access="!hasRole('ROLE_NIGHT')">
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
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						  		<input name="сlose_button" onclick="" type="button" value="Закрыть"/>
						</sec:authorize>				
						
					</c:if>
					
					<c:if test="${petit.id eq null}">
					<form:select  id="sel" path="username" onclick="numberone()">
						<form:option label="Назначить"  value="0" />
						<form:options items="${listassign}"/>
					</form:select>
					
						<input type="submit"  id="addpetit" name="submit" value="<spring:message code="label.addpetit"/>" disabled="disabled" 
							onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
						/>
						
						<input name="submit"  type="submit" value="<spring:message code="label.endpetit"/>" 
							onclick="document.getElementById('typeWarning').hidden = false;document.getElementById('causeWarning').hidden = false;document.getElementById('rectif1Warning').hidden = false;"
						/>
					</c:if>
					
                </p>
</fieldset>
                
  
<!-- ============================================================================================  -->
  
  <c:if test="${petit.id eq null}">
	<form:hidden path="blockger2016.state" value="${1}" />
	
	<sec:authorize access="hasRole('ROLE_TFOMS')">
		<form:hidden path="blockger2016.regsource_id" value="${1}" />
		<form:hidden path="blockger2016.regname" value="${principal.username}" />
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_SMO')">
		<form:hidden path="blockger2016.regsource_id" value="${2}" />
		<form:hidden path="blockger2016.regname" value="${principal.username}" />
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ER')">
		<form:hidden path="blockger2016.regsource_id" value="${3}" />
		<form:hidden path="blockger2016.regname" value="${principal.username}" />
	</sec:authorize>
	</c:if>
	
<!-- ============================================================================================  -->

<c:if test="${petit.id ne null}">
	<c:set var="statec2" value="${petit.blockger2016.state}"/>
	<c:if test="${(statec2 == 3)}">
		&nbsp<spring:message code="label.dateand" />&nbsp<c:out value="${petit.blockger2016.date_end}" />
	</c:if>				
				
	<form:hidden path="blockger2016.idblockger2016"/>
	<form:hidden path="blockger2016.state" value="${2}" />
	<form:hidden path="blockger2016.regsource_id"/>
	<form:hidden path="blockger2016.regname"/>
	
	<form:hidden path="bloutboindletter2016.idletter"/>
				
	<!-- Если пользователь проваливается в форму редактирования  при state =3 (завершен)
	то передаем тот же самый date_end по новой и в базе срабатывает триггер иначе в базу добавить пустая date_end-->
	<input type="hidden" name="fil" value="${petit.blockger2016.date_end}"/>
</c:if>  
	
<!-- ============================================================================================  -->
</form:form>



<hr>
<c:if test="${petit.id eq null}">
<section>
<sec:authorize access="!hasRole('ROLE_NIGHT')">
	<input type="button" id="refreshpage" onclick="refreshp()" value="Обновить" style="    float: right; margin-top: -40px;"></input>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_NIGHT')">
<!-- <input type="button" id="refreshnightcall" onclick="refreshnightcall()" value="Обновить НЧ"></input> -->	
</sec:authorize>
<div style="overflow:auto; height:500px;"> 
<table class="secondtab">
    <thead>
        <tr>
        <th><spring:message code="label.id" /></th>      
		    <!-- <th><spring:message code="label.dateInput" /></th> --> <th>Дата поступления</th><th>Дата изменения</th>
		    <!-- <th><spring:message code="label.dateBegin" /></th>
		    <th><spring:message code="label.dateEnd" /></th>         
		    <th><spring:message code="label.source" /></th>-->
		    <!-- <th><spring:message code="label.present" /></th> -->
		    <!-- <th><spring:message code="label.letterNum" /></th>
		    <th><spring:message code="label.mo" /></th> -->
		    <!--<th><spring:message code="label.letterDate" /></th>
		    <th><spring:message code="label.conect" /></th>
		    <th><spring:message code="label.intermed" /></th>
		    -->
		    <!-- <th><spring:message code="label.surname" /></th> -->
		    <th><spring:message code="label.type" /></th>
		    <!-- <th>Причина</th> -->
		    <th>Фамилия</th>
		    <!-- <th><spring:message code="label.name" /></th> --><th>Имя</th>
			    <th><spring:message code="label.patrony" /></th>
			    <th><spring:message code="label.tel" /></th>
			    <!-- <th><spring:message code="label.policy" /></th>
			    <th><spring:message code="label.adress" /></th> 
		    <th><spring:message code="label.ter" /></th>-->
			    <!--<th><spring:message code="label.terAnswer" /></th>
			    <th><spring:message code="label.last1" /></th>
			    <th><spring:message code="label.last2" /></th>
			    <th><spring:message code="label.hsp" /></th>
			    <th><spring:message code="label.insur" /></th>
			    <th><spring:message code="label.place" /></th>-->
		    	<!--<th><spring:message code="label.cause" /></th>
			    <th><spring:message code="label.rectif1" /></th>
			    <th><spring:message code="label.rectif2" /></th>
			    <th><spring:message code="label.rectif3" /></th>
			    <th><spring:message code="label.rectif4" /></th>
			    <th><spring:message code="label.valid" /></th>
			    <th><spring:message code="label.compens" /></th>
			    <th><spring:message code="label.satisf" /></th>
			    <th><spring:message code="label.compensSource" /></th>
			    <th><spring:message code="label.compensCode" /></th>
			    <th><spring:message code="label.compensSum" /></th>
			    <th><spring:message code="label.propos" /></th>-->
		    <!-- <th><spring:message code="label.username" /></th> --><th>Регистратор</th></th> --><th>Исполнитель</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			
        </tr>
    </thead>
    <tbody>
          <c:forEach items="${petitList}" var="petit">
  			<c:set var="statecl" value="${petit.blockger2016.state}"/>
  			
  			<c:if test="${(statecl == 3 || statecl == 4)}">
		  		<c:set value="someclass3" var="cssClass"></c:set>
			</c:if> 
			
			<c:if test="${(statecl == 1)}">
	  			<c:set value="someclass blink" var="cssClassonUser"></c:set>
	  			<c:set value="" var="cssClass"></c:set>
			</c:if>
			<c:if test="${(statecl != 1)}">
	  			<c:set value="" var="cssClassonUser"></c:set>
			</c:if>
			<c:if test="${(statecl == 2)}">
	  			<c:set value="someclass2" var="cssClass"></c:set>
			</c:if> 
			
    	<tr class="${cssClass}">
      			
				<!-- <td>${petit.num}</td> -->
				<!-- <td>${petit.dateBegin}</td>
			    <td>${petit.dateEnd}</td>
			    <td>${petit.present.presentName}</td>
			    <td>${petit.letterNum}</td>
			    
			    <td>${petit.letterDate}</td>
			    <td>${petit.conect.conectName}</td>
			    <td>${petit.intermedId}</td>
			    
			    
			    
			    <td>${petit.policy}</td>
			    
			    <td>${petit.adress}</td>
			    
			    <td>${petit.terAnswer.terName}</td>
			    <td>${petit.last1}</td>
			    <td>${petit.last2}</td>
			    <td>${petit.hspId}</td>
			    <td>${petit.insurId}</td>	
			    <td>${petit.placeId}</td>
			    <td>${petit.rectif1.rectif1Name}</td>
			    <td>${petit.rectif2.rectif2Name}</td>
			    <td>${petit.rectif3.rectif3Name}</td>
			    <td>${petit.rectif4.rectif4Name}</td>
			    <td>${petit.valid.validName}</td>
			     <td>${petit.compens}</td>
			     <td>${petit.satisf}</td>
			     <td>${petit.compensSource}</td>
			    <td>${petit.compensCode}</td>
			    <td>${petit.compensSum}</td>
			    <td>${petit.propos}</td>
			    <td>${petit.source.sourceName}</td>
				<td>${petit.mo.moName}</td>
				 			    
			    -->
			    
			    <td>${petit.id}</td>      
			    <td>${petit.dateInput}</td>
			    <td>${petit.blockger2016.date_change}</td>
			    <td>${petit.type.typeName}</td>
			    <!-- <td>${petit.cause.causeName}</td> -->         
				<td>${petit.surname}</td>
				<td>${petit.name}</td>
			    <td>${petit.patrony}</td>
			    <td>${petit.tel}</td>
				<!-- <td style="overflow-x: hidden; overflow-y: hidden; white-space: nowrap; max-width: 65px;">${petit.ter.terName}</td> -->
				<td>${petit.blockger2016.regname}</td>
				<td class="${cssClassonUser}">${petit.username}</td>
				
				
			    
			    
			    <c:if test="${(statecl != 4)}">
			    	<td><a  href="nightcallfile/${petit.id}" title="Прослушать"><i class="fa fa-headphones fa-2x"></i></a></td>
			    	<td><a id="iddel" href="delete/${petit.id}" title="Удалить"><i class="fa fa-trash-o fa-2x"></i></a></td>
					<td><a id="iddel" href="refresh/${petit.id}" title="Редактировать"><i class="fa fa-pencil-square-o  fa-2x" aria-hidden="true"></i></a></td>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td><a id="iddel" href="close/${petit.id}" title="Закрыть обращение"><i class="fa fa-unlock  fa-2x" aria-hidden="true"></i></a></td>
					</sec:authorize>
					<sec:authorize access="!hasRole('ROLE_ADMIN')">
						<td><i class="fa fa-unlock  fa-2x noactive" aria-hidden="true"></i></td>
					</sec:authorize>
				</c:if>
				
				<c:if test="${(statecl == 4)}">
					<td><i class="fa fa-headphones fa-2x noactive"></i></a></td>
					<td><i class="fa fa-trash-o fa-2x noactive"></i></td>
					<td><i class="fa fa-pencil-square-o  fa-2x noactive" aria-hidden="true"></i></td>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td><a id="iddel" href="open/${petit.id}" title="Восстановить закрытое обращение"><i class="fa fa-lock  fa-2x" aria-hidden="true"></i></a></td>
					</sec:authorize>
					<sec:authorize access="!hasRole('ROLE_ADMIN')">
						<td><i class="fa fa-lock  fa-2x noactive" aria-hidden="true"></i></td>
					</sec:authorize>
				</c:if>

			    
			    
    </tr>
  </c:forEach>          
    </tbody>
</table>
</div>
</section>
</c:if>
	
</body>
</html>