<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>

<%

	PromoCodesServiceImpl prcDao = new PromoCodesServiceImpl();
	List<PromoCodesBean> promocodes = prcDao.getAllPromoCodes();
		
%>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Promo Code list</h1>
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
                      <b>Promo ID</b>
                    </th>
                    <th>Promo Code</th>
                    <th>Discount percent</th>
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Information</th>
                  </tr>
                </thead>
                <tbody>
                <%
					for (PromoCodesBean promocode : promocodes) {
				%>
                  <tr>
                    <td><%=promocode.getPromoId()%></td>
                    <td><%=promocode.getPromoCode()%></td>
                    <td><%=promocode.getDiscountPercent()%></td>
                    <td><%=promocode.getStartDate()%></td>
                    <td><%=promocode.getEndDate()%></td>
                    <td><%=promocode.getInformation()%></td>
                    
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