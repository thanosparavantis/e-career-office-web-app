<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Super Admin | Manage Departments</title>
    <meta charset="UTF-8">
    <c:import url="/WEB-INF/views/styles.jsp"></c:import>
</head>
<body class="fixed-nav sticky-footer bg-dark">
<c:import url="/WEB-INF/views/nav.jsp"></c:import>
<div class="content-wrapper">
    <div class="container-fluid">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="<c:url value="/super_admin"/>">
                    Super Admin
                </a>
            </li>
            <li class="breadcrumb-item active">
                Departments
            </li>
        </ol>
        <div class="card mb-3">
            <div class="card-header d-flex flex-row align-items-center">
                <i class="fa fa-warehouse mr-2"></i>
                <strong class="mr-auto">Departments</strong>
                <a class="btn btn-info"
                   href="<c:url value="/create_department" />">
                    <i class="far fa-plus-square" style="margin-right:8px"></i>
                    Create Department
                </a>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered table-striped" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Title</td>
                            <td>Actions</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${departments}" var="department">
                            <tr>
                                <td><c:out value="${department.id}" default="-"/></td>
                                <td><c:out value="${department.title}" default="-"/></td>
                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-primary"
                                           href="<c:url value="/view_department?id=${department.id}"/>"><i class="fas fa-external-link-alt" style="margin-right:8px"></i>Show</a>
                                        <a class="btn btn-warning"
                                           href="<c:url value="/edit_department?id=${department.id}"/>"><i class="far fa-edit" style="margin-right:8px"></i>Edit</a>
                                        <a class="btn btn-danger"
                                           href="<c:url value="/delete_department?id=${department.id}"/>"><i class="fas fa-times" style="margin-right:8px"></i>Delete</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <c:import url="/WEB-INF/views/footer.jsp"></c:import>
    </div>
</div>
<c:import url="/WEB-INF/views/scripts.jsp"></c:import>
</body>
</html>
