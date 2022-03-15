<%@include file="header.jsp" %>

	<div class="container mt-3 text-center">
	<h1 class="my-5">Voici les héros qui peuvent intervenir</h1>
	
	<div class="row"> 
	
		<div class="col-3"> 
		<img src="images/Superhero-bro.svg" alt="" class="img-fluid">
		</div>
		<div class="col-9"> 
		<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Nom</th>
			      <th scope="col">Téléphone</th>
			      <th scope="col">Longitude</th>
			      <th scope="col">Latitude</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="hero" items="${heros}"> 
			    <tr>
			      <td>${hero.name}</td>
			      <td>${hero.mobile}</td>
			      <td>${hero.longitude}</td>
			      <td>${hero.latitude}</td>
			    </tr>
			    </c:forEach> 
			  </tbody>
		</table>
		</div>
	</div>
		
	</div>
<%@include file="footer.jsp" %>