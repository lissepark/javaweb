<%@ page import="entity.Account" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div class="login_form_container">

    <script>
        function validate(){
            var x=document.forms["form"]["username"].value;
            var y=document.forms["form"]["password"].value;
            if (x.length>0 && x.length<3 || x.length>10){
                document.getElementById("validlogin").innerHTML="Login should contain not less then 3 symbols "+
                "and not more then 10 symbols";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("loginInput").style.border="1px solid black";
                document.getElementById("loginInput").style.backgroundColor="red";
                return false;}
            else if (x.length==0){
                document.getElementById("validlogin").innerHTML="this field has to be filled";
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
                document.getElementById("validpass").innerHTML="Password should contain not less then 3 symbols "+
                "and not more then 10 symbols";
                document.getElementById("popup").style.padding="5px";
                document.getElementById("passInput").style.border="1px solid black";
                document.getElementById("passInput").style.backgroundColor="red";
                return false;}
            else if (y.length==0){
                document.getElementById("validpass").innerHTML="this field has to be filled";
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
                <div class="test_info">
                    <p>To have access to the site please log in and put your password,and select role</p>
                    <p>Test accounts:
                        <p>1. Admin: "login" = sergii, "password" = 12345</p>
                        <p>2. Student: "login" = anna, "password" = 23456</p>
                    </p>
                    <p>Account "sergii" has been supported both roles</p>
                </div>
                <form name="form" action="${CONTEXT }/login.php" method="post" onsubmit="return validate()">
                    <div>
                        <div>
                            <div class="tdlogin">
                                LOGIN:
                            </div>
                            <div class="tdlogin2">
                                <input type="text" name="username" id="loginInput" /><br>
                            </div>
                            <div id="validlogin"></div>
                            <div class="clear"></div>
                        </div>
                        <div>
                            <div class="tdlogin">
                                PASSWORD:
                            </div>
                            <div class="tdlogin2">
                                <input type="text" name="password" id="passInput" />
                            </div>
                            <div id="validpass"></div>
                            <div class="clear"></div>
                        </div>

                        <div id="login_table">
                            <div>
                                <div>Select role:</div>
                                <div>
                                    <select name="role" id="opening_list">
                                        <option value="1">Admin</option>
                                        <option value="2">Student</option>
                                    </select>
                                </div>
                            </div>
                            <div height="60">
                                <div>&nbsp</div>
                                <div><input type="submit" value="ENTER" id="button"></div>
                            </div>
                        </div>
                    </div>
                    <div>
                    <jsp:include page="modules/validationMessage.jsp" />
                    </div>
                </form>
                <%
                    Integer c = (Integer) request.getAttribute("a");
                    Account b = (Account) request.getAttribute("b");
                    if (b != null) {
                %>

                <script>
                    window.getElementById('parent_popup').style.display = 'none';
                </script>
                <%
                } else if (c == null) {
                %>
                Please log in.
                <script>
                    var delay_popup = 1000;
                    setTimeout(
                            "document.getElementById('parent_popup').style.display='block'",
                            delay_popup);
                </script>
                <%
                } else if (c > 0) {
                %>
               Wrong login or password. Please try again or register.
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