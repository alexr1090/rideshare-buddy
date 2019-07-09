<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Spring Framework Tutorial For Beginners</title>
 <!-- Bootstrap -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="/js/lib/jquery-3.4.1.min/jquery-3.4.1.min.js" ></script>
    <script type="text/javascript">

    	$(document).ready(function () {
    		$('#checkBoxAll').click(function () {
    			if ($(this).is(":checked"))
    				$('.chkCheckBoxId').prop('checked',true);
	   			else
    				$('.chkCheckBoxId').prop('checked',false);
    		});
		});
    	
	</script>


<!-- checkbox multi delete credit: https://youtu.be/2Pt5h4iKEFM  -->
</head>
<link href="/css/styles.css" rel="stylesheet">

<body>
${error}
<div class="container">


<c:if test="${not empty flashMessage}">
	<div class="alert alert-${flashKind} alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  ${flashMessage}
	</div>
</c:if>

<form:form method="post" modelAttribute="delete"> 
	
	<table id="statsTable" class="table table-bordered">
		<thead>
			<tr>
				<td><input type="checkbox" id="checkBoxAll" /></td>
				<td>Date</td>
				<td >Starting Miles</td>
				<td>Ending Miles</td>
				<td>Miles Driven</td>
				<td>Money Made</td>
				<td>Money Spent</td>
				<td>Net Profit/Loss</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${statsList}" var="stats">
		    	<tr>
		    		<td><input type="checkbox" class="chkCheckBoxId" value="${stats.date}" name="date" /></td>
		        	<td><c:out value="${stats.date}"/></td>
		       		<td><c:out value="${stats.startingMiles}"/></td>
		        	<td><c:out value="${stats.endingMiles}"/></td>
		        	<td> <c:out value="${stats.totalDaily}"/></td>
		        	<td><c:out value="$ ${stats.moneyMade}" /></td>
		        	<td><c:out value="$ ${stats.moneySpent}" /></td>
		        	<td><c:out value="$ ${stats.netPorL}" /></td>
		    	</tr>
			</c:forEach>
			<tr>
				<td>Totals</td>
				<td></td>
				<td></td>
				<td></td>
				<td id="totDailySum">${totalMilesSum}</td>
				<td id="moneyMadeSum"><c:out value="$ ${totalMoneyMade}" /></td>
				<td id="moneySpentSum"><c:out value="$ ${totalMoneySpent}" /></td>
				<td id="netPorLSum"><c:out value="$ ${totalNetPorL}" /></td>
				<tr>
				<td>Tax Mileage Credit 2019</td>
				<td id="taxSavings"><c:out value="$ ${taxSavings}" /></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
	</tbody>
	
	</table>
	
<a class="btn btn-primary" href="/addstats" role="button" value="addstats">New Entry</a>
<button type="submit" value="edit" name="edit" class="btn btn-primary" id="edit_btn" >Edit Selected</button>
<button type="submit" value="delete" name="delete" class="btn btn-primary"  onclick="return confirm('Are you sure you want to delete?')">Delete Selected</button>
</form:form>		



<%@include file="includes/footer.jsp"%>     