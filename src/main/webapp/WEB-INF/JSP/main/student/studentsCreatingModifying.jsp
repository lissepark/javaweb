<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mainTerm">

    <div class="mainBack">
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To main</a>
    </div>
    <div class="mainBack">
        <a href="${CONTEXT}${CURRENT_MAPPING}/studentsList.php">Back</a>
    </div>
    <div class="clear"></div>

	<div class="main_line">
		<c:choose>
			<c:when test="${CURRENT_BUTTON eq 1}">
                To add student please fill all the fields and press the button "Add".
            </c:when>
			<c:otherwise>
                To modify please write new data and press the button "Submit".
            </c:otherwise>
		</c:choose>
	</div>

	<c:choose>
		<c:when test="${CURRENT_BUTTON eq 1}">
			<form action="${CONTEXT }${CURRENT_MAPPING}/studentsCreating.php" method="POST">
		</c:when>
		<c:otherwise>
			<form action="${CONTEXT }${CURRENT_MAPPING}/studentsModifying.php" method="POST">
		</c:otherwise>
	</c:choose>

	<input type="hidden" name="id" value="${student.id }" />
	
	<table>
		<tr>
			<td>Surname</td>
			<td><input type="text" class="text" name="lastName"
				value="${student.second_name }"></td>
		</tr>

		<tr>
			<td>Name</td>
			<td><input type="text" class="text" name="firstName"
				value="${student.name }"></td>
		</tr>

		<tr>
			<td>Group</td>
			<td><input type="text" class="text" name="group"
				value="${student.group }"></td>
		</tr>

		<tr>
			<td>Date of joining</td>
			<td><input type="text" class="text" id="datepicker" name="date"
				value="${student.date }"></td>
		</tr>

		<tr>
			<td>&nbsp;</td>

			<td>
                <c:choose>
					<c:when test="${CURRENT_BUTTON eq 1}">
						<input type="submit" value="Add" id="button">
					</c:when>
					<c:otherwise>
						<input type="submit" value="Submit" id="button">
					</c:otherwise>
				</c:choose>
            </td>
		</tr>
	</table>
            </form>
    <div>
	<jsp:include page="/WEB-INF/JSP/modules/validationMessage.jsp" />
    </div>

</div>