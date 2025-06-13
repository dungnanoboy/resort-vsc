<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>

<%
    BlogCategoriesBean blogCategory = (BlogCategoriesBean) request.getAttribute("blogCategory");
%>

<main id="main" class="main">
    <div class="pagetitle">
        <h2>Edit a blog category</h2>
    </div>
    <div class="container shadow p-5">
        <form method="post" action="UpdateBlogCategoriesServ">
            <input type="hidden" name="catblogId" value="<%= blogCategory.getCatblogId() %>">
            <div class="form-row">
                <div class="form-group col-md-6 mb-3">
                    <label>Blog Category Name</label>
                    <input type="text" class="form-control" placeholder="Category Name..." name="catblogName" value="<%= blogCategory.getCatblogName() %>" required>
                    <span class="alert-dagger"></span>
                </div>
            </div>

            <a href="blogcategoriesTB.jsp" class="btn btn-lg btn-warning p-2">
                <i class="bi bi-arrow-left-circle"></i>
                Go back
            </a>

            <button type="submit" class="btn btn-lg btn-primary p-2">
                <i class="bi bi-file-plus-fill"></i> Save information
            </button>
        </form>
    </div>
</main>

<%@ include file="adminfooter.jsp" %>
