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
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
			crossorigin="anonymous" />
	</head>
	<body>
	<% 
		HashMap<String, Object> question = (HashMap<String, Object>) request.getAttribute("question");
		ArrayList questionsUidList = (ArrayList) request.getAttribute("questionsUidList");
		ArrayList answersList = (ArrayList) request.getAttribute("answersList");
		String questionsUid = (String) request.getAttribute("questionsUid");
	%>
		<div class="container">
			<div> <%-- Q1/Q2/Q3/Q4/Q5 --%>
					<div class="pagination justify-content-left">
						
					<%  for (int i = 0; i < questionsUidList.size(); i++) { %>
							<span class="">
							<a class="page-item page-link text-bg-primary" href="/polls/PollServlet?QUESTIONS_UID=<%= questionsUidList.get(i)%>"><%= questionsUidList.get(i)%></a>
							</span>
					<%  } %>
						
					</div>
			</div>
			<div class="mt-3 mb-2"> <%-- 2. 주문시 직원은 고객님께 친절 하였습니까?</div> --%>
				<%= question.get("ORDERS") %>. <%= question.get("QUESTIONS")%>
			</div>
			<div> <%-- (1) 전혀 아니다 (2) 아니다 (3) 보통이다 --%>
				<%
					for (int i=0; i<answersList.size();i++) { %>
						<span>
							<input type="radio" id="radio_<%=i%>" name="radio_<%=questionsUid %>">
							<label for="radio_<%=i%>">(<%= i+1%>)<%=answersList.get(i)%></label>
						</span>
				<%
					}
				%>
			</div>
			<div> <%-- (1) 전혀 아니다 (2) 아니다 (3) 보통이다 --%>
				<%
					ArrayList<HashMap> answer_list = null;
					answer_list = (ArrayList<HashMap>) request.getAttribute("answer_list");
					for (int i=0; i<answer_list.size();i++) {
						HashMap<String,Object> answer = answer_list.get(i);
				%>
				<div>(<%=answer.get("ORDERS") %>) <%=answer.get("EXAMPLE")%></div>

				<%} %>
			</div>
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
			crossorigin="anonymous"></script>
	</body>
</html>
