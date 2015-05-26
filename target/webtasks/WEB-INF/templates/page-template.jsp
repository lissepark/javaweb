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
    <title>Система управления студентами и их успеваемостью</title>
    <meta name="description" content="сайт о списке студентов">
    <meta name="keywords"
          content="студент, список группы, университет, успеваемость студентов">
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
                    System <br>of management education process
                </p>
        </div>
        <div class="divNadpis2"></div>
    </div>
    <div class="prosl"></div>

	<div><jsp:include page="logout/logoutLink.jsp" flush="true" /></div>

	<jsp:include page="${currentPage}" flush="true" />

    <div class="prosl"></div>
<div class="divmenu2">
    <div class="divmenu21">
        <div class="divmenu211">WELCOME</div>
        <div class="divmenu212">
            <p class="p3">Do you like green eggs and ham?</p>
            <p class="p5">I would not like them here or there. I would not
                like them anywhere. I do not like green eggs and ham. I do not like
                them, Sam-I-am.</p>
        </div>
    </div>
    <div class="divmenu22">
        <div class="divmenu221">THE BEST STUDENTS</div>
        <div class="divmenu222">
            <div class="divmenu2221">
                <img src="${CONTEXT }/resources/css/images/footimg1.jpg">
                <p class="p3">Mickey's girlfriend</p>
                <p class="p4">Surprising meeting</p>
                <p class="p5">Would you like them with a mouse?</p>
            </div>
            <div class="divmenu2222">
                <img src="${CONTEXT }/resources/css/images/footimg2.jpg">
                <p class="p3">That Sam-I-am</p>
                <p class="p4">I do so like...</p>
                <p class="p5">Would you like them in a house?</p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="divmenu23">
        <div class="divmenu231">NEWS LIST</div>
        <div class="divmenu232">
            <p class="p3">Do you like green eggs and ham?</p>
            <p class="p5">I do not like them, Sam-I-am.</p>
        </div>
        <div class="divmenu233">
            <p class="p3">Do you like?</p>
            <p class="p5">I do not like them.</p>
        </div>
        <div class="divmenu234">
            <p class="p3">Do you like green eggs and ham?</p>
            <p class="p5">I do not like them.</p>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="divFooter">
    <div class="divFooter1">
        <div class="divFooter11">
            <div class="divFooter111">
                <p class="p2">While creating the project were used such
                    software technologies:</p>
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