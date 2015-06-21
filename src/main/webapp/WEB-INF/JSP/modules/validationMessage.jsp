<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${VALIDATION_MESSAGE ne null }">
	<table id="table_for_error_message">
		<tr>
			<td class="error_message">
                <c:choose>
					<c:when test="${VALIDATION_MESSAGE eq 'lastName'}">
					    Field 'Surname' is not completed
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'firstName'}">
					    Field 'Name' is not completed
				    </c:when>
                    <c:when test="${VALIDATION_MESSAGE eq 'group'}">
					    Field 'Group' is not completed
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'date'}">
					    Field 'Date of joining' is not completed
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'name'}">
					    Field 'Marking period' is not completed
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'disciplines'}">
					    Select subjects in the marking period
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'duration'}">
					    Field 'Duration' is not completed
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'username'}">
					    Field 'LOGIN' is not completed
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'password'}">
                        Field 'PASSWORD' is not completed
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'role'}">
					    Role is not acceptable
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'char'}">
					    Wrong symbols in the field 'Duration'. Use numbers only.
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'Password is failed'}">
					    Wrong password
				    </c:when>
					<c:when test="${VALIDATION_MESSAGE eq 'Account not found'}">
					   Account not founded
				    </c:when>
				    <c:when test="${VALIDATION_MESSAGE eq 'no'}">
					    Select student and marking period!
				    </c:when>
				</c:choose>
            </td>
		</tr>
	</table>
</c:if>





