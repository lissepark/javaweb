<%@ page import="java.util.Calendar" import="java.util.Locale"
         import="java.util.TimeZone" language="java"%>
<%@ page import="entity.Account"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Students studing management system</title>
    <meta name="description" content="site about students">
    <meta name="keywords"
          content="student, group">
    <meta name="author" content="Sergii">
    <link rel="stylesheet" type="text/css"
          href="${CONTEXT }/resources/css/jquery-ui-1.10.4.custom.css" />
    <script type="text/javascript"
            src="${CONTEXT }/resources/js/jquery-1.10.2.min.js"></script>
    <link href="${CONTEXT }/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="${CONTEXT }/resources/css/webtasks.css" rel="stylesheet" type="text/css">
    <script type="text/javascript"></script>

    <script type="text/javascript"
	    src="${CONTEXT }/resources/js/webtasks.js"></script>
    <script type="text/javascript"
	    src="${CONTEXT }/resources/js/jquery-ui-1.10.4.custom.js"></script>

    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

    <script>
	    $(function() {
		    $("#datepicker").datepicker({
			    dateFormat : "dd/mm/yy"
		    });
		    $("#anim").change(function() {
			$("#datepicker").datepicker("option", "showAnim", $(this).val());
		    });
	    });

	    var context = "${CONTEXT}";
    </script>

  </head>

<body>
	<div class="divHead">
        <div class="divNadpis">
                <p class="p1">
                    Students studying management<br>System
                </p>
        </div>
        <div class="divNadpis2"></div>
    </div>
    <div class="prosl">
        <jsp:include page="logout/logoutLink.jsp" flush="true" />
    </div>
    <div class="clear"></div>
    <div>
	<jsp:include page="${currentPage}" flush="true" />
    </div>
    <div class="title_page_container">
        <table cellpadding="0">
            <tr>
                <td align="left">
                    <a	href="${CONTEXT}${CURRENT_MAPPING}/studentsList.php">Students</a>
                </td>
                <td align="center">
                    <a	href="${CONTEXT }${CURRENT_MAPPING}/disciplinesList.php">Subjects</a>
                </td>
                <c:if test="${CURRENT_ROLE eq 1}">
                    <td align="center"><a href="${CONTEXT }${CURRENT_MAPPING}/marksList.php">
                        Add marks</a>
                    </td>
                </c:if>
                <td align="right">
                    <a href="${CONTEXT}${CURRENT_MAPPING}/termsList.php">Marking periods</a>
                </td>
            </tr>
        </table>
    </div>

    <div class="prosl"></div>
<div class="divmenu2">
    <div class="divmenu21">
        <div class="divmenu211">WELCOME</div>
        <div class="divmenu212">
            <p class="p3">Welcome to our school of programming</p>
            <p class="p5">We teach such programming:
            Android programming, Java programming, PHP, HTML/CSS and web-design</p>
        </div>
    </div>
    <div class="divmenu22">
        <div class="divmenu221">BEST STUDENTS</div>
        <div class="divmenu222">
            <div class="divmenu2221">
                <img src="${CONTEXT }/resources/css/images/footimg2.jpg">
                <p class="p3">Andrew</p>
                <p class="p4">Best results in PHP programming</p>
                <p class="p5">Best results in PHP programming</p>
            </div>
            <div class="divmenu2222">
                <img src="${CONTEXT }/resources/css/images/footimg1.jpg">
                <p class="p3">Anna</p>
                <p class="p4">Best results in JS programming</p>
                <p class="p5">Best results in JS programming</p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="divmenu23">
        <div class="divmenu231">NEWS</div>
        <div class="divmenu232">
            <p class="p3">Android Course</p>
            <p class="p5">07.09.2015 Android course will start</p>
        </div>
        <div class="divmenu233">
            <p class="p3">HTML/CSS Course</p>
            <p class="p5">04.09.2015 HTML/CSS course will start</p>
        </div>
        <div class="divmenu234">
            <p class="p3">Java Course</p>
            <p class="p5">01.09.2015 Java course will start</p>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="divFooter">
    <div class="divFooter1">
        <div class="divFooter11">
            <div class="divFooter111">
                <p class="p2">While developing the project such
                    programming technologies were used:</p>
            </div>
            <div class="divFooter112">
                <div class="divFooter113">
                    <ul>
                        <li>Java SE/Java EE</li>
                        <li>IntelliJ IDEA/Notepad</li>
                        <li>HTML/CSS</li>
                        <li>Maven</li>
                        <li>JSP/JSTL</li>
                    </ul>
                </div>
                <div class="divFooter113">
                    <ul>
                        <li>SQL/MySQL</li>
                        <li>JDBC</li>
                        <li>Tomcat</li>
                        <li>JavaScript/JQuery</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="divFooter13">
            <div class="divFooter131">
                <p class="pfooter2">
                    E-mail: sergiivarenyk@gmail.com<br> Tel.: +38(096) 509-59-50<br>
                </p>
            </div>
            <div class="divFooter131">
                <p class="pfooter">
                    &copy; Sergii Varenyk
                    <%
                        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(),
                                Locale.getDefault());
                        int year = calendar.get(Calendar.YEAR);
                        if (year > 2011) {
                    %>2011 -
                    <%=year%>
                    <%
                    } else {
                    %>
                    2011<%
                    }
                %>
                </p>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
</body>
</html>