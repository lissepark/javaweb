<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="disciplines_List_container">
    <div class="mainBack">
		<a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To Main</a>
    </div>
    <div class="mainBack">
		<a href="${CONTEXT}${CURRENT_MAPPING}/termsList.php">Back</a>
    </div>
    <div class="clear"></div>

	<div class="main_line">
		<c:choose>
			<c:when test="${CURRENT_BUTTON eq 1}">
                To add marking period please fill all the fields and press the button "Add".
            </c:when>
			<c:otherwise>
                To modify please write new data and press the button "Submit".
            </c:otherwise>
		</c:choose>
	</div>

	<c:choose>
		<c:when test="${CURRENT_BUTTON eq 1}">
            <form action="${CONTEXT }${CURRENT_MAPPING}/termCreating.php" method="POST">
		</c:when>
		<c:otherwise>
			<form action="${CONTEXT }${CURRENT_MAPPING}/termModifying.php" method="POST">
		</c:otherwise>
	</c:choose>

	<input type="hidden" name="id" value="${term.id }" />

	<table class="under_main_table" style="font-family: cursive;">
		<tr>
			<td width="210px">Duration (weeks)</td>
			<td>
                <input type="text" name="duration" class="text"
                       value="${term.duration }" id="text" placeholder="24">
            </td>
		</tr>

        <tr>
            <td width="210px">Name of the marking period</td>
            <td>
                <input type="text" name="term_name" class="text"
                       value="${term.name}" id="text1">
            </td>
        </tr>

		<tr>
			<td style="padding-top: 30px" valign="top">Subjects in the marking period</td>
			<td style="padding-top: 30px">
				<table>
					<tr>
						<td style="padding: 0">
                            <select multiple size="8" id="multi_list" name="multi_list[]">
                                <c:forEach var="discipline" items="${disciplines }">
                                    <c:choose>
                                        <c:when test="${discipline.id  ne selectedDiscipline.id }">
                                            <option value="${discipline.id }">${discipline.name
                                                    }</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option selected="selected" value="${discipline.id }">${discipline.name
                                                    }</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
						    </select>

                        </td>
					</tr>

					<tr>
						<td style="padding-top: 20px"><c:choose>
								<c:when test="${CURRENT_BUTTON eq 1}">
									<input type="submit" value="Add" id="button">
								</c:when>
								<c:otherwise>
									<input type="submit" value="Submit" id="button">
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>


			</td>
		</tr>
	</table>
    </form>
            <jsp:include page="/WEB-INF/JSP/modules/validationMessage.jsp" />

</div>