<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>

<script>
	// Hàm xử lý khi người dùng nhấn vào biểu tượng "Xóa"
	function deleteBLogCategory(catblogId) {
		// Hiển thị hộp thoại xác nhận
		var confirmDelete = confirm("Are you sure to delete blog category with id "
				+ catblogId);
		console.log("Blog category ID to delete:", catblogId);

		// Nếu người dùng nhấn OK, thực hiện xóa
		if (confirmDelete) {
			$.get("DeleteBlogCategoriesServ?IdCatBlogId=" + catblogId,
					function() {
				console.log("Delete request sent for Blog category ID:", catblogId);
						location.reload();
					});
		}
	}
</script>

<%

	BlogCategoriesServiceImpl cateDao = new BlogCategoriesServiceImpl();
	List<BlogCategoriesBean> categories = cateDao.getAllBlogCategories();
		
%>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Blog category list</h1>
      <nav>
        <a type="button" class="btn btn-success" href="+blogcategoriesTB.jsp">
                <i class="bi bi-file-earmark-text me-1"></i>Add new
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
                      <b>Blog Category ID</b>
                    </th>
                    <th>Blog Category Name</th>
                    <th>Functions</th>
                  </tr>
                </thead>
                <tbody>
                <%
					for (BlogCategoriesBean category : categories) {
				%>
                  <tr>
                    <td><%=category.getCatblogId()%></td>
                    <td><%=category.getCatblogName()%></td>
                    <td class="text-center" scope="row">
                       <a href="UpdateBlogCategoriesServ?id=<%=category.getCatblogId()%>" class="btn btn-primary btn-sm" title="Edit "><i class="bi bi-pencil"></i></a>

                       <a href="#" onclick="deleteBLogCategory(<%=category.getCatblogId()%>)" class="btn btn-danger btn-sm" title="Delete"><i class="bi bi-trash"></i></a>
                    </td>
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