<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>

<% 

	RoomTypesBean roomTy = (RoomTypesBean) request.getAttribute("roomtype");
				
%>

<!-- bradcam_area_start -->
  <div class="bradcam_area breadcam_bg">
      <h3>single roomtype</h3>
  </div>
  <!-- bradcam_area_end -->

   <!--================Blog Area =================-->
   <section class="blog_area single-post-area section-padding">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 posts-list">
               <div class="single-post">
                  <div class="feature-img"  style="display: flex; justify-content: center; align-items: center;">
                     <img class="img-fluid" src="<%=roomTy.getRoomImage()%>" alt="">
                  </div>
                  <div class="blog_details">
                     <h2 style="display: flex; justify-content: center; align-items: center; text-align: center;"><%=roomTy.getTypeName()%></h2>
                     <ul class="blog-info-link mt-3 mb-4" style="display: flex; justify-content: center; align-items: center; text-align: center; list-style: none; padding: 0;">
                        <li><a href="#"><i class="fa fa-user"></i> <%=roomTy.getOccupancy()%> persons</a></li>
                        <li><a href="#"><i class="fa fa-comments"></i><%=roomTy.getPricePerNight()%> $ per night</a></li>
                     </ul>
                     <div class="quote-wrapper">
                        <div class="quotes">
                           <%=roomTy.getAbst()%>
                        </div>
                     </div>
                     <p class="excert">
                        <%=roomTy.getDescription()%>
                     </p>
                  </div>
               </div>
               
            </div>
            
         </div>
      </div>
   </section>
   <!--================ Blog Area end =================-->

<%@ include file="footer.jsp" %>
   