<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>

<main id="main" class="main">
    <div class="pagetitle">
        <h2>Add a blog category</h2>
    </div>
    <div class="container shadow p-5">
        <form method="Post" action="AddBlogCategoriesServ">
            <div class="form-row">
                <div class="form-group col-md-6 mb-3">
                    <label>Blog Category name</label>
                    <input type="text" class="form-control"  placeholder="Email..." name="blogcategory">
                    <span  class="alert-dagger"></span>
                </div>
                

                
            </div>

            <a  class="btn btn-lg btn-warning p-2">
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