<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mainTerm">
    <div class="linkTermMain">
		<a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To Main</a>
    </div>

    <div class="choose">
        <c:if test="${CURRENT_ROLE eq 1}">
        <div class="createTerm">
            <form action="${CONTEXT }${CURRENT_MAPPING}/termCreating.php" method="GET">
                <input type="submit" class="button_long_name" value="Add marking period">
            </form>
        </div>
        </c:if>
        <div class="title_choose_semester">Select the marking period and press button "SELECT"</div>
        <div class="clear"></div>
        <div class="chooser_semester">
	        <form action="${CONTEXT }${CURRENT_MAPPING}/termsList.php" method="POST">
                    <select id="opening_list" name="chooser">
                        <option disabled selected="selected" value="">Select the marking period</option>
                        <c:forEach var="term" items="${terms}">
						    <c:choose>
							    <c:when test="${term.id  eq selectedTerm.id}">
								    <option selected="selected" value="${term.id }">
                                        ${term.name }
                                    </option>
							    </c:when>
		    				    <c:otherwise>
			               		    <option value="${term.id }">
                                        ${term.name }
                                    </option>
				                </c:otherwise>
					        </c:choose>
                        </c:forEach>
                    </select>
				<div class="choose_button">
                <input type="submit" value="SELECT" id="button">
                </div>
            </form>
        </div>
    </div>

    <c:choose>
        <c:when test="${selectedTerm.duration != null}">
            <div class="test_09">Marking period: ${selectedTerm.name}</div>
    <div class="test_09">Duration of the marking period: ${selectedTerm.duration}
        <c:choose>
            <c:when test="${selectedTerm.duration == null}">
            </c:when>
            <c:when test="${Math.abs(selectedTerm.duration % 10)==0}">недель</c:when>
            <c:when test="${Math.abs(selectedTerm.duration % 10)>4&&
                        Math.abs(selectedTerm.duration % 10)<10}">недель</c:when>
            <c:when test="${Math.abs(selectedTerm.duration % 10)==1}">неделя</c:when>
            <c:otherwise>недели</c:otherwise>
        </c:choose>
    </div>
        <c:if test="${CURRENT_ROLE eq 1}">
    <div class="test_09">
        <input type="button" onclick="modifyingTerm()" class="button_long_name"
               value="Modify">
    </div>
    <div class="test_09">
         <input type="button"
                class="button_long_name" value="Delete" onclick="deleteTerm()">
    </div>
        </c:if>
    <div class="name_list_disc">
				List of subjects in the marking period ${selectedTerm.name}
	</div>

	<div class="listAllDisc">
		<div class="nameDisc1">
			Name of subject:
		</div>
	    	<c:forEach var="discipline" items="${disciplines }">
				<c:if test="${discipline ne null }">
					<div class="disciplineName">
						${discipline.name }
					</div>
                </c:if>
			</c:forEach>
    </div>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</div>