<%--
  Created by IntelliJ IDEA.
  User: Clochette
  Date: 25/02/2023
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un.e stagiaire</title>

  <div id="modifyIntern" class="modifyIntern">
    <div class="separation">
      <hr>
    </div>
    <h1>Modifier un.e stagiaire</h1>
    <div class="modal-content">
      <form action="modifyInternController" method="post">
        <p>Merci de remplacer les informations devant être changées :</p>

        <input type="text" id="firstName" name="firstName" placeholder="Prénom">
        <input type="text" id="lastName" name="lastName" placeholder="Nom">


        <button type="submit" name="action" id="submitModifyIntern">Ajouter</button>
      </form>
    </div>

  </div>

</head>
<body>

</body>
</html>
