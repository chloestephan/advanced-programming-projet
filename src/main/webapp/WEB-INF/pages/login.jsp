<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

    <header>
        <title>GIFT - Great Intern Follow-up Tool</title>
        <style><%@include file="/WEB-INF/css/login.css"%></style>
    </header>

    <body>

    <form name='myform' action="Controller">
        <div class="container">
            <label for="loginField">Nom d'utilisateur</label>
            <input type="text" placeholder="Nom d'utilisateur" name="loginField" id ="loginField" required>

            <label for="pwdField">Mot de passe</label>
            <input type="password" placeholder="Mot de passe" name="pwdField" id="pwdField" required>

            <button type="submit" name='action'>Se connecter</button>
        </div>
    </form>

    <c:if test="${!empty errKey}">
        <c:out value="${errKey}" />
    </c:if>

    </body>
</html>
