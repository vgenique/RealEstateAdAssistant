<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/bootstrap4/css/bootstrap.min.css" var="jstlCss" />
<c:url value="" />
<link href="${jstlCss}" rel="stylesheet" />

<script src="/ressources/static/custom-js/custo.js"></script>

<title>Testing Image recognition</title>
</head>
<body>
	<div class="container">
		<jsp:useBean id="obj"
			class="com.capgemini.imagereco.controller.MainController" />
		<!-- HEADER-->
		<nav class="navbar navbar-default">
		<div class="col-md-4">
			<input class="btn btn-primary" type="button" value="Particulier" />
		</div>
		<div class="col-md-4">
			<input class="btn btn-primary" type="button" value="Professionnel" />
		</div>
		</nav>
		<!-- HEADER_END-->
		<!--ROOM TYPE SELECTING -->
		<form>
			<label for="roomNum">Number of rooms</label> <input type="number"
				id="roomNum" />
			<div class="list-group list-group-flush">
				<label>1: <select>
						<%
							List<String> list = obj.getMyList();
							for (String item : list) {
						%>
						<option><%=item%></option>
						<%
							}
						%>
				</select>
				</label>
			</div>

			<!--ROOM TYPE SELECTING_END -->
			<!-- IMAGE UPLOADING AREA-->
			<div>
				<div class="row">
					<div class="col-md-7 offset-col-md-5"></div>
					<div>
						<i class=" btn fas fa-plus-circle fa-5x"></i>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 offset-col-md-6"></div>
					<div>
						<input class="btn btn-primary " type="button" value="Process" />
					</div>
				</div>
			</div>
		</form>
		<!-- IMAGE UPLOADING AREA_END-->

		<!-- API RESULT SUMMARY BOARD-->
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>AWS</th>
						<th>CLARIFY</th>
						<th>Microsoft</th>
						<th>IBM Watson</th>
						<th>Google</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>aws_1</td>
						<td>clarify_1</td>
						<td>aws_1</td>
						<td>clarify_1</td>
					</tr>
					<tr>
						<td>aws_1</td>
						<td>clarify_1</td>
						<td>clarify_1</td>
						<td>aws_1</td>
						<td>clarify_1</td>
					</tr>
					<tr>
						<td>aws_1</td>
						<td>clarify_1</td>
						<td>clarify_1</td>
						<td>aws_1</td>
						<td>clarify_1</td>
					</tr>
					<tr>
						<td>aws_1</td>
						<td>clarify_1</td>
						<td>clarify_1</td>
						<td>aws_1</td>
						<td>clarify_1</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- API RESULT SUMMARY BOARD_END-->

		<!-- CROSS API-IMAGE SUMMARY BOARD-->
		<!--Use case_1-->
		<div class="row  align-middle">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="selected image" />
				<div class="card-body">
					<h5 class="card-title">Image_1</h5>
					<div class="list-group list-group-flush">
						<label> <input type="checkbox" name="imgType"
							value="room_a" checked=true>&nbsp;room_a
						</label> <label> <input type="checkbox" name="imgType"
							value="room_b">&nbsp;room_b
						</label> <label> <input type="checkbox" name="imgType"
							value="room_c">&nbsp;room_c
						</label> <label>Surface:&nbsp; <input type="number" value="" />
						</label>
					</div>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="selected image" />
				<div class="card-body">
					<h5>Image_2</h5>
					<div class="list-group list-group-flush">
						<label> <input type="checkbox" name="imgType"
							value="room_a">&nbsp;room_a
						</label> <label> <input type="checkbox" name="imgType"
							value="room_b">&nbsp;room_b
						</label> <label> <input type="checkbox" name="imgType"
							value="room_c" checked=true>&nbsp;room_c
						</label> <label>Surface:&nbsp; <input type="number" value="" />
						</label>
					</div>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="selected image" />
				<div class="card-body">
					<h5>Image_3</h5>
					<div class="list-group list-group-flush">
						<label> <input type="checkbox" name="imgType"
							value="room_a">&nbsp;room_a
						</label> <label> <input type="checkbox" name="imgType"
							value="room_b" checked=true>&nbsp;room_b
						</label> <label> <input type="checkbox" name="imgType"
							value="room_c">&nbsp;room_c
						</label> <label>Surface:&nbsp; <input type="number" value="" />
						</label>
					</div>
				</div>
			</div>
			<div>
				<input class="btn btn-primary" type="button" value="Generate" />
			</div>
		</div>
		<!--Use case_1_end-->
		<div class="row  align-middle" style="display: none;">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="selected image" />
				<div class="card-body">
					<h5>Image_1</h5>
					<div class="list-group list-group-flush">
						<label> <input type="checkbox" name="imgType"
							value="room_a" checked=true>&nbsp;room_a
						</label> <label> <input type="checkbox" name="imgType"
							value="room_b">&nbsp;room_b
						</label> <label> <input type="checkbox" name="imgType"
							value="room_c">&nbsp;room_c
						</label> <label>Surface:&nbsp; <input type="number" value="" />
						</label>
					</div>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="selected image" />
				<div class="card-body">
					<h5>Image_2</h5>
					<div class="list-group list-group-flush">
						<label> <input type="checkbox" name="imgType"
							value="room_a">&nbsp;room_a
						</label> <label> <input type="checkbox" name="imgType"
							value="room_b">&nbsp;room_b
						</label> <label> <input type="checkbox" name="imgType"
							value="room_c" checked=true>&nbsp;room_c
						</label> <label>Surface:&nbsp; <input type="number" value="" />
						</label>
					</div>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="selected image" />
				<div class="card-body">
					<h5>Image_3</h5>
					<div class="list-group list-group-flush">
						<label> <input type="checkbox" name="imgType"
							value="room_a">&nbsp;room_a
						</label> <label> <input type="checkbox" name="imgType"
							value="room_b" checked=true>&nbsp;room_b
						</label> <label> <input type="checkbox" name="imgType"
							value="room_c">&nbsp;room_c
						</label> <label>Surface:&nbsp; <input type="number" value="" />
						</label>
					</div>
				</div>
			</div>
			<div>
				<input class="btn btn-primary" type="button" value="Generate" />
			</div>
		</div>
		<!-- CROSS API-IMAGE SUMMARY BOARD_END-->
	</div>
</body>
</html>