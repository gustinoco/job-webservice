
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<title id="titleBk"><tiles:insertAttribute name="title"
		ignore="true" /></title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/images/icon/icon.ico" />

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300'
	rel='stylesheet' type='text/css'></link>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/jquery-2.2.0.js"></script>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/jquery-ui-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css"></link>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"></link>


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/datatables.css"></link>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/datatables.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/moment.min.js"></script>
<!--requisito para ordenação por data -->
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/datetime-moment.js"></script>
<!--Ordenar datas das tabelas datatable pt-br -->
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/datatable/FixedColumns.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/datatable/FixedColumns.js"></script>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/jquery.mask.min.js"></script>



<!-- New Alert -->
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/lib/newAlert.js"></script>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/lib/newConfirm.js"></script>


<!--Bootstrap-->
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
<script type="text/javascript" charset="utf8"
	src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-select.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"></link>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/lib/bootstrap-select.css"></link>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css"></link>

</head>
<body>

</body>
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="navbar" />
<tiles:insertAttribute name="body" />
</html>