<%@page import="model.TypeIncidentRepository"%>
<%@include file="header.jsp" %>



<div class="container ">
	<div class="row d-flex justify-content-center">
	
	<h1 class="mb-2 text-center">S'incrire en tant qu'Hero</h1>

		
		
		<div class="col-8"> 
		<img src="images/heroinscription.svg" alt="" class="img-fluid justify-content-center">

		<form  action="heroinscription" method="post">
		  <div class="mb-3">
		    <label for="city" class="form-label">Nom</label>
		    <input type="text" class="form-control" name="name" required>
		  </div>
		  
		  	<div class="form-group">
		    <label for="adress">Adresse</label>
		    <input type="text" class="form-control" name="adress" required>
  			</div>
  			
		  <div class="mb-3">
		    <label for="latitude" class="form-label">Latitude</label>
		    <input type="text" class="form-control" name="latitude" required>
		  </div>
		    <div class="mb-3">
		    <label for="longitude" class="form-label">Longitude</label>
		    <input type="text" class="form-control" name="longitude" required>
		  </div>
		  
		  
		    <div class="mb-3">
			    <label for="mobile" class="form-label">Téléphone</label>
			    <input type="text" class="form-control" name="mobile" required>
		  	</div>
		  	
		  	
	<div class="row"> 
	 	<c:forEach var="incident" items="${incidents}"> 
		  	  	<div class=" col-5 mb-3 form-check">
		  	  	  <input name="incident${incident.id}" type="checkbox" class="form-check-input" value="${incident.id}" >
				  <label class="form-check-label" for="incident"><c:out value="${incident.name}"/></label>
				 </div>
  			 
		</c:forEach>
	</div>
		  	
		  	 <input type="submit" value="Valider" name="add_hero" class="btn btn-primary" id="addHero">
		</form>
		</div>
	
	
		
			</div>
</div>

<script>
$("#addHero").attr("disabled", true);

$('input:checkbox').click(function () {
    let $cs = $("input:checkbox:checked").length;  
   
    if ($cs > 3) {
        this.checked = false;
    }else if ($cs == 0){
        $("#addHero").attr("disabled", true);
    }else{
        $("#addHero").attr("disabled", false);
    }
   
});
</script>

<%@include file="footer.jsp" %>