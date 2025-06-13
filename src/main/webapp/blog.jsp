<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.Month" %>
<%@ page import="java.util.Set, java.util.HashSet" %>

<%
	String catid_s = request.getParameter("catid");
	String aut = request.getParameter("aut");

	int catid = 0; // Khởi tạo giá trị mặc định cho catid
	if (catid_s != null && !catid_s.isEmpty()) {
    	catid = Integer.parseInt(catid_s);
	}

	BlogsServiceImpl blogDao = new BlogsServiceImpl();
	List<BlogsBean> blogs = blogDao.getAllBlogs(catid, aut);

	BlogCategoriesServiceImpl cateDao = new BlogCategoriesServiceImpl();
	List<BlogCategoriesBean> categories = cateDao.getAllCategories();
	
	
%>

<!-- bradcam_area_start -->
    <div class="bradcam_area breadcam_bg">
        <h3>blog</h3>
    </div>
    <!-- bradcam_area_end -->


    <!--================Blog Area =================-->
    <section class="blog_area section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 mb-5 mb-lg-0">
                    <div class="blog_left_sidebar">
                        <%
                        for (BlogsBean blog : blogs) {
                            LocalDateTime publishDate = blog.getPublishDate();
                            String day = String.valueOf(publishDate.getDayOfMonth());
                            String month = publishDate.getMonth().getDisplayName(java.time.format.TextStyle.SHORT, java.util.Locale.ENGLISH);
						%>
                        <article class="blog_item">
                            <div class="blog_item_img">
                                <img class="card-img rounded-0" src="<%=blog.getPicture()%>" alt="">
                                <a href="#" class="blog_item_date">
                                    <h3><%= day %></h3>
                                    <p><%= month %></p>
                                </a>
                            </div>

                            <div class="blog_details">
                                <a class="d-inline-block" href="BlogInfoSrv?blogId=<%=blog.getPostId()%>">
                                    <h2><%=blog.getTitle()%></h2>
                                </a>
                                <p><%=blog.getSummary()%></p>
                                <ul class="blog-info-link">
                                    <li><a href="#"><i class="fa fa-user"></i> <%=blog.getAuthor()%></a></li>
                                    <li><a href="#"><i class="fa fa-thumbs-up"></i> <%=blog.getEmotion()%> Likes</a></li>
                                </ul>
                            </div>
                        </article>
                        <% } %>
                        
                        <nav class="blog-pagination justify-content-center d-flex">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a href="#" class="page-link" aria-label="Previous">
                                        <i class="ti-angle-left"></i>
                                    </a>
                                </li>
                                <li class="page-item">
                                    <a href="#" class="page-link">1</a>
                                </li>
                                <li class="page-item active">
                                    <a href="#" class="page-link">2</a>
                                </li>
                                <li class="page-item">
                                    <a href="#" class="page-link" aria-label="Next">
                                        <i class="ti-angle-right"></i>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget">
                            <form action="#">
                                <div class="form-group">
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" placeholder='Search Keyword'
                                            onfocus="this.placeholder = ''"
                                            onblur="this.placeholder = 'Search Keyword'">
                                        <div class="input-group-append">
                                            <button class="btn" type="button"><i class="ti-search"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                                    type="submit">Search</button>
                            </form>
                        </aside>

                        <aside class="single_sidebar_widget post_category_widget">
                            <h4 class="widget_title">Category</h4>
                            <ul class="list cat-list">
                            	<% for (BlogCategoriesBean cat : categories) { %>
                                <li>
                                    <a href="BlogsSrv?catid=<%=cat.getCatblogId()%>" class="d-flex">
                                        <p><%=cat.getCatblogName()%></p>
                                        <p>( <%=cat.getBlogCount()%> )</p>
                                    </a>
                                </li>
                                <% } %>
                            </ul>
                        </aside>

                        <aside class="single_sidebar_widget popular_post_widget">
                            <h3 class="widget_title">Recent Post</h3>
                            <div class="media post_item">
                                <img src="img/post/post_1.png" alt="post">
                                <div class="media-body">
                                    <a href="single-blog.html">
                                        <h3>From life was you fish...</h3>
                                    </a>
                                    <p>January 12, 2019</p>
                                </div>
                            </div>
                            <div class="media post_item">
                                <img src="img/post/post_2.png" alt="post">
                                <div class="media-body">
                                    <a href="single-blog.html">
                                        <h3>The Amazing Hubble</h3>
                                    </a>
                                    <p>02 Hours ago</p>
                                </div>
                            </div>
                            <div class="media post_item">
                                <img src="img/post/post_3.png" alt="post">
                                <div class="media-body">
                                    <a href="single-blog.html">
                                        <h3>Astronomy Or Astrology</h3>
                                    </a>
                                    <p>03 Hours ago</p>
                                </div>
                            </div>
                            <div class="media post_item">
                                <img src="img/post/post_4.png" alt="post">
                                <div class="media-body">
                                    <a href="single-blog.html">
                                        <h3>Asteroids telescope</h3>
                                    </a>
                                    <p>01 Hours ago</p>
                                </div>
                            </div>
                        </aside>
                        <aside class="single_sidebar_widget tag_cloud_widget">
                            <h4 class="widget_title">Authors</h4>
                            <ul class="list">
                                <% Set<String> authors = new HashSet<>();
                                for (BlogsBean b : blogs) { 
                                    if (!authors.contains(b.getAuthor())) {
                                        authors.add(b.getAuthor()); %>
                                <li>
                                    <a href="BlogsSrv?aut=<%=b.getAuthor()%>"><%=b.getAuthor()%></a>
                                </li>
                                <% 
                					}
           					 	} 
       		 					%>
                            </ul>
                        </aside>


                        <aside class="single_sidebar_widget instagram_feeds">
                            <h4 class="widget_title">Instagram Feeds</h4>
                            <ul class="instagram_row flex-wrap">
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_5.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_6.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_7.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_8.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_9.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <img class="img-fluid" src="img/post/post_10.png" alt="">
                                    </a>
                                </li>
                            </ul>
                        </aside>


                        <aside class="single_sidebar_widget newsletter_widget">
                            <h4 class="widget_title">Newsletter</h4>

                            <form action="#">
                                <div class="form-group">
                                    <input type="email" class="form-control" onfocus="this.placeholder = ''"
                                        onblur="this.placeholder = 'Enter email'" placeholder='Enter email' required>
                                </div>
                                <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                                    type="submit">Subscribe</button>
                            </form>
                        </aside>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->

<%@ include file="footer.jsp" %>