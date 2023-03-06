<%--
  Created by IntelliJ IDEA.
  User: Clochette
  Date: 06/03/2023
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un.e stagiaire</title>
</head>
<body>
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
                                <label for="cahierDesChargesModified">Cahier des charges ?</label>
                            </div>
                            <div>
                                <input type="checkbox" name="ficheVisite" id="ficheVisiteModified" value="${internInfo.fiche_visite}">
                                <label for="ficheVisiteModified">Fiche visite ?</label>
                            </div>

                            <div>
                                <input type="checkbox" name="ficheEvaluation" id="ficheEvaluationModified" value="${internInfo.fiche_evaluation}">
                                <label for="ficheEvaluationModified">Fiche d'évaluation ?</label>
                            </div>

                            <div>
                                <input type="checkbox" name="sondageWeb" id="sondageWebModified" value="${internInfo.sondage_web}">
                                <label for="sondageWebModified">Sondage Web ?</label>
                            </div>

                            <div>
                                <input type="checkbox" name="rapportRendu" id="rapportRenduModified" value="${internInfo.fiche_visite}">
                                <label for="rapportRenduModified">Rapport rendu ?</label>
                            </div>

                            <div>
                                <input type="checkbox" name="soutenance" id="soutenanceModified" value="${internInfo.rapport_rendu}">
                                <label for="soutenanceModified">Soutenance ?</label>
                            </div>

                            <div>
                                <input type="checkbox" name="visitePlanifiee" id="visitePlanifieeModified" value="${internInfo.visite_planifiee}">
                                <label for="visitePlanifieeModified">Visite planifiée ?</label>
                            </div>

                            <div>
                                <input type="checkbox" name="visiteFaite" id="visiteFaiteModified" value="${internInfo.visite_faite}">
                                <label for="visiteFaiteModified">Visite effectuée ?</label>
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

</body>
</html>
