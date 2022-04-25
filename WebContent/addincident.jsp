<%@page import="model.TypeIncidentRepository"%>
<%@include file="header.jsp" %>

<div class="container d-flex justify-content-center">
	<div class="row">
	
	<h1 class="mb-2">Déclarer un incident</h1>
		<div class="col-8">

		<form  action="addIncident" method="post">
		  <div class="mb-3">
		    <label for="city" class="form-label">Nom de la ville</label>
		    <input type="text" class="form-control" name="city">
		  </div>
		  
		   <div class="mb-3">
		      <label for="incident" class="form-label">Type d'incident</label>
		      <select name="incident">
		       <c:forEach var="incident" items="${incidents}"> 
				    		<option value="${incident.id}"><c:out value="${incident.name}"/></option>
				</c:forEach>
		      </select>
		    </div>
		  <input type="submit" value="Valider" name="submit_add_incident" class="btn btn-primary" id="addIncident">
</form>
		</div>
	</div>
</div>




<%@include file="footer.jsp" %>