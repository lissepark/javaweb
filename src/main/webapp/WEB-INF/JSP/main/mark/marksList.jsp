<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>

<div class="disciplines_List_container">
<div class="link_container">
	<table>
		<tr>
			<td><a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To Main</a></td>
		</tr>
	</table>

</div>
<div class="terms_list_container">
	<c:if test=""></c:if>
	<form action="${CONTEXT }${CURRENT_MAPPING}/marksList.php" method="get">
		<table cellspacing="0" style="margin-top: 20px">
			<tr>
				<td style="font-size: large;">Select student</td>

				<td style="padding-left: 50px">
                    <select id="opening_list" name="chooserStd">
                    <c:forEach var="student" items="${students }">
							<c:choose>
								<c:when test="${student.id  eq selectedStudent.id }">
									<option selected="selected" value="${student.id }">
										${student.second_name} ${student.name }</option>
								</c:when>
								<c:otherwise>
									<option value="${student.id }">${student.second_name } ${student.name }</option>
								</c:otherwise>
							</c:choose>
					</c:forEach>
                    </select>
                </td>
			</tr>

			<tr>
				<td style="font-size: large;">Select marking period</td>

				<td style="padding-left: 50px; line-height: 50px">
                    <select class="opening_list" name="chooserTerm">
                    <c:forEach var="term" items="${terms }">
							<c:choose>
								<c:when test="${term.id  eq selectedTerm.id }">
									<option selected="selected" value="${term.id }">Marking period
										${term.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${term.id }">Marking period ${term.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
                        </select>
                </td>
			</tr>
			<tr>
				<td></td>
				<td style="padding-left: 52px; line-height: 50px"><input
					type="submit" value="Select" id="button"></td>
			</tr>

			<tr style="font-size: large;">
				<td colspan="2"><h4>List of subjects in the marking period</h4>
					<p>(If marks were added earlier they will be updated)</td>
			</tr>
		</table>
	</form>

	<table style="margin-top: 20px">
		<form action="${CONTEXT }${CURRENT_MAPPING}/marksList.php"	method="post">

			<input type="hidden" name="idS" value="${selectedStudent.id }" />
            <input type="hidden" name="idT" value="${selectedTerm.id }" />
			<tr>
				<td style="padding: 0" width="600px"><table cellspacing="0"
						cellpadding="3" id="small_font_80_600" border="1px">
						<tr bgcolor="#DCDCDC" align="left" style="border-color: #8B8989;">
							<th colspan="2">Subject</th>
						</tr>
						<c:forEach var="discipline" items="${disciplines }">

							<tr>
								<td>${discipline.name }</td>
								<td align="center">
                                    <input type="number" min="0" max="5"
									step="1" name="${discipline.id }" value="5" id="number"/>
                                </td>
							</tr>
						</c:forEach>

					</table></td>
			<tr>
				<td colspan="2" align="right" style="padding-top: 20px"><input
					type="submit" value="Submit" id="button_marks"></td>

			</tr>
		</form>
	</table>
	<jsp:include page="/WEB-INF/JSP/modules/validationMessage.jsp" />
	<jsp:include page="/WEB-INF/JSP/modules/successfulMessage.jsp" /></div>

</div>
