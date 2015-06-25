<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>letterConversion</title>

<link href="<c:url value="/res/assets/css/letter.css" />"
	rel="stylesheet">
<link href="<c:url value="/res/assets/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/res/assets/js/jquery-2.1.3.min.js" />"></script>
<script src="<c:url value="/res/assets/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div id="wrapper">
		<c:if test="${not empty message}">
		<a href="<c:url value="/res/assets/pdf/${timestamp}-letter.pdf" />">Download Gesch&auml;ftsbrief</a>
		<!-- <div class="message green">${message}</div> --></c:if>
		<div id="headline">LetterConversion</div>
		<form:form action="/letterConversion/formPage.html"
			modelAttribute="letter" class="form-horizontal">
			<div class="form-group">
				<label for="date" class="control-label col-xs-2">Datum</label>
				<div class="col-xs-10">
					<form:input path="date" id="date" placeholder="MM/DD/YYYY"
						class="form-control"></form:input>
					<form:errors path="date" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderSurname" class="control-label col-xs-2">Sender
					Vorname</label>
				<div class="col-xs-10">
					<form:input path="senderSurname" id="senderSurname"
						class="form-control"></form:input>
					<form:errors path="senderSurname" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderName" class="control-label col-xs-2">Sender
					Name</label>
				<div class="col-xs-10">
					<form:input path="senderName" id="senderName" class="form-control"></form:input>
					<form:errors path="senderName" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderStreet" class="control-label col-xs-2">Sender
					Straﬂe</label>
				<div class="col-xs-10">
					<form:input path="senderStreet" id="senderStreet"
						class="form-control"></form:input>
					<form:errors path="senderStreet" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderNr" class="control-label col-xs-2">Sender
					Nr.</label>
				<div class="col-xs-10">
					<form:input path="senderNr" id="senderNr"
						class="form-control"></form:input>
					<form:errors path="senderNr" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderPLZ" class="control-label col-xs-2">Sender
					PLZ</label>
				<div class="col-xs-10">
					<form:input path="senderPLZ" id="senderPLZ" class="form-control"></form:input>
					<form:errors path="senderPLZ" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderPlace" class="control-label col-xs-2">Sender
					Ort</label>
				<div class="col-xs-10">
					<form:input path="senderPlace" id="senderPlace"
						class="form-control"></form:input>
					<form:errors path="senderPlace" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderPhone" class="control-label col-xs-2">Sender
					Telefon</label>
				<div class="col-xs-10">
					<form:input path="senderPhone" id="senderPhone"
						class="form-control"></form:input>
					<form:errors path="senderPhone" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="senderEmail" class="control-label col-xs-2">Sender
					Email</label>
				<div class="col-xs-10">
					<form:input path="senderEmail" id="senderEmail"
						class="form-control"></form:input>
					<form:errors path="senderEmail" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="recipientSurname" class="control-label col-xs-2">Empf‰nger
					Vorname</label>
				<div class="col-xs-10">
					<form:input path="recipientSurname" id="recipientSurname"
						class="form-control"></form:input>
					<form:errors path="recipientSurname" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="recipientName" class="control-label col-xs-2">Empf‰nger
					Name</label>
				<div class="col-xs-10">
					<form:input path="recipientName" id="recipientName"
						class="form-control"></form:input>
					<form:errors path="recipientName" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="recipientStreet" class="control-label col-xs-2">Empf‰nger
					Straﬂe</label>
				<div class="col-xs-10">
					<form:input path="recipientStreet" id="recipientStreet"
						class="form-control"></form:input>
					<form:errors path="recipientStreet" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="recipientNr" class="control-label col-xs-2">Empf‰nger
					Nr.</label>
				<div class="col-xs-10">
					<form:input path="recipientNr" id="recipientNr"
						class="form-control"></form:input>
					<form:errors path="recipientNr" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="recipientPLZ" class="control-label col-xs-2">Empf‰nger
					PLZ</label>
				<div class="col-xs-10">
					<form:input path="recipientPLZ" id="recipientPLZ"
						class="form-control"></form:input>
					<form:errors path="recipientPLZ" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="recipientPlace" class="control-label col-xs-2">Empf‰nger
					Ort</label>
				<div class="col-xs-10">
					<form:input path="recipientPlace" id="recipientPlace"
						class="form-control"></form:input>
					<form:errors path="recipientPlace" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="reference" class="control-label col-xs-2">Referenz</label>
				<div class="col-xs-10">
					<form:input path="reference" id="reference" class="form-control"></form:input>
					<form:errors path="reference" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="regard" class="control-label col-xs-2">Betreff</label>
				<div class="col-xs-10">
					<form:input path="regard" id="regard" class="form-control"></form:input>
					<form:errors path="regard" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="salutation" class="control-label col-xs-2">Anrede</label>
				<div class="col-xs-10">
					<form:input path="salutation" id="salutation" class="form-control"></form:input>
					<form:errors path="salutation" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="text" class="control-label col-xs-2">Text</label>
				<div class="col-xs-10">
					<form:textarea path="text" id="text" class="form-control"></form:textarea>
					<form:errors path="text" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="greeting" class="control-label col-xs-2">Gruﬂformel</label>
				<div class="col-xs-10">
					<form:input path="greeting" id="greeting" class="form-control"></form:input>
					<form:errors path="greeting" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label for="facilities" class="control-label col-xs-2">Anlage</label>
				<div class="col-xs-10">
					<form:textarea path="facilities" id="facilities"
						class="form-control"></form:textarea>
					<form:errors path="facilities" cssclass="error" class="error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<button type="submit" class="btn btn-primary">Gesch‰ftsbrief
						erstellen</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>