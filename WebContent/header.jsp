<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Super Hero</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bangers&display=swap" rel="stylesheet">
<link href="style/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<nav class="container-fluid py-2">
<ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="home.jsp">Accueil</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/superHero/addIncident">Déclarer un incident</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/superHero/heroinscription">S'inscrire comme super hero</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="/superHero/resulthero">List hero</a>
  </li>
</ul>
</nav>
<header class="mb-4">
<img src="images/header.jpg" alt="" class="img-fluid">
</header>
