<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="mainTerm">

    <div class="mainBack">
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To main</a>
    </div>
    <div class="mainBack">
        <a href="${CONTEXT}${CURRENT_MAPPING}/studentsList.php">Back</a>
    </div>
    <div class="clear"></div>

    <div class="disc_list">
        Here you see marks of the selected student:
    </div>

    <div class="studProgress">
                <table class="tablProgrStud">
					<tr>
						<th width="30%">Surname</th>
						<th width="30%">Name</th>
						<th width="20%">Group</th>
						<th width="20%">Date of joining</th>
					</tr>
					<tr>
						<td>${student.second_name }</td>
						<td>${student.name }</td>
						<td>${student.group }</td>
						<td>${student.date }</td>
					</tr>
				</table>

				<form action="${CONTEXT }${CURRENT_MAPPING}/studentProgress.php" method="GET">
				<input type="hidden" name="id" value="${student.id }">

						<div class="selSemMarks">
                            To see marks of the selected student for the particular terms -
                            please select term in the list below and press button "Select"
                        </div>

						<div>
                            <select id="opening_list" name="chooser">
                                <c:forEach var="term" items="${terms }">
									<c:choose>
										<c:when test="${term.id  eq selectedTerm.id }">
											<option selected="selected" value="${term.id }">
												${term.name }</option>
										</c:when>
										<c:otherwise>
											<option value="${term.id }">${term.name }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
                        </div>

						<div>
                            <input type="submit" value="Select" id="button">
                        </div>

						<div>Avarage mark for the term: ${middleValue }</div>

				</form>

                <table class="tablProgrStud2">
                    <tr>
                        <th width="80%">Subject</th>
                        <th width="20%">Mark</th>
                    </tr>
                </table>
                <table class="tablProgrStud2">
                    <c:forEach var="mark" items="${marks }">
                        <tr>
                            <td width="80%"><c:out value="${mark.discipline.name }"></c:out>
                            </td>
                            <td width="20%"><c:out value="${mark.mark }"></c:out>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
    </div>
</div>