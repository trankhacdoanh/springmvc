<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editURL" value="/quan-tri/bai-viet/chinh-sua"/>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach"/>
<c:url var="newAPI" value="/api/new"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<div class="main-content">

		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>

				<li><a href="#">Forms</a></li>
				<li class="active">Form Elements</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>

		<div class="row">
			<div class="col-xs-12">
				<c:if test="${not empty message}">
					<div class="alert alert-${alert}" role="alert">
					  	${message}
					</div>
				</c:if>
				<form:form class="form-horizontal" role="form" id="formSubmit"
					modelAttribute="model">
					<div class="form-group">
						<label for="sel1" class="col-sm-3 control-label no-padding-right">Select
							list:</label>
						<div class="col-sm-9">
							<%-- <select class="col-xs-10 col-sm-5" id="categoryCode"
								name="categoryCode">
								<option>--Chọn--</option>
								<c:forEach var="i" items="${categories}"> 
									<option value="${i.code}">${i.name}</option>
								</c:forEach>
							</select> --%>
							<form:select path="categoryCode" name="categoryCode">
								<form:option value="" label="--Chọn--" />
								<form:options items="${categories}" itemValue="code"
									itemLabel="name" />
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Tiêu đề </label>

						<div class="col-sm-9">
							<!-- <input type="text" id="form-field-1"
								id="title" name="title"  class="col-xs-10 col-sm-5" /> -->
							<form:input path="title" cssClass="col-xs-10 col-sm-5" id="title" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Ảnh đại diện </label>

						<div class="col-sm-9" style="padding-top: 7px;">
							<input type="file" class="col-xs-10 col-sm-5" id="thumbnail"
								name="thumbnail" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Mô tả ngắn </label>

						<div class="col-sm-9">
							<!-- <textarea cols="90" rows="5" id="shortDescription"
								name="shortDescription"></textarea> -->
							<form:textarea path="shortDescription" cols="90" rows="5"
								id="shortDescription" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Nội dung </label>

						<div class="col-sm-9">
							<!-- <textarea rows="5" cols="90" id="content" name="content"></textarea> -->
							<form:textarea path="content" rows="5" cols="90" id="content" />
						</div>
					</div>
					<form:hidden path="id" id="id" />
					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<c:if test="${not empty model.id}">
								<button class="btn btn-info" type="button"
									id="btnAddOrUpdateNew">
									<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật bài
									viết
								</button>
							</c:if>
							<c:if test="${empty model.id }">
								<button class="btn btn-info" type="button"
									id="btnAddOrUpdateNew">
									<i class="ace-icon fa fa-check bigger-110"></i> Thêm bài viết
								</button>
							</c:if>

							&nbsp; &nbsp; &nbsp;
							<button class="btn" type="reset" id="btnHuy">
								<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
							</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script>
		$("#btnAddOrUpdateNew").click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data[""+v.name+""] = v.value; 
			});
			var id = $("#id").val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}

		});
		function addNew(data) {
			$.ajax({
				url : '${newAPI}',
				contentType : "application/json",
				data: JSON.stringify(data),
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					window.location.href = "${editURL}?id="+data.id+"&message=insert_succes";
				},
				error : function() {
					window.location.href = "${newURL}?page=1&limit=2&message=error_system";
				}
			});
		}
		function updateNew(data) {
			$.ajax({
				url : '${newAPI}',
				contentType : "application/json",
				data: JSON.stringify(data),
				type : 'PUT',
				dataType : 'json',
				success : function(data) {
					window.location.href = "${editURL}?id="+data.id+"&message=update_succes";
				},
				error : function() {
					window.location.href = "${newURL}?page=1&limit=2&message=error_system";
				}
			});
		}
		$("#btnHuy").click(function(e) {
			window.location.href = "${newURL}?page=1&limit=2";
		});
	</script>
</body>
</html>