<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>

<%

	UsersServiceImpl uDao = new UsersServiceImpl();
	List<UsersBean> users = uDao.getAllUsers();
		
%>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Users list</h1>
      <nav>
        <a type="button" class="btn btn-success" asp-area="Admin" asp-controller="Menu" asp-action="Create">
                <i class="bi bi-file-earmark-text me-1"></i>Add a menu
            </a>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Datatables</h5>
              <p>Add lightweight datatables to your project with using the <a href="https://github.com/fiduswriter/Simple-DataTables" target="_blank">Simple DataTables</a> library. Just add <code>.datatable</code> class name to any table you wish to conver to a datatable. Check for <a href="https://fiduswriter.github.io/simple-datatables/demos/" target="_blank">more examples</a>.</p>

              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <th>
                      <b>Email</b>
                    </th>
                    <th>Full name</th>
                    <th>Password</th>
                    
                    <th>Mobile</th>
                    <th>Address</th>
                    <th>Gender</th>
                    <th>Avatar</th>
                    <th>Role</th>
                  </tr>
                </thead>
                <tbody>
                <%
					for (UsersBean user : users) {
				%>
                  <tr>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getFullName()%></td>
                    <td><%=user.getPassword()%></td>
                    
                    <td><%=user.getMobile()%></td>
                    <td><%=user.getAddress()%></td>
                    <td><%=user.getGender()%></td>
                    <td><%=user.getAvatar()%></td>
                    <td><%=user.getRole()%></td>
                    
                  </tr>
                 <% } %>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

<%@ include file="adminfooter.jsp" %>