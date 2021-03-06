<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Super Admin | Create User</title>
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
            <li class="breadcrumb-item">
                <a href="<c:url value="/manage_users"/>">
                    Users
                </a>
            </li>
            <li class="breadcrumb-item active">
                Create User
            </li>
        </ol>

        <div class="card mb-3">
            <div class="card-header d-flex flex-row align-items-center">
                <i class="fa fa-users-cog mr-2"></i>
                <strong>Create User</strong>
            </div>
            <div class="card-body">
                <form action="<c:url value="/create_user"/>" method="POST" id="create_user_form">
                        <div class="form-group">
                            <strong><label for="username">Username</label></strong>
                            <input class="form-control" type="text" name="username" id="username" required>
                        </div>

                        <div class="form-group">
                            <strong><label for="password">Password</label></strong>
                            <input class="form-control" type="password" name="password" id="password" required>
                        </div>
                        <div class="form-group">
                            <strong><label for="first_name">First Name</label></strong>
                            <input class="form-control" type="text" name="first_name" id="first_name" required>
                        </div>
                        <div class="form-group">
                            <strong><label for="last_name">Last Name</label></strong>
                            <input class="form-control" type="text" name="last_name" id="last_name" required>
                        </div>
                        <div class="form-group">
                            <strong><label for="phone_number">Phone Number</label></strong>
                            <input class="form-control" type="text" name="phone_number" id="phone_number" required>
                        </div>
                        <div class="form-group">
                            <strong><label for="email">Email</label></strong>
                            <input class="form-control" type="email" name="email" id="email" required>
                        </div>
                        <div class="form-group">
                            <strong><label for="role">Select Role</label></strong>

                            <select class="form-control" name="role" id="role">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.id}">${role.title}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <strong><label for="company">Select Company</label></strong>

                            <select class="form-control" name="company" id="company">
                                <option value="nothing" selected>-</option>

                                <c:forEach items="${companies}" var="company">

                                    <option value="${company.id}">
                                            ${company.title}
                                    </option>

                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <strong><label for="department">Select Department</label></strong>

                            <select class="form-control" name="department" id="department">
                                <option value="nothing" selected>-</option>

                                <c:forEach items="${departments}" var="department">

                                    <option value="${department.id}">
                                            ${department.title}
                                    </option>

                                </c:forEach>
                            </select>
                        </div>
                </form>
            </div>
            <div class="card-footer flex-row align-items-center text-right">
                <a href="manage_users" class="btn btn-warning"><i class="fas fa-caret-left" style="margin-right:8px"></i>Cancel</a>
                <button type="submit" class="btn btn-success" form="create_user_form"><i class="far fa-save" style="margin-right:8px"></i>Save</button>
            </div>

        </div>
    </div>
    <c:import url="/WEB-INF/views/footer.jsp"></c:import>
</div>
<c:import url="/WEB-INF/views/scripts.jsp"></c:import>
</body>
</html>
