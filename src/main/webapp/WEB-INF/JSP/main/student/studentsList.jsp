<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="mainTerm">
    <div class="linkTermMain">
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To Main Page</a>
    </div>
    <c:if test="${CURRENT_ROLE eq 1}">
        <div class="butDelStud">
        <div>To add information about the student please press button "Add student"</div>
            <form action="${CONTEXT }${CURRENT_MAPPING}/studentsCreating.php" method="GET">
                <input type="submit"
                    value="Add student" class="button_long_name" name="creating">
            </form>
        </div>
        <div class="butDelStud">
            <div>To delete the student please tick mark in the field infront of the selected student or several students
            and press button "Delete selected students"</div>
            <input type="button" onclick="deleteStudents()" name="delete"
                   value="Delete selected students" id="button_short_name">
        </div>
        <div class="butDelStud">
            <div>To see marks of the student please tick mark in the field infront of the selected student
                and press button "See marks of the selected students"
            </div>
            <input type="button" class="button_long_name" name="progress"
                   value="See marks of the selected students" onclick="progressStudents()">
        </div>
        <div class="butDelStud">
            <div>To change information about the student please tick mark in the field infront of the selected student
                and press button "Change information"
            </div>
            <input type="submit" value="Change information"
                   class="button_long_name" name="modifying" onclick="modifyingStudent()">
        </div>
    </c:if>

        <div class="disc_list">
            Students list
        </div>

			<div>
                <table id="student_list_table">
					<tr>
						<th width="8%" height="50px"></th>
						<th width="30%">Name</th>
						<th width="30%">Surname</th>
						<th width="16%">Group</th>
						<th width="16%">Date of joining</th>
					</tr>
					<c:forEach var="student" items="${students }">
                    <tr>
						<td><input type="checkbox" id="${student.id }"></td>
						<td>${student.name }</td>
						<td>${student.second_name }</td>
						<td>${student.group }</td>
						<td>${ student.date }</td>
					</tr>
					</c:forEach>
				</table>
            </div>
</div>