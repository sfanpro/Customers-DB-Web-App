<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List customers</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

		<div id="container">
			<div id="content">

				<!-- Add our html table here -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomers" items="${customers}">
					<tr>
						<td>${tempCustomers.firstName}</td>
						<td>${tempCustomers.lastName}</td>
						<td>${tempCustomers.email}</td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>

</html>