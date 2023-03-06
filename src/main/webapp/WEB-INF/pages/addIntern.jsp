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
    <title>Ajouter un.e stagiaire</title>
</head>
<body>
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
        </div>
    </div>
</div>

</body>
</html>
