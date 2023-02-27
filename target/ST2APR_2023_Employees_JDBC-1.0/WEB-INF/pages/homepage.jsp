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
        <c:forEach items="${tutorName}" var="tutor">
          <a class="tutorName">${tutor.name}</a>
        </c:forEach>

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

              <form method="post" action="PrepareModifyInternController">
                <input type="hidden" name="internId" value="${intern.id}">
                <td><button id="modifyInternButton" name="action" type="submit" data-toggle="modal" data-target="#modalModifyIntern">✏️</button></td>
              </form>

              <form method="post" action="removeInternController">
                <input type="hidden" name="internId" value="${intern.id}">
                <td><button name="action" type="submit">❌</button></td>
              </form>
            </tr>
          </c:forEach>
        </table>
      </form>
    </div>

    <button type="button" class="button" data-toggle="modal" data-target="#modalAddIntern">
      Ajouter un.e stagiaire
    </button>

    <!-- add intern modal -->
    <div class="modal fade" id="modalAddIntern" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="modalAddInternLabel">Ajouter un.e stagiaire</h4>
          </div>
          <div class="modal-body">
            <div class="createNewIntern">
              <form action="addInternController" method="post">
                <p>Merci de remplir les informations de la personne stagiaire :</p>
                <input type="text" placeholder="Prénom(s)" name="firstName" id="firstName" required>
                <input type="text" placeholder="Nom de famille" name="lastName" id="lastName" required>
                <!--username = firstName + "_" + lastName -->
                <input type="text" placeholder="Email" name="email" id="email" required>
                <input type="text" placeholder="Groupe" name="groupe" id="groupe" required>
                <input type="date" placeholder="Debut du stage" name="debutDuStage" id="debutDuStage" required>
                <input type="date" placeholder="Fin du stage" name="finDuStage" id="finDuStage" required>
                <input type="text" placeholder="Entreprise du stage" name="entreprise" id="entreprise" required>
                <input type="text" placeholder="Maitre de stage" name="maitreDeStage" id="maitreDeStage" required>
                <input type="text" placeholder="Adresse du lieu du stage" name="adresse_stage" id="adresse_stage" required>

                <p>Merci de cocher si la personne stagiaire répond aux critères suivants :</p>
                <div>
                  <input type="checkbox" name="cahierDesCharges" id="cahierDesCharges">
                  <label for="cahierDesCharges">Cahier des charges ?</label>
                </div>
                <div>
                  <input type="checkbox" name="ficheVisite" id="ficheVisite">
                  <label for="ficheVisite">Fiche visite ?</label>
                </div>

                <div>
                  <input type="checkbox" name="ficheEvaluation" id="ficheEvaluation">
                  <label for="ficheEvaluation">Fiche d'évaluation ?</label>
                </div>

                <div>
                  <input type="checkbox" name="sondageWeb" id="sondageWeb">
                  <label for="sondageWeb">Sondage Web ?</label>
                </div>

                <div>
                  <input type="checkbox" name="rapportRendu" id="rapportRendu">
                  <label for="rapportRendu">Rapport rendu ?</label>
                </div>

                <div>
                  <input type="checkbox" name="soutenance" id="soutenance">
                  <label for="soutenance">Soutenance ?</label>
                </div>

                <div>
                  <input type="checkbox" name="visitePlanifiee" id="visitePlanifiee">
                  <label for="visitePlanifiee">Visite planifiée ?</label>
                </div>

                <div>
                  <input type="checkbox" name="visiteFaite" id="visiteFaite">
                  <label for="visiteFaite">Visite effectuée ?</label>
                </div>

                <div>
                  <input type="text" placeholder="Note technique" name="noteTech" id="noteTech">
                  <input type="text" placeholder="Note com" name="noteCom" id="noteCom">
                </div>

                <button type="submit" name="action" class="submitAddIntern" id="${tutor.id}">Ajouter</button>
              </form>

            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
          </div>
        </div>
      </div>
    </div>

    <!-- modify intern modal -->
    <div class="modal fade" id="modalModifyIntern" tabindex="-1" roles="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="modalModifyInternLabel">Modifier un.e stagiaire</h4>
          </div>

          <div class="modal-body">
            <div class="ModifyIntern">
              <form action="modifyInternController" method="post">
                <p>Merci de remplir les informations de la personne stagiaire :</p>
                <c:forEach items="${intern}" var="internInfo">
                  <input type="text" placeholder="Prénom(s)" name="firstName" id="firstNameModified" value="${internInfo.firstname}">
                  <input type="text" placeholder="Nom de famille" name="lastName" id="lastNameModified" value="${internInfo.lastname}">
                  <input type="text" placeholder="Email" name="email" id="emailModified" value="${internInfo.email}">
                  <input type="text" placeholder="Groupe" name="groupe" id="groupeModified" value="${internInfo.groupe}">
                  <input type="date" placeholder="Debut du stage" name="debutDuStage" id="debutDuStageModified" value="${internInfo.debut_stage}">
                  <input type="date" placeholder="Fin du stage" name="finDuStage" id="finDuStageModified" value="${internInfo.fin_stage}">
                  <input type="text" placeholder="Entreprise du stage" name="entreprise" id="entrepriseModified" value="${internInfo.entreprise}">
                  <input type="text" placeholder="Maitre de stage" name="maitreDeStage" id="maitreDeStageModified" value="${internInfo.maitre_de_stage}">
                  <input type="text" placeholder="Adresse du lieu du stage" name="adresse_stage" id="adresse_stageModified" value="${internInfo.adresse_stage}">

                  <p>Merci de cocher si la personne stagiaire répond aux critères suivants :</p>
                  <div>
                    <input type="checkbox" name="cahierDesCharges" id="cahierDesChargesModified" value="${internInfo.cahier_des_charges}">
                    <label for="cahierDesCharges">Cahier des charges ?</label>
                  </div>
                  <div>
                    <input type="checkbox" name="ficheVisite" id="ficheVisiteModified" value="${internInfo.fiche_visite}">
                    <label for="ficheVisite">Fiche visite ?</label>
                  </div>

                  <div>
                    <input type="checkbox" name="ficheEvaluation" id="ficheEvaluationModified" value="${internInfo.fiche_evaluation}">
                    <label for="ficheEvaluation">Fiche d'évaluation ?</label>
                  </div>

                  <div>
                    <input type="checkbox" name="sondageWeb" id="sondageWebModified" value="${internInfo.sondage_web}">
                    <label for="sondageWeb">Sondage Web ?</label>
                  </div>

                  <div>
                    <input type="checkbox" name="rapportRendu" id="rapportRenduModified" value="${internInfo.fiche_visite}">
                    <label for="rapportRendu">Rapport rendu ?</label>
                  </div>

                  <div>
                    <input type="checkbox" name="soutenance" id="soutenanceModified" value="${internInfo.rapport_rendu}">
                    <label for="soutenance">Soutenance ?</label>
                  </div>

                  <div>
                    <input type="checkbox" name="visitePlanifiee" id="visitePlanifieeModified" value="${internInfo.visite_planifiee}">
                    <label for="visitePlanifiee">Visite planifiée ?</label>
                  </div>

                  <div>
                    <input type="checkbox" name="visiteFaite" id="visiteFaiteModified" value="${internInfo.visite_faite}">
                    <label for="visiteFaite">Visite effectuée ?</label>
                  </div>

                  <div>
                    <input type="text" placeholder="Note technique" name="noteTech" id="noteTechModified" value="${internInfo.note_tech}">
                    <input type="text" placeholder="Note com" name="noteCom" id="noteComModified" value="${internInfo.note_com}">
                  </div>
                </c:forEach>
                <button type="submit" name="action" class="submitModifyIntern" id="${tutor.id}">Ajouter</button>
              </form>

            </div>
          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
          </div>
        </div>
      </div>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </body>

</html>