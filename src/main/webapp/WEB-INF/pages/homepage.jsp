<%--
  Created by IntelliJ IDEA.
  User: Clochette
  Date: 23/02/2023
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <header>
    <title>GIFT - Great Intern Follow-up Tool</title>
    <style><%@include file="/WEB-INF/css/homepage.css"%></style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  </header>

  <body>
    <div class="header">
      <a class="logo">GIFT</a>
      <!-- TODO : search bar -->

      <div class="header-right">
        <c:set var="tutorName" value="${sessionScope.tutorName}" />
        <a class="tutorName">${tutorName}</a>

        <form action="Controller" method="get">
          <input type="submit" value="Se déconnecter" class="active">
        </form>
      </div>
    </div>

    <div class="interns">
      <form>
        <table class="styled-table">
          <thead>
            <tr>
              <td><b>Groupe</b></td>
              <td><b>Nom</b></td>
              <td><b>Cahier des charges</b></td>
              <td><b>Fiche visite</b></td>
              <td><b>Fiche évaluation entreprise</b></td>
              <td><b>Sondage web</b></td>
              <td><b>Rapport rendu</b></td>
              <td><b>Soutenance</b></td>
              <td><b>Visite planifiée</b></td>
              <td><b>Visite faite</b></td>
              <td><b>Debut</b></td>
              <td><b>Fin</b></td>
              <td><b>Entreprise</b></td>
              <td><b>Maitre de stage</b></td>
              <td><b>Adresse</b></td>
              <td><b>Note tech</b></td>
              <td><b>Note com</b></td>
              <td>Modifier</td>
              <td>Supprimer</td>
            </tr>
          </thead>


          <c:forEach items="${listInternsPerTutor}" var="intern">
            <tr id="${intern.id}">
              <td>  ${intern.groupe}</td>
              <td>  ${intern.firstname} ${intern.lastname}   </td>
              <td>  ${intern.cahier_des_charges}    </td>
              <td>  ${intern.fiche_visite}    </td>
              <td>  ${intern.fiche_evaluation}    </td>
              <td>  ${intern.sondage_web}    </td>
              <td>  ${intern.rapport_rendu}    </td>
              <td>  ${intern.soutenance}    </td>
              <td>  ${intern.visite_planifiee}  </td>
              <td>  ${intern.visite_faite}  </td>
              <td>  ${intern.debut_stage}  </td>
              <td>  ${intern.fin_stage}  </td>
              <td>  ${intern.entreprise}  </td>
              <td>  ${intern.maitre_de_stage}  </td>
              <td>  ${intern.adresse_stage}  </td>
              <td>  ${intern.note_tech}  </td>
              <td>  ${intern.note_com}  </td>

              <td>
                <form action="PrepareModifyInternController" method="post">
                  <input type="hidden" name="internId" value="${intern.id}">
                  <button type="submit" name='action'>🖊️</button>
                </form>
              </td>

              <td>
                <form method="post" action="removeInternController">
                  <input type="hidden" name="internId" value="${intern.id}">
                  <button name="action" type="submit">❌</button>
                </form>
              </td>
            </tr>
          </c:forEach>
        </table>
      </form>
    </div>

    <button type="button" class="button" data-toggle="modal" data-target="#modalAddIntern">
      Ajouter un.e stagiaire
    </button>

    <!-- add intern modal -->
    <jsp:include page="addIntern.jsp" />

     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </body>

</html>