<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Add Driving Info</h3>
  </div>
  <div class="panel-body">
	<form:form modelAttribute="userStats">
	
	  <form:errors cssClass="error"/>
	  
	  <div class="form-group">
	    <form:label path="date">Date</form:label>
	    <form:input path="date" type="date" class="form-control" id="exampleInputEmail1" placeholder="Date" />
	    <form:errors path="date" cssClass="error" />
	  </div>
	  <div class="form-group">
	    <form:label path="startMiles">Starting Miles</form:label>
	    <form:input path="startMiles" type="text" class="form-control" id="exampleInputName1" placeholder="Starting Miles" />
	    <form:errors path="startMiles" cssClass="error" />
	  </div>
	  <div class="form-group">
	    <form:label path="endMiles">Ending Miles</form:label>
	    <form:input path="endMiles" type="text" class="form-control" id="exampleInputPassword1" placeholder="Ending Miles" />
	    <form:errors path="endMiles" cssClass="error" />
	  </div>
	  <form:label path="moneyMade">Money Made</form:label>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">$</span>
	 </div>
	 
	  <form:input path="moneyMade" type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="exampleInputPassword1" placeholder="0.00" />
	  <form:errors path="moneyMade" cssClass="error" />
	 
	</div>
	  <form:label path="moneySpent">Money Spent</form:label>
		<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">$</span>
	 </div>
	 
	  <form:input path="moneySpent" type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="exampleInputPassword1" placeholder="0.00" />
	  <form:errors path="moneySpent" cssClass="error" />
	 
	</div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     