<%@ page import="entity.Account" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div align="right" style="position: fixed; right: 20px; bottom: 0px;">
	<p>Тестовые аккаунты: "admin / password" , "sergii / 12345"</p>
	<p>Аккаунт "admin" поддерживает обе роли</p>
</div>

<div class="login_form_container">

    <script>
        function validate(){
            var x=document.forms["form"]["login"].value;
            var y=document.forms["form"]["password"].value;
            if (x.length>0 && x.length<3 || x.length>10){
                document.getElementById("validlogin").innerHTML="Логин должен содержать не менее 3-х "+
                "и не более 10-ти символов";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("loginInput").style.border="1px solid black";
                document.getElementById("loginInput").style.backgroundColor="red";
                return false;}
            else if (x.length==0){
                document.getElementById("validlogin").innerHTML="данное поле обязательно для заполнения";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("loginInput").style.border="1px solid black";
                document.getElementById("loginInput").style.backgroundColor="red";
                return false;
            }
            else{
                document.getElementById("validlogin").innerHTML="";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("loginInput").style.border="1px solid black";
                document.getElementById("loginInput").style.backgroundColor="green";
            }
            if (y.length>0 && y.length<3 || y.length>10){
                document.getElementById("validpass").innerHTML="Пароль должен содержать не менее 3-х "+
                "и не более 10-ти символов";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("passInput").style.border="1px solid black";
                document.getElementById("passInput").style.backgroundColor="red";
                return false;}
            else if (y.length==0){
                document.getElementById("validpass").innerHTML="данное поле обязательно для заполнения";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("passInput").style.border="1px solid black";
                document.getElementById("passInput").style.backgroundColor="red";
                return false;
            }
            else{
                document.getElementById("validpass").innerHTML="";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("passInput").style.border="1px solid black";
                document.getElementById("passInput").style.backgroundColor="green";
            }
        }
    </script>
    <div id="parent_popup">
        <div id="popup">
            <div class="form1">
                <form name="form" action="${CONTEXT }/login.php" method="post" onsubmit="return validate()">
                    <table>
                        <tr>
                            <td class="tdlogin">
                                LOGIN:
                            </td>
                            <td class="tdlogin">
                                <input type="text" name="username" id="loginInput" /><br>
                            </td>
                            <td id="validlogin"></td>
                        </tr>
                        <tr>
                            <td class="tdlogin">
                                PASSWORD:
                            </td>
                            <td class="tdlogin">
                                <input type="text" name="password" id="passInput" />
                            </td>
                            <td id="validpass"></td>
                        </tr>
                        <tr>
                            <td class="tdlogin">
                                <input class="tdlogin" type="submit" name="enter" value="Enter" />
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>

                        <table id="login_table">
                            <tr>
                                <td>Выбрать роль:</td>
                                <td><select name="role" id="opening_list">
                                    <option value="1">Администратор</option>
                                    <option value="2">Студент</option>
                                </select></td>
                            </tr>
                            <tr height="60">
                                <td>&nbsp</td>
                                <td><input type="submit" value="войти" id="button"></td>
                            </tr>
                        </table>

                    </table>
                    <jsp:include page="modules/validationMessage.jsp" />
                </form>
                <%
                    Integer c = (Integer) request.getAttribute("a");
                    System.out.println(c);
                    Account b = (Account) request.getAttribute("b");
                    if (b != null) {
                %>

                <script>
                    window.getElementById('parent_popup').style.display = 'none';
                </script>
                <%
                } else if (c == null) {
                %>
                Авторизируйтесь или зарегистрируйтесь.
                <script>
                    var delay_popup = 1000;
                    setTimeout(
                            "document.getElementById('parent_popup').style.display='block'",
                            delay_popup);
                </script>
                <%
                } else if (c > 0) {
                %>
                Неверный логин или пароль. Повторите авторизацию или
                зарегистрируйтесь.
                <script>
                    var delay_popup = 1000;
                    setTimeout(
                            "document.getElementById('parent_popup').style.display='block'",
                            delay_popup);
                </script>
                <%
                    }
                %>
            </div>
        </div>
    </div>



</div>