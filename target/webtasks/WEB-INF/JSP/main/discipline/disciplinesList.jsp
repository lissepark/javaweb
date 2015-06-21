<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="disciplines_List_container">
    <div class="linkTermMain">
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">To Main</a>
    </div>
    <c:if test="${CURRENT_ROLE eq 1}">
        <div>
            <input type="submit" class="button_long_name" onclick="createDiscipline()"
                value="Add Subject">
        </div>
    </c:if>

        <div class="disc_list">
            Disciplines list
        </div>

        <div class="all_tabl">
            <div class="head_name_disc">Name of Subject</div>
            <c:forEach var="discipline" items="${disciplines }">
            <div>
                <div class="line_disc">
                        ${discipline.name}
                </div>
                <c:if test="${CURRENT_ROLE eq 1}">
                    <div class="modify">
                        <input type="submit" name="id" id="${discipline.id }"
                               class="buttonModDelDisc"
                               onclick="modifDiscipline(id)"
                               value="Modify">
                    </div>
                    <div class="del">
                        <input type="submit" name="value1" value="Delete"
                                class="buttonModDelDisc"
                                onclick="deleteDiscipline(${discipline.id })">
                    </div>
                </c:if>
                <div class="clear"></div>
            </div>
            </c:forEach>
        </div>

        <c:if test="${CURRENT_ROLE eq 1}">
                <div>
                    <input type="submit" class="button_long_name" onclick="createDiscipline()"
                            value="Add Subject">
                </div>
        </c:if>

</div>