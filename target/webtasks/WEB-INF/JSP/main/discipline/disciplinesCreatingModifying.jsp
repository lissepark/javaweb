<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="disciplines_List_container">
	<div class="mainBack">
		<a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To Main</a>
     </div>
    <div class="mainBack">
        <a href="${CONTEXT}${CURRENT_MAPPING}/disciplinesList.php">Back</a>
	</div>
    <div class="clear"></div>

	<div class="main_line">
		<c:choose>
			<c:when test="${CURRENT_BUTTON eq 1}">
                To add subject please fill all the fields and press the button "Add".
            </c:when>
            <c:otherwise>
                To modify please write new data and press the button "Submit".
            </c:otherwise>
		</c:choose>
	</div>


	<c:choose>
		<c:when test="${CURRENT_BUTTON eq 1}">
			<form action="${CONTEXT }${CURRENT_MAPPING}/disciplinesCreating.php" method="POST">
		</c:when>
		<c:otherwise>
			<form action="${CONTEXT }${CURRENT_MAPPING}/disciplinesModifying.php" method="POST">
		</c:otherwise>
	</c:choose>
	
	<input type="hidden" name="id" value="${discipline.id }" >

	<table style="line-height: 50px">
		<tr>
			<td>Name</td>
			<td style="padding-left: 30px">
                <input type="text" name="name"
				maxlength="50" size="35" class="text"  value="${discipline.name }">
            </td>
		</tr>


		<tr>
			<td></td>
			<td style="padding-left: 32px" height="50px"><c:choose>
					<c:when test="${CURRENT_BUTTON eq 1}">
						<input type="submit" value="Add" id="button">
					</c:when>
					<c:otherwise>
						<input type="submit" value="Submit" id="button">
					</c:otherwise>
				</c:choose></td>
		</tr>

	</table>
	</form>
	<jsp:include page="/WEB-INF/JSP/modules/validationMessage.jsp" />

</div>