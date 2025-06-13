<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>

<%

	BlogsServiceImpl blDao = new BlogsServiceImpl();
	List<BlogsBean> blogs = blDao.getAllBlogs1();
		
%>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Blog list</h1>
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
                      <b>Post ID</b>
                    </th>
                    <th>Title</th>
                    <th>Content</th>
                    <th>Summary</th>
                    <th>Author</th>
                    <th>Publish date</th>
                    <th>Category ID</th>
                    <th>Picture</th>
                    <th>Emotion </th>
                  </tr>
                </thead>
                <tbody>
                <%
					for (BlogsBean blog : blogs) {
				%>
                  <tr>
                    <td><%=blog.getPostId()%></td>
                    <td><%=blog.getTitle()%></td>
                    <td><%=blog.getContent()%></td>
                    <td><%=blog.getSummary()%></td>
                    <td><%=blog.getAuthor()%></td>
                    <td><%=blog.getPublishDate()%></td>
                    <td><%=blog.getCatblogId()%></td>
                    <td><%=blog.getPicture()%></td>
                    <td><%=blog.getEmotion()%></td>
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