<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%-- 한글세팅 --%>
<%@ page import="java.util.HashMap,java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Document</title>
	</head>
	<body>
	<% 
		HashMap<String, Object> question = (HashMap<String, Object>) request.getAttribute("question");
		ArrayList questionsUidList = (ArrayList) request.getAttribute("questionsUidList");
		ArrayList answersList = (ArrayList) request.getAttribute("answersList");
		String questionsUid = (String) request.getAttribute("questionsUid");
	%>
		<div> <%-- Q1/Q2/Q3/Q4/Q5 --%>
		<% 
			for (int i = 0; i < questionsUidList.size(); i++) {
		%>
			<a href="/polls/PollServlet?QUESTIONS_UID=<%= questionsUidList.get(i)%>"><%= questionsUidList.get(i)%></a> /
		<%
			}
		%>
		</div>
		<div> <%-- 2. 주문시 직원은 고객님께 친절 하였습니까?</div> --%>
			<%= question.get("ORDERS") %>. <%= question.get("QUESTIONS")%>
		</div>
		<div> <%-- (1) 전혀 아니다 (2) 아니다 (3) 보통이다 --%>
			<%
				for (int i=0; i<answersList.size();i++) { %>
					<span>
						<input type="radio" id="radio_<%=i%>" name="radio_<%=questionsUid %>" value="HTML">
						<label for="radio_<%=i%>">(<%= i+1%>)<%=answersList.get(i)%></label>
					</span>
			<%
				}
			%>
		</div>
	</body>
</html>
